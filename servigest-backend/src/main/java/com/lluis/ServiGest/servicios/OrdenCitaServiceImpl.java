package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.dto.OrdenCitaProjection;
import com.lluis.ServiGest.pojos.OrdenCita;
import com.lluis.ServiGest.repositorios.OrdenCitaDAO;

@Service
public class OrdenCitaServiceImpl implements OrdenCitaService {

	@Autowired
	OrdenCitaDAO ordenCitaDAO;
	
	@Override
	public List<OrdenCitaProjection> listaCitasPendientes() {
		return ordenCitaDAO.mostrarCitasPendientes();
	}
	
	@Override
	public void add(OrdenCita ordenCita) {
		ordenCitaDAO.save(ordenCita);
	}

	@Override
	public void update(OrdenCita ordenCita) {
		if (ordenCitaDAO.existsById(ordenCita.getIdCita())) {
			ordenCitaDAO.save(ordenCita);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La cita no existe");
	}

	@Override
	public void delete(Integer idCita) {
		if (ordenCitaDAO.existsById(idCita)) {
			OrdenCita ordenCita = ordenCitaDAO.findById(idCita).get();
			ordenCitaDAO.delete(ordenCita);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La cita no existe");
	}

}
