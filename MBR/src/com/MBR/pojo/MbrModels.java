package com.MBR.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MbrModels entity. @author MyEclipse Persistence Tools
 */

/**
 * @author Iver3oN Zhang
 * @date 2015-10-30 Impossible is nothing
 */
public class MbrModels implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String userName;
	private Timestamp createTime;
	private String managerName;
	private Integer state;
	private Integer used;
	private Set<MbrModelCondition> mbrModelConditions = new HashSet<MbrModelCondition>();

	// Constructors

	/** default constructor */
	public MbrModels() {
	}

	/** minimal constructor */
	public MbrModels(String userName, String name, Timestamp createTime,
			String managerName, Integer state, Integer used) {
		this.userName = userName;
		this.name = name;
		this.createTime = createTime;
		this.managerName = managerName;
		this.state = state;
		this.used = used;
	}

	/** full constructor */
	public MbrModels(String userName, String name, Timestamp createTime,
			String managerName, Integer state, Integer used,
			Set mbrModelConditions) {
		this.userName = userName;
		this.name = name;
		this.createTime = createTime;
		this.managerName = managerName;
		this.state = state;
		this.used = used;
		this.mbrModelConditions = mbrModelConditions;
	}

	// Property accessors

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

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

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Set<MbrModelCondition> getMbrModelConditions() {
		return this.mbrModelConditions;
	}

	public void setMbrModelConditions(Set mbrModelConditions) {
		this.mbrModelConditions = mbrModelConditions;
	}

}