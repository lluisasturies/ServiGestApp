package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lluis.ServiGest.pojos.Albaran;
import com.lluis.ServiGest.repositorios.AlbaranDAO;

@Service
public class AlbaranServiceImpl implements AlbaranService {

	@Autowired
	AlbaranDAO albaranDAO;
	
	@Override
	public List<Albaran> listaAlbaranes() {
		return (List<Albaran>) albaranDAO.findAll();
	}

	@Override
	public Albaran verAlbaran(Integer idAlbaran) {
		if (albaranDAO.existsById(idAlbaran)) {
			return albaranDAO.findById(idAlbaran).get();
		}
		else {
			return null;
		}
	}

	@Override
	public void add(Albaran albaran) {
		albaranDAO.save(albaran);
	}

	@Override
	public void update(Albaran albaran) {
		if (albaranDAO.existsById(albaran.getIdAlbaran())) {
			albaranDAO.save(albaran);
		}
	}

	@Override
	public void delete(Integer idAlbaran) {
		if (albaranDAO.existsById(idAlbaran)) {
			Albaran albaran = new Albaran();
			albaran.setIdAlbaran(idAlbaran);
			albaranDAO.delete(albaran);
		}
	}

}
