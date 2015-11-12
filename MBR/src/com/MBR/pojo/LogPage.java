package com.MBR.pojo;

import java.util.List;
import com.MBR.pojo.MbrLog;

public class LogPage {

	private int index;
	private String actionId;
	private int sum;
	private int pageSize;
	private String searchName;
	private int pageSum;
	private boolean search;
	private List<MbrLog> list;
	private String startTime;
	private String endTime;
	private String content;
	private String searchInfo;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public List<MbrLog> getList() {
		return list;
	}

	public void setList(List<MbrLog> list) {
		this.list = list;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSum() {
		return pageSum;
	}

	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}

	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean search) {
		this.search = search;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchName() {
		return searchName;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionid2) {
		this.actionId = actionid2;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSearchInfo() {
		return searchInfo;
	}

	public void setSearchInfo(String searchInfo) {
		this.searchInfo = searchInfo;
	}

}
