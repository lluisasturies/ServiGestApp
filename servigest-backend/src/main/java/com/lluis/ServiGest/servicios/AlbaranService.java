package com.lluis.ServiGest.servicios;

import java.util.List;

import com.lluis.ServiGest.pojos.Albaran;

public interface AlbaranService {
	
	// LIST de Albaranes
	public List<Albaran> listaAlbaranes();
			
	// READ
	public Albaran verAlbaran(Integer idAlbaran);
			
	// CREATE
	public void add(Albaran albaran);
			
	// UPDATE
	public void update(Albaran albaran);
			
	// DELETE
	public void delete(Integer idAlbaran);

}
