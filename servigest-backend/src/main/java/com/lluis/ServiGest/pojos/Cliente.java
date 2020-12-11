package com.lluis.ServiGest.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="clientes")
@Getter
@Setter
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idCliente;
	
	@OneToMany(mappedBy = "propietario")
	@JsonIgnore
    private List<Vivienda> viviendasPropietario;
	
	@OneToMany(mappedBy = "inquilino")
	@JsonIgnore
    private List<Vivienda> viviendasInquilino;
	
	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private List<Albaran> albaranes;
	
	@OneToMany(mappedBy = "cliente")
    private List<ClienteTelefono> telefonos;
	
	@OneToMany(mappedBy = "cliente")
    private List<ClienteEmail> emails;
	
	@Column
	@NotNull
	private String nombre;
	
	@Column
	@NotNull
	private String apellidos;
	
	@Column(unique = true)
	private String dni;
	
}
