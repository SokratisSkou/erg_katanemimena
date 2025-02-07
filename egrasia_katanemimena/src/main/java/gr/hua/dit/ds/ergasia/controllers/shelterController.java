package gr.hua.dit.ds.ergasia.controllers;

import gr.hua.dit.ds.ergasia.entities.Admin;
import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.entities.shelter;
import gr.hua.dit.ds.ergasia.entities.user;
import gr.hua.dit.ds.ergasia.repository.ShelterRepository;
import gr.hua.dit.ds.ergasia.repository.UserRepository;
import gr.hua.dit.ds.ergasia.service.AdminService;
import gr.hua.dit.ds.ergasia.service.AdoptionRequestService;
import gr.hua.dit.ds.ergasia.service.ShelterService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import gr.hua.dit.ds.ergasia.service.petService;

import java.util.Optional;


@Controller
@RequestMapping("/shelter")
public class shelterController {

    private final petService petService;
    private final AdoptionRequestService adoptionService;
    private final ShelterService shelterService;
    private final ShelterRepository shelterRepository;
    private final UserRepository userRepository;
    private final AdoptionRequestService adoptionRequestService;

    public shelterController(petService petService, AdoptionRequestService adoptionService,ShelterService shelterService,ShelterRepository shelterRepository,UserRepository userRepository,AdoptionRequestService adoptionRequestService) {
        this.petService = petService;
        this.adoptionService = adoptionService;
        this.shelterService = shelterService;
        this.shelterRepository = shelterRepository;
        this.userRepository = userRepository;
        this.adoptionRequestService = adoptionRequestService;
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Add any necessary attributes to the model for the dashboard view
        return "shelter/dashboard"; // Ensure this view exists
    }
    @GetMapping("/details")
    public String showShelterDetailsForm(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        shelter shelter = shelterRepository.findByName(userDetails.getUsername())
                .orElse(new shelter());
        model.addAttribute("shelter", shelter);
        return "shelter/details"; // Return the form view
    }

    @PostMapping("/save_details")
    public String saveShelterDetails(@RequestParam String name,
                                   @RequestParam String location,
                                   @RequestParam String contactInfo,
                                   @AuthenticationPrincipal UserDetails userDetails) {
        // Get the currently logged-in user
        String username = userDetails.getUsername();
        Optional<user> user= userRepository.findByUsername(username);
        shelter shelter = new shelter();

        // Create and save the additional details
        shelter.setName(name);
        shelter.setLocation(location);
        shelter.setContactInfo(contactInfo);
        shelter.setApprovalStatus("Pending");




        // Save the updated admin entity
        shelterService.save(shelter);

        return "redirect:/shelter/dashboard"; // Redirect to the admin dashboard or another page
    }



    @GetMapping("/add_pet")
    public String addPetForm(Model model) {
        model.addAttribute("pet", new pet());
        return "shelter/add_pet";
    }
    @PostMapping("/save_pet")
    public String savePetDetails(@RequestParam int age,
                                     @RequestParam String name,
                                     @RequestParam String type,
                                     @RequestParam int shelterId,
                                     @AuthenticationPrincipal UserDetails userDetails) {

        shelter shelter = shelterService.findById(shelterId);
        pet pet = new pet();

        // Create and save the additional details
        pet.setShelter(shelter);
        pet.setAge(age);
        pet.setName(name);
        pet.setType(type);
        pet.setApprovalStatus("Pending");
        pet.setHealthStatus("Pending");
        pet.setVet(null);
        pet.setCitizen(null);





        // Save the updated admin entity
        petService.save(pet);

        return "redirect:/shelter/dashboard"; // Redirect to the admin dashboard or another page
    }
    @GetMapping("/pending_adoption_request")
    public String pendingAdoptionRequest (Model model) {
        model.addAttribute("pendingRequests", adoptionRequestService.getPendingRequestsByShelter());
        return "shelter/pending_adoption_request";
    }
    @PostMapping("/accept_request")
    public String acceptAdoptionRequest(@RequestParam("requestId") int requestId) {
        adoptionRequestService.approveRequestByShelter(requestId);
        return "redirect:/shelter/dashboard";

    }
    @PostMapping("/decline_request")
    public String declineAdoptionRequest(@RequestParam("requestId") int requestId) {
        adoptionRequestService.deleteRequest(requestId);
        return "redirect:/admin/dashboard";
    }
}

