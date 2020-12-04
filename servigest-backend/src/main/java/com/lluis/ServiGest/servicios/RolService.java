package com.lluis.ServiGest.servicios;

import java.util.List;
import java.util.Optional;

import com.lluis.ServiGest.enums.RolNombre;
import com.lluis.ServiGest.pojos.Rol;

public interface RolService {
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre);

	public List<Rol> listaRoles();
	
}
