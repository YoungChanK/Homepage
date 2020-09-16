package org.young.Contorller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import org.young.domain.AttachFileDTO;

import net.coobird.thumbnailator.Thumbnailator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("upload")
public class UploadController {
	 private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	 
	 @RequestMapping(value="uploadForm",method = RequestMethod.GET)
	 public void uploadForm() {
		 logger.info("파일업로드 화면");
	 }
	 @RequestMapping(value="uploadForm",method = RequestMethod.POST)
	 public void uploadForm(MultipartFile[] file)throws Exception {
		 for(MultipartFile miltipartFile : file) {
			 String uploadPath="C:\\PFupload";
			 logger.info("파일명 : " +miltipartFile.getOriginalFilename());
			 logger.info("파일크기 : " +miltipartFile.getSize());
			 logger.info("파일타입 : " +miltipartFile.getContentType());
			 logger.info("파일저장 위치 : " +uploadPath);
			 
			 File saveFile = new File(uploadPath,miltipartFile.getOriginalFilename());
			 
			 try {
				miltipartFile.transferTo(saveFile);
			} catch (Exception e) {
				// TODO: handle exception
				logger.info(e.getMessage());
			}
			 
		 }
	 }
	 
	 //년 월 일 폴더 생성
	 private String getFolder() {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = new Date();
		 String str = sdf.format(date);
		 System.out.println("오늘 날짜 : ="+ str);
		 return str.replace("-", File.separator);
	 }
	 //이미지 파일을 판단할 수 있게 하는 메소드 
	 private boolean checkImageType(File file) {
		 try {
			 String contentType=Files.probeContentType(file.toPath());
			 return contentType.startsWith("image");
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return false;
	 }
	 
	 //Ajax  GET
	  @RequestMapping(value = "uploadajax", method = RequestMethod.GET)
	   public void uploadAjax() {
		   logger.info("파일 업로드  ajax 화면");
	   }
	 //Ajax POST
	 @ResponseBody
	 @RequestMapping(value = "uploadajax", method = RequestMethod.POST,produces =MediaType.APPLICATION_JSON_UTF8_VALUE) 
	 public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] file) throws Exception {
		   String uploadPath="C:\\PFupload";
		   //AttachFileDTO 클래스에 list배열로 생성
		   List<AttachFileDTO> list = new ArrayList<>();
		   File uploadFolder=new File(uploadPath,getFolder());
		   logger.info("파일업로드 폴더"+uploadFolder);
		   
		   if(uploadFolder.exists()==false) {
			   uploadFolder.mkdirs(); //mkdir메소드는 폴더를 만들어 주는 메소드
		   }	//make yyyy\\MM\\dd folder 
		for (MultipartFile multipartFile : file) {
			logger.info("파일명 : " + multipartFile.getOriginalFilename());
			logger.info("파일크기 : " + multipartFile.getSize());
			logger.info("파일종료 : " + multipartFile.getContentType());
			logger.info("파일 저장 위치 : " + uploadPath);

			AttachFileDTO attach = new AttachFileDTO();
			String fileName=multipartFile.getOriginalFilename();   //fileName에 파일명 저장
			attach.setFileName(fileName);
//			attach.setFileName(multipartFile.getOriginalFilename());   //setFileName에 파일명 Set
			//파일명 중복을 막기위해 파일명 앞에 UUID_ 추가해주기
			String uploadFileName=fileName;
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid+"_"+uploadFileName;
			
			try {
				File savaFile = new File(uploadFolder,uploadFileName); //파일 업로드 경로
				multipartFile.transferTo(savaFile); //savaFile 경로에 저장
				attach.setUploadPath(getFolder());
				System.out.println("getFolder"+getFolder());
		       	 //AttachFileDTO 클래스에 UUID변수에 저장
	        	 attach.setUuid(uuid.toString());
	        	 //파일 저장할떄 이미지파일이면 썸내일 만들어서 저장
	        	 if(checkImageType(savaFile)) {
	        		 //업로드된 파일이 이미지일 경우
	        		 attach.setImage(true);
	        		 
	        		 //썸네일은 s_를 추가하여 생성
	        		 FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolder,"s_"+uploadFileName));
	        		 //썸네일 크기는 100 x100
	        		 Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,100, 100);
	        		 thumbnail.close();
	        		 
	        	 }
	        	 list.add(attach);
	        	 logger.info("list : "+ list);
			} catch (Exception e) {
				// TODO: handle exception
		          logger.info(e.getMessage());
			}
			
		   }
	 
		   
		   return new ResponseEntity<>(list,HttpStatus.OK);
	 }
	 
	   	//display(업로드 파일이 이미지 인거)
	   @RequestMapping(value = "display", method = RequestMethod.GET)
	   public ResponseEntity<byte[]> getFile(String fileName) {
		   logger.info("fileName="+fileName);
		   File file= new File("C:\\PFupload\\"+fileName);
		   logger.info("file="+file);
		   ResponseEntity<byte[]> result=null;
		   
		   try {
			   HttpHeaders header = new HttpHeaders();
			   header.add("Content-Type",Files.probeContentType(file.toPath()));
			   result=new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		   return result;
	   }
	   //download(업로드 파일이 이미지가 아닌거)
	   @RequestMapping(value = "download", method = RequestMethod.GET,produces =MediaType.APPLICATION_OCTET_STREAM_VALUE)
	   public ResponseEntity<Resource> downloadFile(String fileName) throws Exception {
		   logger.info("download file : "+fileName);
		   Resource resource = new FileSystemResource("C:\\PFupload\\"+fileName);
		   logger.info("resource  : "+resource);
		   String resourceName=resource.getFilename();
		   HttpHeaders header = new HttpHeaders();
		   int uuidindex = resourceName.indexOf("_");
		   String OfileName= resourceName.substring(uuidindex+1);
		   logger.info("인덱스 위치 :"+ uuidindex);
		   logger.info("파일명 : "+ OfileName);
		   
		   
		   try {

			   header.add("Content-Disposition", "attachment; filename=" + new String(OfileName.getBytes("UTF-8"),"ISO-8859-1"));
			   
		} catch (UnsupportedOperationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		   return new ResponseEntity<Resource>(resource,header,HttpStatus.OK);
		   
	   
	   } //download end
	   
	   //파일 삭제 start
	   //파일 삭제 end
	   @RequestMapping(value = "deleteFile", method = RequestMethod.POST)
	   public ResponseEntity<String> deleteFile(String fileName,String type) throws Exception{
		   logger.info("fileName :"+fileName);
		   logger.info("type : "+type);
		   
		   File file;

		   try {	
			   //경로에 있는 % 를 \ 로 변경
			   file = new File("C:\\PFupload\\"+URLDecoder.decode(fileName,"UTF-8"));
			   //썸내일 이미지 파일 삭제
			   file.delete();
			   if(type.equals("image")) {
				   //절대경로에 있는 파일의 s_를 제거
				   String originalFile=file.getAbsolutePath().replace("s_","");
				   file = new File(originalFile);
				   //원본 이미지 삭제
				   file.delete();

			   }
		} catch (UnsupportedOperationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		   
		   
		   
		   return new ResponseEntity<String>("deleted"/*ajax의 success:funcion(data)에 들어가서 출력*/,HttpStatus.OK/*통신이 성공했으면*/) ;
		   
	   }
	   
	   
	   
	   
}
