package com.lluis.ServiGest.servicios;

import com.lluis.ServiGest.pojos.ClienteContacto;

public interface ClienteContactoService {

	// CREATE
	public void add(ClienteContacto clienteContacto);
	
	// UPDATE
	public void update(ClienteContacto clienteContacto);
	
	// DELETE
	public void delete(Integer idContacto);
}
