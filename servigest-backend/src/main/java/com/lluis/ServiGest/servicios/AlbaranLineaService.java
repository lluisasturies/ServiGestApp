package com.lluis.ServiGest.servicios;

import com.lluis.ServiGest.pojos.AlbaranLinea;

public interface AlbaranLineaService {

	// CREATE
	public void add(AlbaranLinea albaranLinea);
	
	// UPDATE
	public void update(AlbaranLinea albaranLinea);
	
	// DELETE
	public void delete(Integer idLinea);
}
