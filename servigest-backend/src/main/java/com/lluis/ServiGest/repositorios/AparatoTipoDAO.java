package com.lluis.ServiGest.repositorios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.AparatoTipo;

@Repository
public interface AparatoTipoDAO extends CrudRepository<AparatoTipo,Integer> {

}
