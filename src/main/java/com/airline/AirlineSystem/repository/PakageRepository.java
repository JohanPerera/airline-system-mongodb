package com.airline.AirlineSystem.repository;

import com.airline.AirlineSystem.entity.Package;
import org.springframework.data.mongodb.repository.*;


public interface PakageRepository extends MongoRepository<Package, Long> {

}
