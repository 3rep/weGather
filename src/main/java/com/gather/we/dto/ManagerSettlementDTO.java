package com.gather.we.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ManagerSettlementDTO {
	private String stadium;
	private Date gametime;
	private String d_status;
	private int amount;
	private int completed_amount;
	private int inprogress_amount;
}
