package com.gather.we.dto;

public class ManagerInputDTO {

	private String username;
	private String rank;
	private String userid;
	private String rankFilter;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "ManagerInputDTO [username=" + username + ", rank=" + rank + ", userid=" + userid + ", rankFilter="
				+ rankFilter + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRankFilter() {
		return rankFilter;
	}
	public void setRankFilter(String rankFilter) {
		this.rankFilter = rankFilter;
	}
	 
	
	
	
	
	
	
	
	
}
