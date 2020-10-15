package org.young.mapper;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.young.domain.BoardVO;
import org.young.domain.MemberVO;

public interface MemberMapper {
	//회원가입 (insert)
	public void createMember(MemberVO vo);
	//idcheck
	public String idCheck(String userid);
	//로그인
	public MemberVO login(MemberVO vo);
	
	public void Logout(HttpSession session);
	//회원정보수정
	public void Membermodify(MemberVO vo);
	//관리자모드
	public List<MemberVO> memberinfo(MemberVO vo)throws Exception;
	
	public MemberVO inforead(MemberVO vo)throws Exception;
	//글수정
	public void update(MemberVO vo) throws Exception;
	//글삭제
	public void delete(MemberVO vo)throws Exception;
}
