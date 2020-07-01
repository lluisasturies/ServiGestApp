package com.lluis.ServiGest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.pojos.Empresa;
import com.lluis.ServiGest.servicios.EmpresaService;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;

@RestController
@CrossOrigin
@RequestMapping("api/empresas")
public class EmpresaController {
	
	@Autowired
	EmpresaService empresaService;
	
	// Obtener LISTA de Empresas
	@GetMapping
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public List<Empresa> listaEmpresas(){
		return empresaService.listaEmpresas();
	}
	
	// Obtener UNA Empresa
	@GetMapping("/{idEmpresa}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public Empresa verEmpresa(@PathVariable("idEmpresa") Integer idEmpresa) {
		return empresaService.verEmpresa(idEmpresa);
	}
	
	// ADD
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@Valid @RequestBody Empresa empresa, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos erroneos");
    	}
		
		empresaService.add(empresa);
	}
	
	// UPDATE
	@PutMapping("/update")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void update(@Valid @RequestBody Empresa empresa, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos erroneos");
    	}
		
		empresaService.update(empresa);
	}
	
	// DELETE
	@DeleteMapping("/delete/{idVivienda}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idEmpresa") Integer idEmpresa) {
		empresaService.delete(idEmpresa);
	}

}
