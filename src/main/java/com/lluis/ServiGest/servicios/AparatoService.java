package com.lluis.ServiGest.servicios;

import java.util.List;

import com.lluis.ServiGest.pojos.Aparato;

public interface AparatoService {
	
	// LIST de Clientes
	public List<Aparato> listaAparatos();
			
	// READ
	public Aparato verAparato(Integer idAparato);
			
	// CREATE
	public void add(Aparato aparato);
			
	// UPDATE
	public void update(Aparato aparato);
			
	// DELETE
	public void delete(Integer idAparato);

}
