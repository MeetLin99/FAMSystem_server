package com.neuedu.beans;

public class Stock {
	private Integer stockno;
	private String gname;
	private String category;
	private Integer ammount;
	private Integer batch;
	public Integer getStockno() {
		return stockno;
	}
	public void setStockno(Integer stockno) {
		this.stockno = stockno;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getAmmount() {
		return ammount;
	}
	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}
	public Integer getBatch() {
		return batch;
	}
	public void setBatch(Integer batch) {
		this.batch = batch;
	}
	
	public Stock() {}
	public Stock(String gname, String category, Integer ammount, Integer batch) {
		super();
		this.gname = gname;
		this.category = category;
		this.ammount = ammount;
		this.batch = batch;
	}
	public Stock(String gname, String category, Integer ammount) {
		super();
		this.gname = gname;
		this.category = category;
		this.ammount = ammount;
	}
	public Stock(Integer stockno, String gname, String category, Integer ammount, Integer batch) {
		super();
		this.stockno = stockno;
		this.gname = gname;
		this.category = category;
		this.ammount = ammount;
		this.batch = batch;
	}
	@Override
	public String toString() {
		return "Stock [stockno=" + stockno + ", gname=" + gname + ", category=" + category + ", ammount=" + ammount
				+ ", batch=" + batch + "]";
	}
	
	
}
