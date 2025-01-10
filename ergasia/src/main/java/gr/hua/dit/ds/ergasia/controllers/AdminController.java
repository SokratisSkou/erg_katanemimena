package gr.hua.dit.ds.ergasia.controllers;
import gr.hua.dit.ds.ergasia.entities.Admin;
import gr.hua.dit.ds.ergasia.repository.AdminRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("Admin")
public class AdminController {

    AdminRepository adminRepository;
    public AdminController(AdminRepository adminRepository) { this.adminRepository = adminRepository; }

    @GetMapping("/new")
    public String saveAdmin(Model model) {

    }

}
