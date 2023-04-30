package com.gather.we.dto;

import java.util.Date;

import lombok.Data;
@Data
public class ManagerSettlementDTO {
	private int no;
	private String managerid;
	private String datetime;
	private String d_status;
	private int amount;
}
