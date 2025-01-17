package gr.hua.dit.ds.ergasia.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        switch (role) {
            case "ROLE_ADMIN":
                response.sendRedirect("/admin/home");
                break;
            case "ROLE_VET":
                response.sendRedirect("/vet/home");
                break;
            case "ROLE_SHELTER":
                response.sendRedirect("/shelter/home");
                break;
            case "ROLE_CITIZEN":
                response.sendRedirect("/citizen/home");
                break;
            default:
                response.sendRedirect("/home");
        }
    }
}
