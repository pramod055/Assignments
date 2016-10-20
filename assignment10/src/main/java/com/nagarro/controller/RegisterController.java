package com.nagarro.controller;

import java.util.List;

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
import com.nagarro.model.RegisterModel;
import com.nagarro.service.RegisterService;

@Controller
@SessionAttributes("userRegistration")
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value ="/register",method=RequestMethod.GET)
	public ModelAndView userRegistration(Model model){
		return new ModelAndView("register","register",new RegisterModel());
	}
    
	@RequestMapping(value ="/register", method=RequestMethod.POST)
	public ModelAndView userlogin(@ModelAttribute("register") RegisterModel register, BindingResult result ,ModelMap model){

		registerService.add(register);
		
		return new ModelAndView("redirect:login.html");
	}
	
	@RequestMapping(value="/success", method = RequestMethod.GET)
	public ModelAndView LoggedUser(Model model){
	List<RegisterModel> users = registerService.findAllUsers();
	model.addAttribute("users",users);
	return new ModelAndView("success");
	}
}
