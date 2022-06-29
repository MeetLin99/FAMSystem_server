package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.beans.News;
import com.neuedu.beans.PageBean;
import com.neuedu.mapper.NewsMapper;
import com.neuedu.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsMapper nm;

	@Override
	public int insertNews(News news) {
		return nm.doInsertNews(news);
	}

	@Override
	public PageBean<News> selectNewsPageBean(int start,int pageSize,int pageNum,String title){
		int totalCount = nm.selectNewstotalCount(title);
		int lastPageNum = 0;
		if(totalCount % pageSize == 0) {
			lastPageNum = totalCount / pageSize ;
		}else {
			lastPageNum = totalCount / pageSize + 1;
		}
		
		if(pageNum > lastPageNum) {
			pageNum = lastPageNum;
		}
		
		if(pageNum < 1) {
			pageNum = 1;
		}
		
		//int start = (pageNum - 1) * pageSize;
		List<News> list = nm.selectNewsByTitleLikeLimit(title, start, pageSize);
		PageBean<News> newsPB = new PageBean<News>(pageSize,pageNum,totalCount,lastPageNum,list);
		return newsPB;
	}

	@Override
	public News selectNewsById(int id) {
		// TODO Auto-generated method stub
		return nm.selectNewsById(id);
	}

	@Override
	public int updateNewsById(News news) {
		// TODO Auto-generated method stub
		return nm.doUpdateNewsById(news);
	}

	@Override
	public int deleteNewsById(int id) {
		// TODO Auto-generated method stub
		return nm.doDeleteNewsById(id);
	}
}
