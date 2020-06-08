package com.lluis.ServiGest.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="viviendas")
public class Vivienda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idVivienda;
	
	@ManyToOne
	@JoinColumn(name = "idPropietario")
	private Cliente propietario; // Cliente asignado como propietario
	
	@ManyToOne
	@JoinColumn(name = "idInquilino")
	private Cliente inquilino; // Cliente asignado como inquilino
	
	@OneToMany(mappedBy = "vivienda")
	private List<ViviendaAparato> aparatos;	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "vivienda")
    private List<Orden> ordenes;
	
	@Column
	private String direccion;
	
	@Column
	private String localidad;
	
	@Column
	private String provincia;
	
	
	
	public Integer getIdVivienda() {
		return idVivienda;
	}

	public void setIdVivienda(Integer idVivienda) {
		this.idVivienda = idVivienda;
	}

	public Cliente getIdPropietario() {
		return propietario;
	}
	
	
	public void setIdPropietario(Cliente idPropietario) {
		this.propietario = idPropietario;
	}

	public Cliente getIdInquilino() {
		return inquilino;
	}

	public void setIdInquilino(Cliente idInquilino) {
		this.inquilino = idInquilino;
	}

	public List<ViviendaAparato> getAparatos() {
		return aparatos;
	}

	public void setAparatos(List<ViviendaAparato> aparatos) {
		this.aparatos = aparatos;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
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
	
	
}