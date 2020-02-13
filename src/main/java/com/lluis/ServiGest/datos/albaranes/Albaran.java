package com.lluis.ServiGest.datos.albaranes;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lluis.ServiGest.datos.ordenes.Orden;

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
	
	@Temporal(TemporalType.DATE)
	private Date fecha;

	
	
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
