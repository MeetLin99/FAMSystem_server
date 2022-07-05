package com.neuedu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.beans.Vendor;
import com.neuedu.beans.PageBean;
import com.neuedu.beans.ResponseBean;
import com.neuedu.service.VendorService;
import com.neuedu.utils.HandleString;

//news的控制层处理
@RestController
public class VendorController {
@Autowired
   private VendorService vs;
@PostMapping("api/addVendor")
   public ResponseBean<Vendor> addGoods(String vname,String vtyp,String vtele )
   {
	   ResponseBean<Vendor>addRB =new ResponseBean<Vendor>();
	   List<Vendor> list =new ArrayList<Vendor>();
	   //准备添加的新闻对象
	
	// if(title == null || "".equals(title) || newsAbstract == null || "".equals(newsAbstract)|| text == null || "".equals(text))
	   if(HandleString.returnNullByString(vname) == null|| HandleString.returnNullByString(vtyp) == null|| HandleString.returnNullByString(vtele) == null)
	   {
		 addRB.setCode("2");
		 addRB.setMsg("添加失败");
		 
	 }
	 else
	 {   int num =  vs.insertVendor(new Vendor(vname,vtyp,vtele));
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
@PostMapping("api/vendor")
public PageBean<Vendor> queryVendorByTitleLikeLimit(String query,String pageSize,String pageNum){
	System.out.println(vs.selectVendorPageBean((Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageSize), Integer.parseInt(pageNum), query));
	return vs.selectVendorPageBean((Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize), Integer.parseInt(pageSize), Integer.parseInt(pageNum), query);
}

@PostMapping("api/getVendorById")
public Vendor queryVendorById(String vno)
{
	return vs.selectVendorById(Integer.parseInt(vno));
}
@PostMapping("api/updateVendor")
public ResponseBean<Vendor> updateVendorById(Vendor vendor)
{
	ResponseBean<Vendor> updateVendorRB =new ResponseBean<Vendor>();
	int num =vs.updateVendorById(vendor);
	if(num == 1)
	{
		updateVendorRB.setCode("1");
		updateVendorRB.setMsg("更新成功");
	}
	else
	{
		updateVendorRB.setCode("2");
		updateVendorRB.setMsg("更新失败");
	}
	return updateVendorRB;
}
@PostMapping("api/deleteVendorById")
public int deleteGoodsById(String vno)
{
	return vs.deleteVendorById(Integer.parseInt(vno));
}

}
