package com.neuedu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.beans.Goods;
import com.neuedu.beans.PageBean;
import com.neuedu.beans.ResponseBean;
import com.neuedu.service.GoodsService;
import com.neuedu.utils.HandleString;

//news的控制层处理
@RestController
public class GoodsController {
@Autowired
   private GoodsService gs;
@PostMapping("api/addGoods")
   public ResponseBean<Goods> addGoods(String gname,String gprice,String gdate )
   {
	   ResponseBean<Goods>addRB =new ResponseBean<Goods>();
	   List<Goods> list =new ArrayList<Goods>();
	   //准备添加的新闻对象
	
	// if(title == null || "".equals(title) || newsAbstract == null || "".equals(newsAbstract)|| text == null || "".equals(text))
	   if(HandleString.returnNullByString(gname) == null|| HandleString.returnNullByString(gprice) == null|| HandleString.returnNullByString(gdate) == null)
	   {
		 addRB.setCode("2");
		 addRB.setMsg("添加失败");
		 
	 }
	 else
	 {   int num =  gs.insertGoods(new Goods(gname,gprice,gdate));
		 if(num == 1)
		 {
			 addRB.setCode("1");
			 addRB.setMsg("添加成功");
			 addRB.setList(list);
		 }else
		 {
			 addRB.setCode("2");
			 addRB.setMsg("添加失败");
		 }
	 }
	   return addRB;
   }
@PostMapping("api/goods")
public PageBean<Goods> queryGoodsByTitleLikeLimit(String query,String pageSize,String pageNum){
	System.out.println(gs.selectGoodsPageBean((Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageSize), Integer.parseInt(pageNum), query));
	return gs.selectGoodsPageBean((Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageSize), Integer.parseInt(pageNum), query);
}

@PostMapping("api/getGoodsById")
public Goods queryGoodsById(String gno)
{
	return gs.selectGoodsById(Integer.parseInt(gno));
}
@PostMapping("api/updateGoods")
public ResponseBean<Goods> updateGoodsById(Goods goods)
{
	ResponseBean<Goods> updateGoodsRB =new ResponseBean<Goods>();
	int num =gs.updateGoodsById(goods);
	if(num == 1)
	{
		updateGoodsRB.setCode("1");
		updateGoodsRB.setMsg("更新成功");
	}
	else
	{
		updateGoodsRB.setCode("2");
		updateGoodsRB.setMsg("更新失败");
	}
	return updateGoodsRB;
}
@PostMapping("api/deleteGoodsById")
public int deleteGoodsById(String gno)
{
	return gs.deleteGoodsById(Integer.parseInt(gno));
}
}
