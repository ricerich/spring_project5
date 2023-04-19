package com.example.service;

import java.util.List;

import com.example.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO board);

	public BoardVO get(Long bno);

	public boolean modify(BoardVO board);

	public boolean remove(Long bno);

	 public List<BoardVO> getList();

//	public List<BoardVO> getList(Criteria cri);

	//Ãß°¡
//	public int getTotal(Criteria cri);

}
