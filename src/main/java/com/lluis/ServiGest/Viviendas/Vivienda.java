package com.lluis.ServiGest.Viviendas;

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

import com.lluis.ServiGest.Aparatos.Aparato;
import com.lluis.ServiGest.Clientes.Cliente;
import com.lluis.ServiGest.Ordenes.Orden;

@Entity
@Table(name="viviendas")
public class Vivienda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idVivienda;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPropietario")
	private Cliente idPropietario; // Cliente asignado como propietario
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idInquilino")
	private Cliente idInquilino; // Cliente asignado como inquilino
	
	@ManyToMany(mappedBy = "idVivienda")
	private List<Aparato> idAparato;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idOrden")
    private List<Orden> ordenes;
	
	@Column
	private String direccion;
	
	@Column
	private String localidad;
	
	@Column
	private String provincia;
	
}
