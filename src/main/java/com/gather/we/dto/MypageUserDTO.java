package com.gather.we.dto;

public class MypageUserDTO {
	private String userid;
	private String type;
	private String username;
	private String password;
	private String email;
	private String tel;
	private String address;
	private String gender;
	private String mbti;
	private int rank;
	private String signupdate;
	
	@Override
	public String toString() {
		return "MypageUserDTO [userid=" + userid + ", type=" + type + ", username=" + username + ", password="
				+ password + ", email=" + email + ", tel=" + tel + ", address=" + address + ", gender=" + gender
				+ ", mbti=" + mbti + ", rank=" + rank + ", signupdate=" + signupdate + "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMbti() {
		return mbti;
	}

	public void setMbti(String mbti) {
		this.mbti = mbti;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSignupdate() {
		return signupdate;
	}

	public void setSignupdate(String signupdate) {
		this.signupdate = signupdate;
	}
	
	
}
