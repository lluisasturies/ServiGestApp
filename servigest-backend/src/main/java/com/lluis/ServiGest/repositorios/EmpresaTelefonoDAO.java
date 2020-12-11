package com.lluis.ServiGest.repositorios;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.EmpresaTelefono;

@Repository
public interface EmpresaTelefonoDAO extends CrudRepository<EmpresaTelefono,Integer>{

	Optional<EmpresaTelefono> findByTelefono(Integer telefono);
	boolean existsByTelefono(Integer telefono);

}
