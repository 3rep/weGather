package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.RegisterDTO;
import com.gather.we.dto.UserLogDTO;

public interface RegisterDAO {
	//íšŒì›ê°€ì…
	public int registerInsert(RegisterDTO dto);
	//ì¶”ìƒë©”ì†Œë“œ
	public RegisterDTO loginOk(String userid, String password);
	//ì•„ì´ë”” ì¤‘ë³µê²€ì‚¬ - ì•„ì´ë””ì˜ ê°¯ìˆ˜ë¥¼ êµ¬í•œë‹¤.
	public int idCheckCount(String userid);
	public List<RegisterDTO> dataAllSelect();
	//íšŒì›ì •ë³´ ìˆ˜ì • í¼
	public RegisterDTO registerEdit(String userid);
	//íšŒì›ì •ë³´ ìˆ˜ì • DB update
	public int registerEditOk(RegisterDTO dto);
	//È¸¿øÈ°µ¿³»¿ª ·©Å© °ÔÀÓ
	public List<UserLogDTO> userLogSelect(String userid);
	//È¸¿øÈ°µ¿³»¿ª ÀÏ¹İ °ÔÀÓ
	public List<UserLogDTO> userLogNormSelect(String userid);
}
