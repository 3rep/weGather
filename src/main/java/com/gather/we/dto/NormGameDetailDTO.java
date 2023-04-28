package com.gather.we.dto;

import java.util.Date;

import lombok.Data;

@Data
public class NormGameDetailDTO {
	private int no;
	private int s_no;
	private int st_no;
	private Date gametime;
	private int min_people;
	private int max_people;
	private int curr_people;
	private String gendertype;
	private int payment;
	private String sportname;
	private String filename;
	private String stadium;
	private String location;
	private String m_name;
}
