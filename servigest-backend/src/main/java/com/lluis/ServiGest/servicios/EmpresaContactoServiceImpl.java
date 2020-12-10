package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.pojos.EmpresaContacto;
import com.lluis.ServiGest.repositorios.EmpresaContactoDAO;

@Service
public class EmpresaContactoServiceImpl implements EmpresaContactoService {

	@Autowired
	EmpresaContactoDAO empresaContactoDAO;
	
	@Override
	public void add(EmpresaContacto empresaContacto) {
		if (!empresaContactoDAO.existsByDato(empresaContacto.getDato())) {
			empresaContactoDAO.save(empresaContacto);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este contacto ya existe");
	}

	@Override
	public void update(EmpresaContacto empresaContacto) {
		if (empresaContactoDAO.existsById(empresaContacto.getIdContacto())) {
			if (!empresaContactoDAO.existsByDato(empresaContacto.getDato())) {
				empresaContactoDAO.save(empresaContacto);
			} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este contacto ya existe");
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El contacto no existe");
	}

	@Override
	public void delete(Integer idContacto) {
		if (empresaContactoDAO.existsById(idContacto)) {
			EmpresaContacto empresaContacto = empresaContactoDAO.findById(idContacto).get();
			empresaContactoDAO.delete(empresaContacto);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El contacto no existe");
	}

}
