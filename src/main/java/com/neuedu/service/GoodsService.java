package com.neuedu.service;


import com.neuedu.beans.Goods;
import com.neuedu.beans.PageBean;


public interface GoodsService {
//添加新闻
	public int insertGoods(Goods goods);
//	获取新闻页面对象,具体参数根据返回值起始可以确定
	public PageBean<Goods> selectGoodsPageBean(int start,int pageSize,int PageNum,String gname);
//
	public Goods selectGoodsById(int gno);
	public int updateGoodsById(Goods goods);
	
	public int deleteGoodsById(int gno);

}
