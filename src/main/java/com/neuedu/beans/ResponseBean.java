package com.neuedu.beans;

import java.util.List;

/**
 * 这是一个响应对象的实体类
 * @author 
 * 注意：T
 */
public class ResponseBean<T> {
	// 属性
    private String code;	// 返回码（1：成功，2：失败）
    private String msg;		// 提示信息
    private List<T> list;	// 携带的数据
    
    // 访问器
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	// 构造器
	public ResponseBean() {}
	public ResponseBean(String code, String msg, List<T> list) {
		super();
		this.code = code;
		this.msg = msg;
		this.list = list;
	}
	
	// 重写toString()方法
	@Override
	public String toString() {
		return "ResponseBean [code=" + code + ", msg=" + msg + ", list=" + list + "]";
	}
}
