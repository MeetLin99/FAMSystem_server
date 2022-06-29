package com.neuedu.service;

import com.neuedu.beans.Admin;

/**
 * admin服务层接口
 * @author lance
 *
 */
public interface AdminService {
	public Admin selectAdminByNameAndPass(String adminName,String adminPassword);

	public int UpdatePassById(Admin updateAdmin);
}
