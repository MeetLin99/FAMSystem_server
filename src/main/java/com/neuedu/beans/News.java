package com.neuedu.beans;

import java.sql.Date;

/**
 * 数据库表NEWS对应的实体类
 * @author 
 *
 */
public class News {


	// 属性
	private Integer id;			// 新闻ID 
	private String Title;		// 新闻标题
	private String newsAbstract;// 新闻摘要
	private String Text;		// 新闻内容
	private Date releasDate;	// 新闻发布时间
	
	// 访问器
	
	public String getTitle() {
		return Title;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getNewsAbstract() {
		return newsAbstract;
	}
	public void setNewsAbstract(String newsAbstract) {
		this.newsAbstract = newsAbstract;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public Date getReleasDate() {
		return releasDate;
	}
	public void setReleasDate(Date releasDate) {
		this.releasDate = releasDate;
	}
	
	// 构造器
	public News() {}
	public News(String title, String newsAbstract, String text) {
		super();
		Title = title;
		this.newsAbstract = newsAbstract;
		Text = text;
	}
	public News(Integer iD, String title, String newsAbstract, String text, Date releasDate) {
		super();
		id = iD;
		Title = title;
		this.newsAbstract = newsAbstract;
		Text = text;
		this.releasDate = releasDate;
	}
	
	// 重写toString()方法
	@Override
	public String toString() {
		return "News [ID=" + id + ", Title=" + Title + ", newsAbstract=" + newsAbstract + ", Text=" + Text
				+ ", releasDate=" + releasDate + "]";
	}
}
