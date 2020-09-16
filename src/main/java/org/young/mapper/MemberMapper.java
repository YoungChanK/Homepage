package org.young.mapper;

import javax.servlet.http.HttpSession;

import org.young.domain.MemberVO;

public interface MemberMapper {
	//회원가입 (insert)
	public void createMember(MemberVO vo);
	//idcheck
	public String idCheck(String userid);
	//로그인
	public MemberVO login(MemberVO vo);
	
	public void Logout(HttpSession session);
}
