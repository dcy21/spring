package com.yc.beans;

import java.io.Serializable;
import java.util.List;

public class JsonModel<T> implements Serializable {
	private static final long serialVersionUID = 6785842571096492682L;
	private Integer code;
	private Object obj;
	private String errmsg;

	private Integer total;
	private Integer pageSize;
	private Integer pages;
	private List<T> rows;

	public JsonModel() {
	}

	public JsonModel(Integer code, Object obj, String errmsg) {
		super();
		this.code = code;
		this.obj = obj;
		this.errmsg = errmsg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "JsonModel [code=" + code + ", obj=" + obj + ", errmsg="
				+ errmsg + ", total=" + total + ", pageSize=" + pageSize
				+ ", pages=" + pages + ", rows=" + rows + "]";
	}

}
