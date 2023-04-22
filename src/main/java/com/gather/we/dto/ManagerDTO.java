package com.gather.we.dto;

import java.util.List;

import lombok.Data;

@Data
public class ManagerDTO {
	private String managerid;
	private int s_no;
	private String sportname;
	private String type;
	private String m_name;
	private String password;
	private String email;
	private String tel;
	private String address;
	private String gender;
	private String prooffile;
	private int active;
	private String signupdate;
	private String m_account;
	private List<RankGameDTO> rankgameList;
	
}
