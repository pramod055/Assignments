package com.nagarro.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.FlightDetails;
import com.nagarro.model.FlightModel;
import com.nagarro.model.UserInput;
import com.nagarro.service.FlightSearch;
import com.nagarro.service.FlightService;
import com.nagarro.util.exception;

@Controller
@SessionAttributes("resultList")
public class HomepageController {
	
	@Autowired
	private FlightService flightService;
	@RequestMapping(value="/flightsearch", method = RequestMethod.GET)
	public ModelAndView searchFlight(@CookieValue(value="myCookie" , defaultValue ="null") String myCookie,Model model){
	return new ModelAndView("flightsearch" ,"flightsearch",new UserInput());
	}
	
	
	@RequestMapping(value="/flightsearch" , method = RequestMethod.POST)
	public ModelAndView displayFlightResults(@Valid @ModelAttribute("flightsearch") UserInput userInputobj, BindingResult result,Model model) throws exception, ParseException, InterruptedException{
		    FlightSearch ob = new FlightSearch();
			ArrayList<FlightDetails> resultantSortedflightsList = (ArrayList<FlightDetails>) ob.runner(userInputobj); 
			model.addAttribute("resultList",resultantSortedflightsList);
			model.addAttribute("headerMsg", "Results!!!");
			return new ModelAndView("flightsearch");
	}

}
