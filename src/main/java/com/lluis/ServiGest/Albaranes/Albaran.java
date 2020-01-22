package com.lluis.ServiGest.Albaranes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lluis.ServiGest.Ordenes.Orden;

@Entity
@Table(name="albaranes")
public class Albaran {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idAlbaran;
	
	@OneToOne
	@JoinColumn(name = "idOrden")
	private Orden idOrden; // Relación con la Orden
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idLinea")
    private List<AlbaranLinea> lineas;
	
	@Column
	private String codigoAlbaran;
	
	@Column
	private String fecha; // Ver que tipo es el date de MySQL en Java

	
	
	public Integer getIdAlbaran() {
		return idAlbaran;
	}

	public void setIdAlbaran(Integer idAlbaran) {
		this.idAlbaran = idAlbaran;
	}

	public Orden getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Orden idOrden) {
		this.idOrden = idOrden;
	}

	public List<AlbaranLinea> getLineas() {
		return lineas;
	}

	public void setLineas(List<AlbaranLinea> lineas) {
		this.lineas = lineas;
	}

	public String getCodigoAlbaran() {
		return codigoAlbaran;
	}

	public void setCodigoAlbaran(String codigoAlbaran) {
		this.codigoAlbaran = codigoAlbaran;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
