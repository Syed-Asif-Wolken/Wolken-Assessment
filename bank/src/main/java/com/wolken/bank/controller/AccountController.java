package com.wolken.bank.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.bank.dto.AccountDTO;
import com.wolken.bank.dto.EmployeeDTO;
import com.wolken.bank.services.AccountService;

@RestController
public class AccountController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AccountService service;
	
	@PostMapping("saveAccount")
	String saveAccountDetails(@RequestBody AccountDTO dto) {
		String out = service.validateAndSave(dto);
		log.info("saveAccountDetails() is called");
		return out;
	}
	
	@GetMapping("getCurrentBalance")
	HashMap<String,Float> getCurrentBalance(@RequestParam String holderName) {
		AccountDTO dto = service.validateAndGetCurrentBalance(holderName);
		log.info(holderName);
		log.info(""+dto);
		log.info("getCurrentBalance() is called");
		HashMap<String,Float> data = new HashMap<>();
		data.put("CurrentBalance", dto.getAmount());
		return data;
	}
	
	@PostMapping("depositAmount")
	String saveDeposit(@RequestParam float deposit, @RequestParam int accNo) {
		String out = service.validateAndDeposit(deposit, accNo);
		log.info("saveDeposit() is called");
		return out;
	}
	
	@PostMapping("withdrawAmount")
	String saveWithdraw(@RequestParam float withdraw, @RequestParam int accNo) {
		String out = service.validateAndWithdraw(withdraw, accNo);
		log.info("saveWithdraw() is called");
		return out;
	}
	
	@PostMapping("closeAccount")
	String updateStatus(@RequestParam int accNo) {
		String out = service.validateAndUpdateStatus(accNo);
		log.info("updateStatus() is called");
		return out;
	}
	
	@GetMapping("findAccByBranchName")
	List<AccountDTO> getAccByBranchName(@RequestParam String branchName) {
		List<AccountDTO> dtos = service.validateAndGetByBranchName(branchName);
		log.info("getAccByBranchName() is called");
		return dtos;
	}
		
}
