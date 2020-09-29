package org.young.service;




import java.util.List;

import javax.mail.internet.MimeMessage;
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
	public void Membermodify(MemberVO member) {
		// TODO Auto-generated method stub
		 mmapper.Membermodify(member);
	}

	@Override
	public List<MemberVO> memberinfo(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return mmapper.memberinfo(vo);
	}


	
	

	


	
}
