package gr.hua.dit.ds.ergasia.service;

import gr.hua.dit.ds.ergasia.entities.user;
import gr.hua.dit.ds.ergasia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find the user by email (username)
        user user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Ensure the role is prefixed with "ROLE_" for Spring Security
        String roleName =user.getRole().getName();  // Assuming `getRole().getName()` gives something like "ADMIN"


        // Return the user details for Spring Security
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(roleName)  // Ensure the role is properly prefixed with "ROLE_"
                .build();
    }
}