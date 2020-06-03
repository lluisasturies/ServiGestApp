package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		if (viviendaDAO.existsById(idVivienda)) {		
			return viviendaDAO.findById(idVivienda).get();
		}
		else {
			return null;
		}
	}

	@Override
	public void add(Vivienda vivienda) {
		viviendaDAO.save(vivienda);
	}

	@Override
	public void update(Vivienda vivienda) {
		if (viviendaDAO.existsById(vivienda.getIdVivienda())) {
			viviendaDAO.save(vivienda);
		}
	}

	@Override
	public void delete(Integer idVivienda) {
		if (viviendaDAO.existsById(idVivienda)) {
			Vivienda vivienda = viviendaDAO.findById(idVivienda).get();
			
			viviendaDAO.delete(vivienda);
		}
	}

}
