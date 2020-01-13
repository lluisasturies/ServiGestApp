package com.lluis.ServiGest.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idEmpresa;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idContacto")
    private List<EmpresaContacto> contactos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idOrden")
    private List<Orden> empresas;
	
	@Column
	private String nombreComercial;
	
	@Column
	private String nombreFiscal;
	
	@Column
	private String nif;
	
	@Column
	private String direccion;
	
	@Column
	private String localidad;
	
	@Column
	private String provincia;
	
	@Column
	private String email;
	
}
