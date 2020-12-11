package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.pojos.EmpresaEmail;
import com.lluis.ServiGest.repositorios.EmpresaEmailDAO;

@Service
public class EmpresaEmailServiceImpl implements EmpresaEmailService  {
	
	@Autowired
	EmpresaEmailDAO empresaEmailDAO;
	
	@Override
	public void add(EmpresaEmail empresaEmail) {
		if (!empresaEmailDAO.existsByEmail(empresaEmail.getEmail())) {
			empresaEmailDAO.save(empresaEmail);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este email ya existe");
		
	}
	
	@Override
	public void update(EmpresaEmail empresaEmail) {
		if (!empresaEmailDAO.existsByEmail(empresaEmail.getEmail())) {
			empresaEmailDAO.save(empresaEmail);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este email ya existe");
	}

	@Override
	public void delete(Integer idEmail) {
		if (empresaEmailDAO.existsById(idEmail)) {
			EmpresaEmail empresaEmail = empresaEmailDAO.findById(idEmail).get();
			empresaEmailDAO.delete(empresaEmail);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El contacto no existe");
	}

}
