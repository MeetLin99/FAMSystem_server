package com.neuedu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.beans.News;
import com.neuedu.beans.PageBean;
import com.neuedu.beans.ResponseBean;
import com.neuedu.service.NewsService;
import com.neuedu.utils.HandleString;

@RestController
public class NewsController {
	@Autowired
	private NewsService ns;
	
	@PostMapping("/api/addNews")
	public ResponseBean<News> addNews(String title,String newsAbstract,String text){
		ResponseBean<News> addRB = new ResponseBean<News>();
		List<News> list = new ArrayList<News>();
		
		//if(title == null || "".equals(title) || newsAbstract== null || "".equals(newsAbstract) || text== null || "".equals(text)) {
		if(HandleString.returnNullByString(title) == null || HandleString.returnNullByString(newsAbstract) == null || HandleString.returnNullByString(text) == null) {
		addRB.setCode("2");
			addRB.setCode("null");
		}else {
			//准备被添加的新闻对象
			int num = ns.insertNews(new News(title,newsAbstract,text));
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
	
	@PostMapping("api/news")
	public PageBean<News> queryNewsByTitleLikeLimit(String query,String pageSize,String pageNum){
		return ns.selectNewsPageBean((Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageSize), Integer.parseInt(pageNum), query);
	}

	@PostMapping("api/getNewsById")
	public News queryNewsById(String id) {
		return ns.selectNewsById(Integer.parseInt(id));
	}
	
	@PostMapping("api/updateNews")
	public ResponseBean<News> updateNewsById(News news) {
		//使用对象接收参数，参数名要和实体类属性名一致
		ResponseBean<News> updateNewRB = new ResponseBean<News>();
		int num = ns.updateNewsById(news);
		if(num == 1) {
			updateNewRB.setCode("1");
			updateNewRB.setMsg("sucessfully");
		}else {
			updateNewRB.setCode("2");
			updateNewRB.setMsg("failed");
		}
		return updateNewRB;
	}

	@PostMapping("api/deleteNewsById")
	public int deleteNewsById(String id){
		return ns.deleteNewsById(Integer.parseInt(id));
	}
}
