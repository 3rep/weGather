package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.NoticeBoardCriteria;
import com.gather.we.dto.NoticeBoardDTO;

public interface NoticeBoardDAO {
	
	public List<NoticeBoardDTO> getList();
	
	public List<NoticeBoardDTO> getListWithPaging(NoticeBoardCriteria criteria);// 글목록
	
	public int getTotalCount(NoticeBoardCriteria criteria);// 전체글 수
	
	public NoticeBoardDTO read(int no);//게 시글 상세조회
	
	public void insert(NoticeBoardDTO dto);// 게시글 생성
	
	public int delete(int no);// 게시글 삭제
	
	public void modify(NoticeBoardDTO dto);// 게시글 수정
}
