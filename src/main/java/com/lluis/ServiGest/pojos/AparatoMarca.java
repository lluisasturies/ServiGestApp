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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="aparatos_marcas")
public class AparatoMarca {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idMarca;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idMarca")
	@JsonIgnore
	private List<Aparato> aparatos;
	
	@Column
	private String marca;

	
	
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
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
