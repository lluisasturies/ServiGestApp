package com.lluis.ServiGest.pojos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lluis.ServiGest.enums.RolNombre;
import com.sun.istack.NotNull;

@Entity
@Table(name="roles")
public class Rol {
    
    @Id
    @Enumerated(EnumType.STRING)
    @NotNull
    private RolNombre rolNombre;

    
    
    public Rol() {
    }

    public Rol(@NotNull RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
