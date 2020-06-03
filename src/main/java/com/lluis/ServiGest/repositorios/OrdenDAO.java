package com.lluis.ServiGest.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.Orden;

@Repository
public interface OrdenDAO extends CrudRepository<Orden,Integer> {

	// Query para sacar las ordenes que estan pendientes... (1 = Abierta)
	@Transactional @Query(value="SELECT * FROM ordenes WHERE estado = '1'", nativeQuery=true)
	List<Orden> mostrarPendientes();

	@Transactional @Query(value="SELECT * FROM ordenes WHERE id_vivienda = :idVivienda", nativeQuery=true)
	List<Orden> ordenesPorVivienda(Integer idVivienda);
	
}
