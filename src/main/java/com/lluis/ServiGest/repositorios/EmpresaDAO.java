package com.lluis.ServiGest.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.Empresa;

@Repository
public interface EmpresaDAO extends CrudRepository<Empresa,Integer>{

	boolean existsByNif(String nif);

	boolean existsByPrefijoOrdenes(String prefijo);

}
