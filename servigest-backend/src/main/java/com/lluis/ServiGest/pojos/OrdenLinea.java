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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ordenes_lineas")
@Getter
@Setter
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
	
}
