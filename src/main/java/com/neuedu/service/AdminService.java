package com.neuedu.service;

import com.neuedu.beans.Admin;
import com.neuedu.beans.PageBean;

/**
 * Admin的服务层接口
 * @author HP
 *
 */
public interface AdminService {
	
	//根据姓名和密码查询管理员信息
	public Admin selectAdminByNameAndPass(String adminName,String adminPassword);
	
	//管理员修改密码
	public int UpdatePassById(Admin updAdmin);
	
	//增加新用户
	public int doInsertAdmin(Admin admin);
	
	//返回用户的分页对象
	public PageBean<Admin> selectAdminPageBean(int start,int pageSize,int pageNum,String ADMINNAME);
	
	//根据id查询admin信息
	public Admin selectAdminById(int id);
	
	//根据id更新信息
	public int updateAdminById(Admin admin);
	
	public int deleteAdminById(int id);
	
}
