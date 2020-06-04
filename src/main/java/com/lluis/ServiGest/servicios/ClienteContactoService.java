package com.lluis.ServiGest.servicios;

import com.lluis.ServiGest.pojos.ClienteContacto;

public interface ClienteContactoService {

	// CREATE
	public void add(ClienteContacto contactoCliente);
	
	// DELETE
	public void delete(Integer id);
}
