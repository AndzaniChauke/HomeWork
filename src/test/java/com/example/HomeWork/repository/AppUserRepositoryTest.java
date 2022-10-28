package com.example.HomeWork.repository;

import com.example.HomeWork.model.AppUser;
import com.example.HomeWork.model.constant.AppUserRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AppUserRepositoryTest {

    @Autowired
    private  AppUserRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @BeforeEach
    void setUp() {
        underTest.deleteAll();
    }

    @Test
    void findByEmail() {

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
        underTest.save(appUser);

        //when

        Boolean checkExists=underTest.findByEmail(email).isEmpty();

        //then

        assertThat(checkExists).isFalse();

    }

    @Test
    void findUserRoles() {

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
        underTest.save(appUser);

        //when

        Boolean checkExists=underTest.findUserRoles(AppUserRole.USER).isEmpty();

        //then

        assertThat(checkExists).isFalse();
    }
}