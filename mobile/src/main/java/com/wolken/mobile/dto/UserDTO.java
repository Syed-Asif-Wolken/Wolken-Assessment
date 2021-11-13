package com.wolken.mobile.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {
	private int id;
	private String brandName;
	private String type;
	private int ram;
	private int rom;
	private int modelNumber;
	private float price;
	private String modelName;
	private boolean availability;
}
