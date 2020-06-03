package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lluis.ServiGest.pojos.Usuario;
import com.lluis.ServiGest.repositorios.UsuarioDAO;

import java.util.Optional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Override
    public Optional<Usuario> getByNombreUsuario(String nu) {
        return usuarioDAO.findByNombreUsuario(nu);
    }

    @Override
    public boolean existePorNombre(String nu) {
        return usuarioDAO.existsByNombreUsuario(nu);
    }

    @Override
    public boolean existePorEmail(String email) {
        return usuarioDAO.existsByEmail(email);
    }

    @Override
    public void add(Usuario usuario) {
        usuarioDAO.save(usuario);
    }
}
