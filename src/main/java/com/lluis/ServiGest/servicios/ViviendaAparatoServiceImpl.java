package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lluis.ServiGest.pojos.ViviendaAparato;
import com.lluis.ServiGest.repositorios.ViviendaAparatoDAO;

@Service
public class ViviendaAparatoServiceImpl implements ViviendaAparatoService  {
	
	@Autowired
	ViviendaAparatoDAO viviendaAparatoDAO;
	
	@Override
	public void add(ViviendaAparato viviendaAparato) {
		viviendaAparatoDAO.save(viviendaAparato);
	}
	
	@Override
	public void update(ViviendaAparato viviendaAparato) {
		if (viviendaAparatoDAO.existsById(viviendaAparato.getIdAparato())) {
			viviendaAparatoDAO.save(viviendaAparato);
		}
	}

	@Override
	public void delete(Integer idAparato) {		
		if (viviendaAparatoDAO.existsById(idAparato)) {
			ViviendaAparato viviendaAparato = viviendaAparatoDAO.findById(idAparato).get();
			viviendaAparatoDAO.delete(viviendaAparato);
		}
	}

}
