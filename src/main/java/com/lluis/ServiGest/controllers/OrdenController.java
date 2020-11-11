package com.lluis.ServiGest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
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

import com.lluis.ServiGest.pojos.Orden;
import com.lluis.ServiGest.servicios.OrdenService;

@RestController
@CrossOrigin
@RequestMapping("api/ordenes")
public class OrdenController {
	
	@Autowired
	OrdenService ordenService;
	
	// Obtener LISTA de Ordenes
	@GetMapping
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public List<Orden> listaOrdenes(){
		return ordenService.listaOrdenes();
	}
		
	// Obtener UNA Orden
	@GetMapping("/{idOrden}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public Orden verOrden(@PathVariable Integer idOrden) {	
		return ordenService.verOrden(idOrden);
	}
		
	// ADD
	@PostMapping("/add")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void guardar(@Valid @RequestBody Orden orden, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos erroneos");
    	}
		
		ordenService.add(orden);
	}
	
	// UPDATE
	@PutMapping("/update")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void update(@Valid @RequestBody Orden orden, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos erroneos");
    	}
		
		ordenService.update(orden);
	}
	
	@PutMapping("/{idOrden}/update/estado/{estado}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void updateEstado(@PathVariable("") Integer idOrden, @PathVariable("estado") byte estado) {
		ordenService.cambiarEstado(idOrden, estado);
	}
	
	// DELETE
	@DeleteMapping("/delete/{idOrden}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idOrden") Integer idOrden) {
		ordenService.delete(idOrden);
	}

}
