package com.lluis.ServiGest.servicios;

import com.lluis.ServiGest.pojos.ClienteEmail;

public interface ClienteEmailService {

	// CREATE
	public void add(ClienteEmail clienteEmail);
	
	// UPDATE
	public void update(ClienteEmail clienteEmail);
	
	// DELETE
	public void delete(Integer idEmail);
}
