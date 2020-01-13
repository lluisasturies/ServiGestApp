package com.lluis.ServiGest.beans;

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
	
}
