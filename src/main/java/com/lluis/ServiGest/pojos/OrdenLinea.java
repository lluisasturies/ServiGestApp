package com.lluis.ServiGest.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordenes_lineas")
public class OrdenLinea {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTrabajo;
	
	@ManyToOne
	@JoinColumn(name = "idOrden")
	private Orden idOrden;
	
	@Column
	private String concepto;
	
	@Column
	private Integer cantidad;
}
