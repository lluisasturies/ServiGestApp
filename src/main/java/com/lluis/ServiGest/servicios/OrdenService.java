package com.lluis.ServiGest.servicios;

import java.util.List;

import com.lluis.ServiGest.pojos.Orden;

public interface OrdenService {

	// LIST de Ordenes
	public List<Orden> listaOrdenes();
		
	// READ
	public Orden verOrden(Integer idOrden);
		
	// CREATE
	public void add(Orden orden);
		
	// UPDATE
	public void update(Orden orden);
		
	// DELETE
	public void delete(Integer idOrden);

}
