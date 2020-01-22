package com.lluis.ServiGest.Clientes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lluis.ServiGest.Viviendas.Vivienda;

@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idCliente;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idPropietario")
    private List<Vivienda> viviendasPropietario;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idInquilino")
    private List<Vivienda> viviendasInquilino;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idContacto")
    private List<ClienteContacto> contactos;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
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
