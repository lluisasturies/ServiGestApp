package com.lluis.ServiGest.Ordenes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenDAO extends CrudRepository<Orden,Integer> {

}
