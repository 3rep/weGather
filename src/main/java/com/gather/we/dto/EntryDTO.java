package com.gather.we.dto;



public class EntryDTO {
	
	 private int id;
	    private String username;
	    private String gender;
	    private int rank;
	    private int s_no;
	    private String userid;
	    private int tel;
	    
	       
	    
	  
		
		@Override
		public String toString() {
			return "EntryDTO [id=" + id + ", username=" + username + ", gender=" + gender + ", rank=" + rank + ", s_no=" + s_no
					+ ", userid=" + userid + ", tel=" + tel + "]";
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
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
		public int getRank() {
			return rank;
		}
		public void setRank(int rank) {
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
    
	    
	
}
