package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lluis.ServiGest.pojos.ClienteContacto;
import com.lluis.ServiGest.repositorios.ClienteContactoDAO;

@Service
public class ClienteContactoServiceImpl implements ClienteContactoService  {
	
	@Autowired
	ClienteContactoDAO clienteContactoDAO;
	
	@Override
	public void add(ClienteContacto clienteContacto) {
		clienteContactoDAO.save(clienteContacto);
	}
	
	@Override
	public void update(ClienteContacto clienteContacto) {
		if (clienteContactoDAO.existsById(clienteContacto.getIdContacto())) {
			clienteContactoDAO.save(clienteContacto);
		}
	}

	@Override
	public void delete(Integer idContacto) {
		if (clienteContactoDAO.existsById(idContacto)) {
			ClienteContacto clienteContacto = clienteContactoDAO.findById(idContacto).get();
			clienteContactoDAO.delete(clienteContacto);
		}
	}

}
