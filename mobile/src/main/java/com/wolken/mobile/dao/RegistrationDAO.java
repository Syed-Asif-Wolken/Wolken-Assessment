package com.wolken.mobile.dao;

import java.util.List;

import com.wolken.mobile.entity.UserEntity;

public interface RegistrationDAO {
	public String save(UserEntity entity);
	public UserEntity updateAvailabilityByModelNo(UserEntity entity, boolean availability);
	public UserEntity updatePriceByModelNo(UserEntity entity, float price);
	public List<UserEntity> getByPrice(float price);
	public List<UserEntity> getByBrandName(String brandName);
	public UserEntity getByModelNo(int modelNo);
	
//	public String delete(UserEntity entity);
}
