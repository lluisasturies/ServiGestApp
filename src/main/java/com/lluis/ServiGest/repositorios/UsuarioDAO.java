package com.lluis.ServiGest.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lluis.ServiGest.pojos.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
	
    Optional<Usuario> findByNombreUsuario(String nu);
    
    boolean existsByNombreUsuario(String nu);
    
    boolean existsByEmail(String email);
    
}
