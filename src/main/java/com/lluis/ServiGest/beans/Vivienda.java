package com.lluis.ServiGest.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="viviendas")
public class Vivienda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idVivienda;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPropietario")
	private Cliente idPropietario; // Cliente asignado como propietario
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idInquilino")
	private Cliente idInquilino; // Cliente asignado como inquilino
	
	@Column
	private String direccion;
	
	@Column
	private String localidad;
	
	@Column
	private String provincia;
	
}
