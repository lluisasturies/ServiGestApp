package com.lluis.ServiGest.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="empresas_telefonos")
@Getter
@Setter
public class EmpresaTelefono {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTelefono;
	
	@ManyToOne
	@JoinColumn(name = "idEmpresa")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull
	private Empresa empresa;
	
	@Column
	private Integer telefono;
	
	@Column
	private String informacion;
	
}
