package com.lluis.ServiGest.servicios;

import com.lluis.ServiGest.pojos.ViviendaCita;

public interface ViviendaCitaService {
			
	// CREATE
	public void add(ViviendaCita ordenCita);
		
	// UPDATE
	public void update(ViviendaCita ordenCita);
		
	// DELETE
	public void delete(Integer idCita);

}
