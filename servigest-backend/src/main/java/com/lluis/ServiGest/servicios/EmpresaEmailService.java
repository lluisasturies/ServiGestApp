package com.lluis.ServiGest.servicios;

import com.lluis.ServiGest.pojos.EmpresaEmail;

public interface EmpresaEmailService {

	// CREATE
	public void add(EmpresaEmail empresaEmail);
	
	// UPDATE
	public void update(EmpresaEmail empresaEmail);
	
	// DELETE
	public void delete(Integer idEmail);
}
