package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.error.EmpresaNotFoundException;
import com.lluis.ServiGest.pojos.Empresa;
import com.lluis.ServiGest.repositorios.EmpresaDAO;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	EmpresaDAO empresaDAO;
	
	@Override
	public List<Empresa> listaEmpresas() {
		return (List<Empresa>) empresaDAO.findAll();
	}

	@Override
	public Empresa verEmpresa(Integer idEmpresa) {
		return empresaDAO.findById(idEmpresa).orElseThrow(() -> new EmpresaNotFoundException());
	}

	@Override
	public void add(Empresa empresa) {
		if (empresaDAO.existsByNombreComercial(empresa.getNombreComercial())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este nombre comercial ya existe");
		
		} else if (empresaDAO.existsByNombreFiscal(empresa.getNombreFiscal())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este nombre fiscal ya existe");
		
		} else if (empresaDAO.existsByNif(empresa.getNif())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este NIF ya existe");
		
		} else if (empresaDAO.existsByPrefijoOrdenes(empresa.getPrefijoOrdenes())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este prefijo de orden ya existe");
		
		} else {
			empresa.setNombreComercial(empresa.getNombreComercial().toUpperCase().toUpperCase());
			empresa.setNombreFiscal(empresa.getNombreFiscal().toUpperCase());
			empresa.setDireccion(empresa.getDireccion().toUpperCase());
			empresa.setLocalidad(empresa.getLocalidad().toUpperCase());
			empresa.setProvincia(empresa.getProvincia().toUpperCase());
			empresa.setPrefijoOrdenes(empresa.getPrefijoOrdenes().toUpperCase());
			
			empresaDAO.save(empresa);
		}
	}

	@Override
	public void update(Empresa empresa) {	
		if (empresaDAO.existsById(empresa.getIdEmpresa())) {
			if (empresaDAO.existsByNombreComercial(empresa.getNombreComercial())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este nombre comercial ya existe");
			
			} else if (empresaDAO.existsByNombreFiscal(empresa.getNombreFiscal())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este nombre fiscal ya existe");
			
			} else if (empresaDAO.existsByNif(empresa.getNif())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este NIF ya existe");
			
			} else if (empresaDAO.existsByPrefijoOrdenes(empresa.getPrefijoOrdenes())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este prefijo de orden ya existe");
			
			} else {
				empresa.setNombreComercial(empresa.getNombreComercial().toUpperCase().toUpperCase());
				empresa.setNombreFiscal(empresa.getNombreFiscal().toUpperCase());
				empresa.setDireccion(empresa.getDireccion().toUpperCase());
				empresa.setLocalidad(empresa.getLocalidad().toUpperCase());
				empresa.setProvincia(empresa.getProvincia().toUpperCase());
				empresa.setPrefijoOrdenes(empresa.getPrefijoOrdenes().toUpperCase());
				
				empresaDAO.save(empresa);
			}
			
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La empresa no existe");
	}

	@Override
	public void delete(Integer idEmpresa) {
		if (empresaDAO.existsById(idEmpresa)) {
			Empresa empresa = empresaDAO.findById(idEmpresa).get();
			
			empresaDAO.delete(empresa);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La empresa no existe");
		
	}

}
