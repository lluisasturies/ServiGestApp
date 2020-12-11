package com.lluis.ServiGest.repositorios;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.EmpresaEmail;

@Repository
public interface EmpresaEmailDAO extends CrudRepository<EmpresaEmail,String>{

	Optional<EmpresaEmail> findByEmail(String email);
	boolean existsByEmail(String email);

}
