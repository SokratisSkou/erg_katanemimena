package gr.hua.dit.ds.ergasia.service;
import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.repository.petRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class petService {
    private petRepository petRepository;
    public petService(petRepository petRepository) {this.petRepository = petRepository;}

    @Transactional
    public List<pet> getPets() {return petRepository.findAll();}


}
