package com.lluis.ServiGest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lluis.ServiGest.servicios.RolService;
import com.lluis.ServiGest.pojos.Rol;

@RestController
@CrossOrigin
@RequestMapping("api/usuarios/roles")
public class RolController {
	
	@Autowired
	RolService rolService;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	// Lista de Roles
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public List<Rol> listaRoles() {
		return rolService.listaRoles();
	}

}
