package com.lluis.ServiGest.Aparatos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lluis.ServiGest.Viviendas.Vivienda;

@Entity
@Table(name="aparatos")
public class Aparato {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idAparato;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipo")
	private AparatoTipo idTipo; // Relación con el AparatoTipo
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMarca")
	private AparatoMarca idMarca; // Relación con el AparatoMarca
	
	@ManyToMany
	private List<Vivienda> idVivienda;
	
	@Column
	private String modelo;

	
	
	public Integer getIdAparato() {
		return idAparato;
	}

	public void setIdAparato(Integer idAparato) {
		this.idAparato = idAparato;
	}

	public AparatoTipo getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(AparatoTipo idTipo) {
		this.idTipo = idTipo;
	}

	public AparatoMarca getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(AparatoMarca idMarca) {
		this.idMarca = idMarca;
	}

	public List<Vivienda> getIdVivienda() {
		return idVivienda;
	}

	public void setIdVivienda(List<Vivienda> idVivienda) {
		this.idVivienda = idVivienda;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
