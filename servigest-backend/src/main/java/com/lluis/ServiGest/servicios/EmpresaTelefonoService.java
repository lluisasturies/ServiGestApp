package com.lluis.ServiGest.servicios;

import com.lluis.ServiGest.pojos.EmpresaTelefono;

public interface EmpresaTelefonoService {

	// CREATE
	public void add(EmpresaTelefono empresaTelefono);
	
	// UPDATE
	public void update(EmpresaTelefono empresaTelefono);
	
	// DELETE
	public void delete(Integer telefono);
}
