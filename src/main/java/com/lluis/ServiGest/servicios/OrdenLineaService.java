package com.lluis.ServiGest.servicios;

import com.lluis.ServiGest.pojos.OrdenLinea;

public interface OrdenLineaService {
			
	// CREATE
	public void add(OrdenLinea ordenLinea);
		
	// UPDATE
	public void update(OrdenLinea ordenLinea);
		
	// DELETE
	public void delete(Integer idTrabajo);

}
