package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.beans.Admin;
import com.neuedu.beans.PageBean;
import com.neuedu.mapper.AdminMapper;
import com.neuedu.service.AdminService;

@Service
public class AdminSeriviceImpl implements AdminService {

	@Autowired
	private AdminMapper am;

	@Override
	public Admin selectAdminByNameAndPass(String adminName, String adminPassword) {
		return am.selectAdminByNameAndPass(adminName, adminPassword);
	}

	@Override
	public int UpdatePassById(Admin updateAdmin) {
		return am.doUpdatePassById(updateAdmin);
	}

	@Override
	public int doInsertAdmin(Admin admin) {
		return am.doInsertAdmin(admin);
	}

	@Override
	public PageBean<Admin> selectAdminPageBean(int start,int pageSize, int pageNum, String ADMINNAME) {
		int totalCount = am.selectAdmintotalCount(ADMINNAME);
		int lastPageNum = 0;
		if (totalCount % pageSize == 0) {
			lastPageNum = totalCount / pageSize;
		}else {
			lastPageNum = totalCount / pageSize + 1;
		}
		//判断当前页数传值是否合理
		if (pageNum > lastPageNum) {
			pageNum = lastPageNum;
		}
		if (pageNum < 1) {
			pageNum = 1;
		}
		List<Admin> list = am.selectAdminByNameLikeLimit(ADMINNAME, start, pageSize);
		//准备一个页面对象
		PageBean<Admin> adminPB = new PageBean<Admin>(pageSize,pageNum,totalCount,lastPageNum,list);
		return adminPB;
	}

	@Override
	public Admin selectAdminById(int id) {
		return am.selectAdminById(id);
	}

	@Override
	public int updateAdminById(Admin admin) {
		return am.doUpdateAdminById(admin);
	}

	@Override
	public int deleteAdminById(int id) {
		return am.doDeleteAdminById(id);
	}


}
