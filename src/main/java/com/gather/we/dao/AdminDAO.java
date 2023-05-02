package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.AdminDTO;
import com.gather.we.dto.ManagerSettlementDTO;
import com.gather.we.dto.PagingVO;
import com.gather.we.dto.RegisterDTO;
import com.gather.we.dto.UserPayDTO;

public interface AdminDAO {
	public AdminDTO loginAdminOk(String adminid, String password);
	//정산 수입내역
	public List<UserPayDTO> revenue();
	public List<UserPayDTO> expense();
	public int waitOk(ManagerSettlementDTO dto);
	//총레코드수
	public int totalRecord(PagingVO vo);
	//해당페이지 선택
	public List<RegisterDTO> pageSelect(PagingVO vo);
}
