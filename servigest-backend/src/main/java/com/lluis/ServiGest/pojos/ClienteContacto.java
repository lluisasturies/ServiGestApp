package com.lluis.ServiGest.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="clientes_contactos")
@Getter
@Setter
public class ClienteContacto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idContacto;
	
	@ManyToOne
	@JoinColumn(name = "idCliente")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Cliente cliente;
	
	@Column
	@NotNull
	private String contacto;
	
	@Column
	@NotNull
	private Integer telefono;
	
	@Column
	@NotNull
	@Email
	private String email;

}