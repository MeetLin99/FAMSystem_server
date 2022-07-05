package com.neuedu.service;
import com.neuedu.beans.Vendor;
import com.neuedu.beans.PageBean;



public interface VendorService {
//添加新闻
	public int insertVendor(Vendor vendor);
//	获取新闻页面对象,具体参数根据返回值起始可以确定
	public PageBean<Vendor> selectVendorPageBean(int start,int pageSize,int PageNum,String vname);
//
	public Vendor selectVendorById(int vno);
	public int updateVendorById(Vendor vendor);
	
	public int deleteVendorById(int vno);
	

}
