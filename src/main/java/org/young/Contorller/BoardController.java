package org.young.Contorller;

import org.young.domain.BoardVO;
import org.young.domain.Criteria;
import org.young.domain.MemberVO;
import org.young.service.BoardService;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.young.domain.PageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	private BoardService service;

	
	private static final Logger logger=LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void listGet(Model model,Criteria cri,HttpServletRequest request)throws Exception {
		HttpSession session = request.getSession();   
		String userid=(String) session.getAttribute("userid");
		model.addAttribute("listid",service.listAll(userid));
		cri.setUserid(userid);
		model.addAttribute("list",service.listPage(cri));
		model.addAttribute("PageMaker",new PageDTO(cri,service.getTotalCount(cri)));
	
//		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void readGet(BoardVO board, Model model) throws Exception{
		logger.info("read Get........."+board);
		logger.info("read Get........."+board.getRegdate());
		
		model.addAttribute("read",service.read(board));
	}
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public void registerGET() throws Exception{
		logger.info("register get.......");
	}
	 private String getFolder() {
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		   Date date = new Date(); //오늘날짜를 date변수에 저장
		   	String str=sdf.format(date);
		   	System.out.println("오늘 날짜 := "+str); //str :2020-08-25 => 2020\\08\\25
		   	
		   	return str.replace("-",File.separator);
		   }
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, Model model,MultipartFile[] file) throws Exception{
		logger.info("register POST.......");
		logger.info("boardVO에 저장되어 있는 값 확인"+board);
		
		String fileName="";
		String filePath="";
		String uploadPath="C:\\PFupload";
		File uploadFolder=new File(uploadPath,getFolder());
		
		   logger.info("파일업로드 폴더"+uploadFolder);
		   //년월일 폴더 만들기
		   //exists() 메소드를 활용하여 생성하고자 하는 폴더가 존재하지 않으면 폴더를 만들어라.
		   if(uploadFolder.exists()==false) {
			   uploadFolder.mkdirs(); //mkdir메소드는 폴더를 만들어 주는 메소드
		   }
		   
		   
		   for(MultipartFile multipartFile : file) {
	    	  if(multipartFile.getSize()!=0) {
	    	  
	         logger.info("파일명 : "+multipartFile.getOriginalFilename());
	         logger.info("파일사이즈 : "+multipartFile.getSize());
	         logger.info("파일타입 : "+multipartFile.getContentType());
	         logger.info("파일 저장 위치 : "+uploadPath);
	         
	         fileName =multipartFile.getOriginalFilename(); //fileName
	         String uploadFileName=multipartFile.getOriginalFilename();
	         UUID uuid=UUID.randomUUID();
	         uploadFileName = uuid+"_"+uploadFileName;
	         filePath=uploadFolder+"\\"+uploadFileName;
	         filePath=filePath.substring(12);
//	         filePath=filePath.replace("\\", "%");
	        
	         logger.info("filePath:"+ filePath);
	      
	         
	         try {
	        	 File saveFile = new File(uploadFolder,uploadFileName);
	        	 multipartFile.transferTo(saveFile);
	         }catch(Exception e) {
	            logger.info(e.getMessage());
	         }
	      }
		logger.info("업로드");
		board.setFilePath(filePath);
		board.setFileName(fileName);
		   }
		service.create(board); //insert sql
//		model.addAttribute("fileName",fileName);
		model.addAttribute("result","success");
		return "redirect://board/list";
		
	}
	

	//수정화면으로 이동
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public void modifyGet(BoardVO board, Model model) throws Exception{
		logger.info("modify Get........."+board);
		model.addAttribute("modify",service.read(board));
	
	}
	//실제 수정이 이루어 지는곳
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyPost(BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("modify post........."+board);
		service.update(board);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/list";
	}
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String removePost(BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("remove post........."+board);
		service.delete(board);
		rttr.addFlashAttribute("msg","DSUCCESS");
		return "redirect:/board/list";
	}
	
		//파일삭제
	   @RequestMapping(value = "deleteFile", method = RequestMethod.POST)
	   public ResponseEntity<String> deleteFile(String fileName,BoardVO board) throws Exception{
		   logger.info("fileName :"+fileName);
	
		   
		   File file;

		   try {	
			   //경로에 있는 % 를 \ 로 변경
			   file = new File("C:\\PFupload\\"+URLDecoder.decode(fileName,"UTF-8"));
			   //썸내일 이미지 파일 삭제
			   file.delete();
			   service.deletefile(board);
			   logger.info("board   :  "+board);
		} catch (UnsupportedOperationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		   
		   
		   
		   return new ResponseEntity<String>("deleted"/*ajax의 success:funcion(data)에 들어가서 출력*/,HttpStatus.OK/*통신이 성공했으면*/) ;
		   
	   }
	   
}
