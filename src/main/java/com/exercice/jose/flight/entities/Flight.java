package com.exercice.jose.flight.entities;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Getter
@Setter
@NoArgsConstructor
public class Flight {

  public Flight(String flightName, LocalDateTime departure) {
    this.flightName = flightName;
    this.departure = departure;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String flightName;

  private LocalDateTime departure;
}
