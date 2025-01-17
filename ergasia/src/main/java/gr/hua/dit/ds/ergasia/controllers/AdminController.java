package gr.hua.dit.ds.ergasia.controllers;
import gr.hua.dit.ds.ergasia.entities.Admin;
import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.entities.shelter;
import gr.hua.dit.ds.ergasia.repository.AdminRepository;
import gr.hua.dit.ds.ergasia.service.ShelterService;
import gr.hua.dit.ds.ergasia.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import gr.hua.dit.ds.ergasia.service.petService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final petService petService;
    private final ShelterService shelterService;

    public AdminController(petService petService, ShelterService shelterService) {
        this.petService = petService;
        this.shelterService = shelterService;
    }

    @GetMapping("/pets/pending")
    public String getPendingPets(Model model) {
        List<pet> pendingPets = petService.getPetsByApprovalStatus("Pending");
        model.addAttribute("pets", pendingPets);
        return "pending_pets"; // View for pending pets
    }

    @GetMapping("/pets/approved")
    public String getApprovedPets(Model model) {
        List<pet> approvedPets = petService.getPetsByApprovalStatus("Approved");
        model.addAttribute("pets", approvedPets);
        return "approved_pets"; // View for approved pets
    }
    @GetMapping("/shelters/pending")
    public String getPendingShelters(Model model) {
        List<shelter> pendingShelters= shelterService.getSheltersByApprovalStatus("Pending");
        model.addAttribute("shelters", pendingShelters);
        return "pending_shelters";
    }
    @GetMapping("/shelters/approved")
    public String getApprovedShelters(Model model) {
        List<shelter> approvedShelters= shelterService.getSheltersByApprovalStatus("Approved");
        model.addAttribute("shelters", approvedShelters);
        return "approved_shelters";
    }


    @PostMapping("/pets/{petId}/approve")
    public String approvePet(@PathVariable Integer petId) {
        petService.updatePetApprovalStatus(petId, "Approved");
        return "redirect:/admin/pets/pending"; // Refresh the pending pets list
    }

    @PostMapping("/pets/{petId}/reject")
    public String rejectPet(@PathVariable Integer petId) {
        petService.deletePet(petId);
        return "redirect:/admin/pets/pending"; // Refresh the pending pets list
    }
    @PostMapping("/shelters/{shelterId}/approve")
    public String approveShelter(@PathVariable Integer shelterId) {
        shelterService.updateShelterApprovalStatus(shelterId, "Approved");
        return "redirect:/admin/shelters/pending"; // Refresh the pending shelter list
    }

    @PostMapping("/shelters/{shelterId}/reject")
    public String rejectShelter(@PathVariable Integer shelterId) {
        shelterService.deleteShelter(shelterId);
        return "redirect:/admin/shelters/pending"; // Refresh the pending shelters list
    }

}
