package com.airline.AirlineSystem.repository;

import com.airline.AirlineSystem.entity.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlightRepository extends MongoRepository<Flight, Long> {

}
