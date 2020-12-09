package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lluis.ServiGest.error.ClienteNotFoundException;
import com.lluis.ServiGest.pojos.Cliente;
import com.lluis.ServiGest.repositorios.ClienteContactoDAO;
import com.lluis.ServiGest.repositorios.ClienteDAO;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteDAO clienteDAO;
	
	@Autowired
	ClienteContactoDAO clienteContactoDAO;

	@Override
	public List<Cliente> listaClientes() {
		return (List<Cliente>) clienteDAO.findAll();
	}

	@Override
	public Cliente verCliente(Integer idCliente) {
		return clienteDAO.findById(idCliente).orElseThrow(() -> new ClienteNotFoundException());
	}

	@Override
	public void add(Cliente cliente) {
		cliente.setNombre(cliente.getNombre().toUpperCase());
		cliente.setApellidos(cliente.getApellidos());
		cliente.setDni(cliente.getDni().toUpperCase());
		
		clienteDAO.save(cliente);
	}

	@Override
	public void update(Cliente cliente) {
		if (clienteDAO.existsById(cliente.getIdCliente())) {
			cliente.setNombre(cliente.getNombre().toUpperCase());
			cliente.setApellidos(cliente.getApellidos());
			cliente.setDni(cliente.getDni().toUpperCase());
			
			clienteDAO.save(cliente);
		}
	}

	@Override
	public void delete(Integer idCliente) {
		if (clienteDAO.existsById(idCliente)) {
			Cliente cliente = clienteDAO.findById(idCliente).get();
			
			clienteDAO.delete(cliente);
		}
	}
	
}
