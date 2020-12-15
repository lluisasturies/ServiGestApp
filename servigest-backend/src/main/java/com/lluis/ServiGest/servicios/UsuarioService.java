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
	
	// UPDATE PASSWORD
	public void updatePassword(Usuario usuario, String password);
	
	public boolean checkIfValidOldPassword(Usuario usuario, String oldPassword); 
	
	// DELETE
	public void delete(Long idUsuario);
	
}
