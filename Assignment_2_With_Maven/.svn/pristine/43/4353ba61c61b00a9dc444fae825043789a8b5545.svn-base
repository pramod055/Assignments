package com.nagarro.flightsearchengine.service;

import java.util.Comparator;

import com.nagarro.flightsearchengine.domain.FlightDetails;
/**
 * @author pramodyadav
 *class use for sort flight based on flight duration
 */
public class SortFlightsBasedOnDuration implements Comparator<FlightDetails> {
	@Override
	public int compare(FlightDetails o1, FlightDetails o2) {
		return Double.compare(o1.getFlight_Dur(),o2.getFlight_Dur());
	}

}
