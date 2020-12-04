package com.lluis.ServiGest.servicios;

import java.util.List;

import com.lluis.ServiGest.pojos.Empresa;

public interface EmpresaService {
	
	// LIST de Empresas
	public List<Empresa> listaEmpresas();
	
	// READ
	public Empresa verEmpresa(Integer idEmpresa);
	
	// CREATE
	public void add(Empresa empresa);
	
	// UPDATE
	public void update(Empresa empresa);
	
	// DELETE
	public void delete(Integer idEmpresa);

}
