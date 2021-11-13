package com.wolken.mobile.services;

import java.util.List;

import com.wolken.mobile.dto.UserDTO;
import com.wolken.mobile.entity.UserEntity;

public interface RegistrationService {
	public String validateAndSave(UserDTO dto);
	public List<UserEntity> getByBrandName(String brandName);
	public List<UserEntity> getByPrice(float price);
	public UserEntity updatePriceByModelNo(int modelNo, float price);
	public UserEntity updateAvailabilityByModelNo(int modelNo, boolean availability);
//	public String delete(UserDTO dto);
}
