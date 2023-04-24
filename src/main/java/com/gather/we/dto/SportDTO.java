package com.gather.we.dto;


public class SportDTO {
	private int s_no;
	private String sportname;
	private String sportdesc;
	private String filename;
	
	
	@Override
	public String toString() {
		return "SportDTO [s_no=" + s_no + ", sportname=" + sportname + ", sportdesc=" + sportdesc + ", filename="
				+ filename + "]";
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getSportname() {
		return sportname;
	}
	public void setSportname(String sportname) {
		this.sportname = sportname;
	}
	public String getSportdesc() {
		return sportdesc;
	}
	public void setSportdesc(String sportdesc) {
		this.sportdesc = sportdesc;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
