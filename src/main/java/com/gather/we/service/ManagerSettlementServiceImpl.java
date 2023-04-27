package com.gather.we.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather.we.dao.ManagerSettlementDAO;
import com.gather.we.dto.MSettlementCriteria;
import com.gather.we.dto.ManagerSettlementDTO;

@Service
public class ManagerSettlementServiceImpl implements ManagerSettlementService {

	@Autowired
	ManagerSettlementDAO dao;
	
	@Override
	public List<ManagerSettlementDTO> mSettlementAllSelect(MSettlementCriteria mscriteria) {
		return dao.getListWithPaging(mscriteria);
	}

	@Override
	public int getTotalCount(MSettlementCriteria mscriteria) {
		return dao.getTotalCount(mscriteria);
	}

	@Override
	public int getTotalCompletedAmount() {
		return dao.selectCompletedAmount();
	}

	@Override
	public int getTotalInprogressAmount() {
		return dao.selectInprogressAmount();
	}

}
