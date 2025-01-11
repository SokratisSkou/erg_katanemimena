package gr.hua.dit.ds.ergasia.service;

import gr.hua.dit.ds.ergasia.entities.user;
import gr.hua.dit.ds.ergasia.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<user> getAllUsers() {
        return userRepository.findAll();
    }
}