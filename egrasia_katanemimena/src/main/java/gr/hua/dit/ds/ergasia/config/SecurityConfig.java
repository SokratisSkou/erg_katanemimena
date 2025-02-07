package gr.hua.dit.ds.ergasia.config;

import gr.hua.dit.ds.ergasia.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig  {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/home", "/login", "/register", "/saveUser", "/images/**", "/js/**", "/css/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/vet/**").hasRole("VET")
                        .requestMatchers("/shelter/**").hasRole("SHELTER")
                        .requestMatchers("/citizen/**").hasRole("CITIZEN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler(new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException, IOException {
                                // Custom logic when login is successful
                                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                                String username = userDetails.getUsername();

                                // Print the username of the logged-in user (for debugging or logging purposes)
                                System.out.println("The user " + username + " has logged in.");

                                // Role-based redirection logic
                                String roleName = authentication.getAuthorities().iterator().next().getAuthority();
                                System.out.println("The role " + roleName + " has logged in.");
                                switch (roleName) {
                                    case "ROLE_ADMIN":

                                        response.sendRedirect("/admin/dashboard");
                                        break;
                                    case "ROLE_VET":
                                        response.sendRedirect("/vet/dashboard");
                                        break;
                                    case "ROLE_SHELTER":
                                        response.sendRedirect("/shelter/dashboard");
                                        break;
                                    case "ROLE_CITIZEN":
                                        response.sendRedirect("/citizen/dashboard");
                                        break;
                                    default:
                                        response.sendRedirect("/index");
                                }
                            }
                        })
                        .failureHandler(new AuthenticationFailureHandler() {
                            @Override
                            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                                // Handle login failure
                                response.sendRedirect("/login?error=true"); // Or another failure handling mechanism
                            }
                        })
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Logout URL
                        .logoutSuccessUrl("/login?logout=true") // Redirect after logout
                        .invalidateHttpSession(true) // Invalidate the session
                        .deleteCookies("JSESSIONID") // Delete the session cookie
                        .permitAll() // Allow all users to access the logout
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        return authManagerBuilder.build();
    }
}

