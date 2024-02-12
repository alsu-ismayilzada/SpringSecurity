package com.example.basicauth.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER") ;

    private String value;

    Role (String value){
        this.value=value;
    }

    public String getValue(){
        return this.value;
    }
    @Override
    public String getAuthority() {
        return name();
    }
}
