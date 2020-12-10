package com.lluis.ServiGest.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.Vivienda;

@Repository
public interface ViviendaDAO extends CrudRepository<Vivienda,Integer>{

	// Query para sacar las viviendas de un cliente concreto
	@Transactional @Query(value="SELECT * FROM viviendas WHERE id_propietario = :idCliente OR id_inquilino = :idCliente", nativeQuery=true)
	List<Vivienda> viviendasPorCliente(@Param("idCliente") Integer idCliente);
	
	boolean existsByDireccion(String direccion);
	
}
