package com.neuedu.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neuedu.beans.Admin;
import com.neuedu.mapper.AdminMapper;
import com.neuedu.service.AdminService;

/**
 * admin服务层实现类
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper am;
	
	@Override
	public Admin selectAdminByNameAndPass(String adminName, String adminPassword) {
		//调用数据库接口
		return am.selectAdminByNameAndPass(adminName, adminPassword);
	}

	@Override
	public int UpdatePassById(Admin updateAdmin) {
		return am.doUpdatePassById(updateAdmin);
	}
}
