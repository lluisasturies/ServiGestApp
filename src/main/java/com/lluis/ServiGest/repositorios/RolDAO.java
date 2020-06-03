package com.lluis.ServiGest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.enums.RolNombre;
import com.lluis.ServiGest.pojos.Rol;

import java.util.Optional;

@Repository
public interface RolDAO extends JpaRepository<Rol, RolNombre> {
	
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}