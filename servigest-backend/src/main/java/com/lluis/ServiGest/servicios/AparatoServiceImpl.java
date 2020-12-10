package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.error.AparatoNotFoundException;
import com.lluis.ServiGest.pojos.Aparato;
import com.lluis.ServiGest.repositorios.AparatoDAO;

@Service
public class AparatoServiceImpl implements AparatoService {

	@Autowired
	AparatoDAO aparatoDAO;
	
	@Override
	public List<Aparato> listaAparatos() {
		return (List<Aparato>) aparatoDAO.findAll();
	}

	@Override
	public Aparato verAparato(Integer idAparato) {
		return aparatoDAO.findById(idAparato).orElseThrow(() -> new AparatoNotFoundException());
	}

	@Override
	public void add(Aparato aparato) {
		if (!aparatoDAO.existsByModelo(aparato.getModelo())) {
			aparato.setModelo(aparato.getModelo().toUpperCase());
			
			aparatoDAO.save(aparato);
		} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El modelo ya existe");
	}

	@Override
	public void update(Aparato aparato) {
		if (aparatoDAO.existsById(aparato.getIdAparato())) {
			if (!aparatoDAO.existsByModelo(aparato.getModelo())) {
				aparato.setModelo(aparato.getModelo().toUpperCase());
			
				aparatoDAO.save(aparato);
			} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El modelo ya existe");
		}
	}

	@Override
	public void delete(Integer idAparato) {
		if (aparatoDAO.existsById(idAparato)) {
			Aparato aparato = aparatoDAO.findById(idAparato).get();
			
			aparatoDAO.delete(aparato);
		}
	}

}
