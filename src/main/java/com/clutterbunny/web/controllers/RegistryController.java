package com.clutterbunny.web.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.clutterbunny.domain.BookRegistry;
import com.clutterbunny.domain.RegistryTypeEnum;
import com.clutterbunny.domain.User;
import com.clutterbunny.domain.UserSourceEnum;
import com.clutterbunny.domain.UserStatusEnum;
import com.clutterbunny.domain.UserTypeEnum;


@Transactional
@Controller
@RequestMapping(value = "/registry")
public class RegistryController extends AbstractController {
	
	private static final Logger logger = Logger.getLogger(RegistryController.class);
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping(value = "/book", method = {RequestMethod.GET})
	public @ResponseBody ModelAndView signup(HttpServletRequest request, HttpServletResponse response) {
		return createModel("registryBook");
	}
	
	@RequestMapping(value = "/book/add", method = {RequestMethod.GET, RequestMethod.POST}, produces="application/json")
	public @ResponseBody String addBook(
			@RequestParam(value="email", required=true) String email
			, @RequestParam(value="firstName", required=false) String firstName
			, @RequestParam(value="lastName", required=false) String lastName
			, @RequestParam(value="schoolName", required=false) String schoolName
			, @RequestParam(value="isbnNumber", required=false) String isbnNumber
			, @RequestParam(value="bookName", required=false) String bookName
			, @RequestParam(value="quantity", required=true) String quantity
			, @RequestParam(value="expectedDate", required=false) String expectedDate
			) {
		
		User user = userDAO.getUserByEmail(email);
		if(user == null) {
			user = new User();
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setType(UserTypeEnum.School);
			user.setStatus(UserStatusEnum.active);
			user.setSource(UserSourceEnum.MyApp);
			
			userDAO.save(user);
		}
		
		BookRegistry br = new BookRegistry();
		br.setIsbnNumber(isbnNumber);
		br.setQuantity(Integer.parseInt(quantity));
		br.setType(RegistryTypeEnum.Take);
		br.setUserId(user.getId());
		br.setName(bookName);
		
		try {
			br.setByWhen(sdf.parse(expectedDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		bookRegistryDAO.save(br);
		
		return "{\"status\":\"success\"}";
	}
	
	
	@RequestMapping(value = "/search", method = {RequestMethod.GET})
	public ModelAndView searchBook() {
		return createModel("searchBook");
	}
	
	@RequestMapping(value = "/searchResults", method = {RequestMethod.GET}, produces="application/json")
	public @ResponseBody List<BookRegistry> searchBook(
			@RequestParam(value="kw", required=true) String kw) {
		
		
		return bookRegistryDAO.searchBooks(kw);
	}
	
}
