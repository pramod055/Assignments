package com.nagarro.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
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
	public ModelAndView user(Model model){

		model.addAttribute("LoginModel", new LoginModel());
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("login");
		return mnv;
		
	}
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public ModelAndView userlogin(@Valid @ModelAttribute("LoginModel") LoginModel loginModel, BindingResult result,
			Model model,HttpServletResponse response) throws exception {
		flightService.saveCSVFileIntoDB();
		if(result.hasErrors())
		{
			 return new ModelAndView("login");
		}
		if(!loginService.validateUser(loginModel)){
			model.addAttribute("ErrorMessage", "Invalid User and Password !!! Please Login Again");
	    	  return new ModelAndView("login");
		}
		else{
			Cookie ck=new Cookie("myCookie", "LoggedIn");
			ck.setMaxAge(180);
			response.addCookie(ck);
			return new ModelAndView("redirect:flightsearch.html");
		}
			
	}
	@RequestMapping(value="/logout")
	public ModelAndView logout(Model model,HttpServletResponse response,HttpServletRequest req) throws exception {
		 Cookie ck=new Cookie("myCookie","");
		 ck.setMaxAge(0);
		 response.addCookie(ck);  
		 model.addAttribute("msg", "You are successfully logged out!!!");
			
		 return new ModelAndView("logout");
	}
}















/*









package com.nagarro.controller;

import java.util.Timer;
import java.util.TimerTask;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nagarro.model.LoginModel;
import com.nagarro.service.FlightInterfaceService;
import com.nagarro.service.LoginInterfaceService;

@Controller
@SessionAttributes("userName")
public class LoginController 
{
	
	@Autowired
	private LoginInterfaceService loginInterfaceService;
	
	@Autowired
	private FlightInterfaceService flightInterfaceService;
	
	@SuppressWarnings("resource")
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginUser( @ModelAttribute("LoginModel") LoginModel loginModel) 
	{
		
		Timer timerObject= new Timer();
		timerObject.schedule(new FlightInterfaceService(), 0, 20000);
		new ClassPathXmlApplicationContext("application-config2.xml");
		
		System.out.println("in login get");
	    System.out.println(loginModel.getUserName());
	    System.out.println(loginModel.getPassword());
		return "login";
		//return new ModelAndView("login","login",new LoginModel());
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUserRedirect(@Valid @ModelAttribute("LoginModel") LoginModel loginModel,BindingResult result,Model model) 
	{
		System.out.println("in login post");
		System.out.println(result.hasErrors());
	    System.out.println(loginModel.getUserName());
	    System.out.println(loginModel.getPassword());
	    model.addAttribute("userName", loginModel.getUserName());
	    
	    
	    flightInterfaceService.populateFlightDb();
	    
	    if(result.hasErrors())
	    	return "login";
	    
	    if( !(loginInterfaceService.isValidLoginUser(loginModel) ) )
	    	{
	    	model.addAttribute("userName", "Invalid user,please login again");
	    	  System.out.println("login user is not valid");
	    	  return "login";
	    	}//return new ModelAndView("login","login",new LoginModel());
	    else
	    	return "redirect:homepage.html";
	    	//return new ModelAndView("redirect:homepage.html");
	}

}


*/



















