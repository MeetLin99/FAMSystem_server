package com.neuedu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.beans.Admin;
import com.neuedu.beans.Goods;
import com.neuedu.beans.PageBean;
import com.neuedu.beans.ResponseBean;
import com.neuedu.service.AdminService;

/**
 * admin控制层实现类
 * @author HP
 *
 */
@RestController
public class AdminController {
	@Autowired
	private AdminService as;
	
	@RequestMapping(value ="api/login",method = RequestMethod.POST)
	public ResponseBean<Admin> adminLogin(String username,String password){
		//准备返回的响应对象（状态码、提示消息、数据）
		ResponseBean<Admin> loginRB = new ResponseBean<Admin>();
		//调用服务层的支持（数据）
		Admin login = as.selectAdminByNameAndPass(username, password);
		//准备响应对象中的存储数据的集合
		List<Admin> list = new ArrayList<Admin>();
		//处理登录是否成功
		if (login != null) {//登录成功，处理响应对象
			//状态码：“1”
			loginRB.setCode("1");
			//提示消息
			loginRB.setMsg("恭喜，登陆成功！");
			//数据
			list.add(login);
			loginRB.setList(list);
		}else {//登录失败，处理响应对象
			//状态码：“2”
			loginRB.setCode("2");
			//提示消息
			loginRB.setMsg("用户名或者密码不存在！");
			//数据
			loginRB.setList(list);
		}
		return loginRB;
	}
	
	//个人信息
	@RequestMapping(value = "api/info",method = RequestMethod.POST)
	public ResponseBean<Admin> adminInfo(String aname,String apass){
		//准备响应对象
		ResponseBean<Admin> infoRB = new ResponseBean<Admin>();
		//准备响应对象中的List合集
		List<Admin> list = new ArrayList<Admin>();
		//调用服务层支持
		Admin info = as.selectAdminByNameAndPass(aname, apass);
		//个人信息是否获取成功
		if (info != null) {
			list.add(info);
			infoRB.setCode("1");
			infoRB.setMsg("个人信息获取成功！！！");
			infoRB.setList(list);
		}else {
			infoRB.setCode("2");
			infoRB.setMsg("个人信息获取失败！");
			infoRB.setList(list);
		}
		return infoRB;
		
	}
	
	//修改密码
	@RequestMapping(value = "api/pass",method = RequestMethod.POST)
	public ResponseBean<Admin> updatePass(String aname,String apass,String newPassword,String rNewPassword){
		//准备响应对象
		ResponseBean<Admin> updateRB = new ResponseBean<Admin>();
		//准备响应对象中的List合集
		List<Admin> list = new ArrayList<Admin>();
		//调用服务层支持
		//1.找到要修改的管理员信息(原来的姓名和密码)
		Admin nowLogin = as.selectAdminByNameAndPass(aname, apass);
		if (nowLogin == null) {
			//用户名或者密码错误
			updateRB.setCode("2");
			updateRB.setMsg("用户名或者密码错误，修改失败");
		}else {
			//2.封装被修改信息的对象
			nowLogin.setAdminPassword(rNewPassword);
			//3.真正的调用服务层修改密码处理
			int num = as.UpdatePassById(nowLogin);
			if(num == 1) {
				updateRB.setCode("1");
				updateRB.setMsg("修改成功，请重新登录");
				updateRB.setList(list);
			}else {
				updateRB.setCode("2");
				updateRB.setMsg("修改失败");
				updateRB.setList(list);
			}
		}
		return updateRB;
	}
	
	//添加用户信息
	@PostMapping("api/addAdmin")
	public ResponseBean<Admin> insertAdmin(String adminname,String adminpassword) {
		Admin admin = new Admin();
		admin.setAdminName(adminname);
		admin.setAdminPassword(adminpassword);
		System.out.println(admin);
		ResponseBean<Admin> addRB = new ResponseBean<Admin>();
		List<Admin> list = new ArrayList<Admin>();
		int num = as.doInsertAdmin(admin);
		System.out.println(admin.getAdminName());
		System.out.println(admin.getAdminPassword());
		if (num == 1) {
			addRB.setCode("1");
			addRB.setMsg("添加用户信息成功！！！");
			addRB.setList(list);
		}else {
			addRB.setCode("2");
			addRB.setMsg("添加失败!");
		}
		return addRB;
	}
	
	//显示用户信息
	@PostMapping("api/admin")
	public PageBean<Admin> queryAdminByTitleLikeLimit(String query,String pageSize,String pageNum){
		System.out.println("as.selectAdminPageBean((Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageSize), Integer.parseInt(pageNum), query)");
		return as.selectAdminPageBean((Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageSize), Integer.parseInt(pageNum), query);
	};
	
	//id查询信息
	@PostMapping("api/getAdminById")
	public Admin queryAdminById(String id) {
		return as.selectAdminById(Integer.parseInt(id));
	}
	
	//id修改信息
	@PostMapping("api/updateaAdmin")
	public ResponseBean<Admin> updateAdminById(String id,String adminpassword)
	{
		Admin admin = new Admin();
		admin.setId(Integer.parseInt(id));
		admin.setAdminPassword(adminpassword);
		ResponseBean<Admin> updateAdminRB =new ResponseBean<Admin>();
		int num =as.updateAdminById(admin);
		if(num == 1)
		{
			updateAdminRB.setCode("1");
			updateAdminRB.setMsg("更新成功");
		}
		else
		{
			updateAdminRB.setCode("2");
			updateAdminRB.setMsg("更新失败");
		}
		return updateAdminRB;
	}
	
	@PostMapping("api/deleteAdminById")
	public int deleteAdminById(String id)
	{
		return as.deleteAdminById(Integer.parseInt(id));
	}
	
}
