package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lluis.ServiGest.pojos.EmpresaContacto;
import com.lluis.ServiGest.repositorios.EmpresaContactoDAO;

@Service
public class EmpresaContactoImpl implements EmpresaContactoService {

	@Autowired
	EmpresaContactoDAO empresaContactoDAO;
	
	@Override
	public void add(EmpresaContacto empresaContacto) {
		empresaContactoDAO.save(empresaContacto);
	}

	@Override
	public void update(EmpresaContacto empresaContacto) {
		if (empresaContactoDAO.existsById(empresaContacto.getIdContacto())) {
			empresaContactoDAO.save(empresaContacto);
		}
	}

	@Override
	public void delete(Integer idContacto) {
		if (empresaContactoDAO.existsById(idContacto)) {
			EmpresaContacto empresaContacto = empresaContactoDAO.findById(idContacto).get();
			empresaContactoDAO.delete(empresaContacto);
		}
	}

}
