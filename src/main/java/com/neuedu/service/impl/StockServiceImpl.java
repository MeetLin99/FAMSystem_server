package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.beans.Stock;
import com.neuedu.beans.PageBean;
import com.neuedu.mapper.StockMapper;
import com.neuedu.service.StockService;

@Service
public class StockServiceImpl implements StockService{
	@Autowired
	private StockMapper nm;

	@Override
	public int insertStock(Stock stock) {
		return nm.doInsertStock(stock);
	}

	@Override
	public PageBean<Stock> selectStockPageBean(int start,int pageSize,int pageNum,String gname){
		int totalCount = nm.selectStocktotalCount(gname);
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
		List<Stock> list = nm.selectStockBygnameLikeLimit(gname, start, pageSize);
		PageBean<Stock> newsPB = new PageBean<Stock>(pageSize,pageNum,totalCount,lastPageNum,list);
		return newsPB;
	}

	@Override
	public Stock selectStockById(int stockno) {
		// TODO Auto-generated method stub
		return nm.selectStockById(stockno);
	}

	@Override
	public int updateStockById(Stock stock) {
		// TODO Auto-generated method stub
		return nm.doUpdateStockById(stock);
	}

	@Override
	public int deleteStockById(int stockno) {
		// TODO Auto-generated method stub
		return nm.doDeleteStockById(stockno);
	}

	@Override
	public List<Stock> findAll() {
		// TODO Auto-generated method stub
		return nm.selectAllStock();
	}




	
}
