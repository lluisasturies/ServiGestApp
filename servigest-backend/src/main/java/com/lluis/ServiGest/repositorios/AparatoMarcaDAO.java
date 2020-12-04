package com.lluis.ServiGest.repositorios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.AparatoMarca;

@Repository
public interface AparatoMarcaDAO extends CrudRepository<AparatoMarca,Integer> {

}
