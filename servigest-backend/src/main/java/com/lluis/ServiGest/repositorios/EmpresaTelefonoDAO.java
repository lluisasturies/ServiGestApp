package com.lluis.ServiGest.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.EmpresaTelefono;

@Repository
public interface EmpresaTelefonoDAO extends CrudRepository<EmpresaTelefono,Integer>{

	boolean existsByTelefono(Integer telefono);

}
