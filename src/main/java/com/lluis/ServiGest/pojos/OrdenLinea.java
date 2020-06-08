package com.lluis.ServiGest.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="ordenes_lineas")
public class OrdenLinea {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTrabajo;
	
	@ManyToOne
	@JoinColumn(name = "idOrden")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Orden orden;
	
	@Column
	private String concepto;
	
	@Column
	private Integer cantidad;

	
	
	public Integer getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(Integer idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public Orden getIdOrden() {
		return orden;
	}

	public void setIdOrden(Orden idOrden) {
		this.orden = idOrden;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
