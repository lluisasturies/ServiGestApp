package com.lluis.ServiGest.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePasswordDTO {
	
	@NotBlank
	@Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String oldPassword;
    
}
