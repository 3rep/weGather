package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.NoticeBoardCriteria;
import com.gather.we.dto.NoticeBoardDTO;

public interface NoticeBoardService {
	public List<NoticeBoardDTO> getList(NoticeBoardCriteria criteria);//게시글 전체조회
	
	public int getTotalCount(NoticeBoardCriteria criteria);//게시글 전체수
	
	public NoticeBoardDTO read(int no);//게시글 상세페이지
	
	public void register(NoticeBoardDTO dto);//게시글 생성
	
	public int delete(int no); //게시글 삭제
	
	public void modify(NoticeBoardDTO dto);//게시글 수정
}
