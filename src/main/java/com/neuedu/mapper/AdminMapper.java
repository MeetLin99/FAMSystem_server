package com.neuedu.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neuedu.beans.Admin;

/**
 * admin数据层
 * @author lance
 *
 */
public interface AdminMapper {

	@Select("SELECT * FROM admin WHERE ADMINNAME = #{adminname} AND ADMINPASSWORD = #{adminpassword}")
	public Admin selectAdminByNameAndPass(@Param("adminname")String adminname,@Param("adminpassword")String adminpassword);

	//管理员修改密码，updateAdmin封装修改信息的对象
	@Update("UPDATE admin SET ADMINPASSWORD = #{adminPassword},ADMINSTATUS = 1 WHERE id = #{id}")
	public int doUpdatePassById(Admin updateAdmin);
}
