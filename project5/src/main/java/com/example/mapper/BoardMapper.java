package com.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.example.domain.BoardVO;

public interface BoardMapper 
{
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
//	public List<BoardVO> getListWithPaging(Criteria cri);

	public void insert(BoardVO board);

	public Integer insertSelectKey(BoardVO board);

	public BoardVO read(Long bno);

	public int delete(Long bno);

	public int update(BoardVO board);
}
