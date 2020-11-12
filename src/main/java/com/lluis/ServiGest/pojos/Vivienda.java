package com.lluis.ServiGest.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="viviendas")
@Getter
@Setter
public class Vivienda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idVivienda;
	
	@ManyToOne
	@JoinColumn(name = "idPropietario")
	private Cliente propietario;
	
	@ManyToOne
	@JoinColumn(name = "idInquilino")
	private Cliente inquilino;
	
	@OneToMany(mappedBy = "vivienda", cascade = CascadeType.REMOVE)
	private List<ViviendaAparato> aparatos;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "vivienda")
	@JsonManagedReference
    private List<Orden> ordenes;
	
	@Column
	@NotNull
	private String direccion;
	
	@Column
	@NotNull
	private String localidad;
	
	@Column
	@NotNull
	private String provincia;
	
}