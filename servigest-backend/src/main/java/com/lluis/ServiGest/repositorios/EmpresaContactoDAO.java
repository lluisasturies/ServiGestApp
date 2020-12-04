package com.lluis.ServiGest.repositorios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.EmpresaContacto;

@Repository
public interface EmpresaContactoDAO extends CrudRepository<EmpresaContacto,Integer> {

}
