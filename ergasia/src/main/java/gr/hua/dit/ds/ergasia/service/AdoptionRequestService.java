package gr.hua.dit.ds.ergasia.service;

import gr.hua.dit.ds.ergasia.entities.AdoptionRequest;
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

    private void updateFinalStatus(AdoptionRequest request) {
        if ("Approved".equals(request.getAdminApprovalStatus()) && "Approved".equals(request.getShelterApprovalStatus())) {
            request.setStatus("Approved");
        }
        adoptionRequestRepository.save(request);
    }

    public AdoptionRequest submitRequest(AdoptionRequest request) {
        request.setStatus("Pending");
        request.setShelterApprovalStatus("Pending");
        request.setAdminApprovalStatus("Pending");
        return adoptionRequestRepository.save(request);
    }

}