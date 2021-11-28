package com.airline.AirlineSystem.service.impl;

import com.airline.AirlineSystem.entity.Airport;
import com.airline.AirlineSystem.repository.AirportRepository;
import com.airline.AirlineSystem.service.AirportService;
import com.airline.AirlineSystem.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    public AirportServiceImpl() {
        super();
    }


    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Airport addAirport(Airport airport) {
        airport.setId(sequenceGeneratorService.generateSequence(Airport.SEQUENCE_NAME));
        return airportRepository.save(airport);
    }

    @Override
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }

    @Override
    public Airport updateAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).get();
    }


}
