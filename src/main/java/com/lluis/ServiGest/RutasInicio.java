package com.lluis.ServiGest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lluis.ServiGest.datos.albaranes.AlbaranDAO;
import com.lluis.ServiGest.datos.clientes.ClienteDAO;
import com.lluis.ServiGest.datos.ordenes.OrdenDAO;
import com.lluis.ServiGest.datos.viviendas.ViviendaDAO;

@Controller
public class RutasInicio {

	@Autowired
	private ViviendaDAO viviendaDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private OrdenDAO ordenDAO;
	
	@Autowired
	private AlbaranDAO albaranDAO;
	
	@GetMapping("/")
	public ModelAndView inicio() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("inicio"); // Nombre de la vista
		model.addObject("numeroViviendas", viviendaDAO.count());
		model.addObject("numeroClientes", clienteDAO.count());
		model.addObject("numeroOrdenes", ordenDAO.count());
		model.addObject("numeroAlbaranes", albaranDAO.count());
		model.addObject("listaOrdenes", ordenDAO.findAll());
		model.addObject("ordenesPendientes", ordenDAO.mostrarPendientes());
		
		return model;
	}
}
