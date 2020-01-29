package com.lluis.ServiGest.datos.clientes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RutasClientes {

	/*
	 * Ruta de la lista de clientes
	 * 
	 */
	@GetMapping("/clientes")
	public ModelAndView clientes() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("clientes/clientes"); // Nombre de la vista
		
		return model;
	}
	
	/*
	 * Ruta de un cliente {idCliente}
	 * 
	 */
	@GetMapping("/clientes/ver/{idCliente}")
	public ModelAndView verCliente(@PathVariable Integer idCliente) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("clientes/verCliente"); // Nombre de la vista
		
		return model;
	}
	
	
	/*
	 * Post que añade un cliente
	 * 
	 */
	@PostMapping("/clientes/add")
	public ModelAndView addCliente(@ModelAttribute Cliente cliente) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/clientes");
		
		return model;
	}
	
	/*
	 * Post que edita un cliente
	 * 
	 */	
	@PostMapping("/clientes/update")
	public ModelAndView updateCliente(@ModelAttribute Cliente cliente) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/clientes");
		
		return model;
	}
	
	/*
	 * Post que borra un cliente
	 * 
	 */
	@PostMapping("/clientes/delete/{idCliente}")
	public ModelAndView deleteVivienda(@PathVariable Integer idCliente) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/clientes");
		
		return model;
	}
}
