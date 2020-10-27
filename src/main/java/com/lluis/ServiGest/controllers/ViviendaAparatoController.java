package com.lluis.ServiGest.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.pojos.ViviendaAparato;
import com.lluis.ServiGest.servicios.ViviendaAparatoService;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;

@RestController
@CrossOrigin
@RequestMapping("api/vivienda/aparato")
public class ViviendaAparatoController {
	
	@Autowired
	ViviendaAparatoService viviendaAparatoService;
	
	// ADD
	@PostMapping("/add")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@Valid @RequestBody ViviendaAparato viviendaAparato, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos vacíos o datos erroneos");
//    	}
		
		viviendaAparatoService.add(viviendaAparato);	
	}
	
	// DELETE
	@DeleteMapping("/delete/{idViviendaAparato}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idViviendaAparato") Integer idViviendaAparato) {
		viviendaAparatoService.delete(idViviendaAparato);
	}

}
