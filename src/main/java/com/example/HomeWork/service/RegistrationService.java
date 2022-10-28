package com.example.HomeWork.service;

import com.example.HomeWork.form.RegistrationRequest;
import com.example.HomeWork.model.AppUser;
import com.example.HomeWork.model.constant.AppUserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;

    public String register(RegistrationRequest request) {
        return appUserService.signUpUser(
                new AppUser(
                        request.getEmail(),
                        request.getFirstName(),
                        request.getLastName(),
                        request.getAge(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );

    }
}
