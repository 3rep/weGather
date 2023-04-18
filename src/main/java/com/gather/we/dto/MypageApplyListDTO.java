package com.gather.we.dto;

public class MypageApplyListDTO {

	//rank_game 테이블
	private int no;
	private int s_no;
	private String managerid;
	private int st_no;
	private String gametime;
	private int g_status; //경기 확정 버튼 생성 : 2(취소)/1(확정)/0(대기)
	private int payment;
	
	
	//stadium_info 테이블
	private String stadium;
	private String region;
	
	//sport테이블
	private String sportname;
	
	
	

	@Override
	public String toString() {
		return "MypageRankgameDTO [no=" + no + ", s_no=" + s_no + ", managerid=" + managerid + ", st_no=" + st_no
				+ ", gametime=" + gametime + ", g_status=" + g_status + ", payment=" + payment + ", stadium=" + stadium
				+ ", region=" + region + ", sportname=" + sportname + "]";
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




	public String getGametime() {
		return gametime;
	}




	public void setGametime(String gametime) {
		this.gametime = gametime;
	}




	public int getG_status() {
		return g_status;
	}




	public void setG_status(int g_status) {
		this.g_status = g_status;
	}




	public int getPayment() {
		return payment;
	}




	public void setPayment(int payment) {
		this.payment = payment;
	}




	public String getStadium() {
		return stadium;
	}




	public void setStadium(String stadium) {
		this.stadium = stadium;
	}




	public String getRegion() {
		return region;
	}




	public void setRegion(String region) {
		this.region = region;
	}




	public String getSportname() {
		return sportname;
	}




	public void setSportname(String sportname) {
		this.sportname = sportname;
	}

	
	
}
