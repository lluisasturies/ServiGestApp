package com.lluis.ServiGest.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="ordenes_lineas")
public class OrdenLinea {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idLinea;
	
	@ManyToOne
	@JoinColumn(name = "idOrden")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull
	private Orden orden;
	
	@Column
	@NotNull
	private String concepto;
	
	@Column
	@NotNull
	private LocalDate fecha;

	
	
	public Integer getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(Integer idLinea) {
		this.idLinea = idLinea;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
}
