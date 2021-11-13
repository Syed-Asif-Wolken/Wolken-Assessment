package com.wolken.bank.entity;

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
public class EmployeeEntity {
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator = "gen")
	private int id;
	private String name;
	private String email;
	private String designation;
	private long contact;
	private float salary;
}
