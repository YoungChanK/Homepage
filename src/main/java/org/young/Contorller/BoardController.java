package org.young.Contorller;

import org.young.domain.BoardVO;
import org.young.domain.Criteria;
import org.young.domain.MemberVO;
import org.young.service.BoardService;

import java.util.List;

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
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, Model model) throws Exception{
		logger.info("register POST.......");
		logger.info("boardVO에 저장되어 있는 값 확인"+board);
		service.create(board); //insert sql

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

}
