package com.lluis.ServiGest.datos.viviendas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lluis.ServiGest.datos.aparatos.Aparato;
import com.lluis.ServiGest.datos.clientes.Cliente;
import com.lluis.ServiGest.datos.ordenes.Orden;

@Entity
@Table(name="viviendas")
public class Vivienda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idVivienda;
	
	@ManyToOne
	@JoinColumn(name = "idPropietario")
	private Cliente idPropietario; // Cliente asignado como propietario
	
	@ManyToOne
	@JoinColumn(name = "idInquilino")
	private Cliente idInquilino; // Cliente asignado como inquilino
	
	@ManyToMany(mappedBy = "idVivienda")
	private List<Aparato> idAparato;
	
	@OneToMany(mappedBy = "idVivienda")
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
		return idPropietario;
	}

	public void setIdPropietario(Cliente idPropietario) {
		this.idPropietario = idPropietario;
	}

	public Cliente getIdInquilino() {
		return idInquilino;
	}

	public void setIdInquilino(Cliente idInquilino) {
		this.idInquilino = idInquilino;
	}

	public List<Aparato> getIdAparato() {
		return idAparato;
	}

	public void setIdAparato(List<Aparato> idAparato) {
		this.idAparato = idAparato;
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
