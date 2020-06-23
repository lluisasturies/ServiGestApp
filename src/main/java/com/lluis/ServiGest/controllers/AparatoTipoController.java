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

import com.lluis.ServiGest.pojos.AparatoTipo;
import com.lluis.ServiGest.servicios.AparatoTipoService;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/aparatos/tipos")
public class AparatoTipoController {
	
	@Autowired
	AparatoTipoService aparatoTipoService;
	
	// Obtener LISTA de Tipos
	@GetMapping
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public List<AparatoTipo> listaMarcasAparatos(){
		return aparatoTipoService.listaTiposAparatos();
	}
	
	// Obtener UN Tipo
	@GetMapping("/{idTipo}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public AparatoTipo verAparato(@PathVariable("idTipo") Integer idTipo) {
		return aparatoTipoService.verTipoAparato(idTipo);
	}
	
	// ADD
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@Valid @RequestBody AparatoTipo aparatoMarca, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos erroneos");
    	}
		
		aparatoTipoService.add(aparatoMarca);
	}
	
	// UPDATE
	@PutMapping("/update")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void update(@Valid @RequestBody AparatoTipo aparatoTipo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos erroneos");
    	}
		
		aparatoTipoService.update(aparatoTipo);
	}
	
	// DELETE
	@DeleteMapping("/delete/{idTipo}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idTipo") Integer idTipo) {
		aparatoTipoService.delete(idTipo);
	}

}
