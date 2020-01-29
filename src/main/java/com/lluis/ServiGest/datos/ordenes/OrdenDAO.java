package com.lluis.ServiGest.datos.ordenes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenDAO extends CrudRepository<Orden,Integer> {

}
