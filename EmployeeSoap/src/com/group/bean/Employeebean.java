package com.group.bean;

public class Employeebean {

	private String username;
	private String password;
	private int userid;
	private int groupid;
	private String email;
	private static int count = 0;
	
	public Employeebean(){
		count++;
		this.setUserid(count);
	}
	
	/*public Employeebean(String username, String password, int groupid, String email)
	{
		this.username = username;
		this.password = password;
		++userid;
		this.groupid = groupid;
		this.email = email;
	}*/
	
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Employee [userid= " + userid + ", groupid= " + groupid + ", username=" + username
				+ ", password= " + password + ", email= " + email + "]";
	}
	
	
}
