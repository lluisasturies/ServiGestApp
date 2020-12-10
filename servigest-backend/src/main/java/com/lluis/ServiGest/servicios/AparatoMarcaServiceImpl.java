package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.error.AparatoMarcaNotFoundException;
import com.lluis.ServiGest.pojos.AparatoMarca;
import com.lluis.ServiGest.repositorios.AparatoMarcaDAO;

@Service
public class AparatoMarcaServiceImpl implements AparatoMarcaService {

	@Autowired
	AparatoMarcaDAO aparatoMarcaDAO;
	
	@Override
	public List<AparatoMarca> listaMarcasAparatos() {
		return (List<AparatoMarca>) aparatoMarcaDAO.findAll();
	}

	@Override
	public AparatoMarca verMarcaAparato(Integer idMarca) {
		return aparatoMarcaDAO.findById(idMarca).orElseThrow(() -> new AparatoMarcaNotFoundException());
	}

	@Override
	public void add(AparatoMarca aparatoMarca) {
		if (!aparatoMarcaDAO.existsByNombre(aparatoMarca.getNombre())) {
			aparatoMarca.setNombre(aparatoMarca.getNombre().toUpperCase());
		
			aparatoMarcaDAO.save(aparatoMarca);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de marca ya existe");
	}

	@Override
	public void update(AparatoMarca aparatoMarca) {
		if (aparatoMarcaDAO.existsById(aparatoMarca.getIdMarca())) {
			if (!aparatoMarcaDAO.existsByNombre(aparatoMarca.getNombre())) {
				aparatoMarca.setNombre(aparatoMarca.getNombre().toUpperCase());
			
				aparatoMarcaDAO.save(aparatoMarca);
			} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de marca ya existe");
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
