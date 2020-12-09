package com.lluis.ServiGest.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		empresa.setNombreComercial(empresa.getNombreComercial().toUpperCase());
		empresa.setNombreFiscal(empresa.getNombreFiscal());
		empresa.setDireccion(empresa.getDireccion());
		empresa.setLocalidad(empresa.getLocalidad());
		empresa.setProvincia(empresa.getProvincia());
		empresa.setPrefijoOrdenes(empresa.getPrefijoOrdenes());
		
		empresaDAO.save(empresa);
		
	}

	@Override
	public void update(Empresa empresa) {	
		if (empresaDAO.existsById(empresa.getIdEmpresa())) {
			empresa.setNombreComercial(empresa.getNombreComercial().toUpperCase());
			empresa.setNombreFiscal(empresa.getNombreFiscal());
			empresa.setDireccion(empresa.getDireccion());
			empresa.setLocalidad(empresa.getLocalidad());
			empresa.setProvincia(empresa.getProvincia());
			empresa.setPrefijoOrdenes(empresa.getPrefijoOrdenes());
			
			empresaDAO.save(empresa);
		}		
	}

	@Override
	public void delete(Integer idEmpresa) {
		if (empresaDAO.existsById(idEmpresa)) {
			Empresa empresa = empresaDAO.findById(idEmpresa).get();
			
			empresaDAO.delete(empresa);
		}
		
	}

}
