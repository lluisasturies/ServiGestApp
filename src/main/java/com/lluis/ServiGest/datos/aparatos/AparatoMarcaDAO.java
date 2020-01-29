package com.lluis.ServiGest.datos.aparatos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AparatoMarcaDAO extends CrudRepository<AparatoMarca,Integer> {

}
