package gr.hua.dit.ds.ergasia.service;

import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.entities.vet;
import gr.hua.dit.ds.ergasia.repository.CitizenRepository;
import gr.hua.dit.ds.ergasia.repository.VetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VetService {
    private final VetRepository vetRepository;
    @Autowired
    public VetService(VetRepository vetRepository) {this.vetRepository = vetRepository;}
    @Transactional
    public void save(vet vet) {
        vetRepository.save(vet);
    }
    @Transactional
    public vet findByUsername(String username) {
        vet vet = vetRepository.findByName(username);
        if (vet == null) {
            throw new RuntimeException("Vet not found for username: " + username); // Throw an exception if not found
        }
        return vet; // Return the Vet object
    }
}
