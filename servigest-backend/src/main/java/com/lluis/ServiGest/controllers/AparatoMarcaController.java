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

import com.lluis.ServiGest.pojos.AparatoMarca;
import com.lluis.ServiGest.servicios.AparatoMarcaService;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;

@RestController
@CrossOrigin
@RequestMapping("api/aparatos/marcas")
public class AparatoMarcaController {
	
	@Autowired
	AparatoMarcaService aparatoMarcaService;
	
	// Obtener LISTA de Marcas
	@GetMapping
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public List<AparatoMarca> listaMarcasAparatos(){
		return aparatoMarcaService.listaMarcasAparatos();
	}
	
	// Obtener UNA Marca
	@GetMapping("/{idMarca}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public AparatoMarca verAparato(@PathVariable("idMarca") Integer idMarca) {
		return aparatoMarcaService.verMarcaAparato(idMarca);
	}
	
	// ADD
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@Valid @RequestBody AparatoMarca aparatoMarca, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos erroneos");
    	}
		
		aparatoMarcaService.add(aparatoMarca);
	}
	
	// UPDATE
	@PutMapping("/update")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void update(@Valid @RequestBody AparatoMarca aparatoMarca, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos erroneos");
    	}
		
		aparatoMarcaService.update(aparatoMarca);
	}
	
	// DELETE
	@DeleteMapping("/delete/{idMarca}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idMarca") Integer idMarca) {
		aparatoMarcaService.delete(idMarca);
	}

}
