package com.airline.AirlineSystem.repository;

import com.airline.AirlineSystem.entity.Airport;
import org.springframework.data.mongodb.repository.*;


public interface AirportRepository extends MongoRepository<Airport, Long> {

}
