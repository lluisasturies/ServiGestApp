package com.lluis.ServiGest.Viviendas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViviendaDAO extends CrudRepository<Vivienda,Integer>{

}
