package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.error.ViviendaNotFoundException;
import com.lluis.ServiGest.pojos.Vivienda;
import com.lluis.ServiGest.repositorios.ViviendaDAO;

@Service
public class ViviendaServiceImpl implements ViviendaService {

	@Autowired
	ViviendaDAO viviendaDAO;
	
	@Override
	public List<Vivienda> listaViviendas() {
		return (List<Vivienda>) viviendaDAO.findAll();
	}

	@Override
	public Vivienda verVivienda(Integer idVivienda) {	
		return viviendaDAO.findById(idVivienda).orElseThrow(() -> new ViviendaNotFoundException());
	}

	@Override
	public void add(Vivienda vivienda) {
		if (!viviendaDAO.existsByDireccion(vivienda.getDireccion())) {
			vivienda.setDireccion(vivienda.getDireccion().toUpperCase());
			vivienda.setLocalidad(vivienda.getLocalidad().toUpperCase());
			vivienda.setProvincia(vivienda.getProvincia().toUpperCase());
			
			viviendaDAO.save(vivienda);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esta dirección ya existe");
	}

	@Override
	public void update(Vivienda vivienda) {
		if (viviendaDAO.existsById(vivienda.getIdVivienda())) {
			vivienda.setDireccion(vivienda.getDireccion().toUpperCase());
			vivienda.setLocalidad(vivienda.getLocalidad().toUpperCase());
			vivienda.setProvincia(vivienda.getProvincia().toUpperCase());
				
			viviendaDAO.save(vivienda);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La vivienda no existe");
	}

	@Override
	public void delete(Integer idVivienda) {
		if (viviendaDAO.existsById(idVivienda)) {
			Vivienda vivienda = viviendaDAO.findById(idVivienda).get();
			viviendaDAO.delete(vivienda);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La vivienda no existe");
	}

}
