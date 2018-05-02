package com.exercice.jose.flight;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exercice.jose.flight.entities.Flight;
import com.exercice.jose.flight.repositories.FlightRepository;

@SpringBootApplication
public class FlightApplication implements CommandLineRunner{

  @Autowired
  private FlightRepository flightRepo;

	public static void main(String[] args) {
		SpringApplication.run(FlightApplication.class, args);
  }  

  @Override
  public void run(String... args) throws Exception {
    initializeData();
  }
  
  /**
   * Method responsible to initialize the data
   */
  private void initializeData() {
    flightRepo.save(new Flight("Air Canada 8099", LocalTime.of(7, 30)));
    flightRepo.save(new Flight("United Airlines 6115", LocalTime.of(10, 30)));
    flightRepo.save(new Flight("WestJet 6456", LocalTime.of(12, 30)));
    flightRepo.save(new Flight("Delta 3833", LocalTime.of(15, 00)));
  }

}
