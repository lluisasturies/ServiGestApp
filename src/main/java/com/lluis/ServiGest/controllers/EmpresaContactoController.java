package com.lluis.ServiGest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lluis.ServiGest.pojos.EmpresaContacto;
import com.lluis.ServiGest.servicios.EmpresaContactoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/empresas/contacto")
public class EmpresaContactoController {

	@Autowired
	EmpresaContactoService empresaContactoService;
		
	// ADD
	@PostMapping("/add")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody EmpresaContacto empresaContacto) {
		empresaContactoService.add(empresaContacto);
	}
		
	// DELETE
	@DeleteMapping("/delete/{idContacto}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idContacto") Integer idContacto) {
		empresaContactoService.delete(idContacto);
	}
	
}
