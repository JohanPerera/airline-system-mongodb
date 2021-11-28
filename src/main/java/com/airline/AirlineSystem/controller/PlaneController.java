package com.airline.AirlineSystem.controller;


import com.airline.AirlineSystem.entity.Plane;
import com.airline.AirlineSystem.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlaneController {

    @Autowired
    private PlaneService planeService ;

    public PlaneController() {
        super();
    }

    public PlaneController(PlaneService planeService) {
        super();
        this.planeService = planeService;
    }

    @GetMapping("/planes")
    public String getAllPlanes(Model model){
        model.addAttribute("planes",planeService.getAllPlanes());
        return "plane";
    }

    @GetMapping("/planes/new")
    public String createPlaneForm(Model model){
        Plane plane = new Plane();
        model.addAttribute("plane",plane);
        return "add_plane";
    }

    @PostMapping("/planes")
    public String savePlane(@ModelAttribute("plane") Plane plane){
        planeService.addPlane(plane);
        return "redirect:/planes";
    }

    @GetMapping("/planes/edit/{id}")
    public String editPlaneForm(@PathVariable Long id, Model model){
        model.addAttribute("plane",planeService.getPlaneById(id));
        return "edit_plane";
    }

    @PostMapping("/planes/{id}")
    public String updatePlane(@PathVariable Long id, @ModelAttribute("plane") Plane plane){
        Plane existingPlane = planeService.getPlaneById(id);

        existingPlane.setId(id);
        existingPlane.setRegistration_number(plane.getRegistration_number());
        existingPlane.setModel_number(plane.getModel_number());
        existingPlane.setPassenger_capacity(plane.getModel_number());

        planeService.updatePlane(existingPlane);
        return "redirect:/planes";
    }



    @GetMapping("/planes/{id}")
    public String deletePlane(@PathVariable Long id){
        planeService.deletePlane(id);
        return "redirect:/planes";
    }
}
