package gr.hua.dit.ds.ergasia.controllers;

import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.entities.shelter;
import gr.hua.dit.ds.ergasia.service.ShelterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shelters")
public class shelterController {
    private final ShelterService shelterService;

    public shelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @GetMapping
    public String getAllShelters(Model model) {
        model.addAttribute("shelters", shelterService.getAllShelters());
        return "shelters"; // returns a view named "shelters"
    }

    @PostMapping
    public String addShelter(@ModelAttribute shelter shelter) {
        shelterService.addShelter(shelter);
        return "redirect:/shelters";
    }

    @PostMapping("/{shelterId}/pets")
    public String addPetToShelter(@PathVariable Integer shelterId, @ModelAttribute pet pet) {
        shelterService.addPetToShelter(shelterId, pet);
        return "redirect:/shelters";
    }
}