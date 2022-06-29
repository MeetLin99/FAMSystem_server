package com.neuedu.service;

import com.neuedu.beans.News;
import com.neuedu.beans.PageBean;

public interface NewsService {
	public int insertNews(News news);

	//获取新闻的页面对象,具体的参数根据返回值起始就可以确定
	public PageBean<News> selectNewsPageBean(int start,int pageSize,int pageNum,String title);

	public News selectNewsById(int id);
	
	public int updateNewsById(News news);
	
	public int deleteNewsById(int id);
}
