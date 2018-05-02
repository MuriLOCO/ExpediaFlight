package com.exercice.jose.flight.utils;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * This class as designed to convert LocalTime to Time so it can be placed correctly on the DB
 * @author Jose Mendes
 *
 */
@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {

  @Override
  public Time convertToDatabaseColumn(LocalTime localTime) {
    return localTime != null ? Time.valueOf(localTime) : null;
  }

  @Override
  public LocalTime convertToEntityAttribute(Time time) {
    return time != null ? time.toLocalTime() : null;
  }

}
