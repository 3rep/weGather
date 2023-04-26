package com.gather.we.dto;

import lombok.Data;

@Data
public class UserPayDTO {
	private String payment_no;
	private String success;
	private String payer_name;
	private int paid_at;
	private int paid_amount;
}
