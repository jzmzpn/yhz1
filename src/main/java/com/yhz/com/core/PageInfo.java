package com.yhz.com.core;

import java.util.List;

public class PageInfo {
	
	private Integer rows;
	
	private Integer page;
	
	private String sortOrder;
	
	private Integer total;
	
	private String search;
	
	private List list;

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@Override
	public String toString() {
		return "PageInfo [rows=" + rows + ", page=" + page + ", sortOrder=" + sortOrder + ", total=" + total
				+ ", search=" + search + ", list=" + list + "]";
	}

	
	

}
