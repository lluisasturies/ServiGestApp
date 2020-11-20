package com.lluis.ServiGest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.dto.JwtDTO;
import com.lluis.ServiGest.dto.LoginUsuario;
import com.lluis.ServiGest.seguridad.jwt.JwtProvider;
import com.lluis.ServiGest.servicios.UsuarioService;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JwtProvider jwtProvider;
    

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        
    	// Validación del usuario y contraseña
    	if (bindingResult.hasErrors()) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos vacíos o email inválido");
    	}
    	
    	// Proceso de autenticación por parte de Spring Security
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword())
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        // Hago uso de un servicio para generar un Token
        String jwt = jwtProvider.generateToken(authentication);
        
        // Obtengo el usuario con su Rol
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        // Lo coloco en el objeto que devolvere con el Token
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity<JwtDTO>(jwtDTO, HttpStatus.OK);
    }
}