package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.error.ClienteNotFoundException;
import com.lluis.ServiGest.pojos.Cliente;
import com.lluis.ServiGest.repositorios.ClienteDAO;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteDAO clienteDAO;

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
		if (!clienteDAO.existsByDni(cliente.getDni())) {
			cliente.setNombre(cliente.getNombre().toUpperCase());
			cliente.setApellidos(cliente.getApellidos().toUpperCase());
			cliente.setDni(cliente.getDni().toUpperCase());
			
			clienteDAO.save(cliente);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este DNI ya existe");
	}

	@Override
	public void update(Cliente cliente) {
		if (clienteDAO.existsById(cliente.getIdCliente())) {
			if (!clienteDAO.existsByDni(cliente.getDni())) {
				cliente.setNombre(cliente.getNombre().toUpperCase());
				cliente.setApellidos(cliente.getApellidos().toUpperCase());
				cliente.setDni(cliente.getDni().toUpperCase());
				
				clienteDAO.save(cliente);
			} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este DNI ya existe");
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El cliente no existe");
	}

	@Override
	public void delete(Integer idCliente) {
		if (clienteDAO.existsById(idCliente)) {
			Cliente cliente = clienteDAO.findById(idCliente).get();
			
			clienteDAO.delete(cliente);
		}
	}
	
}
