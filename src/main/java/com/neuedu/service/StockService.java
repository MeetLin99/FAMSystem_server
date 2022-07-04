package com.neuedu.service;

import com.neuedu.beans.Stock;

import java.util.List;

import com.neuedu.beans.PageBean;

public interface StockService {
	public int insertStock(Stock stock);

	//获取新闻的页面对象,具体的参数根据返回值起始就可以确定
	public PageBean<Stock> selectStockPageBean(int start,int pageSize,int pageNum,String gname);

	public Stock selectStockById(int stockno);
	
	public int updateStockById(Stock stock);
	
	public int deleteStockById(int stockno);
	
	public List<Stock> findAll();

}
