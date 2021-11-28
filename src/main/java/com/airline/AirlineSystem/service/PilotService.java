package com.airline.AirlineSystem.service;

import com.airline.AirlineSystem.entity.Pilot;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PilotService {

    List<Pilot> getAllPilots();


    Pilot addPilots(Pilot pilot);

    void deletePilot(Long id);

    Pilot updatePilot(Pilot pilot);

    Pilot getPilotById(Long id);
}
