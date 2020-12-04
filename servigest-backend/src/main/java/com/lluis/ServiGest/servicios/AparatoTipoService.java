package com.lluis.ServiGest.servicios;

import java.util.List;

import com.lluis.ServiGest.pojos.AparatoTipo;

public interface AparatoTipoService {
	
	// LIST de Tipos de Aparatos
	public List<AparatoTipo> listaTiposAparatos();
			
	// READ
	public AparatoTipo verTipoAparato(Integer idTipo);
			
	// CREATE
	public void add(AparatoTipo aparatoTipo);
			
	// UPDATE
	public void update(AparatoTipo aparatoTipo);
			
	// DELETE
	public void delete(Integer idTipo);

}
