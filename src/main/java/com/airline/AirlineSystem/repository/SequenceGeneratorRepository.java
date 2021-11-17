package com.airline.AirlineSystem.repository;

import com.airline.AirlineSystem.entity.DatabaseSequence;
import com.airline.AirlineSystem.entity.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SequenceGeneratorRepository  extends MongoRepository<DatabaseSequence,Long> {
}
