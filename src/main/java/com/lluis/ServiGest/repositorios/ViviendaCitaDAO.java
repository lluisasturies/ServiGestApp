package com.lluis.ServiGest.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.ViviendaCita;

@Repository
public interface ViviendaCitaDAO extends CrudRepository<ViviendaCita,Integer> {

}
