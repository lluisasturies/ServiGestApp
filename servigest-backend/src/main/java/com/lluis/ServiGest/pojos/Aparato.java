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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="aparatos")
public class Aparato {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idAparato;
	
	@ManyToOne
	@JoinColumn(name = "idTipo")
	@NotNull
	private AparatoTipo tipo;
	
	@ManyToOne
	@JoinColumn(name = "idMarca")
	@NotNull
	private AparatoMarca marca;
	
	@OneToMany(mappedBy = "aparato")
	@JsonIgnore
	private List<ViviendaAparato> viviendas;
	
	@Column(unique = true)
	@NotNull
	private String modelo;

	
	
	public Integer getIdAparato() {
		return idAparato;
	}

	public void setIdAparato(Integer idAparato) {
		this.idAparato = idAparato;
	}

	public AparatoTipo getTipo() {
		return tipo;
	}

	public void setTipo(AparatoTipo tipo) {
		this.tipo = tipo;
	}

	public AparatoMarca getMarca() {
		return marca;
	}

	public void setMarca(AparatoMarca marca) {
		this.marca = marca;
	}

	public List<ViviendaAparato> getViviendas() {
		return viviendas;
	}

	public void setViviendas(List<ViviendaAparato> viviendas) {
		this.viviendas = viviendas;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}