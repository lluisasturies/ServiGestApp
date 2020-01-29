package com.lluis.ServiGest.datos.viviendas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViviendaDAO extends CrudRepository<Vivienda,Integer>{

}
