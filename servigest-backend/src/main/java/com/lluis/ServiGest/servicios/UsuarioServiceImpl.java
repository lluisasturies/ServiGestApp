package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.lluis.ServiGest.pojos.Usuario;
import com.lluis.ServiGest.repositorios.UsuarioDAO;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Override
	public List<Usuario> listaUsuarios() {
		return (List<Usuario>) usuarioDAO.findAll();
	}

    @Override
    public Usuario getUsuario(String nu) {
        return usuarioDAO.findByEmail(nu);
    }
    
    @Override
    public void add(Usuario usuario) {
    	if (!usuarioDAO.existsByEmail(usuario.getEmail())) {
    		usuarioDAO.save(usuario);
    	} else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El email ya existe");
        
    }

	@Override
	public void update(Usuario usuario) {
		if (usuarioDAO.existsById(usuario.getId())) {
			usuarioDAO.save(usuario);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
	}
	
	@Override
	public void updatePassword(Usuario usuario, String password) {
		if (usuarioDAO.existsById(usuario.getId())) {
			usuario.setPassword(passwordEncoder.encode(password));
			
			usuarioDAO.save(usuario);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
	}
	
	@Override
	public boolean checkIfValidOldPassword(Usuario usuario, String oldPassword) {
		
		if (passwordEncoder.matches(oldPassword, usuario.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void delete(Long idUsuario) {
		if (usuarioDAO.existsById(idUsuario)) {
			Usuario usuario = usuarioDAO.findById(idUsuario).get();
			usuarioDAO.delete(usuario);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
	}

}
