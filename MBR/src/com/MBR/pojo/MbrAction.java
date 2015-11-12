package com.MBR.pojo;

/**
 * MbrAction entity. @author MyEclipse Persistence Tools
 */

public class MbrAction implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer actionid;
	private String action;

	// Constructors

	/** default constructor */
	public MbrAction() {
	}

	/** full constructor */
	public MbrAction(Integer actionid, String action) {
		this.actionid = actionid;
		this.action = action;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActionid() {
		return this.actionid;
	}

	public void setActionid(Integer actionid) {
		this.actionid = actionid;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}