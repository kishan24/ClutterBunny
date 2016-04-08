package com.clutterbunny.web.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.clutterbunny.dao.BookRegistryDAO;
import com.clutterbunny.dao.UserDAO;
import com.clutterbunny.exceptions.InputValidateException;

public abstract class AbstractController {
	
	@Autowired protected UserDAO userDAO;
	@Autowired protected BookRegistryDAO bookRegistryDAO;
	

	protected ModelAndView createModel(String viewName) {
		ModelAndView mav = new ModelAndView("index");
		mav.getModelMap().put("p", viewName);
		return mav;
	}
	
	
	public void validateNotNull(String fieldName, String value) throws InputValidateException {
		if(value == null || value.trim().length() == 0) {
			throw new InputValidateException(fieldName + " value should not be null or empty.");
		}
	}
	
	public void validateNotNull(String fieldName, Object value) throws InputValidateException {
		if(value == null) {
			throw new InputValidateException(fieldName + " value should not be null.");
		}
	}
	
	public void validateNumber(String fieldName, String value) throws InputValidateException {
		
		validateNotNull(fieldName, value);
		try {
			Integer.parseInt(value);
		} catch(Exception e) {
			throw new InputValidateException(fieldName + " should be only a number type");
		}
	}
	
	public void validateDouble(String fieldName, String value) throws InputValidateException {
		
		validateNotNull(fieldName, value);
		try {
			Double.parseDouble(value);
		} catch(Exception e) {
			throw new InputValidateException(fieldName + " should be only a number type");
		}
	}
	
	public void validateNumberBetween(String fieldName, int value, int min, int max) throws InputValidateException {
		if(value <= min || value >= max) {
			throw new InputValidateException(fieldName + " should be between "+ min +" and " + max);
		}
	}
	
	public void validatePositiveNumber(String fieldName, double value) throws InputValidateException {
		if(value < 0) {
			throw new InputValidateException(fieldName +" value should be greater than 0");
		}
	}
	
	public void validateNumbers(String fieldName, String value, int length) throws InputValidateException {
		validateNotNull(fieldName, value);
		
		if(value.length() != length) {
			throw new InputValidateException(fieldName + " should be length of "+ length +" digits");
		}
		
		for(char c : value.toCharArray()) {
			if(!Character.isDigit(c)) {
				throw new InputValidateException(fieldName + " should contain only digits");
			}
		}
	}
	
	public void validateLength(String fieldName, String value, int length) throws InputValidateException {
		validateNotNull(fieldName, value);
		
		if(value.length() != length) {
			throw new InputValidateException(fieldName + " should be length of "+ length );
		}
		
	}
	
	
	public void validateMinLength(String fieldName, String value, int length) throws InputValidateException {
		validateNotNull(fieldName, value);
		
		if(value.length() < length) {
			throw new InputValidateException(fieldName + " should be min length of "+ length );
		}
		
	}
	
	
	
	public void validateCantOldDate(String fieldName, Date value) throws InputValidateException {
		validateNotNull(fieldName, value);
		
		if(value.getTime() < System.currentTimeMillis()) {
			throw new InputValidateException(fieldName +" should not be older date.");
		}
		
	}
	
	
}
