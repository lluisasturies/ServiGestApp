package com.lluis.ServiGest.pojos;

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
@Table(name="albaranes_lineas")
@Getter
@Setter
public class AlbaranLinea {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idLinea;
	
	@ManyToOne
	@JoinColumn(name = "idAlbaran")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull
	private Albaran albaran;
	
	@Column
	@NotNull
	private String concepto;
	
	@Column
	@NotNull
	private Integer cantidad;
	
	@Column
	@NotNull
	private Integer precio;

}
