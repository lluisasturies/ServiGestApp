package com.lluis.ServiGest.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Min(9)
	private Integer telefono;
	
	@Column
	private String dato;
	
	@ManyToOne
	@JoinColumn(name = "idEmpresa")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull
	private Empresa empresa;
	
}
