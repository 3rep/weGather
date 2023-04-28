package com.gather.we.dto;

public class Manager10DTO {
	
	    private String stadium;
	    private String location;
	    private String gametime;
	    private int g_status;
	    private String managerid;
	    
	    
	    private String id;
	    private String username;
	    private String gender;
	    private Integer rank;
	    private int s_no;
	    private String userid;
	    private int tel;
	    private int p_no;
	   
		private String rankFilter;
	   
	    
	    
	    
	    
	    
	    
	    
		
		
		@Override
		public String toString() {
			return "Manager10DTO [stadium=" + stadium + ", location=" + location + ", gametime=" + gametime
					+ ", g_status=" + g_status + ", managerid=" + managerid + ", id=" + id + ", username=" + username
					+ ", gender=" + gender + ", rank=" + rank + ", s_no=" + s_no + ", userid=" + userid + ", tel=" + tel
					+ ", p_no=" + p_no + ", rankFilter=" + rankFilter + "]";
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
		
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public Integer getRank() {
			return rank;
		}
		public void setRank(Integer rank) {
			this.rank = rank;
		}
		public int getS_no() {
			return s_no;
		}
		public void setS_no(int s_no) {
			this.s_no = s_no;
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public int getTel() {
			return tel;
		}
		public void setTel(int tel) {
			this.tel = tel;
		}
		public String getRankFilter() {
			return rankFilter;
		}
		public void setRankFilter(String rankFilter) {
			this.rankFilter = rankFilter;
		}
		public String getManagerid() {
			return managerid;
		}
		public void setManagerid(String managerid) {
			this.managerid = managerid;
		}
		public int getP_no() {
			return p_no;
		}
		public void setP_no(int p_no) {
			this.p_no = p_no;
		}
	    
		
	    
		public boolean isValid() {
	        return userid != null && !userid.isEmpty() && rank != null;
	    }

	    // null 대응 메서드 추가
	    public void initialize() {
	        if (rank == null) {
	            rank = 0;
	        }
	    }
   
    
  
    
    
}
