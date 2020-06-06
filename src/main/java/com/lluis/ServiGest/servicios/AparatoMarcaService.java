package com.lluis.ServiGest.servicios;

import java.util.List;

import com.lluis.ServiGest.pojos.AparatoMarca;

public interface AparatoMarcaService {
	
	// LIST de Marcas de Aparatos
	public List<AparatoMarca> listaMarcasAparatos();
			
	// READ
	public AparatoMarca verMarcaAparato(Integer idMarca);
			
	// CREATE
	public void add(AparatoMarca aparatoMarca);
			
	// UPDATE
	public void update(AparatoMarca aparatoMarca);
			
	// DELETE
	public void delete(Integer idMarca);

}
