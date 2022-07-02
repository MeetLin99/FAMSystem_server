package com.neuedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neuedu.beans.Stock;

public interface StockMapper {
	@Insert("INSERT INTO stock (GNAME,CATEGORY,AMMOUNT,BATCH)"+
			"VALUES (#{gname},#{category},#{ammount},#{batch})")
	public int doInsertStock(Stock stock);

	@Select("<script>"
			+ "SELECT * FROM stock "
			+ "WHERE 1= 1 "
			+ "<if test = ' gname != null'>"
			+ "AND gname LIKE CONCAT('%',#{gname},'%') "
			+ "</if>"
			+ "LIMIT #{start},#{pageSize}"
			+ "</script>"
			)
	public List<Stock> selectStockBygnameLikeLimit(@Param("gname")String gname,@Param("start")int start,@Param("pageSize")int pageSize);
	
	@Select("<script>"
			+ "SELECT COUNT(*) FROM stock "
			+ "WHERE 1 = 1 "
			+ "<if test = ' gname  != null'>"
			+ "AND gname LIKE CONCAT('%',#{gname},'%')"
			+ "</if>"
			+ "</script>"
			)
	public int selectStocktotalCount(@Param("gname")String gname
);
	
	@Select("SELECT * FROM stock WHERE stockno = #{stockno}")
	public Stock selectStockById(@Param("id")int id);

	@Update("UPDATE stock SET GNAME = #{gname},CATEGORY= #{category},AMMOUNT= #{ammount} WHERE id = #{id}")
	public int doUpdateStockById(Stock stock);
	
	@Delete("DELETE FROM stock WHERE stockno = #{stockno}")
	public int doDeleteStockById(@Param("stockno")int stockno);

}
