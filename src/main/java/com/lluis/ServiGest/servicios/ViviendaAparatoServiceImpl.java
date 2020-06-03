package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lluis.ServiGest.pojos.ViviendaAparato;
import com.lluis.ServiGest.repositorios.ViviendaAparatoDAO;

@Service
public class ViviendaAparatoServiceImpl implements ViviendaAparatoService  {
	
	@Autowired
	ViviendaAparatoDAO viviendaAparatoDAO;
	
	@Override
	public List<ViviendaAparato> verAparatosVivienda(Integer idVivienda) {
		return viviendaAparatoDAO.aparatosPorVivienda(idVivienda);
	}
	
	@Override
	public void add(ViviendaAparato viviendaAparato) {
		viviendaAparatoDAO.save(viviendaAparato);
		
	}

	@Override
	public void delete(Integer id) {		
		if (viviendaAparatoDAO.existsById(id)) {
			ViviendaAparato viviendaAparato = viviendaAparatoDAO.findById(id).get();
			
			viviendaAparatoDAO.delete(viviendaAparato);
		}
	}

}
