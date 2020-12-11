package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.pojos.ClienteTelefono;
import com.lluis.ServiGest.repositorios.ClienteTelefonoDAO;

@Service
public class ClienteTelefonoServiceImpl implements ClienteTelefonoService  {
	
	@Autowired
	ClienteTelefonoDAO clienteTelefonoDAO;
	
	@Override
	public void add(ClienteTelefono clienteTelefono) {
		if (!clienteTelefonoDAO.existsByTelefono(clienteTelefono.getTelefono())) {
			clienteTelefonoDAO.save(clienteTelefono);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este telefono ya existe");
		
	}
	
	@Override
	public void update(ClienteTelefono clienteTelefono) {
		if (!clienteTelefonoDAO.existsByTelefono(clienteTelefono.getTelefono())) {
			clienteTelefonoDAO.save(clienteTelefono);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este telefono ya existe");
	}

	@Override
	public void delete(Integer telefono) {
		if (clienteTelefonoDAO.existsByTelefono(telefono)) {
			ClienteTelefono clienteTelefono = clienteTelefonoDAO.findByTelefono(telefono).get();
			clienteTelefonoDAO.delete(clienteTelefono);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El telefono no existe");
	}

}
