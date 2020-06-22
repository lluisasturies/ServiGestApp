package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		aparatoDAO.save(aparato);
	}

	@Override
	public void update(Aparato aparato) {
		if (aparatoDAO.existsById(aparato.getIdAparato())) {
			aparatoDAO.save(aparato);
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
