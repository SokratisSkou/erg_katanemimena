package gr.hua.dit.ds.ergasia.service;

import gr.hua.dit.ds.ergasia.entities.Admin;
import gr.hua.dit.ds.ergasia.entities.Role;
import gr.hua.dit.ds.ergasia.entities.user;
import gr.hua.dit.ds.ergasia.entities.vet;
import gr.hua.dit.ds.ergasia.repository.RoleRepository;
import gr.hua.dit.ds.ergasia.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {


    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Integer saveUser(user user) {
        String passwd= user.getPassword();
        String encodedPassword = passwordEncoder.encode(passwd);
        user.setPassword(encodedPassword);

        Role role = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Role roles= new Role();
        user.setRole(roles.getName());

        user = userRepository.save(user);
        return user.getId();
    }

    @Transactional
    public Integer updateUser(user user) {
        user = userRepository.save(user);
        return user.getId();
    }

    @Transactional
    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole())// Remove "ROLE_" prefix for Spring Security
                .build();
    }

    @Transactional
    public Object getUsers() {
        return userRepository.findAll();
    }

    public Object getUser(int userId) {
        return userRepository.findById(userId);
    }

    @Transactional
    public void updateOrInsertRole(Role role) {
        roleRepository.updateOrInsert(role);
    }

    public user registerUser(String email, String password, String name, String role) {
        if (!isValidRole(role)) {
            throw new IllegalArgumentException("Invalid role: " + role);
        }

        user user = new user();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        user.setRole(role);

        return userRepository.save(user);
    }

    private boolean isValidRole(String role) {
        return role.equals("ROLE_ADMIN") || role.equals("ROLE_VET") ||
                role.equals("ROLE_SHELTER") || role.equals("ROLE_CITIZEN");
    }
}