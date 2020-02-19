package com.lluis.ServiGest.datos.empresas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lluis.ServiGest.datos.ordenes.Orden;

@Entity
@Table(name="empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idEmpresa;
	
	@OneToMany(mappedBy = "idContacto")
    private List<EmpresaContacto> contactos;
	
	@OneToMany(mappedBy = "idEmpresa")
    private List<Orden> ordenes;
	
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

	
	
	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public List<EmpresaContacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<EmpresaContacto> contactos) {
		this.contactos = contactos;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getNombreFiscal() {
		return nombreFiscal;
	}

	public void setNombreFiscal(String nombreFiscal) {
		this.nombreFiscal = nombreFiscal;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
