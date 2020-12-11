package com.lluis.ServiGest.repositorios;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.ClienteTelefono;

@Repository
public interface ClienteTelefonoDAO extends CrudRepository<ClienteTelefono,Integer>{

	Optional<ClienteTelefono> findByTelefono(Integer telefono);
	boolean existsByTelefono(Integer telefono);

}
