package com.fineract.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fineract.model.Account;
import com.fineract.model.Sample;
import com.fineract.service.TemplateService;



@Controller
public class FineractApplicationController {
	
	@Autowired
	TemplateService templateService;
	
	@RequestMapping({"/","index"})
	public ModelAndView welcome(Model model) {
		return new ModelAndView("accounts","command",new Sample());
	}
	
	@RequestMapping("/getAccounts")
	public ModelAndView getAccounts(@RequestParam String identifier) {

		ModelAndView model = new ModelAndView("listAccounts");
		try {
			List<Account> list;
			if(!StringUtils.isEmpty(identifier)) {
				list = new ArrayList<>();
				Account account = templateService.getAccountByIdentifier(identifier);
				list.add(account);
			}else {
				list = templateService.getAccountList();
			}
			
			model.addObject("accountList", list);
			return model;
		} catch (Exception e) {
			model.addObject("Error", "No Data Found");
			return model;
		}

	}
	
	@RequestMapping(value = "/addSample", method = RequestMethod.POST)
	public ModelAndView addSample(@ModelAttribute("sample") Sample sample) {
		System.out.println(" Sample Input "+sample.getIdentifier());
		System.out.println(" Sample Input "+sample.getPayload());
		templateService.addSample(sample);		

		ModelAndView model = new ModelAndView("listSample");
		List<Sample> list = templateService.getSampleList();
		model.addObject("sampleList", list);
		return model;
	}
	
	@RequestMapping(value = "/listSamples", method = RequestMethod.GET)
	public ModelAndView listSamples() {
		ModelAndView model = new ModelAndView("listSample");
		List<Sample> list = templateService.getSampleList();
		model.addObject("sampleList", list);
		return model;
	}
	
	@RequestMapping("/listAccounts")
	public ModelAndView listAccounts() {

		ModelAndView model = new ModelAndView("listAccounts");
		try {
			List<Account> list = templateService.getAccountList();
			model.addObject("accountList", list);
			return model;
		} catch (Exception e) {
			model.addObject("Error", "No Data Found");
			return model;
		}

	}
	
}
