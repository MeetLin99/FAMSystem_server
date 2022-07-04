package com.neuedu.beans;

import java.sql.Date;

/**
 * 这是数据库表student对应的实体类【准备简单Java类】
 * @author ZY
 *
 */
public class Goods {
	// 属性
	private Integer gno;		// 学生编号
	private String  gname;	// 学生姓名
	private String gprice;		// 学生年龄
	private String gdate;	// 学生性别
	private Date releasDate;

	public Date getReleasDate() {
		return releasDate;
	}
	public void setReleasDate(Date releasDate) {
		this.releasDate = releasDate;
	}
	// 访问器
	
	
	// 构造器
	public Goods() {}
	
	

	
	public Integer getGno() {
		return gno;
	}
	public void setGno(Integer gno) {
		this.gno = gno;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGprice() {
		return gprice;
	}
	public void setGprice(String gprice) {
		this.gprice = gprice;
	}
	public String getGdate() {
		return gdate;
	}
	public void setGdate(String gdate) {
		this.gdate = gdate;
	}
	
	public Goods(Integer gno, String gname, String gprice, String gdate, Date releasDate) {
		super();
		this.gno = gno;
		this.gname = gname;
		this.gprice = gprice;
		this.gdate = gdate;
		this.releasDate = releasDate;
	}
	
	public Goods(String gname, String gprice, String gdate) {
		super();
		this.gname = gname;
		this.gprice = gprice;
		this.gdate = gdate;
	}
	@Override
	public String toString() {
		return "Goods [gno=" + gno + ", gname=" + gname + ", gprice=" + gprice + ", gdate=" + gdate + ", releasDate="
				+ releasDate + "]";
	}
	
}
