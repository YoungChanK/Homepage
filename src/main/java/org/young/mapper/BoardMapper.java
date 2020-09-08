package org.young.mapper;

import org.young.domain.BoardVO;

public interface BoardMapper {
	//글쓰기
	public void create(BoardVO vo) throws Exception;
}
