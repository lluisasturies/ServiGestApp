package com.lluis.ServiGest.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="empresas")
@Getter
@Setter
public class Empresa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idEmpresa;
	
	@OneToMany(mappedBy = "empresa")
    private List<EmpresaTelefono> telefonos;
	
	@OneToMany(mappedBy = "empresa")
    private List<EmpresaEmail> emails;
	
	@OneToMany(mappedBy = "empresa")
	@JsonIgnore
    private List<Orden> ordenes;
	
	@Column(unique = true)
	@NotNull
	private String nombreComercial;
	
	@Column(unique = true)
	@NotNull
	private String nombreFiscal;
	
	@Column(unique = true)
	@NotNull
	private String nif;
	
	@Column
	@NotNull
	private String direccion;
	
	@Column
	@NotNull
	private String localidad;
	
	@Column
	@NotNull
	private String provincia;
	
	@Column(unique = true)
	@NotNull
	private String prefijoOrdenes;
	
}
