package com.neuedu.beans;


/**
 * 这是数据库表student对应的实体类【准备简单Java类】
 * @author ZY
 *
 */
public class Vendor {
	// 属性
	private Integer vno;		// 学生编号
	private String  vname;	// 学生姓名
	private String vtyp;		// 学生年龄
	private String vtele;	// 学生性别
	// 访问器
	
	
	// 构造器
	public Vendor() {}
	public Integer getVno() {
		return vno;
	}
	public void setVno(Integer vno) {
		this.vno = vno;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVtyp() {
		return vtyp;
	}
	public void setVtyp(String vtyp) {
		this.vtyp = vtyp;
	}
	public String getVtele() {
		return vtele;
	}
	public void setVtele(String vtele) {
		this.vtele = vtele;
	}
	public Vendor(Integer vno, String vname, String vtyp, String vtele) {
		super();
		this.vno = vno;
		this.vname = vname;
		this.vtyp = vtyp;
		this.vtele = vtele;
	}
	public Vendor(String vname, String vtyp, String vtele) {
		super();
		this.vname = vname;
		this.vtyp = vtyp;
		this.vtele = vtele;
	}
	@Override
	public String toString() {
		return "Vendor [vno=" + vno + ", vname=" + vname + ", vtyp=" + vtyp + ", vtele=" + vtele + "]";
	}
	
}
