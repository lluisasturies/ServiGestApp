package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.pojos.ClienteEmail;
import com.lluis.ServiGest.repositorios.ClienteEmailDAO;

@Service
public class ClienteEmailServiceImpl implements ClienteEmailService  {
	
	@Autowired
	ClienteEmailDAO clienteEmailDAO;
	
	@Override
	public void add(ClienteEmail clienteEmail) {
		if (!clienteEmailDAO.existsByEmail(clienteEmail.getEmail())) {
			clienteEmailDAO.save(clienteEmail);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este email ya existe");
		
	}
	
	@Override
	public void update(ClienteEmail clienteEmail) {
		if (!clienteEmailDAO.existsByEmail(clienteEmail.getEmail())) {
			clienteEmailDAO.save(clienteEmail);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este email ya existe");
	}

	@Override
	public void delete(Integer idEmail) {
		if (clienteEmailDAO.existsById(idEmail)) {
			ClienteEmail clienteEmail = clienteEmailDAO.findById(idEmail).get();
			clienteEmailDAO.delete(clienteEmail);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El contacto no existe");
	}

}
