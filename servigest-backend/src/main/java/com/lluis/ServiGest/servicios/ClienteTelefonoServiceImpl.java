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
		clienteTelefonoDAO.save(clienteTelefono);		
	}
	
	@Override
	public void update(ClienteTelefono clienteTelefono) {
		if (clienteTelefonoDAO.existsById(clienteTelefono.getIdTelefono())) {
			clienteTelefonoDAO.save(clienteTelefono);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El telefono no existe");
	}

	@Override
	public void delete(Integer idTelefono) {
		if (clienteTelefonoDAO.existsById(idTelefono)) {
			ClienteTelefono clienteTelefono = clienteTelefonoDAO.findById(idTelefono).get();
			clienteTelefonoDAO.delete(clienteTelefono);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El telefono no existe");
	}

}
