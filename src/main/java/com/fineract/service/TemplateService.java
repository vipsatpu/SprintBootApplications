package com.fineract.service;

import java.util.List;

import com.fineract.model.Account;
import com.fineract.model.Sample;

public interface TemplateService {
	
	public List<Account> getAccountList();
	public Account getAccountByIdentifier(String accountIdentifier);
	public void addSample(Sample sample);
	public List<Sample> getSampleList();
}
