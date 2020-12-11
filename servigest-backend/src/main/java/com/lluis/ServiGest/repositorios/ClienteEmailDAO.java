package com.lluis.ServiGest.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.ClienteEmail;

@Repository
public interface ClienteEmailDAO extends CrudRepository<ClienteEmail,Integer>{

	boolean existsByEmail(String email);

}
