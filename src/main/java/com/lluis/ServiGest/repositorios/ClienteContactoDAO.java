package com.lluis.ServiGest.repositorios;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.ClienteContacto;

@Repository
public interface ClienteContactoDAO extends CrudRepository<ClienteContacto,Integer>{

	@Transactional @Query(value="SELECT * FROM clientes_contactos WHERE id_cliente = :idCliente", nativeQuery=true)
	List<ClienteContacto> contactosPorCliente(@Param("idCliente") Integer idCliente);

}
