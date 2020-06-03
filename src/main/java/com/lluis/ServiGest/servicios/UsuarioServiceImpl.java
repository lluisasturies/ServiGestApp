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
    UsuarioDAO usuarioRepository;

    @Override
    public Optional<Usuario> getByNombreUsuario(String nu) {
        return usuarioRepository.findByNombreUsuario(nu);
    }

    @Override
    public boolean existePorNombre(String nu) {
        return usuarioRepository.existsByNombreUsuario(nu);
    }

    @Override
    public boolean existePorEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
