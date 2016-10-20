package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.LoginModel;
import com.nagarro.service.FlightService;
import com.nagarro.service.LoginService;
import com.nagarro.util.exception;

@Controller
@SessionAttributes("loginmodel")
public class LoginController 
{
	@Autowired
	private LoginService loginService;
	@Autowired
	private FlightService flightService;

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView user(){
		return new ModelAndView("login","login",new LoginModel());
	}

	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public ModelAndView userlogin(@ModelAttribute("login") LoginModel login, BindingResult result,Model model) throws exception{
       
		flightService.saveCSVFileIntoDB();
		model.addAttribute("userId", login.getUserId());
		
		if(loginService.validateUser(login))
			return new ModelAndView("redirect:flightsearch.html");
		else
			return new ModelAndView("redirect:login.html");
	}


}
