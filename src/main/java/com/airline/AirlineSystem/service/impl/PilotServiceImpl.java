package com.airline.AirlineSystem.service.impl;


import com.airline.AirlineSystem.entity.Pilot;

import com.airline.AirlineSystem.repository.PilotRepository;
import com.airline.AirlineSystem.service.PilotService;
import com.airline.AirlineSystem.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotServiceImpl  implements PilotService {

    @Autowired
    PilotRepository pilotRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    public  PilotServiceImpl(){super();}


    @Override
    public List <Pilot> getAllPilots() {
        return pilotRepository.findAll();
    }


    @Override
    public Pilot addPilots(Pilot pilot) {
        pilot.setId(sequenceGeneratorService.generateSequence(Pilot.SEQUENCE_NAME));
        return  pilotRepository.save(pilot);
    }

    @Override
    public void deletePilot(Long id) {
        pilotRepository.deleteById(id);
    }

    @Override
    public Pilot updatePilot(Pilot pilot) {
        return pilotRepository.save(pilot);
    }

    @Override
    public Pilot getPilotById( Long id){ return  pilotRepository.findById(id).get();}


}
