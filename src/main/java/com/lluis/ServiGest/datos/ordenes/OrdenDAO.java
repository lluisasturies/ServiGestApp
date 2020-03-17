package com.lluis.ServiGest.datos.ordenes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenDAO extends CrudRepository<Orden,Integer> {

	// Query para sacar las ordenes que estan pendientes... (1 = Pendiente)
	@Transactional @Query(value="SELECT * FROM ordenes WHERE pendiente = '1'", nativeQuery=true)
	List<Orden> mostrarPendientes();
	
}
