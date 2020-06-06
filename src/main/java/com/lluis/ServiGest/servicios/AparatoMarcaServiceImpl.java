package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lluis.ServiGest.pojos.AparatoMarca;
import com.lluis.ServiGest.repositorios.AparatoMarcaDAO;

public class AparatoMarcaServiceImpl implements AparatoMarcaService {

	@Autowired
	AparatoMarcaDAO aparatoMarcaDAO;
	
	@Override
	public List<AparatoMarca> listaMarcasAparatos() {
		return (List<AparatoMarca>) aparatoMarcaDAO.findAll();
	}

	@Override
	public AparatoMarca verMarcaAparato(Integer idMarca) {
		if (aparatoMarcaDAO.existsById(idMarca)) {
			return aparatoMarcaDAO.findById(idMarca).get();
		}
		else {
			return null;
		}
		
	}

	@Override
	public void add(AparatoMarca aparatoMarca) {
		aparatoMarcaDAO.save(aparatoMarca);
	}

	@Override
	public void update(AparatoMarca aparatoMarca) {
		if (aparatoMarcaDAO.existsById(aparatoMarca.getIdMarca())) {
			aparatoMarcaDAO.save(aparatoMarca);
		}
	}

	@Override
	public void delete(Integer idMarca) {
		if (aparatoMarcaDAO.existsById(idMarca)) {
			AparatoMarca aparatoMarca = aparatoMarcaDAO.findById(idMarca).get();
			aparatoMarcaDAO.delete(aparatoMarca);
		}
	}

}
