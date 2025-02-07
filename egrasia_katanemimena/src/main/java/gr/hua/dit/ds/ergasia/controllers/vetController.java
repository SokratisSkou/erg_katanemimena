package gr.hua.dit.ds.ergasia.controllers;

import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.entities.user;
import gr.hua.dit.ds.ergasia.entities.vet;
import gr.hua.dit.ds.ergasia.repository.UserRepository;
import gr.hua.dit.ds.ergasia.repository.VetRepository;
import gr.hua.dit.ds.ergasia.service.ShelterService;
import gr.hua.dit.ds.ergasia.service.VetService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import gr.hua.dit.ds.ergasia.service.petService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/vet")
public class vetController {

    private final petService petService;
    private final VetRepository vetRepository;
    private final VetService vetService;
    private final UserRepository userRepository;

    public vetController(petService petService, VetRepository vetRepository, VetService vetService,UserRepository userRepository) {
        this.petService = petService;
        this.vetRepository = vetRepository;
        this.vetService = vetService;
        this.userRepository = userRepository;
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Add any necessary attributes to the model for the dashboard view
        return "vet/dashboard"; // Ensure this view exists
    }
    @GetMapping("/details")
    public String showVetDetailsForm(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        vet vet = new vet();

        model.addAttribute("vet", vet);
        return "vet/details"; // Return the form view
    }

    @PostMapping("/save_details")
    public String saveVetDetails(@RequestParam String name,
                                     @RequestParam String surname,
                                     @RequestParam String contactInfo,
                                     @AuthenticationPrincipal UserDetails userDetails) {
        // Get the currently logged-in user
        String username = userDetails.getUsername();
        Optional<user> user= userRepository.findByUsername(username);

        vet vet = new vet();

        // Create and save the additional details
        vet.setName(name);
        vet.setSurname(surname);
        vet.setContactInfo(contactInfo);






        vetService.save(vet);

        return "redirect:/vet/dashboard"; // Redirect to the admin dashboard or another page
    }


    @GetMapping("/pending_pets")
    public String viewPetsForApproval(Model model) {
        model.addAttribute("pets", petService.getPendingForHealthStatusPets());
        return "vet/pending_pets";
    }

    @PostMapping("/approve_pet")
    public String approvePet(@RequestParam("petId") int petId, @AuthenticationPrincipal UserDetails userDetails) {
        vet currentVet = vetService.findByUsername(userDetails.getUsername());

        petService.updateHealthStatus(petId,currentVet);
        return "redirect:/vet/dashboard";
    }
    @PostMapping("/decline_pet")
    public String declinePet(@RequestParam("petId") int petId) {
        // Delete the pet from the database
        petService.deletePetById(petId);
        return "redirect:/vet/dashboard"; // Redirect to the vet dashboard
    }

}
