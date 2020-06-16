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

@Entity
@Table(name="clientes")
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
    private List<ClienteContacto> contactos;
	
	@Column
	@NotNull
	private String nombre;
	
	@Column
	@NotNull
	private String apellidos;
	
	@Column
	@NotNull
	private String dni;

	
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public List<Vivienda> getViviendasPropietario() {
		return viviendasPropietario;
	}

	public void setViviendasPropietario(List<Vivienda> viviendasPropietario) {
		this.viviendasPropietario = viviendasPropietario;
	}

	public List<Vivienda> getViviendasInquilino() {
		return viviendasInquilino;
	}

	public void setViviendasInquilino(List<Vivienda> viviendasInquilino) {
		this.viviendasInquilino = viviendasInquilino;
	}

	public List<ClienteContacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<ClienteContacto> contactos) {
		this.contactos = contactos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
