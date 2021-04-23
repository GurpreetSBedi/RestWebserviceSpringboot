package com.gurpreet.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.MimeMappings.Mapping;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gurpreet.spring.exceptions.APIException;
import com.gurpreet.spring.model.DataAPIObject;
import com.gurpreet.spring.model.GameDataAPIObject;
import com.gurpreet.spring.service.APIDataService;
import com.gurpreet.spring.service.RestWebservice;

@RestController
@RequestMapping("/project")
public class RestWebServiceController {

	@Autowired
	APIDataService apiDataService;
	
	@Autowired
	RestWebservice restWebservice;
	
	@GetMapping(value="/data/{callId}/call", produces=MediaType.APPLICATION_JSON_VALUE)
	public DataAPIObject getData(@PathVariable String callId){
		if(callId.startsWith("-")) { throw new APIException("No ID found, must send valid Id.");}
		System.out.println("Get request has call ID : "+callId);
		DataAPIObject dataObj = apiDataService.getDataAPIObject(callId);
		//DataAPIObject dataObj = new DataAPIObject(callId, "21212", "getData", "arrays");
		System.out.println("Data object : "+dataObj.toString());
		ResponseEntity<String> response = restWebservice.sendRequest("http://localhost:8090/game/game/"+callId+"/values", dataObj, HttpMethod.GET);
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			GameDataAPIObject gameDataAPIObject = mapper.readValue(response.getBody(), GameDataAPIObject.class);
			System.out.println(gameDataAPIObject.toString());
		}catch(Exception e) {
			throw new APIException("Unable to complete object Mapping"+e );
		}
		
		return dataObj; 
	}
	
	@PostMapping(value="/data/new/{id}", produces=MediaType.APPLICATION_JSON_VALUE, 
								consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addData(@PathVariable String id, @Validated @RequestBody DataAPIObject data){
		
		System.out.println("POST data obj value"+ data.toString());
		if(id.startsWith("-")) {
			throw new APIException("Unknown or negative values are not allowed as input.");
			}
		restWebservice.sendRequest("http://localhost:8090/game/game/1234/values", data, HttpMethod.POST);
		return new ResponseEntity<Object> ("Data has been updated",HttpStatus.ACCEPTED); 
	}
}
