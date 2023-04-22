package com.gather.we.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gather.we.dao.AdminManagerDAO;
import com.gather.we.dto.ManagerDTO;
import com.gather.we.dto.RankGameDTO;

@Service
public class AdminManagerServiceImpl implements AdminManagerService {
	@Inject
	AdminManagerDAO dao;

	@Override
	public List<ManagerDTO> approveList() {
		return dao.approveList();
	}

	@Override
	public ManagerDTO approveDetail(String managerid) {
		return dao.approveDetail(managerid);
	}

	@Override
	public void approveOk(String managerid) {
		dao.approveOk(managerid);
	}

	@Override
	public void refuseOk(String managerid) {
		dao.refuseOk(managerid);
	}

	@Override
	public List<ManagerDTO> managerList() {
		return dao.managerList();
	}

	@Override
	public List<RankGameDTO> managerRecent(String managerid) {
		return dao.managerRecent(managerid);
	}
}
