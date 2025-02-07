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



@Service
public class UserService  {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void saveUser(user user) {
        String passwd= user.getPassword();
        String encodedPassword = passwordEncoder.encode(passwd);
        user.setPassword(encodedPassword);

        Role role = roleRepository.findByName(user.getRoleName())
                .orElseThrow(() -> new RuntimeException("Error: Role not found"));
        user.setRole(role);
        userRepository.save(user);
    }


    @Transactional
    public Integer updateUser(user user) {
        return userRepository.save(user).getId();
    }




    @Transactional
    public Object getUsers() {
        return userRepository.findAll();
    }

    public  Object getUser(int userId) {
        return userRepository.findById(userId);
    }

    @Transactional
    public void updateOrInsertRole(Role role) {
        roleRepository.save(role);
    }

    @Transactional
    public user registerUser(user user) {
        // Encode the password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Fetch the Role from the database using the roleRepository
        Role role = roleRepository.findByName(user.getRoleName())
                .orElseThrow(() -> new RuntimeException("Error: Role not found"));
        user.setRole(role);

        return userRepository.save(user);
    }
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

}
