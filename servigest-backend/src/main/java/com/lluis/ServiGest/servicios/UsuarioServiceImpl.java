package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lluis.ServiGest.pojos.Usuario;
import com.lluis.ServiGest.repositorios.UsuarioDAO;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;
    
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
        usuarioDAO.save(usuario);
    }

	@Override
	public void update(Usuario usuario) {
		if (usuarioDAO.existsById(usuario.getId())) {
			usuarioDAO.save(usuario);
		}
	}

	@Override
	public void delete(Long idUsuario) {
		if (usuarioDAO.existsById(idUsuario)) {
			Usuario usuario = usuarioDAO.findById(idUsuario).get();
			usuarioDAO.delete(usuario);
		}
	}

    @Override
    public boolean existePorEmail(String email) {
        return usuarioDAO.existsByEmail(email);
    }

}
