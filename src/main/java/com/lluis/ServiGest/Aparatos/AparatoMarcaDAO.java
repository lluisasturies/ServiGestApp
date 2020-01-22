package com.lluis.ServiGest.Aparatos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AparatoMarcaDAO extends CrudRepository<AparatoMarca,Integer> {

}
