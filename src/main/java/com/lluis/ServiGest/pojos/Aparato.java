package com.lluis.ServiGest.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="aparatos")
public class Aparato {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idAparato;
	
	@ManyToOne
	@JoinColumn(name = "idTipo")
	private AparatoTipo tipo; // Relación con el AparatoTipo
	
	@ManyToOne
	@JoinColumn(name = "idMarca")
	private AparatoMarca marca; // Relación con el AparatoMarca
	
	@OneToMany(mappedBy = "aparato")
	@JsonIgnore
	private List<ViviendaAparato> viviendas;
	
	@Column
	private String modelo;

	
	
	public Integer getIdAparato() {
		return idAparato;
	}

	public void setIdAparato(Integer idAparato) {
		this.idAparato = idAparato;
	}

	public AparatoTipo getIdTipo() {
		return tipo;
	}

	public void setIdTipo(AparatoTipo idTipo) {
		this.tipo = idTipo;
	}

	public AparatoMarca getIdMarca() {
		return marca;
	}

	public void setIdMarca(AparatoMarca idMarca) {
		this.marca = idMarca;
	}

	public List<ViviendaAparato> getViviendas() {
		return viviendas;
	}

	public void setIdVivienda(List<ViviendaAparato> viviendas) {
		this.viviendas = viviendas;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}