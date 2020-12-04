package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lluis.ServiGest.error.AparatoTipoNotFoundException;
import com.lluis.ServiGest.pojos.AparatoTipo;
import com.lluis.ServiGest.repositorios.AparatoTipoDAO;

@Service
public class AparatoTipoServiceImpl implements AparatoTipoService {

	@Autowired
	AparatoTipoDAO aparatoTipoDAO;
	
	@Override
	public List<AparatoTipo> listaTiposAparatos() {
		return (List<AparatoTipo>) aparatoTipoDAO.findAll();
	}

	@Override
	public AparatoTipo verTipoAparato(Integer idTipo) {
		return aparatoTipoDAO.findById(idTipo).orElseThrow(() -> new AparatoTipoNotFoundException());
	}

	@Override
	public void add(AparatoTipo aparatoTipo) {
		aparatoTipoDAO.save(aparatoTipo);
	}

	@Override
	public void update(AparatoTipo aparatoTipo) {
		if (aparatoTipoDAO.existsById(aparatoTipo.getIdTipo())) {
			aparatoTipoDAO.save(aparatoTipo);
		}
	}

	@Override
	public void delete(Integer idTipo) {
		if (aparatoTipoDAO.existsById(idTipo)) {
			AparatoTipo aparatoTipo = aparatoTipoDAO.findById(idTipo).get();
			aparatoTipoDAO.save(aparatoTipo);
		}
	}

}
