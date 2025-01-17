package gr.hua.dit.ds.ergasia.controllers;

import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.entities.shelter;
import gr.hua.dit.ds.ergasia.service.AdoptionRequestService;
import gr.hua.dit.ds.ergasia.service.ShelterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import gr.hua.dit.ds.ergasia.service.petService;

import java.security.Principal;

@Controller
@RequestMapping("/shelters")
public class shelterController {
    private final ShelterService shelterService;
    private final AdoptionRequestService adoptionRequestService;
    private final petService petService;

    public shelterController(ShelterService shelterService, AdoptionRequestService adoptionRequestService, petService petService) {
        this.shelterService = shelterService;
        this.adoptionRequestService = adoptionRequestService;
        this.petService = petService;
    }

    @GetMapping("/register")
    public String registerShelterForm(Model model) {
        model.addAttribute("shelter", new shelter());
        return "shelter_register";
    }

    @PostMapping("/register")
    public String submitShelter(@ModelAttribute shelter shelter) {
        shelterService.submitShelter(shelter);
        return "redirect:/";
    }
    @GetMapping("/add-pet")
    public String addPetForm(Model model) {
        model.addAttribute("pet", new pet());
        return "add_pet"; // View to add a new pet
    }

    @PostMapping("/add-pet")
    public String addPet(@ModelAttribute pet pet){
        petService.addPetPendingApproval(pet); // Add pet with "Pending" status
        return "redirect:/shelters";
    }

    @GetMapping("/adoption-requests")
    public String viewAdoptionRequests(Model model) {
        model.addAttribute("requests", adoptionRequestService.getPendingRequests());
        return "adoption_requests";
    }

    @PostMapping("/adoption-requests/{requestId}/approve")
    public String approveAdoptionRequest(@PathVariable Integer requestId) {
        adoptionRequestService.approveRequestByShelter(requestId);
        return "redirect:/shelters/adoption-requests";
    }
}