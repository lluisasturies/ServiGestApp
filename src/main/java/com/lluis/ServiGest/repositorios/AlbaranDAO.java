package com.lluis.ServiGest.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.Albaran;

@Repository
public interface AlbaranDAO extends CrudRepository<Albaran,Integer> {

}
