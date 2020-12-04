package com.lluis.ServiGest.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.ViviendaAparato;

@Repository
public interface ViviendaAparatoDAO extends CrudRepository<ViviendaAparato,Integer>{

	@Transactional @Query(value="SELECT * FROM viviendas_aparatos WHERE fk_id_vivienda = :idVivienda", nativeQuery=true)
	List<ViviendaAparato> aparatosPorVivienda(@Param("idVivienda") Integer idVivienda);
	
}
