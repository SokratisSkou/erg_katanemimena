package gr.hua.dit.ds.ergasia.service;

import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.entities.shelter;
import gr.hua.dit.ds.ergasia.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShelterService {
    private final ShelterRepository shelterRepository;
    private final petRepository petRepository;

    public ShelterService(ShelterRepository shelterRepository, petRepository petRepository) {
        this.shelterRepository = shelterRepository;
        this.petRepository = petRepository;
    }

    public shelter submitShelter(shelter shelter) {
        shelter.setAprovalStatus("Pending");
        return shelterRepository.save(shelter);
    }
    public List<shelter> getPendingShelters() {
        return shelterRepository.findByAprovalStatus("Pending");
    }
    public void approveShelter(Integer shelterId) {
        shelter shelter = shelterRepository.findById(shelterId).orElseThrow(() -> new RuntimeException("Shelter not found"));
        shelter.setAprovalStatus("Approved");
        shelterRepository.save(shelter);
    }

    public void addPetToShelter(Integer shelterId, pet pet) {
        Optional<shelter> shelter = shelterRepository.findById(shelterId);
        if (shelter.isPresent()) {
            pet.setShelter(shelter.get());
            petRepository.save(pet);
        } else {
            throw new RuntimeException("Shelter not found");
        }
    }

    public List<shelter> getAllShelters() {
        return shelterRepository.findAll();
    }
    public List<shelter> getSheltersByApprovalStatus(String status) {
        return shelterRepository.findByAprovalStatus(status);
    }
    public void deleteShelter(Integer shelterId) {
        shelterRepository.deleteById(shelterId);
    }
    public void updateShelterApprovalStatus(Integer shelterId, String status) {
        shelter shelter= shelterRepository.findById(shelterId).orElseThrow(() -> new RuntimeException("Shelter not found"));
        shelter.setAprovalStatus(status);
        shelterRepository.save(shelter);
    }
    public String getCurrentShelter() {
        return shelterRepository.toString();
    }
}