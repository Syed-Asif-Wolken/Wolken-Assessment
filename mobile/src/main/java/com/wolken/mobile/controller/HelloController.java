package com.wolken.mobile.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wolken.mobile.dto.UserDTO;
import com.wolken.mobile.entity.UserEntity;
import com.wolken.mobile.services.RegistrationService;

@Controller
public class HelloController{

Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
@Autowired
RegistrationService service;

@RequestMapping("save")
ModelAndView save(UserDTO dto) {
	ModelAndView view = new ModelAndView();
	String out = service.validateAndSave(dto);
	view.setViewName("hello");
	view.addObject("out", out);
	return view;
}

@RequestMapping("update-price")
ModelAndView updatePrice(UserDTO dto) {
	ModelAndView view = new ModelAndView();
	UserEntity out = service.updatePriceByModelNo(dto.getModelNumber(), dto.getPrice());
	view.setViewName("hello");
	if(out!=null) {
		view.addObject("out","Updated Successfully");
	}
	view.addObject("onedata", out);
	if(out==null) {
		view.addObject("msg", "Data not found");
		logger.warn("Data not found");
	}
	return view;
}

@RequestMapping("update-availability")
ModelAndView updateAvailability(UserDTO dto) {
	ModelAndView view = new ModelAndView();
	UserEntity out = service.updateAvailabilityByModelNo(dto.getModelNumber(), dto.isAvailability());
	view.setViewName("hello");
	if(out!=null) {
		view.addObject("out","Updated Successfully");
	}
	view.addObject("onedata", out);
	if(out==null) {
		view.addObject("msg", "Data not found");
		logger.warn("Data not found");
	}
	return view;
}

@RequestMapping("get-by-price")
ModelAndView getByPrice(UserDTO dto) {
	ModelAndView view = new ModelAndView();
	logger.info(dto);
	List<UserEntity> out = service.getByPrice(dto.getPrice());
	view.setViewName("hello");
	view.addObject("data", out);
	view.addObject("msg", "Data not found");
	logger.error("Data not found");
	return view;
}

@RequestMapping("get-by-brand")
ModelAndView getByBrand(UserDTO dto) {
	ModelAndView view = new ModelAndView();
	List<UserEntity> out = service.getByBrandName(dto.getBrandName());
	view.setViewName("hello");
	view.addObject("data", out);
	view.addObject("msg", "Data not found");
	logger.fatal("Data not found");
	return view;
}

}
