package com.lluis.ServiGest.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="empresas_contactos")
public class EmpresaContacto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idContacto;
	
	@ManyToOne
	@JoinColumn(name = "idEmpresa")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull
	private Empresa empresa; // Relación con la Empresa
	
	@Column
	@NotNull
	private String nombre;
	
	@Column
	@NotNull
	private Integer telefono;
	
	@Column
	@NotNull
	@Email
	private String email;

	
	
	public Integer getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(Integer idContacto) {
		this.idContacto = idContacto;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
