package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lluis.ServiGest.pojos.ViviendaCita;
import com.lluis.ServiGest.repositorios.ViviendaCitaDAO;

@Service
public class ViviendaCitaServiceImpl implements ViviendaCitaService {

	@Autowired
	ViviendaCitaDAO ordenCitaDAO;
	
	@Override
	public void add(ViviendaCita ordenCita) {
		ordenCitaDAO.save(ordenCita);
	}

	@Override
	public void update(ViviendaCita ordenCita) {
		if (ordenCitaDAO.existsById(ordenCita.getIdCita())) {
			ordenCitaDAO.save(ordenCita);
		}
	}

	@Override
	public void delete(Integer idCita) {
		if (ordenCitaDAO.existsById(idCita)) {
			ViviendaCita ordenCita = ordenCitaDAO.findById(idCita).get();
			ordenCitaDAO.delete(ordenCita);
		}
	}

}
