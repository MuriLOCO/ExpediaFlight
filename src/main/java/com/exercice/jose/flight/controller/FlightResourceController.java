package com.exercice.jose.flight.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercice.jose.flight.entities.Flight;
import com.exercice.jose.flight.services.FlightService;

@RestController
public class FlightResourceController {

  private FlightService flightService;

  @Autowired
  public FlightResourceController(FlightService flightService) {
    this.flightService = flightService;
  }

  /**
   * Controller responsible to return the Flights between 5 hours before and 5 hours after the chosen departure time
   * @param departure - Departure time in LocalDateTime
   * @return - List of Flights under this time window
   */
  @RequestMapping(value = "/departure", method = RequestMethod.GET)
  public List<Flight> getDeparture(@RequestParam(value = "departure", required = true) LocalDateTime departure) {
    return flightService.getFlightsByDeparture(departure);
  }
}
