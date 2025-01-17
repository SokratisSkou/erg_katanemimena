package gr.hua.dit.ds.ergasia.service;

import gr.hua.dit.ds.ergasia.entities.Citizen;
import gr.hua.dit.ds.ergasia.repository.CitizenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CitizenService {
    private CitizenRepository citizenRepository;
    public CitizenService(CitizenRepository citizenRepository) {this.citizenRepository = citizenRepository;}


}
