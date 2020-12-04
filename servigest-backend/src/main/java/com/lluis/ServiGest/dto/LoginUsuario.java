package com.lluis.ServiGest.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUsuario {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
    
}
