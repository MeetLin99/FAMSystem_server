package com.neuedu.beans;

import java.util.List;

/**
 * 封装自己的分页使用的页面数据类
 * @author 
 *
 */
public class PageBean<T> {
	// 属性
	private Integer pageSize;		//每页显示的记录数
	private Integer pageNum;		//当前是第几页
	private Integer totalCount;		//数据的总条数(一定根据你需要的条件)
	private Integer lastPageNum;	//最后一页
	private List<T> list;			//当前页面的数据
	
	// 访问器
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getLastPageNum() {
		return lastPageNum;
	}
	public void setLastPageNum(Integer lastPageNum) {
		this.lastPageNum = lastPageNum;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	// 构造器
	public PageBean(){
		
	}
	public PageBean(Integer pageSize, Integer pageNum, Integer totalCount, Integer lastPageNum, List<T> list) {
	
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.totalCount = totalCount;
		this.lastPageNum = lastPageNum;
		this.list = list;
	}
	
	// 重写toString()方法
	@Override
	public String toString() {
		return "PageBean [pageSize=" + pageSize + ", pageNum=" + pageNum + ", totalCount=" + totalCount
				+ ", lastPageNum=" + lastPageNum + ", list=" + list + "]";
	}
}
