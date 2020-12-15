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
		empresaTelefonoDAO.save(clienteTelefono);		
	}
	
	@Override
	public void update(EmpresaTelefono empresaTelefono) {
		if (empresaTelefonoDAO.existsById(empresaTelefono.getIdTelefono())) {
			empresaTelefonoDAO.save(empresaTelefono);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El telefono no existe");
	}

	@Override
	public void delete(Integer idTelefono) {
		if (empresaTelefonoDAO.existsById(idTelefono)) {
			EmpresaTelefono empresaTelefono = empresaTelefonoDAO.findById(idTelefono).get();
			empresaTelefonoDAO.delete(empresaTelefono);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El telefono no existe");
	}

}
