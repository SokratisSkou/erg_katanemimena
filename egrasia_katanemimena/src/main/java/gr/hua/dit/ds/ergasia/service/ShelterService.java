package gr.hua.dit.ds.ergasia.service;

import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.entities.shelter;
import gr.hua.dit.ds.ergasia.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShelterService {
    private final ShelterRepository shelterRepository;
    private final petRepository petRepository;

    @Autowired
    public ShelterService(ShelterRepository shelterRepository, petRepository petRepository) {
        this.shelterRepository = shelterRepository;
        this.petRepository = petRepository;
    }

    public shelter submitShelter(shelter shelter) {
        shelter.setApprovalStatus("Pending");
        return shelterRepository.save(shelter);
    }
    public List<shelter> getPendingShelters() {
        return shelterRepository.findByApprovalStatus("Pending");
    }
    public void approveShelter(Integer shelterId) {
        shelter shelter = shelterRepository.findById(shelterId).orElseThrow(() -> new RuntimeException("Shelter not found"));
        shelter.setApprovalStatus("Approved");
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
    @Transactional
    public void save(shelter shelter) {
        shelterRepository.save(shelter); // Save the shelter entity
    }
    public Optional<shelter> findByName(String name) {
        return shelterRepository.findByName(name);
    }


    public List<shelter> getAllShelters() {
        return shelterRepository.findAll();
    }
    public List<shelter> getSheltersByApprovalStatus(String status) {
        return shelterRepository.findByApprovalStatus(status);
    }
    public void deleteShelter(Integer shelterId) {
        shelterRepository.deleteById(shelterId);
    }
    public void updateShelterApprovalStatus(Integer shelterId, String status) {
        shelter shelter= shelterRepository.findById(shelterId).orElseThrow(() -> new RuntimeException("Shelter not found"));
        shelter.setApprovalStatus(status);
        shelterRepository.save(shelter);
    }
    public String getCurrentShelter() {
        return shelterRepository.toString();
    }

    public shelter findById(Integer shelterId) {
        Optional<shelter> shelterOptional = shelterRepository.findById(shelterId);
        if (shelterOptional.isPresent()) {
            return shelterOptional.get();
        } else {
            // Handle the case where the shelter is not found
            return null; // or throw an exception
        }
    }
}