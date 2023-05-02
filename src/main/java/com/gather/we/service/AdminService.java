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
	//ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Ô³ï¿½ï¿½ï¿½
	public List<UserPayDTO> revenue();

	//ÃÑ·¹ÄÚµå¼ö
	public int totalRecord(PagingVO vo);
	//ÇØ´çÆäÀÌÁö ¼±ÅÃ
	public List<RegisterDTO> pageSelect(PagingVO vo);

	public List<AdminManagerSettlementDTO> expense();
	public List<AdminManagerSettlementDTO> managerFee();
	public int waitOk(AdminManagerSettlementDTO dto);

}
