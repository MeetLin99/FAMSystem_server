package com.neuedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neuedu.beans.Goods;

//news层数据接口
public interface GoodsMapper {
//添加新闻信息，news：封装新闻信息对象，返回1添加成功，否则失败
@Insert("INSERT INTO goods (gno,gname,gprice,releasdate) " + 
		"VALUES (#{gno},#{gname},#{gprice},NOW())")
	public int doInsertGoods(Goods goods);
@Select("<script>"
		+ "SELECT * FROM goods "
		+ "WHERE 1= 1 "
		+ "<if test = ' gname != null'>"
		+ "AND gname LIKE CONCAT('%',#{gname},'%') "
		+ "</if>"
		+ "LIMIT #{start},#{pageSize}"
		+ "</script>"
		)
public List<Goods> selectGoodsByTitleLikeLimit(@Param("gname")String gname,@Param("start")int start,@Param("pageSize")int pageSize);

/**
 * 查询新闻总数
 * @param title
 * @return 符合条件总数
 */
@Select("<script>"
		+ "SELECT COUNT(*) FROM goods "
		+ "WHERE 1 = 1 "
		+ "<if test = ' gname  != null'>"
		+ "AND gname LIKE CONCAT('%',#{gname},'%')"
		+ "</if>"
		+ "</script>"
		)
public int selectGoodstotalCount(@Param("gname")String gname);
@Select("SELECT * FROM goods WHERE gno = #{gno}")
public Goods selectGoodsById(@Param("gno")int gno);

@Update("UPDATE goods SET gprice=#{gprice},gdate=#{gdate} WHERE gno =#{gno}")
public int doUpdateGoodsById(Goods goods);

@Delete("DELETE FROM goods WHERE gno =#{gno} ")
public int doDeleteGoodsById(@Param("gno")int gno);
}
