package com.MBR.pojo;

/**
 * MbrModelCondition entity. @author MyEclipse Persistence Tools
 */

public class MbrModelCondition implements java.io.Serializable {

	// Fields

	private Integer id;
	private MbrMetaData mbrMetaData;
	private MbrModels mbrModels;

	// Constructors

	/** default constructor */
	public MbrModelCondition() {
	}

	/** full constructor */
	public MbrModelCondition(Integer id, MbrMetaData mbrMetaData,
			MbrModels mbrModels) {
		this.id = id;
		this.mbrMetaData = mbrMetaData;
		this.mbrModels = mbrModels;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MbrMetaData getMbrMetaData() {
		return this.mbrMetaData;
	}

	public void setMbrMetaData(MbrMetaData mbrMetaData) {
		this.mbrMetaData = mbrMetaData;
	}

	public MbrModels getMbrModels() {
		return this.mbrModels;
	}

	public void setMbrModels(MbrModels mbrModels) {
		this.mbrModels = mbrModels;
	}

}