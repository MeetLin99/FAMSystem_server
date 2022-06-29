package com.neuedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neuedu.beans.News;

public interface NewsMapper {
	@Insert("INSERT INTO news (TITLE,NEWSABSTRACT,TEXT,RELEASDATE)"+
			"VALUES (#{Title},#{newsAbstract},#{Text},NOW())")
	public int doInsertNews(News news);

	@Select("<script>"
			+ "SELECT * FROM news "
			+ "WHERE 1= 1 "
			+ "<if test = ' title != null'>"
			+ "AND title LIKE CONCAT('%',#{title},'%') "
			+ "</if>"
			+ "LIMIT #{start},#{pageSize}"
			+ "</script>"
			)
	public List<News> selectNewsByTitleLikeLimit(@Param("title")String title,@Param("start")int start,@Param("pageSize")int pageSize);
	
	/**
	 * 查询新闻总数
	 * @param title
	 * @return 符合条件总数
	 */
	@Select("<script>"
			+ "SELECT COUNT(*) FROM news "
			+ "WHERE 1 = 1 "
			+ "<if test = ' title  != null'>"
			+ "AND title LIKE CONCAT('%',#{title},'%')"
			+ "</if>"
			+ "</script>"
			)
	public int selectNewstotalCount(@Param("title")String title
);
	
	@Select("SELECT * FROM news WHERE id = #{id}")
	public News selectNewsById(@Param("id")int id);

	@Update("UPDATE news SET NEWSABSTRACT = #{newsAbstract},TEXT= #{Text} WHERE id = #{id}")
	public int doUpdateNewsById(News news);
	
	@Delete("DELETE FROM news WHERE id = #{id}")
	public int doDeleteNewsById(@Param("id")int id);
}
