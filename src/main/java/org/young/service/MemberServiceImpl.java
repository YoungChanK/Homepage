package org.young.service;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.young.domain.MemberVO;
import org.young.mapper.MemberMapper;
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberMapper mmapper;
	
	@Override
	public void createMember(MemberVO vo) {
		// TODO Auto-generated method stub
		 mmapper.createMember(vo);
		
	}

	@Override
	public String idCheck(String userid) {
		// TODO Auto-generated method stub
		return mmapper.idCheck(userid);
	}

	@Override
	public MemberVO login(MemberVO member) {
		return mmapper.login(member);
	}

	@Override
	public void Logout(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate();
	}
	
	
}
