package com.lluis.ServiGest.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="clientes_contactos")
public class ClienteContacto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idContacto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente")
	private Cliente idCliente; // Relación con el Cliente
	
	@Column
	private String contacto;
	
	@Column
	private Integer telefono;
	
	@Column
	private String email;
	
}
