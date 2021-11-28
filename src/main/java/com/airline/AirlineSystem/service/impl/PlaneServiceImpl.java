package com.airline.AirlineSystem.service.impl;

import com.airline.AirlineSystem.entity.Airport;
import com.airline.AirlineSystem.entity.Plane;
import com.airline.AirlineSystem.repository.AirportRepository;
import com.airline.AirlineSystem.repository.PlaneRepository;
import com.airline.AirlineSystem.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlaneServiceImpl {
    @Autowired
    PlaneRepository planeRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    public PlaneServiceImpl() {
        super();
    }


    @Override
    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    @Override
    public Plane addPlane(Plane plane) {
        plane.setId(sequenceGeneratorService.generateSequence(Plane.SEQUENCE_NAME));
        return planeRepository.save(plane);
    }

    @Override
    public void deletePlane(Long id) {
        planeRepository.deleteById(id);
    }

    @Override
    public Plane updatePlane(Plane plane) {
        return planeRepository.save(plane);
    }

    @Override
    public Plane getPlaneById(Long id) {
        return planeRepository.findById(id).get();
    }
}
