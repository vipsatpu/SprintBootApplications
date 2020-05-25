package com.fineract.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fineract.model.Account;
import com.fineract.model.FineractServiceConstants;
import com.fineract.model.Sample;
import com.fineract.service.TemplateService;
import com.fineract.service.TokenService;

@Service
public class TemplateServiceImpl implements TemplateService {
	
	private final Logger logger = LoggerFactory.getLogger(TemplateServiceImpl.class);

	@Autowired
	TokenService tokenService;
	
	public List<Account> getAccountList() {
		RestTemplate restTemplate = new RestTemplate();
		String accessToken = tokenService.getToken(); 
		List<Account> list = null;
		try {
			System.setProperty("java.net.useSystemProxies", "true");
			final HttpHeaders headers = new HttpHeaders();
		    headers.set(FineractServiceConstants.AUTHORIZATION_HEADER_STR, accessToken);
		    headers.set(FineractServiceConstants.USER_HEADER_STR, FineractServiceConstants.USERNAME);
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    headers.set(FineractServiceConstants.TENANT_IDENTIFIER_STR, FineractServiceConstants.TENANT_IDENTIFIER);
			           

		    //Create a new HttpEntity
		    final HttpEntity<List<Account>> entity = new HttpEntity<List<Account>>(headers);
		    ParameterizedTypeReference<List<Account>>  parameterizedTypeReference = 
				    new ParameterizedTypeReference<List<Account>>(){};
		    
		    //Execute the method writing your HttpEntity to the request
		    ResponseEntity<List<Account>> responseEntity = restTemplate.exchange(FineractServiceConstants.TEMPLATE_SERVICE_ENDPOINT, HttpMethod.GET, entity, parameterizedTypeReference);        
		    logger.info("Status {}",responseEntity.getStatusCode());
		    if(responseEntity.getStatusCode() == HttpStatus.OK) {
		    	list = responseEntity.getBody();
		    }
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return list;
	}
	
	public Account getAccountByIdentifier(String accountIdentifier) {
		Account account = null;
		RestTemplate restTemplate = new RestTemplate();
		String accessToken = tokenService.getToken(); 
		try {
			System.setProperty("java.net.useSystemProxies", "true");
			final HttpHeaders headers = new HttpHeaders();
		    headers.set(FineractServiceConstants.AUTHORIZATION_HEADER_STR, accessToken);
		    headers.set(FineractServiceConstants.USER_HEADER_STR, FineractServiceConstants.USERNAME);
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    headers.set(FineractServiceConstants.TENANT_IDENTIFIER_STR, FineractServiceConstants.TENANT_IDENTIFIER);
			           

		  //Create a new HttpEntity
		    final HttpEntity<Account> entity = new HttpEntity<Account>(headers);
		    
		    //Execute the method writing your HttpEntity to the request
		    ResponseEntity<Account> responseEntity = restTemplate.exchange(
		    		FineractServiceConstants.TEMPLATE_SERVICE_ENDPOINT+"/"+accountIdentifier, HttpMethod.GET, entity, Account.class);        
		    logger.info("Status {}",responseEntity.getStatusCode());
		    if(responseEntity.getStatusCode() == HttpStatus.OK) {
		    	account = responseEntity.getBody();
		    }
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return account;
	}

	/**
	 * 
	 * @param sample
	 */
	public void addSample(Sample sample) {
		RestTemplate restTemplate = new RestTemplate();
		String accessToken = tokenService.getToken(); 
		try {
			System.setProperty("java.net.useSystemProxies", "true");
			final HttpHeaders headers = new HttpHeaders();
		    headers.set(FineractServiceConstants.AUTHORIZATION_HEADER_STR, accessToken);
		    headers.set(FineractServiceConstants.USER_HEADER_STR, FineractServiceConstants.USERNAME);
		    //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    headers.set(FineractServiceConstants.TENANT_IDENTIFIER_STR, FineractServiceConstants.TENANT_IDENTIFIER);
			           

		  //Create a new HttpEntity
		    final HttpEntity<Sample> entity = new HttpEntity<>(sample, headers);
		    
		    
		    //Execute the method writing your HttpEntity to the request
		    ResponseEntity<Sample> responseEntity = restTemplate.exchange(
		    		FineractServiceConstants.TEMPLATE_SERVICE_ENDPOINT_FOR_SAMPLE, HttpMethod.POST, entity, Sample.class);        
		    logger.info("Status {}",responseEntity.getStatusCode());
		    if(responseEntity.getStatusCode() == HttpStatus.OK) {
		    	System.out.println("---"+responseEntity.getBody());
		    }
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}		
	}

	public List<Sample> getSampleList() {
		RestTemplate restTemplate = new RestTemplate();
		String accessToken = tokenService.getToken(); 
		List<Sample> list = null;
		try {
			System.setProperty("java.net.useSystemProxies", "true");
			final HttpHeaders headers = new HttpHeaders();
		    headers.set(FineractServiceConstants.AUTHORIZATION_HEADER_STR, accessToken);
		    headers.set(FineractServiceConstants.USER_HEADER_STR, FineractServiceConstants.USERNAME);
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    headers.set(FineractServiceConstants.TENANT_IDENTIFIER_STR, FineractServiceConstants.TENANT_IDENTIFIER);
			           

		    //Create a new HttpEntity
		    final HttpEntity<List<Sample>> entity = new HttpEntity<List<Sample>>(headers);
		    ParameterizedTypeReference<List<Sample>>  parameterizedTypeReference = 
				    new ParameterizedTypeReference<List<Sample>>(){};
		    
		    //Execute the method writing your HttpEntity to the request
		    ResponseEntity<List<Sample>> responseEntity = restTemplate.exchange(FineractServiceConstants.TEMPLATE_SERVICE_ENDPOINT_FOR_SAMPLE, HttpMethod.GET, entity, parameterizedTypeReference);        
		    logger.info("Status {}",responseEntity.getStatusCode());
		    if(responseEntity.getStatusCode() == HttpStatus.OK) {
		    	list = responseEntity.getBody();
		    }
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return list;
	}
	
}
