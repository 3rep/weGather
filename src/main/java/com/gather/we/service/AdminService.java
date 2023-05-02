package com.gather.we.service;

import java.util.List;

import com.gather.we.dto.AdminDTO;
import com.gather.we.dto.AdminManagerSettlementDTO;
import com.gather.we.dto.ManagerSettlementDTO;
import com.gather.we.dto.PagingVO;
import com.gather.we.dto.RegisterDTO;
import com.gather.we.dto.UserPayDTO;

public interface AdminService {
	public AdminDTO loginAdminOk(String adminid, String password);
	//���� ���Գ���
	public List<UserPayDTO> revenue();

	//�ѷ��ڵ��
	public int totalRecord(PagingVO vo);
	//�ش������� ����
	public List<RegisterDTO> pageSelect(PagingVO vo);

	public List<AdminManagerSettlementDTO> expense();
	public List<AdminManagerSettlementDTO> managerFee();
	public int waitOk(AdminManagerSettlementDTO dto);

}
