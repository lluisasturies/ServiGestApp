package com.lluis.ServiGest.datos.aparatos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AparatoDAO extends CrudRepository<Aparato,Integer>{

	@Transactional @Query(value="SELECT * FROM aparatos WHERE id_aparato = (SELECT id_aparato_id_aparato FROM aparatos_id_vivienda WHERE id_vivienda_id_vivienda = :idvivienda)", nativeQuery=true)
	List<Aparato> aparatosPorVivienda(@Param("idvivienda") Integer idaparato);
	
}
