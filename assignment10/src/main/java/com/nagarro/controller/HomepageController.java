package com.nagarro.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.FlightModel;
import com.nagarro.model.UserInput;
import com.nagarro.service.FlightService;
import com.nagarro.util.exception;

@Controller
@SessionAttributes("flightSearch")
public class HomepageController {
	
	@Autowired
	private FlightService flightService;
	@RequestMapping(value="/flightsearch", method = RequestMethod.GET)
	public ModelAndView searchFlight(Model model){
	return new ModelAndView("flightsearch" ,"flightsearch",new UserInput());
	}
	
	
	@RequestMapping(value="/flightsearch" , method = RequestMethod.POST)
	public ModelAndView displayFlight(@ModelAttribute("flightsearch") UserInput userInputobj, BindingResult result,Model model) throws exception, ParseException, InterruptedException{
		    List<FlightModel> searchResult= flightService.searchFlightFromDB(userInputobj);
		   // request.
			return new ModelAndView("redirect:success.html");
	}

}
