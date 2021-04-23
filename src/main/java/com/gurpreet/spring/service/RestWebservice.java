package com.gurpreet.spring.service;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gurpreet.spring.exceptions.APIException;
import com.gurpreet.spring.model.DataAPIObject;
import com.gurpreet.spring.model.GameDataAPIObject;

@Service
public class RestWebservice {
	
	RestTemplate restTemplate = new RestTemplate();
	
	private RestTemplate getRestTemplate() {
		restTemplate.setErrorHandler(new ResponseErrorHandler() {
			
			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {
				
				return false;
			}
			
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				
			}
		});
		
		setMessageConverters();
		
		return restTemplate;
	}
	
	private void setMessageConverters() {
		
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
		restTemplate.getMessageConverters().add(converter);
	}

	private HttpHeaders getHeader() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.add("X-Context-Id", "API-Contxt");
		httpHeaders.add("X-Channel", "WEB");
		httpHeaders.add("X-Callers", "API-Dev");
		httpHeaders.add("X-User-Id", "Gurpreet");
		List<MediaType> mediaList = new ArrayList<MediaType>();
		mediaList.add(MediaType.APPLICATION_JSON);
		httpHeaders.setAccept(mediaList);
		return httpHeaders;
	}
	
	public ResponseEntity<String> sendRequest(String url, DataAPIObject object, HttpMethod httpMethod){
		
		ResponseEntity<String> response = null;
		URI endpoint = URI.create(url);
		RestTemplate restTemplate = getRestTemplate();
		try {
			HttpEntity<?> request = new HttpEntity(object.getId(),getHeader());
			response = restTemplate.exchange(endpoint, httpMethod, request, String.class);
		}catch(Exception ex) {
			if(null != response &&  response.getStatusCode().is4xxClientError()) {
				StringBuilder builder = new StringBuilder();
				builder.append("")
					   .append("");
				throw new APIException(String.format("Webservice is unsuccessful and unable to complete request",builder.toString()));
			}
			else {
				throw new RuntimeException(); 
			}
		}
		return response;
	}
}
