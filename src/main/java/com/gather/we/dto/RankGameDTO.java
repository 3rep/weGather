package com.gather.we.dto;

import java.util.Date;

public class RankGameDTO {
	private int no;
	private int s_no;
	private String managerid;
	private int st_no;
	private Date gametime;
	private int min_people;
	private int max_people;
	private int curr_people;
	private String gendertype;
	private int req_rank;
	private int payment;
	private int managerfee;
	private int g_status;
	private int manager;
	
	@Override
	public String toString() {
		return "RankGameDTO [no=" + no + ", s_no=" + s_no + ", managerid=" + managerid + ", st_no=" + st_no
				+ ", gametime=" + gametime + ", min_people=" + min_people + ", max_people=" + max_people
				+ ", curr_people=" + curr_people + ", gendertype=" + gendertype + ", req_rank=" + req_rank
				+ ", payment=" + payment + ", managerfee=" + managerfee + ", g_status=" + g_status + ", manager="
				+ manager + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	public int getSt_no() {
		return st_no;
	}

	public void setSt_no(int st_no) {
		this.st_no = st_no;
	}

	public Date getGametime() {
		return gametime;
	}

	public void setGametime(Date gametime) {
		this.gametime = gametime;
	}

	public int getMin_people() {
		return min_people;
	}

	public void setMin_people(int min_people) {
		this.min_people = min_people;
	}

	public int getMax_people() {
		return max_people;
	}

	public void setMax_people(int max_people) {
		this.max_people = max_people;
	}

	public int getCurr_people() {
		return curr_people;
	}

	public void setCurr_people(int curr_people) {
		this.curr_people = curr_people;
	}

	public String getGendertype() {
		return gendertype;
	}

	public void setGendertype(String gendertype) {
		this.gendertype = gendertype;
	}

	public int getReq_rank() {
		return req_rank;
	}

	public void setReq_rank(int req_rank) {
		this.req_rank = req_rank;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public int getManagerfee() {
		return managerfee;
	}

	public void setManagerfee(int managerfee) {
		this.managerfee = managerfee;
	}

	public int getG_status() {
		return g_status;
	}

	public void setG_status(int g_status) {
		this.g_status = g_status;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}
}
