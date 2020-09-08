package org.young.dbtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.young.domain.MemberVO;
import org.young.mapper.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MemberMapper mmapper;
	@Test
	public void CreateMember() throws Exception{
		MemberVO member = new MemberVO();
		member.setUserid("chan1");
		member.setUserpw("1234");
		member.setUsername("young");
		member.setEmail("k@naver.com");
		logger.info(member.getUserid());
		mmapper.createMember(member);
	}

}
