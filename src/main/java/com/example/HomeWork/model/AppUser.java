package com.example.HomeWork.model;

import com.example.HomeWork.model.constant.AppUserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails {

    @Id
    private String email;

    private String firstName;

    private String lastName;

    private String age;

    private String password;
    @Enumerated(EnumType.STRING)

    private AppUserRole appUserRole;

    private Boolean locked = false;
    private Boolean enabled = false;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer hasRole(String roleName) {
        AppUserRole UserLogin = AppUserRole.USER;
        AppUserRole ManagerLogin = AppUserRole.MANAGER;



        if (UserLogin.toString() == roleName) {
            return 1;
        } else {
            return 2;
        }

    }

    public AppUser(String email, String firstName, String lastName, String age, String password, AppUserRole appUserRole) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.appUserRole = appUserRole;
    }

    public AppUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
