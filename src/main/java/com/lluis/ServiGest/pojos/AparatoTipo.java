package com.lluis.ServiGest.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="aparatos_tipos")
public class AparatoTipo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTipo;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tipo")
	@JsonIgnore
	private List<Aparato> aparatos;
	
	@Column
	@NotNull
	private String nombre;

	
	
	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public List<Aparato> getAparatos() {
		return aparatos;
	}

	public void setAparatos(List<Aparato> aparatos) {
		this.aparatos = aparatos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
