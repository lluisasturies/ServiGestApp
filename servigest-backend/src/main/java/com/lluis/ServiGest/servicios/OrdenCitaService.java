package com.lluis.ServiGest.servicios;

import java.util.List;

import com.lluis.ServiGest.dto.OrdenCitaProjection;
import com.lluis.ServiGest.pojos.OrdenCita;

public interface OrdenCitaService {
	
	// Listado Citas Pendientes
	public List<OrdenCitaProjection> listaCitasPendientes();
			
	// CREATE
	public void add(OrdenCita ordenCita);
		
	// UPDATE
	public void update(OrdenCita ordenCita);
		
	// DELETE
	public void delete(Integer idCita);

}
