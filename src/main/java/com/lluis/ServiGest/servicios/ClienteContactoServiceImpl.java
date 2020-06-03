package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lluis.ServiGest.pojos.ClienteContacto;
import com.lluis.ServiGest.repositorios.ClienteContactoDAO;

@Service
public class ClienteContactoServiceImpl implements ClienteContactoService  {
	
	@Autowired
	ClienteContactoDAO clienteContactoDAO;
	
	@Override
	public List<ClienteContacto> verContactosCliente(Integer idCliente) {
		return (List<ClienteContacto>) clienteContactoDAO.contactosPorCliente(idCliente);
	}
	
	@Override
	public void add(ClienteContacto contactoCliente) {
		clienteContactoDAO.save(contactoCliente);
	}

	@Override
	public void delete(Integer id) {
		if (clienteContactoDAO.existsById(id)) {
			ClienteContacto clienteContacto = clienteContactoDAO.findById(id).get();
			
			clienteContactoDAO.delete(clienteContacto);
		}
		
	}

}
