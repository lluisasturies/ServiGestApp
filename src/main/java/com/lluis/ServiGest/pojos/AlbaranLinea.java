package com.lluis.ServiGest.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="albaranes_lineas")
public class AlbaranLinea {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idLinea;
	
	@ManyToOne
	@JoinColumn(name = "idAlbaran")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Albaran idAlbaran; // Relación con el Albaran
	
	@Column
	private String concepto;
	
	@Column
	private Integer cantidad;
	
	@Column
	private Integer precio;

	
	
	public Integer getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(Integer idLinea) {
		this.idLinea = idLinea;
	}

	public Albaran getIdAlbaran() {
		return idAlbaran;
	}

	public void setIdAlbaran(Albaran idAlbaran) {
		this.idAlbaran = idAlbaran;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
}
