package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lluis.ServiGest.pojos.AlbaranLinea;
import com.lluis.ServiGest.repositorios.AlbaranLineaDAO;

@Service
public class AlbaranLineaServiceImpl implements AlbaranLineaService {

	@Autowired
	AlbaranLineaDAO albaranLineaDAO;
	
	@Override
	public void add(AlbaranLinea albaranLinea) {
		albaranLineaDAO.save(albaranLinea);
	}

	@Override
	public void update(AlbaranLinea albaranLinea) {
		if (albaranLineaDAO.existsById(albaranLinea.getIdLinea())) {
			albaranLineaDAO.save(albaranLinea);
		}
	}

	@Override
	public void delete(Integer idLinea) {
		if (albaranLineaDAO.existsById(idLinea)) {
			AlbaranLinea albaranLinea = new AlbaranLinea();
			albaranLinea.setIdLinea(idLinea);
			albaranLineaDAO.delete(albaranLinea);
		}
	}

}
