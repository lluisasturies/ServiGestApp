package com.lluis.ServiGest.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lluis.ServiGest.enums.RolNombre;
import com.lluis.ServiGest.pojos.Rol;
import com.lluis.ServiGest.repositorios.RolDAO;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolServiceImpl implements RolService {

    @Autowired
    RolDAO rolDAO;

    @Override
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolDAO.findByRolNombre(rolNombre);
    }

	@Override
	public List<Rol> listaRoles() {
		return rolDAO.findAll();
	}
}
