package com.neuedu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.beans.Admin;
import com.neuedu.beans.ResponseBean;
import com.neuedu.service.AdminService;

/**
 * admin控制层实现类
 * @author lance
 *
 */

@RestController
public class AdminController {
	//自动注入服务层
	@Autowired
	private AdminService as;
	
	@RequestMapping(value = "api/login",method = RequestMethod.POST)
	public ResponseBean<Admin> adminLogin(String username,String password){
		ResponseBean<Admin> loginRB = new ResponseBean<Admin>();
		Admin login = as.selectAdminByNameAndPass(username, password);
		List<Admin> list = new ArrayList<Admin>();
		//处理登录成功失败
		if(login != null) {
			loginRB.setCode("1");
			loginRB.setMsg("login sucessfully");
			list.add(login);//数据添加到集合
			loginRB.setList(list);
		}else {
			loginRB.setCode("2");
			loginRB.setMsg("login failed");
			loginRB.setList(list);
		}
		return loginRB;
	}
		
	@RequestMapping(value = "api/info",method = RequestMethod.POST)
	public ResponseBean<Admin> adminInfo(String aname,String apass){
	//准备返回的响应对象(状态码、消息、数据）
	ResponseBean<Admin> infoRB = new ResponseBean<Admin>();
	List<Admin> list = new ArrayList<Admin>();
	//调用服务层的支持（数据）
	Admin info = as.selectAdminByNameAndPass(aname, apass);
	if(info != null) {
		list.add(info);
		infoRB.setCode("1");
		infoRB.setMsg("sucessfully");
		infoRB.setList(list);
	}else {
		infoRB.setCode("2");
		infoRB.setMsg("failed");
		infoRB.setList(list);
	}
	return infoRB;
	}

	@RequestMapping(value = "api/pass",method = RequestMethod.POST)
	public ResponseBean<Admin> updatePass(String aname,String apass,String rNewPassword){
		ResponseBean<Admin> updateRB = new ResponseBean<Admin>();
		List<Admin> list = new ArrayList<Admin>();
		//找到管理员信息
		Admin nowLogin = as.selectAdminByNameAndPass(aname, apass);
		if(nowLogin != null) {
			//封装被修改信息的对象
			nowLogin.setAdminPassword(rNewPassword);
		}
		
		//调用服务层修改密码
		int num = as.UpdatePassById(nowLogin);
		if(num == 1) {
			updateRB.setCode("1");
			updateRB.setMsg("changed");
			updateRB.setList(list);
		}else {
			updateRB.setCode("2");
			updateRB.setMsg("failed");
		}
		
		return updateRB;
	}
	
}
