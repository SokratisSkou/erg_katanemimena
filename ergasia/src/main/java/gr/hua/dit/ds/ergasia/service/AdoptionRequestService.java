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

    public List<AdoptionRequest> getAllRequests() {
        return adoptionRequestRepository.findAll();
    }

    public AdoptionRequest submitRequest(AdoptionRequest request) {
        return adoptionRequestRepository.save(request);
    }
}