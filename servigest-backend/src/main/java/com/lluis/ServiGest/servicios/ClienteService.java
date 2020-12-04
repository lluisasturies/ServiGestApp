package com.lluis.ServiGest.servicios;

import java.util.List;

import com.lluis.ServiGest.pojos.Cliente;

public interface ClienteService {
	
	// LIST de Clientes
	public List<Cliente> listaClientes();
		
	// READ
	public Cliente verCliente(Integer idCliente);
		
	// CREATE
	public void add(Cliente cliente);
		
	// UPDATE
	public void update(Cliente cliente);
		
	// DELETE
	public void delete(Integer idCliente);

}
