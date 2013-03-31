package com.itcast.vo;

public class UserLogin {

	/**
	 * 客户端IP
	 */
	String clientIp;
	/**
	 * 用户唯一性标志
	 */
	String guid;
	/**
	 * 用户Id
	 */
	String tid;
	String userName ;
	String userPwd ;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "UserLogin [clientIp=" + clientIp + ", guid=" + guid + ", tid="
				+ tid + ", userName=" + userName + ", userPwd=" + userPwd + "]";
	}
	public UserLogin(String clientIp, String guid, String tid, String userName,
			String userPwd) {
		super();
		this.clientIp = clientIp;
		this.guid = guid;
		this.tid = tid;
		this.userName = userName;
		this.userPwd = userPwd;
	}
	public UserLogin() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
