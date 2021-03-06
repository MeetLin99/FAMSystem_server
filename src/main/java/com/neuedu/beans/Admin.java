package com.neuedu.beans;
/**
 * 数据库表ADMIN对应实体类
 * @author 
 *
 */
public class Admin {
	
	// 属性
	private Integer id;				// ID
	private String adminName;		// 登录名字
	private String adminPassword;	// 登录密码
	private String adminStatus; 	// 登录状态,0未修改密码，1修改过密码
	private String adminSex;        // 用户性别
	
	// 访问器
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}
	public String getAdminSex() {
		return adminSex;
	}
	public void setAdminSex(String adminSex) {
		this.adminSex = adminSex;
	}
	
	
	// 构造器
	public Admin() {}
	public Admin(Integer id, String adminName, String adminPassword, String adminStatus, String adminSex) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminStatus = adminStatus;
		this.adminSex = adminSex;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", adminPassword=" + adminPassword + ", adminStatus="
				+ adminStatus + ", adminSex=" + adminSex + "]";
	}


}
