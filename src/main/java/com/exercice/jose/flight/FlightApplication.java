package com.exercice.jose.flight;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exercice.jose.flight.entities.Flight;
import com.exercice.jose.flight.repositories.FlightRepository;

@SpringBootApplication
public class FlightApplication {

  private final static LocalDateTime TIME_NOW = LocalDateTime.now();

  private FlightRepository flightRepo;

  @Autowired
  public FlightApplication(FlightRepository flightRepo) {
    this.flightRepo = flightRepo;
  }

	public static void main(String[] args) {
		SpringApplication.run(FlightApplication.class, args);
  }

  private void initializeData() {
    flightRepo.save(new Flight("Air Canada 8099", TIME_NOW.withHour(7).withMinute(30)));
    flightRepo.save(new Flight("United Airlines 6115", TIME_NOW.withHour(10).withMinute(30)));
    flightRepo.save(new Flight("WestJet 6456", TIME_NOW.withHour(12).withMinute(30)));
    flightRepo.save(new Flight("Delta 3833", TIME_NOW.withHour(15).withMinute(00)));
	}

}
