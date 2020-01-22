package com.lluis.ServiGest.Empresas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaContactoDAO extends CrudRepository<EmpresaContacto,Integer> {

}
