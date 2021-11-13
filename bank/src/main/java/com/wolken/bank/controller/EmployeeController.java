package com.wolken.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.bank.dto.EmployeeDTO;
import com.wolken.bank.services.EmployeeService;

@RestController
public class EmployeeController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
			
	@Autowired
	EmployeeService service;
	
	@GetMapping("getEmployees")
	List<EmployeeDTO> getEmployeeDetails() {
		List<EmployeeDTO> dtos = service.validateAndGetAll();
		log.info("getEmployeeDetails() is called");
		return dtos;
	}
	
	@PostMapping("saveEmployee")
	String saveEmployeeDetails(@RequestBody EmployeeDTO dto) {
		String out = service.validateAndSave(dto);
		log.info("saveEmployeeDetails() is called");
		return out;
	}
	
	@PostMapping("saveAllEmployees")
	String saveAllEmployeeDetails(@RequestBody List<EmployeeDTO> dtos) {
		String out = service.validateAndSaveAll(dtos);
		log.info("saveAllEmployeeDetails() is called");
		return out;
	}
	
	@GetMapping("findByDesignation")
	List<EmployeeDTO> getByDesignation(@RequestParam String designation) {
		List<EmployeeDTO> dtos = service.validateAndGetByDesignation(designation);
		log.info("getByDesignation() is called");
		return dtos;
	}
	
	@GetMapping("findBySalary")
	List<EmployeeDTO> getBySalary(@RequestParam float salary) {
		List<EmployeeDTO> dtos = service.validateAndGetBySalary(salary);
		log.info("getBySalary() is called");
		return dtos;
	}
	
}
