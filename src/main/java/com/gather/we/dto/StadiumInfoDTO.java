package com.gather.we.dto;

public class StadiumInfoDTO {
	private int st_no;
	private String stadium;
	private String location;
	private String region;
	
	@Override
	public String toString() {
		return "StaInformationDTO [st_no=" + st_no + ", stadium=" + stadium + ", location=" + location + ", region="
				+ region + "]";
	}
	
	public int getSt_no() {
		return st_no;
	}
	public void setSt_no(int st_no) {
		this.st_no = st_no;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
}
