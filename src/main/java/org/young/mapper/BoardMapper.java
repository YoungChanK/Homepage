package org.young.mapper;

import java.util.List;

import org.young.domain.BoardVO;
import org.young.domain.MemberVO;

public interface BoardMapper {
	//글쓰기
	public void create(BoardVO vo) throws Exception;
	
	public List<BoardVO> listAll(String userid)throws Exception;
	
	public BoardVO read(BoardVO vo) throws Exception;
}
