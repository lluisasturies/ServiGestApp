package com.lluis.ServiGest.servicios;

import com.lluis.ServiGest.pojos.OrdenCita;

public interface OrdenCitaService {
			
	// CREATE
	public void add(OrdenCita ordenCita);
		
	// UPDATE
	public void update(OrdenCita ordenCita);
		
	// DELETE
	public void delete(Integer idCita);

}
