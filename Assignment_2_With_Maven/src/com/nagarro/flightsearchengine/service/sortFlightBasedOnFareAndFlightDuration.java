package com.nagarro.flightsearchengine.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.nagarro.flightsearchengine.domain.FlightDetails;
/**
 * @author pramodyadav
 *class use for sort flight based on two attribute fare and duration
 *Comparator is used to sort flight with multiple attribute
 */
public class sortFlightBasedOnFareAndFlightDuration implements Comparator<FlightDetails> 
{
	 private List<Comparator<FlightDetails>> listComparators;
	 
	    @SafeVarargs
		public sortFlightBasedOnFareAndFlightDuration(Comparator<FlightDetails>... comparators) {
	        this.listComparators = Arrays.asList(comparators);
	    }
	    @Override
	    public int compare(FlightDetails o1, FlightDetails o2) {
	        for (Comparator<FlightDetails> comparator : listComparators) {
	            int result = comparator.compare(o1, o2);
	            if (result != 0) {
	                return result;
	            }
	        }
	        return 0;
	    }
	}



