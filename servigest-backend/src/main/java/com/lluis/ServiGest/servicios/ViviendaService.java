package com.lluis.ServiGest.servicios;

import java.util.List;

import com.lluis.ServiGest.pojos.Vivienda;

public interface ViviendaService {
	
	// LIST de Viviendas
	public List<Vivienda> listaViviendas();
	
	// READ
	public Vivienda verVivienda(Integer idVivienda);
	
	// CREATE
	public void add(Vivienda vivienda);
	
	// UPDATE
	public void update(Vivienda vivienda);
	
	// DELETE
	public void delete(Integer idVivienda);

}
