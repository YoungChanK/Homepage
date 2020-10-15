package org.young.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.young.domain.BoardVO;
import org.young.domain.MemberVO;

public interface MemberService {
	public void createMember(MemberVO vo);
	//idcheck
	public String idCheck(String userid);
	//로그인 정보 조회
	public MemberVO login(MemberVO member);
	//회원정보수정
	public void Membermodify(MemberVO member);
	public List<MemberVO> memberinfo(MemberVO vo)throws Exception;
	public MemberVO inforead(MemberVO vo)throws Exception;
	//글수정
	public void update(MemberVO vo) throws Exception;
	//글삭제
	public void delete(MemberVO vo)throws Exception;
}
