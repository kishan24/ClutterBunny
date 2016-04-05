package com.clutterbunny.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Transactional
@Controller
@RequestMapping(value = "/user")
public class UserController extends AbstractController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = "/signup", method = {RequestMethod.GET})
	public @ResponseBody ModelAndView signup(HttpServletRequest request, HttpServletResponse response) {
		return createModel("signup");
	}
	
}
