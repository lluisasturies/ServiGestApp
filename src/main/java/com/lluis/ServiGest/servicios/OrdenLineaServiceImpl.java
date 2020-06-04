package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lluis.ServiGest.pojos.OrdenLinea;
import com.lluis.ServiGest.repositorios.OrdenLineaDAO;

@Service
public class OrdenLineaServiceImpl implements OrdenLineaService {
	
	@Autowired
	OrdenLineaDAO ordenLineaDAO;

	@Override
	public void add(OrdenLinea ordenLinea) {
		ordenLineaDAO.save(ordenLinea);
	}

	@Override
	public void update(OrdenLinea ordenLinea) {
		if (ordenLineaDAO.existsById(ordenLinea.getIdTrabajo())) {
			ordenLineaDAO.save(ordenLinea);
		}
	}

	@Override
	public void delete(Integer idTrabajo) {
		if (ordenLineaDAO.existsById(idTrabajo)) {
			OrdenLinea ordenLinea = ordenLineaDAO.findById(idTrabajo).get();
			ordenLineaDAO.delete(ordenLinea);
		}
	}

}
