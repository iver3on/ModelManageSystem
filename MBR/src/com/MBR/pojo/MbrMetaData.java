package com.MBR.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * MbrMetaData entity. @author MyEclipse Persistence Tools
 */

public class MbrMetaData implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Double defaultValue;
	private Set mbrModelConditions = new HashSet(0);

	// Constructors

	/** default constructor */
	public MbrMetaData() {
	}

	/** minimal constructor */
	public MbrMetaData(String name, Double defaultValue) {
		this.name = name;
		this.defaultValue = defaultValue;
	}

	/** full constructor */
	public MbrMetaData(String name, Double defaultValue, Set mbrModelConditions) {
		this.name = name;
		this.defaultValue = defaultValue;
		this.mbrModelConditions = mbrModelConditions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(Double defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Set getMbrModelConditions() {
		return this.mbrModelConditions;
	}

	public void setMbrModelConditions(Set mbrModelConditions) {
		this.mbrModelConditions = mbrModelConditions;
	}

}