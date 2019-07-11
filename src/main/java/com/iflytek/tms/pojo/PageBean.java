package com.iflytek.tms.pojo;

/**
 *分页的实体类
 */
public class PageBean {
	
	
	/**
	 * 当前页码
	 */
	private int currentPageNum;
	
	
	/**
	 * 总页码
	 */
	private int totalPageSize;
	
	
	/**
	 * 每页显示数量
	 */
	private int everyPageSize;
	
	
	/**
	 * 总数据量
	 */
	private int totalDataCount;

	public PageBean() {
	}

	public PageBean(int totalDataCount , int everyPageSize) {
		this.totalDataCount = totalDataCount;
		this.everyPageSize = everyPageSize;
		
		if(totalDataCount % everyPageSize == 0) {
			totalPageSize = totalDataCount / everyPageSize;
		}else {
			totalPageSize = totalDataCount / everyPageSize + 1;
		}
	}
	


	public int getCurrentPageNum() {
		return currentPageNum;
	}


	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}


	public int getTotalPageSize() {
		return totalPageSize;
	}


	public void setTotalPageSize(int totalPageSize) {
		this.totalPageSize = totalPageSize;
	}


	public int getEveryPageSize() {
		return everyPageSize;
	}


	public void setEveryPageSize(int everyPageSize) {
		this.everyPageSize = everyPageSize;
	}


	public int getTotalDataCount() {
		return totalDataCount;
	}


	public void setTotalDataCount(int totalDataCount) {
		this.totalDataCount = totalDataCount;
	}
	
}
