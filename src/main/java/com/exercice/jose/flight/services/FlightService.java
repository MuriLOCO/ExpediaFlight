package com.exercice.jose.flight.services;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exercice.jose.flight.entities.Flight;
import com.exercice.jose.flight.repositories.FlightRepository;

@Component
public class FlightService {

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("hh:mm a");

  private FlightRepository flightRepo;

  @Autowired
  public FlightService(FlightRepository flightRepo) {
    this.flightRepo = flightRepo;
  }

  /**
   * Method responsible to return all the flights with a departure time between 5 hours before and 5 hours after the chosen departure time
   * @param departure - Departure time in String format
   * @return - List of Flights with the corresponding departure time window
   */
  public List<Flight> getFlightsByDeparture(String departure) {
    LocalTime localTime = LocalTime.parse(departure, FORMATTER);
    return flightRepo.findByDepartureBeforeAndDepartureAfter(localTime.plus(5, ChronoUnit.HOURS),
          localTime.minus(5, ChronoUnit.HOURS));
  }

}
