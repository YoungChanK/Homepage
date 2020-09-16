package org.young.Contorller;

import org.young.domain.BoardVO;
import org.young.domain.MemberVO;
import org.young.service.BoardService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	private BoardService service;

	
	private static final Logger logger=LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void listGet(Model model,MemberVO member,HttpServletRequest request)throws Exception {
		HttpSession session = request.getSession();   
		String userid=(String) session.getAttribute("userid");
		logger.info("list....get:"+session.getAttribute("userid"));
		model.addAttribute("list",service.listAll(userid));
		logger.info("id값:" +userid);
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
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public void modifyGet(BoardVO board, Model model) throws Exception{
		logger.info("modify Get........."+board);
		model.addAttribute("modify",service.read(board));
	
	}
}