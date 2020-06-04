package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lluis.ServiGest.pojos.Orden;
import com.lluis.ServiGest.repositorios.OrdenDAO;

@Service
public class OrdenServiceImpl implements OrdenService {
	
	@Autowired
	OrdenDAO ordenDAO;

	@Override
	public List<Orden> listaOrdenes() {
		return (List<Orden>) ordenDAO.findAll();
		
	}

	@Override
	public Orden verOrden(Integer idOrden) {
		if (ordenDAO.existsById(idOrden)) {	
			return ordenDAO.findById(idOrden).get();
		} 
		else {
			return null;
		}
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

}
