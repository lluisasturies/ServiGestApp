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
@Table(name="ordenes_citas")
public class OrdenCita {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idCita;
	
	@ManyToOne
	@JoinColumn(name = "idOrden")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull
	private Orden orden;
	
	@Column
	private LocalDate fecha;
	
	
	
	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
}
