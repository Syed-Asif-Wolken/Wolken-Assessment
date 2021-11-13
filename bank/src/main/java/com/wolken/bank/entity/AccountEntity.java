package com.wolken.bank.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class AccountEntity {
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator = "gen")
	private int accNo;
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
	private Date dob;
}
