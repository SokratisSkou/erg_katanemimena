package gr.hua.dit.ds.ergasia.controllers;

import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.service.ShelterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import gr.hua.dit.ds.ergasia.service.petService;

import java.util.List;

@Controller
@RequestMapping("/vet")
public class vetController {
    private final petService petService;


    public vetController(petService petService ) {
        this.petService = petService;

    }



    @GetMapping("/pets")
    public String getAllPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "vet_pets"; // View for vet to see all pets
    }

    @PostMapping("/pets")
    public String updatePetHealth(@ModelAttribute List<pet> pets) {
        for (pet pet : pets) {
            petService.addPet(pet); // Save each updated pet
        }
        return "redirect:/vet/pets"; // Redirect back to the pets list
    }




}
