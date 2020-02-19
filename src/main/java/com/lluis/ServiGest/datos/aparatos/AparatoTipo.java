package com.lluis.ServiGest.datos.aparatos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="aparatos_tipos")
public class AparatoTipo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTipo;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "idAparato")
	private List<Aparato> aparatos;
	
	@Column
	private String tipo;

	
	
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
