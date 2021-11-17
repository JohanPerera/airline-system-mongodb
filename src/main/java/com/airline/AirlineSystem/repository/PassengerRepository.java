package com.airline.AirlineSystem.repository;

import com.airline.AirlineSystem.entity.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PassengerRepository extends MongoRepository<Passenger,Long> {

}
