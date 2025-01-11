package gr.hua.dit.ds.ergasia.controllers;

import gr.hua.dit.ds.ergasia.entities.pet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import gr.hua.dit.ds.ergasia.service.*;

@Controller
@RequestMapping("/pets")
public class petController {
    private final petService petService;

    public petController(petService petService) {
        this.petService = petService;
    }

    @GetMapping
    public String getAllPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "pets"; // returns a view named "pets"
    }

    @PostMapping
    public String addPet(@ModelAttribute pet pet, Model model) {
        petService.addPet(pet);
        return "redirect:/pets"; // redirects to the list of pets
    }
}