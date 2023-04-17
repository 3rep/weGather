package com.gather.we.dto;

public class SportDTO {
	private int no;
	private String sportname;
	private String sportdesc;
	private String filename;
	
	@Override
	public String toString() {
		return "SportDTO [no=" + no + ", sportname=" + sportname + ", sportdesc=" + sportdesc + ", filename=" + filename
				+ "]";
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSport_name() {
		return sportname;
	}
	public void setSportname(String sport_name) {
		this.sportname = sport_name;
	}
	public String getSportdesc() {
		return sportdesc;
	}
	public void setSportdesc(String sport_desc) {
		this.sportdesc = sport_desc;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
}
