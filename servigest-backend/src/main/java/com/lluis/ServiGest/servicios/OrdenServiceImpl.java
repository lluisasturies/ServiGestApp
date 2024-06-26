package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.error.OrdenNotFoundException;
import com.lluis.ServiGest.pojos.Orden;
import com.lluis.ServiGest.repositorios.OrdenCitaDAO;
import com.lluis.ServiGest.repositorios.OrdenDAO;

@Service
public class OrdenServiceImpl implements OrdenService {
	
	@Autowired
	OrdenDAO ordenDAO;
	
	@Autowired
	OrdenCitaDAO ordenCitaDAO;

	@Override
	public List<Orden> listaOrdenes() {
		return (List<Orden>) ordenDAO.findAll();
	}
	
	@Override
	public List<Orden> listaOrdenesAbiertas() {
		return ordenDAO.mostrarPendientes();
	}

	@Override
	public Orden verOrden(Integer idOrden) {
		return ordenDAO.findById(idOrden).orElseThrow(() -> new OrdenNotFoundException());
	}

	@Override
	public void add(Orden orden) {
		orden.setAsunto(orden.getAsunto().toUpperCase());
		orden.setOrden(orden.getOrden().toUpperCase());
		
		ordenDAO.save(orden);
	}

	@Override
	public void update(Orden orden) {
		if (ordenDAO.existsById(orden.getIdOrden())) {
			orden.setAsunto(orden.getAsunto().toUpperCase());
			orden.setOrden(orden.getOrden().toUpperCase());
			
			ordenDAO.save(orden);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La orden no existe");
	}

	@Override
	public void delete(Integer idOrden) {
		if (ordenDAO.existsById(idOrden)) {
			Orden orden = ordenDAO.findById(idOrden).get();
			ordenDAO.delete(orden);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La orden no existe");
	}

	@Override
	public void cambiarEstado(Integer idOrden) {
		if (ordenDAO.existsById(idOrden)) {
			Orden orden = ordenDAO.findById(idOrden).get();
			
			if (orden.isEstado() == true) {
				orden.setEstado(false);
			} else {
				orden.setEstado(true);
			}

			ordenDAO.save(orden);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La orden no existe");
	}

}
