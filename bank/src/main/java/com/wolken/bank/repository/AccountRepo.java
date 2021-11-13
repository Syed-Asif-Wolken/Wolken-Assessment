package com.wolken.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.wolken.bank.entity.AccountEntity;

public interface AccountRepo extends JpaRepositoryImplementation<AccountEntity, Integer>{

	AccountEntity findByHolderName(String holderName);

	AccountEntity findByAccNo(int accNo);

	List<AccountEntity> findByBranchName(String branchName);

}
