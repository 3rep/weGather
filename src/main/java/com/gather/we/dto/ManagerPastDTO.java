package com.gather.we.dto;


public class ManagerPastDTO {
	
	
	 private String stadium;
	    private String location;
	    private String gametime;
	    private int g_status;
	    private String managerid;
	    
	    
	    
	    
	    
	    
		
		
		@Override
		public String toString() {
			return "ManagerPastDTO [stadium=" + stadium + ", location=" + location + ", gametime=" + gametime
					+ ", g_status=" + g_status + ", managerid=" + managerid + "]";
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
		public String getManagerid() {
			return managerid;
		}
		public void setManagerid(String managerid) {
			this.managerid = managerid;
		}
		
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
