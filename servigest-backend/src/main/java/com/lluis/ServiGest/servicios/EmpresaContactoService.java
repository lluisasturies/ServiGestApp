package com.lluis.ServiGest.servicios;

import com.lluis.ServiGest.pojos.EmpresaContacto;

public interface EmpresaContactoService {

	// CREATE
	public void add(EmpresaContacto empresaContacto);
	
	// UPDATE
	public void update(EmpresaContacto empresaContacto);
	
	// DELETE
	public void delete(Integer idContacto);
}
