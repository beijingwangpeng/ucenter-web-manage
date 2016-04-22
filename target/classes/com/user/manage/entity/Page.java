package com.user.manage.entity;

import java.util.List;

/**
 * 分页辅助类
 * 
 * @author wangpeng 2013-11-28
 */
public class Page {

	/** 当前页号  默认第一页*/
	private long pageNo = 1;
	/** 页面总大小 */
	private long pageSize = 10;
	/** 页面实体集合 */
	private List<?> dataList;
	/** 数据起始位  */
	private long firstIndex = 0;
	/** 总数据条数 */
	private long recordCount;
	/** 总页数 */
	private long pageCount;
	
	
	public long getPageNo() {
		return pageNo;
	}
	public void setPageNo(long pageNo) {
		if(pageNo<=0){
			this.pageNo = 1;
		}else if(pageNo >pageCount && pageCount!=0){
			this.pageNo = pageCount;
		}else{
			this.pageNo = pageNo;
		}
		this.firstIndex = (this.pageNo-1)*this.pageSize;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public List<?> getDataList() {
		return dataList;
	}
	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}
	public long getFirstIndex() {
		return firstIndex;
	}
	public void setFirstIndex(long firstIndex) {
		this.firstIndex = firstIndex;
	}
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
		pageCount = (recordCount  +  pageSize  - 1) / pageSize;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
}
