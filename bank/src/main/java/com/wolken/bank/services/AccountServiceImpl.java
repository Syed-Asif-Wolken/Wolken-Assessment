package com.wolken.bank.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.bank.dto.AccountDTO;
import com.wolken.bank.dto.EmployeeDTO;
import com.wolken.bank.entity.AccountEntity;
import com.wolken.bank.entity.EmployeeEntity;
import com.wolken.bank.repository.AccountRepo;


@Service
public class AccountServiceImpl implements AccountService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
	@Autowired
	AccountRepo repo;

	@Override
	public String validateAndSave(AccountDTO dto) {
		try {
			if(dto!=null) {
				Date date1;
				AccountEntity entity = new AccountEntity();
				try {
					date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDob());
					entity.setDob(date1);
				} catch (ParseException e) {
					log.error(e.getMessage());
				}  
				
				BeanUtils.copyProperties(dto,entity,"dob");
				repo.save(entity);
				return "Data Saved Successfully";
			}
			else {
				log.info("DTO is null");
			}
		} catch (NullPointerException | TypeMismatchException e) {
			log.error(e.getMessage(), e.getClass().getSimpleName());
		}
		return null;
	}

	@Override
	public AccountDTO validateAndGetCurrentBalance(String holderName) {
		AccountEntity entity = repo.findByHolderName(holderName);
		log.info(""+entity);
		AccountDTO dto = new AccountDTO();
		BeanUtils.copyProperties(entity, dto,"dob");  
		dto.setDob(formatter.format(entity.getDob()));
		log.info(""+dto);
		return dto;
	}

	@Override
	public String validateAndDeposit(float deposit, int accNo) {
		try {
			if(deposit>0){
				AccountEntity entity = repo.findByAccNo(accNo);
				log.info(""+entity);
				entity.setAmount(entity.getAmount()+deposit);
				repo.save(entity);
				log.info(""+entity);
				return "Amount Deposited";
			}
			else {
				return "No Amount to deposit";
			}
		} catch (NullPointerException | TypeMismatchException e) {
			log.error(e.getMessage(), e.getClass().getSimpleName());
		}
		return null;
	}

	@Override
	public String validateAndWithdraw(float withdraw, int accNo) {
		try {
			if(withdraw>0 && accNo>0){
				AccountEntity entity = repo.findByAccNo(accNo);
				if(entity!=null) {
					log.info(""+entity);
					if(withdraw<entity.getAmount()) {
						entity.setAmount(entity.getAmount()-withdraw);
						repo.save(entity);
						log.info(""+entity);
						return "Amount Withdrawn";
					}
					else {
						return "Account does not exist";
					}
					}
				else {
					return "Withdrawn amount greater than balance or accNo doesn't exist";
				}
			}
			else {
				return "No Amount to withdraw";
			}
		} catch (NullPointerException | TypeMismatchException e) {
			log.error(e.getMessage(), e.getClass().getSimpleName());
		}
		return null;
	}

	@Override
	public String validateAndUpdateStatus(int accNo) {
		try {
			if(accNo>0){
				AccountEntity entity = repo.findByAccNo(accNo);
				if(entity!=null) {
					log.info(""+entity);
					entity.setStatus(false);
					repo.save(entity);
					log.info(""+entity);
					return "Account Closed (Status Updated)";
					}
				else {
					return "Account does not exist";
				}
			}
			else {
				return "Invalid Account Number";
			}
		} 
		catch (NullPointerException | TypeMismatchException e) {
			log.error(e.getMessage(), e.getClass().getSimpleName());
		}
		return null;
	}

	@Override
	public List<AccountDTO> validateAndGetByBranchName(String branchName) {
		List<AccountEntity> entityList = repo.findByBranchName(branchName);
		List<AccountDTO> dtos = new ArrayList<>();
		log.info(""+entityList);
		for (AccountEntity entity : entityList) {
			AccountDTO dto = new AccountDTO();
			BeanUtils.copyProperties(entity, dto,"dob");
			dto.setDob(formatter.format(entity.getDob()));
			dtos.add(dto);
		}
		log.info(""+dtos);
		return dtos;
	}

}
