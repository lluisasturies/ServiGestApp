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

import com.lluis.ServiGest.pojos.Cliente;
import com.lluis.ServiGest.servicios.ClienteService;

@RestController
@CrossOrigin
@RequestMapping("api/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	// LISTA de Clientes
	@GetMapping
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public List<Cliente> listaClientes(){
		return clienteService.listaClientes();
	}
	
	// UN Cliente
	@GetMapping("/{idCliente}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public Cliente verCliente(@PathVariable("idCliente") Integer idCliente) {
		return clienteService.verCliente(idCliente);
	}
		
	// ADD
	@PostMapping("/add")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@Valid @RequestBody Cliente cliente, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos erroneos");
    	}
		
		clienteService.add(cliente);
	}
	
	// UPDATE
	@PutMapping("/update")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void update(@Valid @RequestBody Cliente cliente, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos erroneos");
    	}
		
		clienteService.update(cliente);
	}
		
	// DELETE
	@DeleteMapping("/delete/{idCliente}")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idCliente") Integer idCliente) {
		clienteService.delete(idCliente);
	}
	
}
