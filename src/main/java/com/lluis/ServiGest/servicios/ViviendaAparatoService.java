package com.lluis.ServiGest.servicios;

import java.util.List;

import com.lluis.ServiGest.pojos.ViviendaAparato;

public interface ViviendaAparatoService {

	// Aparatos de una Vivienda
	public List<ViviendaAparato> verAparatosVivienda(Integer idVivienda);
		
	// CREATE
	public void add(ViviendaAparato viviendaAparato);
		
	// DELETE
	public void delete(Integer id);
		
}
