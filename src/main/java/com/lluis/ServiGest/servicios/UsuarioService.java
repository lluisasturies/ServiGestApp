package com.lluis.ServiGest.servicios;

import java.util.Optional;

import com.lluis.ServiGest.pojos.Usuario;

public interface UsuarioService {

	public Optional<Usuario> getByNombreUsuario(String nu);
	
	public boolean existePorNombre(String nu);
	
	public boolean existePorEmail(String email);
	
	public void add(Usuario usuario);
}
