package com.lluis.ServiGest.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.dto.OrdenCitaProjection;
import com.lluis.ServiGest.pojos.OrdenCita;

@Repository
public interface OrdenCitaDAO extends CrudRepository<OrdenCita,Integer> {

	// Query para sacar las citas que estan pendientes...
	@Transactional @Query(value="SELECT ordenes_citas.id_cita AS idCita, ordenes_citas.fecha AS fechaCita, ordenes.id_orden AS idOrden, ordenes.asunto AS asunto, viviendas.id_vivienda AS idVivienda, viviendas.direccion AS direccion FROM ordenes_citas INNER JOIN ordenes ON ordenes_citas.id_orden = ordenes.id_orden INNER JOIN viviendas ON ordenes.id_vivienda = viviendas.id_vivienda WHERE ordenes_citas.fecha > CURRENT_TIMESTAMP()", nativeQuery=true)
	List<OrdenCitaProjection> mostrarCitasPendientes();

}
