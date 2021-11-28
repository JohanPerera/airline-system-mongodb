package com.airline.AirlineSystem.entity;

import com.airline.AirlineSystem.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PackageController {

    @Autowired
    private PackageService packageService;

    public PackageController() {
        super();
    }

    public PackageController(PackageService packageService) {
        super();
        this.packageService = packageService;
    }

    @GetMapping("/packages")
    public String getAllPackages(Model model){
        model.addAttribute("packages",packageService.getAllPackages());
        return "package";
    }

    @GetMapping("/packages/new")
    public String createPackageForm(Model model){
        Package pakage = new Package();
        model.addAttribute("package",pakage);
        return "add_package";
    }

    @PostMapping("/packages")
    public String savePackage(@ModelAttribute("package")Package pakage){
        packageService.addPackage(pakage);
        return "redirect:/packages";
    }

    @GetMapping("/packages/edit/{id}")
    public String editPackageForm(@PathVariable Long id, Model model){
        model.addAttribute("package",packageService.getPackageById(id));
        return "edit_package";
    }

    @PostMapping("/packages/{id}")
    public String updatePackage(@PathVariable Long id, @ModelAttribute("package") Package pakage){
        Package existingPackage = packageService.getPackageById(id);

        existingPackage.setId(id);
        existingPackage.setName(pakage.getName());
        existingPackage.setPrice(pakage.getPrice());

        packageService.updatePackage(existingPackage);
        return "redirect:/packages";
    }


    @GetMapping("/packages/{id}")
    public String deletepackage(@PathVariable Long id){
        packageService.deletePackage(id);
        return "redirect:/packages";
    }

}
