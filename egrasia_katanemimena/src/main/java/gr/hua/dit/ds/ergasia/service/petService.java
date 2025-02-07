package gr.hua.dit.ds.ergasia.service;
import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.entities.shelter;
import gr.hua.dit.ds.ergasia.entities.vet;
import gr.hua.dit.ds.ergasia.repository.petRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class petService {
    private final petRepository petRepository;


    public petService(petRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<pet> getAllPets() {
        return petRepository.findAll();
    }

    public pet addPet(pet pet) {
        return petRepository.save(pet);
    }
    public List<pet> getPetsByApprovalStatus(String status) {
        return petRepository.findByApprovalStatus(status);
    }
    public void deletePet(Integer petId) {
        petRepository.deleteById(petId);
    }
    public void updatePetApprovalStatus(Integer petId, String status) {
        pet pet = petRepository.findById(petId).orElseThrow(() -> new RuntimeException("Pet not found"));
        pet.setApprovalStatus(status);
        petRepository.save(pet);
    }
    public void addPetPendingApproval(pet pet) {
        pet.setHealthStatus("Pending");
        pet.setApprovalStatus("Pending");
        petRepository.save(pet);
    }

    public List<pet> getApprovedPets() {
        return petRepository.findByHealthStatusAndApprovalStatus("Approved","Approved");
    }
    public List<pet> getPendingForHealthStatusPets() {return petRepository.findByHealthStatus("Pending");}
    public void updateHealthStatus(Integer petId,vet current_vet) {
        pet pet = petRepository.findById(petId).orElseThrow(() -> new RuntimeException("Pet not found"));
        pet.setHealthStatus("Approved");
        pet.setVet(current_vet);
        petRepository.save(pet);
    }
    @Transactional
    public void save(pet pet) {
        petRepository.save(pet);
    }
    public void deletePetById(Integer petId) {
        petRepository.deleteById(petId);
    }
    public List<pet> getPendingForApprovalStatusPets() {return petRepository.findByApprovalStatus("Pending");}
    public pet findById(int petId) {
        Optional<pet> petOptional = petRepository.findById(petId); // Use the repository method
        return petOptional.orElse(null); // Return the pet if found, or null if not found
    }

}