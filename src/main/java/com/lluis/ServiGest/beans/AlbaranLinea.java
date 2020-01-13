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
@Table(name="albaranes_lineas")
public class AlbaranLinea {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idLinea;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAlbaran")
	private Albaran idAlbaran; // Relación con el Albaran
	
	@Column
	private String concepto;
	
	@Column
	private Integer cantidad;
	
	@Column
	private Integer precio;
	
}
