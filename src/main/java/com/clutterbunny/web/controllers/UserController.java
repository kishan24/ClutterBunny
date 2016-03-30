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
	
	/*@RequestMapping(value = "/{userId}/mortgageAccounts", method = { RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody ResponseTO mortgageAccounts(@PathVariable("userId") long userId) {
		try {
			ResponseTO r = new ResponseTO();
			r.setStatus(ResponseStatus.Success);
			r.setResult(mortgageAccountDAO.findByUserId(userId));
			
			return r;
		} catch (Exception e) {
			logger.error(e);
			return error(e);
		}
	}
	
	@RequestMapping(value = "/", method = {RequestMethod.GET})
	public @ResponseBody User calc(@RequestParam("loanAmt") String loanAmt, @RequestParam("loanTermYears") String loanTermYears, @RequestParam("interestRate") String interestRate) {
		try {
			validateNumber("Loan Amount", loanAmt);
			validateNumber("Loan Term", loanTermYears);
			validateDouble("Interest Term", interestRate);
			
			long loan = Long.parseLong(loanAmt);
			int months = Integer.parseInt(loanTermYears)*12;
			double apr = Double.parseDouble(interestRate);
			
			ResponseTO resp = new ResponseTO();
			long payment = AmortizationCalc.calcMonthlyPayment(loan, apr, months);
			AmortizationTO a = AmortizationCalc.getMonthlyPayments(loan, apr, months, payment);
			
			Calendar c = Calendar.getInstance();
			for(MortgageMonthPayment m : a.getPmts()) {
				c.add(Calendar.MONTH, 1);
				m.setCreatedTime(c.getTime());
			}
			
			a.setPayment(payment);
			resp.setResult(a);
			return resp;
			
		} catch (InputValidateException e) {
			logger.warn(e.getMessage());
			return userError(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			return error(e);
		}
	}*/
}
