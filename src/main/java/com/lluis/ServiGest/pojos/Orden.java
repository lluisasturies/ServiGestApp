package com.lluis.ServiGest.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ordenes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orden {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idOrden;
	
	@ManyToOne
	@JoinColumn(name = "idVivienda")
	//@JsonProperty(access = Access.WRITE)s
	@JsonIgnoreProperties(allowSetters = true, value = {"ordenes"})
	@NotNull
	private Vivienda vivienda;
	
	@ManyToOne
	@JoinColumn(name = "idEmpresa")
	@NotNull
	private Empresa empresa;
	
	@OneToMany(mappedBy = "orden")
	private List<OrdenLinea> lineas;
	
	@OneToMany(mappedBy = "orden")
	@Where(clause = "fecha > CURRENT_TIMESTAMP()")
	private List<OrdenCita> citasPendientes;
	
	@OneToMany(mappedBy = "orden")
	private List<OrdenCita> citas;
	
	@Column
	@NotNull
	private String orden;
	
	@Column
	@NotNull
	private String asunto;
	
	@Column
	@NotNull
	private LocalDate fecha;
	
	@Column
	@NotNull
	private boolean estado = true;
	
}
