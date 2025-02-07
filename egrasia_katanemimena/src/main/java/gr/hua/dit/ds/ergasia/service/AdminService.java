package gr.hua.dit.ds.ergasia.service;
import gr.hua.dit.ds.ergasia.entities.Admin;
import gr.hua.dit.ds.ergasia.repository.AdminRepository;
import gr.hua.dit.ds.ergasia.repository.petRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import gr.hua.dit.ds.ergasia.entities.pet;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    // Constructor injection
    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    private petRepository PetRepository;
    @Transactional
    public void save(Admin admin) {
        adminRepository.save(admin); // Call the save method on the instance of adminRepository
    }



}
