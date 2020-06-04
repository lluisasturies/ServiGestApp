package com.lluis.ServiGest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lluis.ServiGest.pojos.Aparato;
import com.lluis.ServiGest.pojos.Vivienda;
import com.lluis.ServiGest.pojos.ViviendaAparato;
import com.lluis.ServiGest.servicios.ViviendaAparatoService;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/aparatos/vivienda")
public class ViviendaAparatoController {
	
	@Autowired
	ViviendaAparatoService viviendaAparatoService;
	
	// ADD
	@PostMapping("/{idVivienda}/add")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@PathVariable("idVivienda") Integer idVivienda, @RequestBody Aparato aparato) {
		Vivienda vivienda = new Vivienda();
		vivienda.setIdVivienda(idVivienda);
		
		ViviendaAparato viviendaAparato = new ViviendaAparato();
		viviendaAparato.setIdAparato(aparato);
		viviendaAparato.setIdVivienda(vivienda);
			
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
