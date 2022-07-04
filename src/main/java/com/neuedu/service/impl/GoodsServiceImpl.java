package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.beans.Goods;
import com.neuedu.beans.PageBean;
import com.neuedu.mapper.GoodsMapper;
import com.neuedu.service.GoodsService;


@Service
    public class GoodsServiceImpl implements GoodsService {
@Autowired
    private GoodsMapper gm;
@Override
	public int insertGoods(Goods goods) {
		// TODO Auto-generated method stub
	//调用数据层支持
		return gm.doInsertGoods(goods);
	}
@Override
public PageBean<Goods> selectGoodsPageBean(int start,int pageSize,int pageNum,String gname){
	int totalCount = gm.selectGoodstotalCount(gname);
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
	List<Goods> list = gm.selectGoodsByTitleLikeLimit(gname, start, pageSize);
	PageBean<Goods> goodsPB = new PageBean<Goods>(pageSize,pageNum,totalCount,lastPageNum,list);
	return goodsPB;
}

@Override
public Goods selectGoodsById(int gno) {
	// TODO Auto-generated method stub
	return gm.selectGoodsById(gno);
}
@Override
public int updateGoodsById(Goods goods) {
	// TODO Auto-generated method stub
	return gm.doUpdateGoodsById(goods);
}
@Override
public int deleteGoodsById(int gno) {
	// TODO Auto-generated method stub
	return gm.doDeleteGoodsById(gno);
}
 
}
