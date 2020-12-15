package com.lluis.ServiGest.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.lluis.ServiGest.pojos.Rol;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUsuarioDTO {
	
	@NotNull
	private Long id;
	
	@NotNull
    private String nombre;
	
	@NotBlank
	@Email
    private String email;

    @NotNull
    private Rol rol;
    
}
