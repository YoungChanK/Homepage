package org.young.dbtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.young.domain.BoardVO;
import org.young.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BoardMapper bomapper;

	@Test
	public void testCreate() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("새로운 제목을 넣습니다.");
		board.setContent("새로운 글을 넣습니다.");
		board.setWriter("user00");
		logger.info("타이틀 확인ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + board.getTitle());
		bomapper.create(board);
	}
}
