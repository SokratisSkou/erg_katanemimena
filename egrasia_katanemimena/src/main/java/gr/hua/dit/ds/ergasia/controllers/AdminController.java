package gr.hua.dit.ds.ergasia.controllers;
import gr.hua.dit.ds.ergasia.entities.Admin;
import gr.hua.dit.ds.ergasia.entities.user;
import gr.hua.dit.ds.ergasia.entities.vet;
import gr.hua.dit.ds.ergasia.repository.AdminRepository;
import gr.hua.dit.ds.ergasia.repository.UserRepository;
import gr.hua.dit.ds.ergasia.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ShelterService shelterService;
    private final petService petService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final AdminService adminService;
    private final AdminRepository adminRepository;
    private final AdoptionRequestService adoptionRequestService;

    public AdminController(ShelterService shelterService, petService petService, UserService userService, UserRepository userRepository, AdminService adminService, AdminRepository adminRepository, AdoptionRequestService adoptionRequestService) {
        this.shelterService = shelterService;
        this.petService = petService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.adminService = adminService;
        this.adminRepository = adminRepository;
        this.adoptionRequestService = adoptionRequestService;
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Add any necessary attributes to the model for the dashboard view
        return "/admin/dashboard"; // Ensure this view exists
    }
    @GetMapping("/details")
    public String showAdminDetailsForm(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Admin admin = adminRepository.findBySurname(userDetails.getUsername())
                .orElse(new Admin()); // Create a new Admin if not found
        model.addAttribute("admin", admin);
        return "admin/details"; // Return the form view
    }

    @PostMapping("/save_details")
    public String saveAdminDetails(@RequestParam String name,
                                   @RequestParam String surname,
                                   @RequestParam int age,
                                   @AuthenticationPrincipal UserDetails userDetails) {
        // Get the currently logged-in user
        String username = userDetails.getUsername();
        Optional<user> user= userRepository.findByUsername(username); // Fetch the user by email
        Admin admin = new Admin();

        // Create and save the additional details
        admin.setName(name);

        admin.setSurname(surname);
        admin.setAge(age);
        System.out.println(admin.getAge());

        // Save the updated admin entity
        adminService.save(admin);

        return "redirect:/admin/dashboard"; // Redirect to the admin dashboard or another page
    }



    @GetMapping("/pending_shelters")
    public String viewSheltersForApproval(Model model) {
        model.addAttribute("shelters", shelterService.getPendingShelters());
        return "admin/pending_shelters";
    }

    @PostMapping("/approve_shelter")
    public String approveShelter(@RequestParam("shelterId") int shelterId) {
        shelterService.approveShelter(shelterId);
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/delete_shelter")
    public String deleteShelter(@RequestParam("shelterId") int shelterId) {
        shelterService.deleteShelter(shelterId);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/pending_pets")
    public String managePets(Model model) {
        model.addAttribute("pets", petService.getPendingForApprovalStatusPets());
        return "/admin/pending_pets";
    }
    @PostMapping("/approve_pet")
    public String approvePet(@RequestParam("petId") int petId) {

        petService.updatePetApprovalStatus(petId,"Approved");
        return "redirect:/admin/dashboard";
    }
    @PostMapping("/decline_pet")
    public String declinePet(@RequestParam("petId") int petId) {
        // Delete the pet from the database
        petService.deletePetById(petId);
        return "redirect:/admin/dashboard"; // Redirect to the vet dashboard
    }

    @GetMapping("/manage_users")
    public String manageUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "admin/manage_users";
    }
    @GetMapping("/edit_user")
    public String editUser (@RequestParam("id") int userId, Model model) {
        Object user = userService.getUser(userId); // Fetch the user by ID
        model.addAttribute("user", user);
        return "admin/edit_user"; // Return the edit user view
    }

    @PostMapping("/delete_user")
    public String deleteUser (@RequestParam("id") int userId) {
        userService.deleteUser (userId); // Implement this method in your UserService
        return "redirect:/admin/manage_users"; // Redirect back to the manage users page
    }
    @GetMapping("/pending_adoption_request")
    public String pendingAdoptionRequest (Model model) {
        model.addAttribute("pendingRequests", adoptionRequestService.getPendingRequestsByAdmin());
        return "admin/pending_adoption_request";
    }
    @PostMapping("/accept_request")
    public String acceptAdoptionRequest(@RequestParam("requestId") int requestId) {
        adoptionRequestService.approveRequestByAdmin(requestId);
        return "redirect:/admin/dashboard";

    }
    @PostMapping("/decline_request")
    public String declineAdoptionRequest(@RequestParam("requestId") int requestId) {
        adoptionRequestService.deleteRequest(requestId);
        return "redirect:/admin/dashboard";
    }



}