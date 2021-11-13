package com.wolken.bank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AccountDTO {
	private String holderName;
	private long contactNo;
	private String email;
	private String address;
	private String branchName;
	private String typeOfAccount;
	private float amount;
	private boolean status;
	private String nominee;
	private String gender;
	private String dob;
}
