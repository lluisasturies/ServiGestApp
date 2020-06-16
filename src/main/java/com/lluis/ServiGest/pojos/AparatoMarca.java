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
@Table(name="aparatos_marcas")
public class AparatoMarca {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idMarca;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "marca")
	@JsonIgnore
	private List<Aparato> aparatos;
	
	@Column
	@NotNull
	private String nombre;

	
	
	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public List<Aparato> getAparatos() {
		return aparatos;
	}

	public void setAparatos(List<Aparato> aparatos) {
		this.aparatos = aparatos;
	}

	public String getMarca() {
		return nombre;
	}

	public void setMarca(String marca) {
		this.nombre = marca;
	}
	
}
