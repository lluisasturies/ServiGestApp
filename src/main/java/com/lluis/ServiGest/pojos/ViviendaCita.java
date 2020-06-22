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
@Table(name="viviendas_citas")
public class ViviendaCita {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idCita;
	
	@ManyToOne
	@JoinColumn(name = "idVivienda")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull
	private Vivienda vivienda;
	
	@Column
	private LocalDate fecha;
	
	
	
	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
}
