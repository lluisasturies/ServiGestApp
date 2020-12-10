package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.pojos.ClienteContacto;
import com.lluis.ServiGest.repositorios.ClienteContactoDAO;

@Service
public class ClienteContactoServiceImpl implements ClienteContactoService  {
	
	@Autowired
	ClienteContactoDAO clienteContactoDAO;
	
	@Override
	public void add(ClienteContacto clienteContacto) {
		if (!clienteContactoDAO.existsByDato(clienteContacto.getDato())) {
			clienteContactoDAO.save(clienteContacto);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este contacto ya existe");
		
	}
	
	@Override
	public void update(ClienteContacto clienteContacto) {
		if (clienteContactoDAO.existsById(clienteContacto.getIdContacto())) {
			if (!clienteContactoDAO.existsByDato(clienteContacto.getDato())) {
				clienteContactoDAO.save(clienteContacto);
			} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este contacto ya existe");
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El contacto no existe");
	}

	@Override
	public void delete(Integer idContacto) {
		if (clienteContactoDAO.existsById(idContacto)) {
			ClienteContacto clienteContacto = clienteContactoDAO.findById(idContacto).get();
			clienteContactoDAO.delete(clienteContacto);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El contacto no existe");
	}

}
