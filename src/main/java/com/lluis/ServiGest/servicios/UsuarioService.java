package com.lluis.ServiGest.servicios;

import java.util.List;

import com.lluis.ServiGest.pojos.Usuario;

public interface UsuarioService {

	// List de Usuarios
	public List<Usuario> listaUsuarios();
	
	// READ
	public Usuario getUsuario(String email);
	
	// CREATE
	public void add(Usuario usuario);
	
	// UPDATE
	public void update(Usuario usuario);
	
	// DELETE
	public void delete(Long idUsuario);
	
	public boolean existePorEmail(String email);
	
}
