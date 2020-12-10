package com.lluis.ServiGest.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.Cliente;

@Repository
public interface ClienteDAO extends CrudRepository<Cliente,Integer> {
	
	boolean existsByDni(String dni);

}
