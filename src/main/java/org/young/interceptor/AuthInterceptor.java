package org.young.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//세션 가져오기
		HttpSession session = request.getSession();
		//login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져오기
		Object obj = session.getAttribute("login");
		if(obj ==null) {
			//로그인이 안되어 있는 상태이므로 로그인 폼으로 다시 돌려보냄(redirect)
			response.sendRedirect("/young/member/login");
			return false; //더이상 컨트롤러 요청으로 가지않도록 false로 반환
		}
		//preHandel의 return은 컨트롤러 요청 uri로 가도 되는지 허가하는 의미
		//true면 컨트롤러 uri로 가게 됨
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}




}
