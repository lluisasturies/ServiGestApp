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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="ordenes")
public class Orden {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idOrden;
	
	@ManyToOne
	@JoinColumn(name = "idVivienda")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Vivienda vivienda; // Relación con la Vivienda
	
	@ManyToOne
	@JoinColumn(name = "idEmpresa")
	private Empresa empresa; // Relación con la Empresa
	
	@OneToMany(mappedBy = "orden")
	private List<OrdenLinea> idTrabajo;
	
	@Column
	private String orden;
	
	@Column
	private String asunto;
	
	@Column
	private LocalDate fecha;
	
	@Column(columnDefinition = "BIT DEFAULT 1")
	private byte estado;
	
	

	public Integer getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public Vivienda getIdVivienda() {
		return vivienda;
	}

	public void setIdVivienda(Vivienda idVivienda) {
		this.vivienda = idVivienda;
	}

	public Empresa getIdEmpresa() {
		return empresa;
	}

	public void setIdEmpresa(Empresa idEmpresa) {
		this.empresa = idEmpresa;
	}
	
	public List<OrdenLinea> getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(List<OrdenLinea> idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public byte getEstado() {
		return estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
}
