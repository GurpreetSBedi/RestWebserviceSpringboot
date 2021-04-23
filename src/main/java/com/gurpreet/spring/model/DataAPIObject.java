package com.gurpreet.spring.model;

public class DataAPIObject {
	
	String val;
	String id;
	String apiName;
	String dataStructure;
	
	
	public DataAPIObject(String val, String id, String apiName, String dataStructure) {
		this.val = val;
		this.id = id;
		this.apiName = apiName;
		this.dataStructure = dataStructure;
	}
	
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getDataStructure() {
		return dataStructure;
	}

	public void setDataStructure(String dataStructure) {
		this.dataStructure = dataStructure;
	}

	@Override
	public String toString() {
		return "DataAPIObject [val=" + val + ", id=" + id + ", apiName=" + apiName + ", dataStructure=" + dataStructure
				+ "]";
	}
	
	/**@Override
	public String toString() {
		StringJoiner stringJoiner = new StringJoiner("/");
		stringJoiner.add("DataAPIObject");
		stringJoiner.add(String.valueOf(val));
		stringJoiner.add("id");
		stringJoiner.add(String.valueOf(id));
		stringJoiner.add("apiName");
		stringJoiner.add(apiName);
		stringJoiner.add("id");
		stringJoiner.add("dataStructure");
		stringJoiner.add(dataStructure);
		return stringJoiner.toString();
	}*/
}
