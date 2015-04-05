package com.yuguo.mydoctor.main.entity;

/**
 * 登录用户信息
 * 
 * @author wangshaoibn
 * 
 */
public class User {
	/**
	 * 网络请求ID
	 */
	private String id;
	/**
	 * 网络请求TOKEN
	 */
	private String token;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 用户名
	 */
	private String username;

	public User() {

	}

	public User(String id, String token, String realname, String phone,
                String username, String tel) {
		super();
		this.id = id;
		this.token = token;
		this.realname = realname;
		this.phone = phone;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
