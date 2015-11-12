package com.MBR.pojo;

import java.sql.Timestamp;

/**
 * MbrLog entity. @author MyEclipse Persistence Tools
 */

public class MbrLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private Timestamp dateTime;
	private Integer dataId;
	private String action;
	private String content;
	private Integer actionid;

	// Constructors

	/** default constructor */
	public MbrLog() {
	}

	/** full constructor */
	public MbrLog(String userName, Timestamp dateTime, Integer dataId,
			String action, String content, Integer actionid) {
		this.userName = userName;
		this.dateTime = dateTime;
		this.dataId = dataId;
		this.action = action;
		this.content = content;
		this.actionid = actionid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Timestamp getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getDataId() {
		return this.dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getActionid() {
		return this.actionid;
	}

	public void setActionid(Integer actionid) {
		this.actionid = actionid;
	}

}