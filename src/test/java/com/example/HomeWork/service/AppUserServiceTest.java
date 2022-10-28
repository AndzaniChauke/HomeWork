package com.example.HomeWork.service;

import com.example.HomeWork.model.AppUser;
import com.example.HomeWork.model.constant.AppUserRole;
import com.example.HomeWork.repository.AppUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AppUserServiceTest {
    @Mock
    private AppUserRepository appUserRepository;
    @Mock
    private  BCryptPasswordEncoder bCryptPasswordEncoder;



    private AppUserService underTest;

    @BeforeEach
    void setUp() {
        underTest=new AppUserService(appUserRepository,bCryptPasswordEncoder);
    }

    @Test
    void loadUserByUsername() {



    }


    @Test
    void emailAddressExists() {
        //given
        String email="dummy@gmail.com";
        AppUser appUser=new AppUser(
                email,
                "Andrew",
                "Smith",
                "20",
                "password",
                AppUserRole.USER
        );

        //when
        underTest.signUpUser(appUser);

        //then
        boolean check=underTest.emailAddressExists(email);
        assertThat(check).isTrue();

    }

    @Test
    void signUpUser() {
    //given
        String email="dummy@gmail.com";
        AppUser appUser=new AppUser(
                email,
                "Andrew",
                "Smith",
                "20",
                "password",
                AppUserRole.USER
        );

        //when
        underTest.signUpUser(appUser);

        //then
        ArgumentCaptor<AppUser> appUserArgumentCaptor =
                ArgumentCaptor.forClass(AppUser.class);

        verify(appUserRepository).save(appUserArgumentCaptor.capture());

        AppUser capturedStudent = appUserArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(appUser);
    }
}