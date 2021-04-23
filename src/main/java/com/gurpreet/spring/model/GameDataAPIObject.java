package com.gurpreet.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameDataAPIObject {
	
	//@JsonProperty("val")
	String val;
	//@JsonProperty("id")
	String id;
	//@JsonProperty("apiName")
	String apiName;
	//@JsonProperty("dataStructure")
	String dataStructure;
	
	@JsonProperty("val")
	public String getVal() {
		return val;
	}

	@JsonProperty("val")
	public void setVal(String val) {
		this.val = val;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("apiName")
	public String getApiName() {
		return apiName;
	}

	@JsonProperty("apiName")
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	@JsonProperty("dataStructure")
	public String getDataStructure() {
		return dataStructure;
	}

	@JsonProperty("dataStructure")
	public void setDataStructure(String dataStructure) {
		this.dataStructure = dataStructure;
	}

	@Override
	public String toString() {
		return "DataAPIObject [val=" + val + ", id=" + id + ", apiName=" + apiName + ", dataStructure=" + dataStructure
				+ "]";
	}

}
