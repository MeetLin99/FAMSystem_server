package com.neuedu.mapper;
/**
 * admin数据层的处理
 * @author HP
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neuedu.beans.Admin;

public interface AdminMapper {
	
	/**
	 * 根据用户名和密码查询管理员信息
	 * @param adminname：姓名
	 * @param adminpassword：密码
	 * @return：返回管理员信息
	 */
	@Select("SELECT * FROM admin WHERE ADMINNAME = #{adminname} AND ADMINPASSWORD = #{adminpassword}")
	public Admin selectAdminByNameAndPass(@Param ("adminname")String adminname,@Param ("adminpassword")String adminpassword);
	
	/**
	 * 管理员修改密码
	 * @param updateAdmin：封装修改信息的对象
	 * @return：如果返回的是1，修改成功，否则修改失败
	 */
	@Update("UPDATE admin SET ADMINPASSWORD = #{adminPassword},ADMINSTATUS = 1 WHERE ID = #{id}")
	public int doUpdatePassById(Admin updateAdmin);
	
	/**
	 * 增加新的用户
	 * @param admin；封装被增加的用户信息
	 * @return
	 */
	@Insert("INSERT INTO admin (ADMINNAME,ADMINPASSWORD,ADMINSEX) VALUES (#{adminName},#{adminPassword},#{adminSex})")
	public int doInsertAdmin(Admin admin);
	

	@Select("<script>"
			+ "SELECT * FROM admin "
			+ "where 1=1 "
			+ "<if test = 'ADMINNAME != null' >"
			+ "AND ADMINNAME like CONCAT('%',#{ADMINNAME},'%')"
			+ "</if>"
			+ " LIMIT #{start},#{pageSize}"
			+ "</script>")
	public List<Admin> selectAdminByNameLikeLimit(@Param("ADMINNAME")String ADMINNAME,@Param("start")int start,@Param("pageSize")int pageSize);
	
	
	/**
	 * 查询用户信息总数
	 * @param stuname
	 * @return
	 */
	@Select("<script>"
			+ "SELECT COUNT(*) from admin "
			+ "where TRUE = TRUE "
			+ "<if test='ADMINNAME != null'>"
			+ "and ADMINNAME LIKE CONCAT('%',#{ADMINNAME},'%')"
			+ "</if>"
			+ "</script>"
			)
	public int selectAdmintotalCount(@Param("ADMINNAME")String ADMINNAME);
	
	/**
	 * 根据ID查询admin用户信息
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM admin WHERE ID = #{id}")
	public Admin selectAdminById(@Param("id")int id);
	
	@Update("UPDATE admin SET ADMINPASSWORD = #{adminPassword} , ADMINSEX = #{adminSex} WHERE ID = #{id}")
	public int doUpdateAdminById(Admin admin);
	
	@Delete("DELETE FROM admin WHERE ID =#{id} ")
	public int doDeleteAdminById(@Param("id")int id);

}

