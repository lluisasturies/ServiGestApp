package com.lluis.ServiGest.servicios;

import com.lluis.ServiGest.pojos.ViviendaAparato;

public interface ViviendaAparatoService {
	
	// CREATE
	public void add(ViviendaAparato viviendaAparato);
	
	// UPDATE
	public void update(ViviendaAparato viviendaAparato);
		
	// DELETE
	public void delete(Integer id);
		
}
