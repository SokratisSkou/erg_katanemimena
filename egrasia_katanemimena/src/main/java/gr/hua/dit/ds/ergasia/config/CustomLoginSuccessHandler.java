package gr.hua.dit.ds.ergasia.config;

import gr.hua.dit.ds.ergasia.entities.Role;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // Determine the user's role and redirect to the appropriate dashboard
        String roleName = authentication.getAuthorities().iterator().next().getAuthority();
        System.out.println("User Role: " + roleName);

        switch (roleName) {
            case "ADMIN":
                response.sendRedirect("/admin/dashboard");
                break;
            case "VET":
                response.sendRedirect("/vet/dashboard");
                break;
            case "SHELTER":
                response.sendRedirect("/shelter/dashboard");
                break;
            case "CITIZEN":
                response.sendRedirect("/citizen/dashboard");
                break;
            default:
                response.sendRedirect("/index");
        }
    }
}

