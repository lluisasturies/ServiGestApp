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

import com.lluis.ServiGest.dto.JwtDTO;
import com.lluis.ServiGest.dto.LoginUsuario;
import com.lluis.ServiGest.dto.NuevoUsuario;
import com.lluis.ServiGest.enums.RolNombre;
import com.lluis.ServiGest.pojos.Rol;
import com.lluis.ServiGest.pojos.Usuario;
import com.lluis.ServiGest.seguridad.jwt.JwtProvider;
import com.lluis.ServiGest.servicios.RolServiceImpl;
import com.lluis.ServiGest.servicios.UsuarioServiceImpl;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioServiceImpl usuarioService;

    @Autowired
    RolServiceImpl rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<NuevoUsuario> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
    	
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("Campos vacíos o email inválido", HttpStatus.BAD_REQUEST);
    	}
        
        if (usuarioService.existePorNombre(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity("El nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        
        if (usuarioService.existePorEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity("El email ya existe", HttpStatus.BAD_REQUEST);
        }
        
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), 
        		nuevoUsuario.getNombreUsuario(), 
        		nuevoUsuario.getEmail(), 
        		passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<String> rolesStr = nuevoUsuario.getRoles();
        Set<Rol> roles = new HashSet<>();
        
        for (String rol : rolesStr) {
            switch (rol) {
                case "admin":
                    Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
                    roles.add(rolAdmin);
                    break;
                default:
                    Rol rolTecnico = rolService.getByRolNombre(RolNombre.ROLE_TECNICO).get();
                    roles.add(rolTecnico);
            }
        }
        
        usuario.setRoles(roles);
        usuarioService.add(usuario);
        
        return new ResponseEntity("usuario guardado", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity("campos vacíos o email inválido", HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword())
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity<JwtDTO>(jwtDTO, HttpStatus.OK);
    }
}