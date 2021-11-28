package com.airline.AirlineSystem.service;

import com.airline.AirlineSystem.entity.Airport;
import com.airline.AirlineSystem.entity.Plane;

import java.util.List;

public interface PlaneService {

    List<Plane> getAllPlanes();


    Plane addPlane(Plane plane);

    void deletePlane(Long id);

    Plane updatePlane(Plane plane);

    Plane getPlaneById(Long id);
}
