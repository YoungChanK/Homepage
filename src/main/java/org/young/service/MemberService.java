package org.young.service;

import org.young.domain.MemberVO;

public interface MemberService {
	public void createMember(MemberVO vo);
	//idcheck
	public String idCheck(String userid);
	//로그인 정보 조회
	public MemberVO login(MemberVO member);
}
