package com.lluis.ServiGest.servicios;

import java.util.List;

import com.lluis.ServiGest.pojos.Cliente;
import com.lluis.ServiGest.pojos.ClienteContacto;

public interface ClienteService {
	
	// LIST de Clientes
	public List<Cliente> listaClientes();
	
	// Contactos de un Cliente
	public List<ClienteContacto> verContactosCliente(Integer idCliente);
		
	// READ
	public Cliente verCliente(Integer idCliente);
		
	// CREATE
	public void add(Cliente cliente);
		
	// UPDATE
	public void update(Cliente cliente);
		
	// DELETE
	public void delete(Integer idCliente);

}
