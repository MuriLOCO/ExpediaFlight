package com.exercice.jose.flight.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercice.jose.flight.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

  /**
   * Method responsible to obtain the flights which are in the windows of the two conditions of the LocalDateTime
   * @param conditionOne - First condition
   * @param conditionTwo - Second condition
   * @return - List of Flights under these condition
   */
  List<Flight> findByDepartureBeforeAndDepartureAfter(LocalDateTime conditionOne, LocalDateTime conditionTwo);
}
