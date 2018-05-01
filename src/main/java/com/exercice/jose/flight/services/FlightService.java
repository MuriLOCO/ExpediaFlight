package com.exercice.jose.flight.services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.exercice.jose.flight.entities.Flight;
import com.exercice.jose.flight.repositories.FlightRepository;

public class FlightService {

  private FlightRepository flightRepo;

  @Autowired
  public FlightService(FlightRepository flightRepo) {
    this.flightRepo = flightRepo;
  }

  /**
   * Method responsible to return all the flights with a departure time between 5 hours before and 5 hours after the chosen departure time
   * @param departure - Departure time
   * @return - List of Flights with the corresponding departure time window
   */
  public List<Flight> getFlightsByDeparture(LocalDateTime departure) {
    return flightRepo.findByDepartureBeforeAndDepartureAfter(departure.plus(5, ChronoUnit.HOURS),
          departure.minus(5, ChronoUnit.HOURS));
  }

}
