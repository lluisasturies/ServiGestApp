package com.lluis.ServiGest.Aparatos;

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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idAparato")
	private List<Aparato> aparatos;
	
	@Column
	private String tipo;
	
}
