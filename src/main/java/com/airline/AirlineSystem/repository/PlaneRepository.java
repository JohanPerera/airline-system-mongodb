package com.airline.AirlineSystem.repository;

import com.airline.AirlineSystem.entity.Airport;
import com.airline.AirlineSystem.entity.Plane;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaneRepository extends MongoRepository<Plane,Long> {
}
