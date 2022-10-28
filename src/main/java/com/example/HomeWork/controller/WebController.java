package com.example.HomeWork.controller;

import com.example.HomeWork.form.RegistrationRequest;
import com.example.HomeWork.service.AppUserService;
import com.example.HomeWork.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@AllArgsConstructor
public class WebController {

    private final AppUserService appUserService;
    private final RegistrationService registrationService;

    private final MessageSource messageSource;

    @GetMapping("/")
    public String GetHomePage(){
        return "index";
    }

    @GetMapping("/registration")
    public String GetRegistrationPage(RegistrationRequest request,Model model){
        model.addAttribute("request",request);
        return "registration";
    }

    @GetMapping("/login")
    public String GetLoginPage(){
        return "login";
    }


    @PostMapping("/registration")
    public String regis(@Valid @ModelAttribute("request") RegistrationRequest request, BindingResult result, Model model ){
        model.addAttribute("request", request);

        if (result.hasErrors()) {
            return "/registration";
        }

        if(appUserService.emailAddressExists(request.getEmail())==false) {

            System.out.println(messageSource.getMessage("api.error.user.already.registered", null, Locale.ENGLISH));
            result.addError(new ObjectError("emailAddress", messageSource.getMessage("api.error.user.already.registered", null, Locale.ENGLISH)));
            return "/registration";
        }
        System.out.println(messageSource.getMessage("api.response.user.creation.successful", null, Locale.ENGLISH));
        return registrationService.register(request);
    }

    @GetMapping("/success")
    public String getSuccessPage(){


        return "success";

    }
}
