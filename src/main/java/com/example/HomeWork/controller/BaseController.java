package com.example.HomeWork.controller;

import com.example.HomeWork.model.AppUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseController {
    AppUser getLoggedUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = (AppUser) authentication.getPrincipal();;
        return appUser;
    }
}
