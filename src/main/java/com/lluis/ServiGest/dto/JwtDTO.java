package com.lluis.ServiGest.dto;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class JwtDTO {
	
    private String token;
    private String bearer = "Bearer";
    private String email;
    private Collection<? extends GrantedAuthority> authorities;
    
    public JwtDTO(String token, String email, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.email = email;
        this.authorities = authorities;
    }
}
