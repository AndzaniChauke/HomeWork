package com.example.HomeWork.controller;


import com.example.HomeWork.model.constant.AppUserRole;
import com.example.HomeWork.repository.AppUserRepository;
import com.example.HomeWork.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {
    private final AppUserRepository appUserRepository;
    @GetMapping("/home")
    public String GetUserHomePage(Model model){


        String output1 = getLoggedUser().getFirstName().substring(0, 1).toUpperCase() + getLoggedUser().getFirstName().substring(1).toLowerCase();


        String output2 = getLoggedUser().getLastName().substring(0, 1).toUpperCase() + getLoggedUser().getLastName().substring(1).toLowerCase();
        model.addAttribute("userProfile", getLoggedUser());


        model.addAttribute("firstname", output1);
        model.addAttribute("lastname", output2);
        model.addAttribute("driver", getLoggedUser());
        model.addAttribute("employees", appUserRepository.findUserRoles(AppUserRole.USER));
        return"admin/home";
    }
}
