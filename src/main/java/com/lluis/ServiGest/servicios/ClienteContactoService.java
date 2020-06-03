package com.lluis.ServiGest.servicios;

import java.util.List;

import com.lluis.ServiGest.pojos.ClienteContacto;

public interface ClienteContactoService {

	// Aparatos de una Vivienda
	public List<ClienteContacto> verContactosCliente(Integer idCliente);
	
	// CREATE
	public void add(ClienteContacto contactoCliente);
	
	// DELETE
	public void delete(Integer id);
}
