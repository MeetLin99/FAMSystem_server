package com.neuedu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.beans.Stock;
import com.neuedu.beans.PageBean;
import com.neuedu.beans.ResponseBean;
import com.neuedu.service.StockService;
import com.neuedu.utils.HandleString;

@RestController
public class StockController {
	@Autowired
	private StockService ns;
	
	@PostMapping("/api/addStock")
	public ResponseBean<Stock> addStock(String gname,String category,int ammount,int batch){
		ResponseBean<Stock> addRB = new ResponseBean<Stock>();
		List<Stock> list = new ArrayList<Stock>();
		
		//if(title == null || "".equals(title) || newsAbstract== null || "".equals(newsAbstract) || text== null || "".equals(text)) {
		if(HandleString.returnNullByString(gname) == null || HandleString.returnNullByString(category) == null) {
		addRB.setCode("2");
			addRB.setCode("null");
		}else {
			int num = ns.insertStock(new Stock(gname,category,ammount,batch));
			if(num == 1) {
				addRB.setCode("1");
				addRB.setCode("sucessfully");
				addRB.setList(list);
			}else {
				addRB.setCode("2");
				addRB.setCode("failed");
			}		
		}
		return addRB;
	}
	
	@PostMapping("api/Stock")
	public PageBean<Stock> queryNewsByTitleLikeLimit(String query,String pageSize,String pageNum){
		return ns.selectStockPageBean((Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageSize), Integer.parseInt(pageNum), query);
	}

	@PostMapping("api/getStockById")
	public Stock queryStockById(String stockno) {
		return ns.selectStockById(Integer.parseInt(stockno));
	}
	
	@PostMapping("api/updateStock")
	public ResponseBean<Stock> updateStockById(Stock stock) {
		System.out.println(stock.toString());
		ResponseBean<Stock> updateNewRB = new ResponseBean<Stock>();
		int num = ns.updateStockById(stock);
		if(num == 1) {
			updateNewRB.setCode("1");
			updateNewRB.setMsg("sucessfully");
		}else {
			updateNewRB.setCode("2");
			updateNewRB.setMsg("failed");
		}
		return updateNewRB;
	}

	@PostMapping("api/deleteStockById")
	public int deleteStockById(String stockno){
		System.out.println(stockno);
		return ns.deleteStockById(Integer.parseInt(stockno));
	}

}
