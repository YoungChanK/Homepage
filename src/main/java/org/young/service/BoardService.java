package org.young.service;

import java.util.List;

import org.young.domain.BoardVO;
import org.young.domain.Criteria;
import org.young.domain.MemberVO;

public interface BoardService {
	
	public void create(BoardVO vo) throws Exception;
	//글수정
	public void update(BoardVO vo) throws Exception;
	//글삭제
	public void delete(BoardVO vo)throws Exception;
	public void deletefile(BoardVO vo)throws Exception;

	public List<BoardVO> listAll(String userid) throws Exception;
	public BoardVO read(BoardVO vo) throws Exception;
	public List<BoardVO> listPage(Criteria cri)throws Exception;
	public int getTotalCount(Criteria cri)throws Exception;
	
}
