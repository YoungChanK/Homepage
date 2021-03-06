package org.young.Contorller;

import org.young.domain.BoardVO;
import org.young.domain.MemberVO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.young.service.BoardService;
import org.young.service.MemberService;


@Controller
@RequestMapping("member")
public class MemberController {
	private static final Logger logger=LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService meservice;
	

	//회원가입 화면
	@RequestMapping(value="member", method=RequestMethod.GET)
	public void MemberGet()throws Exception{
		logger.info("회원가입 화면");
	}
	//회원가입 처리
	@RequestMapping(value="member", method=RequestMethod.POST)
	public String MemberPost(MemberVO vo)throws Exception{
		logger.info(vo.toString());
		meservice.createMember(vo);
	
	
		return "redirect:/member/login";
		
//		MemberVO member=meservice.createMember(vo);
	}
	//회원수정
	@RequestMapping(value="membermodify",method=RequestMethod.GET)
	public void MembermodifyGet()throws Exception{
		logger.info("회원수정 화면");
		
	}
	@RequestMapping(value="membermodify",method=RequestMethod.POST)
	public String MembermodifyPost(MemberVO vo)throws Exception{
		meservice.Membermodify(vo);
		logger.info("vo값은: "+vo);
		return "redirect:/member/login";
	}
	@ResponseBody
	@RequestMapping(value = "idCheck",method = RequestMethod.POST)
	public String idCheck(String userid) {
		String str="";
		String idcheck = meservice.idCheck(userid);
		logger.info("idcheck"+idcheck);
		if(idcheck==null) {
			str="yes";
			logger.info("null 값 ? "+str);
		}else {
			str="no";
			logger.info("이미 있음 "+str);
	
		}
		return str;
		
	}
	//메인화면폼
	@RequestMapping(value="main", method=RequestMethod.GET)
	public void MainGet()throws Exception{
		logger.info("메인 화면 이동");
	}
	//로그인화면폼
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void LoginGet()throws Exception{
		logger.info("로그인 화면 이동");
	}
	@RequestMapping(value="logout")
	public String Logout(HttpSession session)throws Exception{
//		meservice.Logout(session);
		session.invalidate();
		logger.info("세션값" + session.getId());
/*		ModelAndView mav = new ModelAndView();
		mav.setViewName("/home");
		mav.addObject("msg","logout");*/
	
		
		return "redirect:/member/login";
	}
	//로그인처리
		@RequestMapping(value="loginPost", method=RequestMethod.POST)
		public String LoginPost(MemberVO member,Model model,HttpServletRequest request)throws Exception{
			HttpSession session = request.getSession();    

			logger.info("로그인 처리");
			MemberVO vo= meservice.login(member);
			//만약에 인터셉터를 사용하지 않고 로그인처리를 하고자 할때 컨트롤러에서 아래처럼 작성
			if(vo !=null) { //로그인되었으면
				session.setAttribute("login",vo);
				session.setAttribute("userid",vo.getUserid());
				session.setAttribute("auto",vo.isAuthority());
				logger.info("세션값 : " + session.getAttribute("login"));
				logger.info("ID값 : " + session.getAttribute("userid"));
				logger.info("권한값 : " + session.getAttribute("auto"));
				return "redirect:/board/list";
				}
			else { //로그인이 되어 있지않았으면 login.jsp로 이동
				logger.info("로그인실패");
				return "redirect:/member/login";
			}		
		}
		
		@RequestMapping(value="admin", method=RequestMethod.GET)
		public void adminGet(MemberVO member,Model model)throws Exception{
			List<MemberVO> vo=meservice.memberinfo(member);
			model.addAttribute("memberinfo",meservice.memberinfo(member));
			
			logger.info(vo.toString());
		}
		@RequestMapping(value="inforead", method=RequestMethod.GET)
		public void inforeadGet(MemberVO member,Model model)throws Exception{
			logger.info("inforead Get"+member);
			model.addAttribute("inforead",meservice.inforead(member));
			
		
		}

		//실제 수정이 이루어 지는곳
		@RequestMapping(value = "modify", method = RequestMethod.POST)
		public String modifyPost(MemberVO member,RedirectAttributes rttr) throws Exception{
			logger.info("modify post........."+member);
			meservice.update(member);
			rttr.addFlashAttribute("msg","SUCCESS");
			return "redirect:/member/admin";
		}
		@RequestMapping(value = "remove", method = RequestMethod.POST)
		public String removePost(MemberVO member,RedirectAttributes rttr) throws Exception{
			logger.info("remove post........."+member);
			meservice.delete(member);
			rttr.addFlashAttribute("msg","DSUCCESS");
			return "redirect:/member/admin";
		}
		
	
}
