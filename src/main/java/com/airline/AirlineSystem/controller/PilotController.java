package com.airline.AirlineSystem.controller;

import com.airline.AirlineSystem.entity.Pilot;
import com.airline.AirlineSystem.service.AirportService;
import com.airline.AirlineSystem.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PilotController {

  @Autowired
  private PilotService pilotService;

    public PilotController() {
        super();
    }

    public PilotController(PilotService pilotService) {
        super();
        this.pilotService = pilotService;
    }

    @GetMapping("/pilots")
    public String getAllPilots(Model model){
        model.addAttribute("pilots",pilotService.getAllPilots());
        return "pilots";
    }

    @GetMapping("/pilots/new")
    public String createPilotForm(Model model){
        Pilot pilot = new Pilot();
        model.addAttribute("pilot",pilot);
        return "add_pilots";
    }

    @PostMapping("/pilots")
    public String savePilots(@ModelAttribute("pilot")  Pilot pilot){
        pilotService.addPilots(pilot);
        return "redirect:/pilots";
    }

    @GetMapping("/pilots/edit/{id}")
    public String editPilotForm(@PathVariable Long id, Model model){
        model.addAttribute("pilot",pilotService.getPilotById(id));
        return "edit_pilots";
    }

    @PostMapping("/pilots/{id}")
    public String updatePilots(@PathVariable Long id, @ModelAttribute("pilot") Pilot pilot){
        Pilot exsitingPilot = pilotService.getPilotById(id);

        exsitingPilot.setId(id);
        exsitingPilot.setName(pilot.getName());
        exsitingPilot.setAge(pilot.getAge());
        pilotService.updatePilot(exsitingPilot);
        return "redirect:/pilots";
    }

    @GetMapping("/pilots/{id}")
    public String deletePilot(@PathVariable Long id){
        pilotService.deletePilot(id);
        return "redirect:/pilots";
    }
}
