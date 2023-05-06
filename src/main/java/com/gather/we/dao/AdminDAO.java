package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.AdminDTO;
import com.gather.we.dto.AdminManagerSettlementDTO;
import com.gather.we.dto.ManagerSettlementDTO;
import com.gather.we.dto.PagingVO;
import com.gather.we.dto.RegisterDTO;
import com.gather.we.dto.UserPayDTO;

public interface AdminDAO {
	public AdminDTO loginAdminOk(String adminid, String password);
	//���� ���Գ���
	public List<UserPayDTO> revenue(PagingVO vo);
	public int revenueTotalRecord(PagingVO vo);
	//�ѷ��ڵ��
	public int totalRecord(PagingVO vo);
	//�ش������� ����
	public List<RegisterDTO> pageSelect(PagingVO vo);

	public List<AdminManagerSettlementDTO> expense(PagingVO vo);
	public int expenseTotalRecord(PagingVO vo);
	public List<AdminManagerSettlementDTO> managerFee(PagingVO vo);
	public int managerFeeTotalRecord(PagingVO vo);
	public int waitOk(AdminManagerSettlementDTO dto);
	
	//지정한 날짜에 해당하는 수입내역 리스트 뽑기
	public List<UserPayDTO> selectedRevenueList(PagingVO vo);
	//지정한 날짜에 해당하는 수입총액
	public int revenueResult(PagingVO vo);
	//지정한 날짜에 해당하는 지촐총액
	public int expenseResult(PagingVO vo);
}
