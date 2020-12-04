package com.lluis.ServiGest.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.AlbaranLinea;

@Repository
public interface AlbaranLineaDAO extends CrudRepository<AlbaranLinea,Integer>{

}
