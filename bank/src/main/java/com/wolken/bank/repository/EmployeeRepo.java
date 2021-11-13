package com.wolken.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.wolken.bank.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepositoryImplementation<EmployeeEntity, Integer>{

	List<EmployeeEntity> findByDesignation(String designation);

	List<EmployeeEntity> findBySalary(float salary);

}
