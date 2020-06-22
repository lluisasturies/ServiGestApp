package com.lluis.ServiGest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lluis.ServiGest.pojos.ViviendaCita;
import com.lluis.ServiGest.servicios.ViviendaCitaService;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/ordenes/citas")
public class ViviendaCitaController {
	
	@Autowired
	ViviendaCitaService viviendaCitaService;
	
	// ADD
	@PostMapping("/add")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@Valid @RequestBody ViviendaCita viviendaCita) {
		viviendaCitaService.add(viviendaCita);
	}
	
	// UPDATE
	@PutMapping("/update")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void update(@Valid @RequestBody ViviendaCita viviendaCita) {
		viviendaCitaService.update(viviendaCita);
	}
	
	// DELETE
	@DeleteMapping("/delete/{idCita}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idCita") Integer idCita) {
		viviendaCitaService.delete(idCita);
	}

}
