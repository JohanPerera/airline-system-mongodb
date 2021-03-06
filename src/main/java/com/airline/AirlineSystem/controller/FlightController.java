package com.airline.AirlineSystem.controller;

import com.airline.AirlineSystem.entity.Flight;
import com.airline.AirlineSystem.service.AirportService;
import com.airline.AirlineSystem.service.FlightService;
import com.airline.AirlineSystem.service.PilotService;
import com.airline.AirlineSystem.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private PlaneService planeService;

    @Autowired
    private PilotService pilotService;

    public FlightController(FlightService flightService) {
        super();
        this.flightService = flightService;
    }

    public FlightController() {
        super();
    }

    @GetMapping("/flights")
    public String getAllFlights(Model model){
        model.addAttribute("flights",flightService.getAllFlights());
        return "flights";
    }

    @GetMapping("/flights/new")
    public String createFlightForm(Model model){
        Flight flight = new Flight();
        model.addAttribute("flight",flight);
        model.addAttribute("airports",airportService.getAllAirports());
        model.addAttribute("pilots",pilotService.getAllPilots());
        model.addAttribute("planes",planeService.getAllPlanes());
        return "add_flight";
    }

    @PostMapping("/flights")
    public String saveFlight(@ModelAttribute("flight") Flight flight){
        System.out.println(flight.getId());
        System.out.println(flight.getFromAirport().getName());
        System.out.println(flight.getToAirport().getName());
        flightService.addFlight(flight);
        return "redirect:/flights";
    }

    @GetMapping("flights/edit/{id}")
    public String editFlightForm(@PathVariable Long id, Model model){
        model.addAttribute("flight",flightService.getFlightById(id));
        model.addAttribute("airports",airportService.getAllAirports());
        model.addAttribute("pilots",pilotService.getAllPilots());
        model.addAttribute("planes",planeService.getAllPlanes());
        return "edit_flight";
    }

    @PostMapping("/flights/{id}")
    public String updateFlight(@PathVariable Long id,@ModelAttribute("flight") Flight flight){
        Flight existingFlight = flightService.getFlightById(id);


        System.out.println(flight.getDepTime());

        existingFlight.setId(id);
        existingFlight.setDepTime(flight.getDepTime());
        existingFlight.setFromAirport(flight.getFromAirport());
        existingFlight.setToAirport(flight.getToAirport());
        existingFlight.setPlane(flight.getPlane());

        flightService.updateFlight(flight);
        return "redirect:/flights";
    }

    @GetMapping("/flights/{id}")
    public String deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
        return "redirect:/flights";
    }
}
