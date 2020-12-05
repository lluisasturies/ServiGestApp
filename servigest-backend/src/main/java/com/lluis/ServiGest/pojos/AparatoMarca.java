package com.lluis.ServiGest.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="aparatos_marcas")
@Getter
@Setter
public class AparatoMarca {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idMarca;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "marca")
	@JsonIgnore
	private List<Aparato> aparatos;
	
	@Column(unique = true)
	@NotNull
	private String nombre;
	
}
