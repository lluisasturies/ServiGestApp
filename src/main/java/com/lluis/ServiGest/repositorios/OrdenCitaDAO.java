package com.lluis.ServiGest.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.OrdenCita;

@Repository
public interface OrdenCitaDAO extends CrudRepository<OrdenCita,Integer> {

}
