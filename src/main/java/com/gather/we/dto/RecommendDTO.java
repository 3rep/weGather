package com.gather.we.dto;



public class RecommendDTO  {
		private int no;
		private String userid;
		private String mbti;
	 	private String gender;
	    private int age;
	    private String game;
	    
	    
	       
	    
	    
		@Override
		public String toString() {
			return "RecommendDTO [no=" + no + ", userid=" + userid + ", mbti=" + mbti + ", gender=" + gender + ", age="
					+ age + ", game=" + game + "]";
		}
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getMbti() {
			return mbti;
		}
		public void setMbti(String mbti) {
			this.mbti = mbti;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getGame() {
			return game;
		}
		public void setGame(String game) {
			this.game = game;
		}
	      
	   	
	    
	    
}
