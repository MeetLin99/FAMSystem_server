package com.neuedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neuedu.beans.Vendor;

//news层数据接口
public interface VendorMapper {
//添加新闻信息，news：封装新闻信息对象，返回1添加成功，否则失败
@Insert("INSERT INTO vendor (vno,vname,vtyp,vtele) " + 
		"VALUES (#{vno},#{vname},#{vtyp},#{vtele})")
	public int doInsertVendor(Vendor vendor);
@Select("<script>"
		+ "SELECT * FROM vendor "
		+ "WHERE 1= 1 "
		+ "<if test = ' vname != null'>"
		+ "AND vname LIKE CONCAT('%',#{vname},'%') "
		+ "</if>"
		+ "LIMIT #{start},#{pageSize}"
		+ "</script>"
		)
public List<Vendor> selectVendorByTitleLikeLimit(@Param("vname")String vname,@Param("start")int start,@Param("pageSize")int pageSize);

/**
 * 查询新闻总数
 * @param title
 * @return 符合条件总数
 */
@Select("<script>"
		+ "SELECT COUNT(*) FROM vendor "
		+ "WHERE 1 = 1 "
		+ "<if test = ' vname  != null'>"
		+ "AND vname LIKE CONCAT('%',#{vname},'%')"
		+ "</if>"
		+ "</script>"
		)
public int selectVendortotalCount(@Param("vname")String vname);
@Select("SELECT * FROM vendor WHERE vno = #{vno}")
public Vendor selectVendorById(@Param("vno")int vno);

@Update("UPDATE Vendor SET vtyp=#{vtyp},vtele=#{vtele} WHERE vno =#{vno}")
public int doUpdateVendorById(Vendor vendor);

@Delete("DELETE FROM vendor WHERE vno =#{vno} ")
public int doDeleteVendorById(@Param("vno")int vno);}

