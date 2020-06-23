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

import com.lluis.ServiGest.pojos.Vivienda;
import com.lluis.ServiGest.servicios.ViviendaService;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/viviendas")
public class ViviendaController {
	
	@Autowired
	ViviendaService viviendaService;
	
	// Obtener LISTA de Viviendas
	@GetMapping
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public List<Vivienda> listaViviendas() {
		return viviendaService.listaViviendas();
	}
	
	// Obtener UNA Vivienda
	@GetMapping("/{idVivienda}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public Vivienda verVivienda(@PathVariable("idVivienda") Integer idVivienda) {
		return viviendaService.verVivienda(idVivienda);
	}
	
	// ADD
	@PostMapping("/add")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@Valid @RequestBody Vivienda vivienda, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos vacíos o datos erroneos");
    	}
		
		viviendaService.add(vivienda);
	}
	
	// UPDATE
	@PutMapping("/update")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void update(@Valid @RequestBody Vivienda vivienda, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos vacíos o datos erroneos");
    	}
		
		viviendaService.update(vivienda);
	}
	
	// DELETE
	@DeleteMapping("/delete/{idVivienda}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idVivienda") Integer idVivienda) {
		viviendaService.delete(idVivienda);
	}

}
