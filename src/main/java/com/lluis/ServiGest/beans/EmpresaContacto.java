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
@Table(name="empresas_contactos")
public class EmpresaContacto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idContacto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEmpresa")
	private Empresa idEmpresa; // Relación con la Empresa
	
	@Column
	private String nombre;
	
	@Column
	private Integer telefono;
	
	@Column
	private String email;
	
}
