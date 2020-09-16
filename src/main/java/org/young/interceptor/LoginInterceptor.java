package org.young.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("pre handle...........");
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object userVO =modelAndView.getModel().get("userVO");
		if(userVO !=null) {
			logger.info("new login success");
			logger.info("세션값"+userVO);
			session.setAttribute("login", userVO);
			response.sendRedirect("/young/board/list");
		}else {
			logger.info("세션값mmmmmmmmmmm"+userVO);
			response.sendRedirect("/young/member/login");
		}
		logger.info("세션값"+userVO);
		System.out.println("post2 handle..........");
	}
	
	
}
