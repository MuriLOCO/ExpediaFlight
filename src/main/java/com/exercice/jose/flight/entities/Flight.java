package com.exercice.jose.flight.entities;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Flight {

  public Flight(String flightName, LocalTime departure) {
    this.flightName = flightName;
    this.departure = departure;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String flightName;

  private LocalTime departure;
}
