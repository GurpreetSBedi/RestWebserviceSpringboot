package com.gurpreet.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gurpreet.spring.model.DataAPIObject;

@Service
public class APIDataService {

	private static List<DataAPIObject> listOfObj = new ArrayList<>();
	
	static {
		DataAPIObject dApiObj1 = new DataAPIObject("gurpreet", "21", "getData", "arrays");
		DataAPIObject dApiObj2 = new DataAPIObject("bedi", "31", "getPersonalData", "list");
		DataAPIObject dApiObj3 = new DataAPIObject("singh", "20", "getNullData", "map");
		DataAPIObject dApiObj4 = new DataAPIObject("kaur", "19", "getTeenAgeData", "set");
		DataAPIObject dApiObj5 = new DataAPIObject("mister", "44", "getLegacyData", "hashing");
		DataAPIObject dApiObj6 = new DataAPIObject("uncle", "33", "getOlderData", "vector");
		listOfObj.add(dApiObj1);
		listOfObj.add(dApiObj2);
		listOfObj.add(dApiObj3);
		listOfObj.add(dApiObj4);
		listOfObj.add(dApiObj5);
		listOfObj.add(dApiObj6);
	}
	
	public List<DataAPIObject> getAllDataAPIObjects(){
		return listOfObj;
	}
	
	public DataAPIObject getDataAPIObject(String id) {
		DataAPIObject returnObject = null;
		for(DataAPIObject dapiObj : listOfObj) {
			if(id.equalsIgnoreCase(dapiObj.getId())){
				returnObject = dapiObj;
				break;
			}
		}
		return returnObject;
	}
}
