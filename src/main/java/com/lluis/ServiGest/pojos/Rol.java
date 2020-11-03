package com.lluis.ServiGest.pojos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lluis.ServiGest.enums.RolNombre;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="roles")
@Getter
@Setter
public class Rol {
    
    @Id
    @Enumerated(EnumType.STRING)
    @NotNull
    private RolNombre rolNombre;
    
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<Usuario> usuarios;
    
}
