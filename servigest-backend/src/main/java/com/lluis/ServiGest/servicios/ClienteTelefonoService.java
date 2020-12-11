package com.lluis.ServiGest.servicios;

import com.lluis.ServiGest.pojos.ClienteTelefono;

public interface ClienteTelefonoService {

	// CREATE
	public void add(ClienteTelefono clienteTelefono);
	
	// UPDATE
	public void update(ClienteTelefono clienteTelefono);
	
	// DELETE
	public void delete(Integer idTelefono);
}
