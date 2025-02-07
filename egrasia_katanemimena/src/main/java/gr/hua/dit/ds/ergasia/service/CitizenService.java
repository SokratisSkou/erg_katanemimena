package gr.hua.dit.ds.ergasia.service;

import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.entities.shelter;
import gr.hua.dit.ds.ergasia.repository.CitizenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {
    private final CitizenRepository citizenRepository;
    @Autowired
    public CitizenService(CitizenRepository citizenRepository) {this.citizenRepository = citizenRepository;}
    @Transactional
    public void save(Citizen citizen) {
        citizenRepository.save(citizen); // Save the shelter entity
    }
    public Citizen findById(Integer citizenId) {
        Optional<Citizen> CitizenOptional = citizenRepository.findById(citizenId);
        if (CitizenOptional.isPresent()) {
            return CitizenOptional.get();
        } else {

            return null; // or throw an exception
        }
    }


}
