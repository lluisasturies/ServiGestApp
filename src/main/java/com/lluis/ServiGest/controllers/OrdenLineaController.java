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

import com.lluis.ServiGest.pojos.OrdenLinea;
import com.lluis.ServiGest.servicios.OrdenLineaService;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/ordenes/linea")
public class OrdenLineaController {
	
	@Autowired
	OrdenLineaService ordenLineaService;
	
	// ADD
	@PostMapping("/add")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody OrdenLinea ordenLinea) {
		ordenLineaService.add(ordenLinea);
	}
	
	// DELETE
	@DeleteMapping("/delete/{idTrabajo}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idTrabajo") Integer idTrabajo) {
		ordenLineaService.delete(idTrabajo);
	}

}
