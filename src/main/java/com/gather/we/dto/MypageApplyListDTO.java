package com.gather.we.dto;

import java.util.Date;

public class MypageApplyListDTO {

	private String userid; //���̵�
	private int no; //����Ϸù�ȣ 
	private String sportname; //�����
	private Date gametime; //���ð�
	private String stadium; //�����
	private int g_status; //��ũ��� ������	
	
	
	@Override
	public String toString() {
		return "MypageApplyListDTO [userid=" + userid + ", no=" + no + ", sportname=" + sportname + ", gametime="
				+ gametime + ", stadium=" + stadium + ", g_status=" + g_status + "]";
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getSportname() {
		return sportname;
	}


	public void setSportname(String sportname) {
		this.sportname = sportname;
	}


	public Date getGametime() {
		return gametime;
	}


	public void setGametime(Date gametime) {
		this.gametime = gametime;
	}


	public String getStadium() {
		return stadium;
	}


	public void setStadium(String stadium) {
		this.stadium = stadium;
	}


	public int getG_status() {
		return g_status;
	}


	public void setG_status(int g_status) {
		this.g_status = g_status;
	}
	
	
}
