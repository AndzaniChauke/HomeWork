package com.example.HomeWork.service;

import com.example.HomeWork.model.AppUser;
import com.example.HomeWork.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AppUserService implements UserDetailsService {
    private final static String USER_NOT_FOUND="USER WITH EMAIL %S NOT FOUND";

    private  AppUserRepository appUserRepository;

    private  BCryptPasswordEncoder bCryptPasswordEncoder;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository=appUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND,email)));
    }

    public boolean emailAddressExists(String email) {

        boolean userExists=appUserRepository.findByEmail(email).isEmpty();
        return  userExists;
    }

    public String  signUpUser(AppUser appUser){

        String encodedPassword=bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);
        appUserRepository.save(appUser);
        return "success";

    }




}
