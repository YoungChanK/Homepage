package org.young.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.young.domain.BoardVO;
import org.young.domain.MemberVO;
import org.young.mapper.BoardMapper;
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	

	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		mapper.create(vo);
	}

	

	@Override
	public List<BoardVO> listAll(String userid) throws Exception {
		// TODO Auto-generated method stub
		return mapper.listAll(userid);
		
	}



	@Override
	public BoardVO read(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
	
		return mapper.read(vo);
	}
	
}
