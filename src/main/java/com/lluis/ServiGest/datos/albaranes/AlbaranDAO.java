package com.lluis.ServiGest.datos.albaranes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbaranDAO extends CrudRepository<Albaran,Integer> {

}
