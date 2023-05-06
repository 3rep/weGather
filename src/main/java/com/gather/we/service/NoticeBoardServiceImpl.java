package com.gather.we.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.we.dao.NoticeBoardDAO;
import com.gather.we.dto.NoticeBoardCriteria;
import com.gather.we.dto.NoticeBoardDTO;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
	
	@Autowired
	private NoticeBoardDAO dao;
	
	@Override
	public List<NoticeBoardDTO> getList(NoticeBoardCriteria criteria) {
		return dao.getListWithPaging(criteria);
	}

	@Override
	public int getTotalCount(NoticeBoardCriteria criteria) {
		return dao.getTotalCount(criteria);
	}
	
	@Override
	public NoticeBoardDTO read(int no) {
		return dao.read(no);
	}

	@Override
	public void register(NoticeBoardDTO dto) {
		dao.insert(dto);
	}

	@Override
	public int delete(int no) {
		return dao.delete(no);
	}

	@Override
	public void modify(NoticeBoardDTO dto) {
		dao.modify(dto);
	}

}
