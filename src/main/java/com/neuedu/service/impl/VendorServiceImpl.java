package com.neuedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.beans.Vendor;
import com.neuedu.beans.PageBean;
import com.neuedu.mapper.VendorMapper;
import com.neuedu.service.VendorService;


@Service
    public class VendorServiceImpl implements VendorService {
@Autowired
    private VendorMapper vm;
@Override
	public int insertVendor(Vendor vendor) {
		// TODO Auto-generated method stub
	//调用数据层支持
		return vm.doInsertVendor(vendor);
	}
@Override
public PageBean<Vendor> selectVendorPageBean(int start,int pageSize,int pageNum,String vname){
	int totalCount = vm.selectVendortotalCount(vname);
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
	List<Vendor> list = vm.selectVendorByTitleLikeLimit(vname, start, pageSize);
	PageBean<Vendor> vendorPB = new PageBean<Vendor>(pageSize,pageNum,totalCount,lastPageNum,list);
	return vendorPB;
}

@Override
public Vendor selectVendorById(int vno) {
	// TODO Auto-generated method stub
	return vm.selectVendorById(vno);
}
@Override
public int updateVendorById(Vendor vendor) {
	// TODO Auto-generated method stub
	return vm.doUpdateVendorById(vendor);
}
@Override
public int deleteVendorById(int vno) {
	// TODO Auto-generated method stub
	return vm.doDeleteVendorById(vno);
}
}
