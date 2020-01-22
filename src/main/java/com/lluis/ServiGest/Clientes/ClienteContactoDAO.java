package com.lluis.ServiGest.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteContactoDAO extends CrudRepository<ClienteContacto,Integer>{

}
