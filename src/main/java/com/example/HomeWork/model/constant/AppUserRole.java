package com.example.HomeWork.model.constant;

import org.springframework.security.core.GrantedAuthority;

public enum AppUserRole implements GrantedAuthority {

    USER,
    ADMIN,
    MANAGER,

    DRIVER,

    OWNER;
//Update app_user SET app_user_role='MANAGER' WHERE id=1;


    @Override
    public String getAuthority() {
        return null;
    }

}