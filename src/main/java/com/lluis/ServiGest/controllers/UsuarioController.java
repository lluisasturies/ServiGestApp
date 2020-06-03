package com.lluis.ServiGest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.lluis.ServiGest.servicios.UsuarioService;
import com.lluis.ServiGest.pojos.Usuario;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
	@PreAuthorize("#nombreusuario == authentication.principal.username || hasRole('ADMIN')")
	public Usuario verUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
		return usuarioService.getUsuario(nombreUsuario);
	}
	
	// ADD
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity add(@Valid @RequestBody Usuario nuevoUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return new ResponseEntity("Campos erroneos", HttpStatus.BAD_REQUEST);
    	}
        
        if (usuarioService.existePorNombre(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity("El nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        
        if (usuarioService.existePorEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity("El email ya existe", HttpStatus.BAD_REQUEST);
        }
        
        // Codifico el password
        nuevoUsuario.setPassword(passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        // Añado el nuevo Usuario
        usuarioService.add(nuevoUsuario);
        
        return new ResponseEntity(HttpStatus.CREATED);
	}
	
	// UPDATE
	@PutMapping("/update")
	@PreAuthorize("#nombreusuario == authentication.principal.username || hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Usuario usuario) {
		usuarioService.update(usuario);
	}
	
	// DELETE
	@DeleteMapping("/delete/{idUsuario}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idUsuario") Long idUsuario) {
		usuarioService.delete(idUsuario);
	}

}
