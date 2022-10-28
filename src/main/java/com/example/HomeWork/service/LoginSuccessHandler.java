package com.example.HomeWork.service;

import com.example.HomeWork.model.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        AppUser appUser = (AppUser) authentication.getPrincipal();

        String redirectURL = request.getContextPath();


        if (appUser.hasRole(String.valueOf(appUser.getAppUserRole())) == 1) {
            redirectURL = "user/home";
        } else {
            redirectURL = "admin/home";
        }

        response.sendRedirect(redirectURL);

    }

}

