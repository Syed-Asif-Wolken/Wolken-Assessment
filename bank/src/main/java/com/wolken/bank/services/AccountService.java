package com.wolken.bank.services;

import java.util.List;

import com.wolken.bank.dto.AccountDTO;

public interface AccountService {

	String validateAndSave(AccountDTO dto);

	AccountDTO validateAndGetCurrentBalance(String holderName);

	String validateAndDeposit(float deposit, int accNo);

	String validateAndWithdraw(float withdraw, int accNo);

	String validateAndUpdateStatus(int accNo);

	List<AccountDTO> validateAndGetByBranchName(String branchName);

}
