package com.fineract.service.impl;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fineract.model.FineractServiceConstants;
import com.fineract.service.TokenService;

@Service

public class TokenServiceImpl implements TokenService {

	private final Logger logger = LoggerFactory.getLogger(TokenServiceImpl.class);
	
	public String getToken() {
		String accessToken = "";
		RestTemplate restTemplate = new RestTemplate();
		try {
			System.setProperty("java.net.useSystemProxies", "true");
			final HttpHeaders headers = new HttpHeaders();
		    headers.set(FineractServiceConstants.TENANT_IDENTIFIER_STR, FineractServiceConstants.TENANT_IDENTIFIER);
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			
		    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FineractServiceConstants.IDENTITY_SERVICE_ENDPOINT)
			        .queryParam(FineractServiceConstants.GRANT_TYPE_STR, FineractServiceConstants.GRANT_TYPE)
			        .queryParam(FineractServiceConstants.USERNAME_STR, FineractServiceConstants.USERNAME)
			        .queryParam(FineractServiceConstants.PASSWORD_STR, 
			        		Base64Utils.encodeToString(FineractServiceConstants.PASSWORD.getBytes(
			        				Charset.forName(FineractServiceConstants.CHARACTER_ENCODING))));
			
			final HttpEntity<LinkedHashMap<String, String>> entity = new HttpEntity<LinkedHashMap<String, String>>(headers);
			
			ParameterizedTypeReference<LinkedHashMap<String, String>>  parameterizedTypeReference = 
				    new ParameterizedTypeReference<LinkedHashMap<String, String>>(){};
				    
			ResponseEntity<LinkedHashMap<String, String>> responseEntity = restTemplate.exchange(
				        builder.build().toUriString(), 
				        HttpMethod.POST, 
				        entity, 
				        parameterizedTypeReference);      
			logger.info("Status {}",responseEntity.getStatusCode());
		    if(responseEntity.getStatusCode() == HttpStatus.OK && null != responseEntity.getBody().get(FineractServiceConstants.ACCESS_TOKEN)) {
		    	accessToken = responseEntity.getBody().get(FineractServiceConstants.ACCESS_TOKEN);
		    }
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return accessToken;
	}
	
}
