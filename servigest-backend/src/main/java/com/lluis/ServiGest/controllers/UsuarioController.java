package com.lluis.ServiGest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.servicios.UsuarioService;

import com.lluis.ServiGest.dto.UpdatePasswordDTO;
import com.lluis.ServiGest.dto.UpdateUsuarioDTO;
import com.lluis.ServiGest.pojos.Usuario;

@RestController
@CrossOrigin
@RequestMapping("api/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	// Lista de Usuarios
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public List<Usuario> listaUsuarios() {
		return usuarioService.listaUsuarios();
	}
	
	// Un Usuario
	@GetMapping("/{nombreUsuario}")
	@PreAuthorize("#nombreUsuario == authentication.principal.username || hasRole('ADMIN')")
	public Usuario verUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
		return usuarioService.getUsuario(nombreUsuario);
	}
	
	// ADD
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@Valid @RequestBody Usuario nuevoUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos erroneos");
    	}
        
        // Codifico el password
        nuevoUsuario.setPassword(passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        // Añado el nuevo Usuario
        usuarioService.add(nuevoUsuario);
	}
	
	// UPDATE
	@PutMapping("/update")
	@PreAuthorize("#usuarioDTO.email == authentication.principal.username || hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void update(@Valid @RequestBody UpdateUsuarioDTO usuarioDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos erroneos");
    	}
		
		Usuario usuario = new Usuario();
		
		usuario.setId(usuarioDTO.getId());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setRol(usuarioDTO.getRol());
		
		usuario.setPassword(usuarioService.getUsuario(usuarioDTO.getOldEmail()).getPassword());
		
		usuarioService.update(usuario);
	}
	
	// UPDATE PASSWORD
	@PutMapping("/updatePassword")
	@PreAuthorize("#updatePasswordDTO.email == authentication.principal.username || hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void updatePassword(@Valid @RequestBody UpdatePasswordDTO updatePasswordDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos erroneos");
    	}
		
		Usuario usuario = usuarioService.getUsuario(updatePasswordDTO.getEmail());
		
		if (usuarioService.checkIfValidOldPassword(usuario, updatePasswordDTO.getOldPassword())) {
			usuarioService.updatePassword(usuario, updatePasswordDTO.getPassword());
	    } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contraseña incorrecta");
		
	}
	
	// DELETE
	@DeleteMapping("/delete/{idUsuario}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idUsuario") Long idUsuario) {
		usuarioService.delete(idUsuario);
	}

}
