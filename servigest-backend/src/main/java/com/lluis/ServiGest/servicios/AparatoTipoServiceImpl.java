package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
		if (!aparatoTipoDAO.existsByNombre(aparatoTipo.getNombre())) {
			aparatoTipo.setNombre(aparatoTipo.getNombre().toUpperCase());
			
			aparatoTipoDAO.save(aparatoTipo);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este tipo ya existe");
		
	}

	@Override
	public void update(AparatoTipo aparatoTipo) {
		if (aparatoTipoDAO.existsById(aparatoTipo.getIdTipo())) {
			if (!aparatoTipoDAO.existsByNombre(aparatoTipo.getNombre())) {
				aparatoTipo.setNombre(aparatoTipo.getNombre().toUpperCase());
			
				aparatoTipoDAO.save(aparatoTipo);
			} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este tipo ya existe");
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
