package com.MBR.pojo;

/**
 * MbrModelCondition entity. @author MyEclipse Persistence Tools
 */

public class MbrModelCondition implements java.io.Serializable {

	// Fields

	private Integer id;
	private MbrInputParameter mbrInputParameter;
	private MbrModels mbrModels;

	// Constructors

	/** default constructor */
	public MbrModelCondition() {
	}

	/** full constructor */
	public MbrModelCondition(Integer id, MbrInputParameter mbrInputParameter,
			MbrModels mbrModels) {
		this.id = id;
		this.mbrInputParameter = mbrInputParameter;
		this.mbrModels = mbrModels;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MbrInputParameter getMbrMetaData() {
		return this.mbrInputParameter;
	}

	public void setMbrMetaData(MbrInputParameter mbrInputParameter) {
		this.mbrInputParameter = mbrInputParameter;
	}

	public MbrModels getMbrModels() {
		return this.mbrModels;
	}

	public void setMbrModels(MbrModels mbrModels) {
		this.mbrModels = mbrModels;
	}

}