/*package com.nagarro.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.nagarro.model.RegisterModel;
import com.nagarro.service.RegisterService;

@Controller
@SessionAttributes("userRegistration")
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value ="/register",method=RequestMethod.GET)
	public String userRegistration(Model model){
		model.addAttribute("RegisterModel", new RegisterModel());
		return "register";
	}
    
	@RequestMapping(value ="/register", method=RequestMethod.POST)
	public String userlogin(@Valid @ModelAttribute("RegisterModel") RegisterModel registermodel, BindingResult result ,Model model){

		System.out.println("in register post"+result.hasErrors());
		if(result.hasErrors()){
			return "register";
		}
		if(registerService.validateUser(registermodel))
		{
			registerService.add(registermodel);
			return "login";
		}
		else
		{
			System.out.println("user exist already");
			model.addAttribute("ErrorMessage", "UserId Already Exists !!! Please Enter New User Id");
			return "register";
		}
	
	}
	
	@RequestMapping(value="/flightResults", method = RequestMethod.GET)
	public ModelAndView LoggedUser(Model model){
	return new ModelAndView("flightResults");
	}
}



*/


package com.nagarro.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.nagarro.model.RegisterModel;
import com.nagarro.service.RegisterService;

@Controller
@SessionAttributes("userRegistration")
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value ="/register",method=RequestMethod.GET)
	public ModelAndView userRegistration(Model model){
		model.addAttribute("RegisterModel", new RegisterModel());
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("register");
		return mnv;
	}
    
	@RequestMapping(value ="/register", method=RequestMethod.POST)
	public ModelAndView userlogin(@Valid @ModelAttribute("RegisterModel") RegisterModel registermodel, BindingResult result ,Model model){

		System.out.println("in register!! post"+result.hasErrors());
		if(result.hasErrors()){
			return new ModelAndView("register");
		}
		if(registerService.validateUser(registermodel))
		{
			registerService.add(registermodel);
		    return new ModelAndView ("redirect:login.html");
		}
		else
		{
			model.addAttribute("ErrorMessage", "UserId Already Exists !!! Please Enter New User Id");
			return new ModelAndView("register");
		}
	
	}
	@RequestMapping(value="/flightResults", method = RequestMethod.GET)
	public ModelAndView LoggedUser(Model model){
	return new ModelAndView("flightResults");
	}
}





