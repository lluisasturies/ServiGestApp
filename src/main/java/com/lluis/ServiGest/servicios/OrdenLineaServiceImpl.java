package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.pojos.OrdenLinea;
import com.lluis.ServiGest.repositorios.OrdenLineaDAO;

@Service
public class OrdenLineaServiceImpl implements OrdenLineaService {
	
	@Autowired
	OrdenLineaDAO ordenLineaDAO;
	
	@Autowired
	OrdenService ordenService;

	@Override
	public void add(OrdenLinea ordenLinea) {
		if (ordenLinea.getOrden().isEstado() == true) {
			ordenLineaDAO.save(ordenLinea);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La orden está cerrada");

	}

	@Override
	public void update(OrdenLinea ordenLinea) {
		if (ordenLineaDAO.existsById(ordenLinea.getIdLinea())) {
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
