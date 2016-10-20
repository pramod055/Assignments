/*package com.nagarro.controller;



import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.LoginModel;


@Controller
public class LoginController1
{
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(Model model)
	{
		model.addAttribute("flightSearchUser", new LoginModel());
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("login");
		return mnv;
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
	public ModelAndView loginProcess(@Valid @ModelAttribute("flightSearchUser") LoginModel flightSearchUser, BindingResult result)
	{
		if ( result.hasErrors() )
		{
			ModelAndView model = new ModelAndView();
			model.setViewName("login");
			return model;
		}
		if ( flightSearchUser.getUserId().equals("pramod") )
		{
			ModelAndView model = new ModelAndView();
			model.setViewName("login");
			model.addObject("errorMsg", "Invalid Username and Password");
			return model;
		}

		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("redirect:flight");
		return mnv;
	}
}
*/