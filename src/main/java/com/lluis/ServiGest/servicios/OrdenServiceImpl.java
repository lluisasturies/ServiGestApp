package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		ordenDAO.save(orden);
	}

	@Override
	public void update(Orden orden) {
		if (ordenDAO.existsById(orden.getIdOrden())) {
			ordenDAO.save(orden);
		}
	}

	@Override
	public void delete(Integer idOrden) {
		if (ordenDAO.existsById(idOrden)) {
			Orden orden = ordenDAO.findById(idOrden).get();
			ordenDAO.delete(orden);
		}
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
		}
	}

}
