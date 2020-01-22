package com.lluis.ServiGest.Albaranes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbaranDAO extends CrudRepository<Albaran,Integer> {

}
