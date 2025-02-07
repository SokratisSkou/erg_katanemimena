package gr.hua.dit.ds.ergasia.service;

import gr.hua.dit.ds.ergasia.entities.AdoptionRequest;
import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.repository.AdoptionRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptionRequestService {
    private final AdoptionRequestRepository adoptionRequestRepository;

    public AdoptionRequestService(AdoptionRequestRepository adoptionRequestRepository) {
        this.adoptionRequestRepository = adoptionRequestRepository;
    }

    public List<AdoptionRequest> getPendingRequests() {
        return adoptionRequestRepository.findByStatus("Pending");
    }

    public void approveRequestByShelter(Integer requestId) {
        AdoptionRequest request = adoptionRequestRepository.findById(requestId).orElseThrow(() -> new RuntimeException("Request not found"));
        request.setShelterApprovalStatus("Approved");
        updateFinalStatus(request);
    }

    public void approveRequestByAdmin(Integer requestId) {
        AdoptionRequest request = adoptionRequestRepository.findById(requestId).orElseThrow(() -> new RuntimeException("Request not found"));
        request.setAdminApprovalStatus("Approved");
        updateFinalStatus(request);
    }

    public void updateFinalStatus(AdoptionRequest request) {
        if ("Approved".equals(request.getAdminApprovalStatus()) && "Approved".equals(request.getShelterApprovalStatus())) {
            request.setStatus("Approved");
        }
        adoptionRequestRepository.save(request);
    }

    public void submitRequest(AdoptionRequest request, pet pet, Citizen citizen) {
        request.setCitizen(citizen);
        request.setPet(pet);
        request.setStatus("Pending");
        request.setShelterApprovalStatus("Pending");
        request.setAdminApprovalStatus("Pending");
        request.setShelter(null);
        adoptionRequestRepository.save(request);
    }
    public void deleteRequest(Integer requestId) {
        adoptionRequestRepository.deleteById(requestId);
    }
    public List<AdoptionRequest> getPendingRequestsByShelter() {
        return adoptionRequestRepository.findByShelterApprovalStatus("Pending");

    }
    public List<AdoptionRequest> getPendingRequestsByAdmin() {
        return adoptionRequestRepository.findByShelterApprovalStatus("Pending");

    }


}