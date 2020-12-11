package com.lluis.ServiGest.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.EmpresaEmail;

@Repository
public interface EmpresaEmailDAO extends CrudRepository<EmpresaEmail,Integer>{

	boolean existsByEmail(String email);

}
