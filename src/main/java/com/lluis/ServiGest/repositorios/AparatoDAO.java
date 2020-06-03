package com.lluis.ServiGest.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.Aparato;

@Repository
public interface AparatoDAO extends CrudRepository<Aparato,Integer>{
	
}
