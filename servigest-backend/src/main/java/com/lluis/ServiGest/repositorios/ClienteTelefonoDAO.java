package com.lluis.ServiGest.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.ClienteTelefono;

@Repository
public interface ClienteTelefonoDAO extends CrudRepository<ClienteTelefono,Integer>{

	boolean existsByTelefono(Integer telefono);

}
