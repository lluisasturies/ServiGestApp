package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.pojos.EmpresaTelefono;
import com.lluis.ServiGest.repositorios.EmpresaTelefonoDAO;

@Service
public class EmpresaTelefonoServiceImpl implements EmpresaTelefonoService  {
	
	@Autowired
	EmpresaTelefonoDAO empresaTelefonoDAO;
	
	@Override
	public void add(EmpresaTelefono clienteTelefono) {
		if (!empresaTelefonoDAO.existsByTelefono(clienteTelefono.getTelefono())) {
			empresaTelefonoDAO.save(clienteTelefono);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este telefono ya existe");
		
	}
	
	@Override
	public void update(EmpresaTelefono empresaTelefono) {
		if (!empresaTelefonoDAO.existsByTelefono(empresaTelefono.getTelefono())) {
			empresaTelefonoDAO.save(empresaTelefono);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este telefono ya existe");
	}

	@Override
	public void delete(Integer telefono) {
		if (empresaTelefonoDAO.existsByTelefono(telefono)) {
			EmpresaTelefono empresaTelefono = empresaTelefonoDAO.findByTelefono(telefono).get();
			empresaTelefonoDAO.delete(empresaTelefono);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El telefono no existe");
	}

}
