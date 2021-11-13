package com.wolken.bank.services;

import java.util.List;

import com.wolken.bank.dto.EmployeeDTO;

public interface EmployeeService {
	List<EmployeeDTO> validateAndGetAll();

	String validateAndSave(EmployeeDTO dto);

	String validateAndSaveAll(List<EmployeeDTO> dtos);

	List<EmployeeDTO> validateAndGetByDesignation(String designation);

	List<EmployeeDTO> validateAndGetBySalary(float salary);
}
