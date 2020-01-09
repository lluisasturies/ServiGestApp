package com.lluis.ServiGest.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lluis.ServiGest.beans.Orden;
import com.lluis.ServiGest.beans.Vivienda;

@Controller
public class RutasOrdenes {

	/*
	 * Ruta de la lista de ordenes
	 * 
	 */
	@GetMapping("/ordenes")
	public ModelAndView ordenes() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("ordenes/ordenes"); // Nombre de la vista
		
		return model;
	}
	
	/*
	 * Ruta de una orden {idOrden}
	 * 
	 */
	@GetMapping("/ordenes/ver/{idOrden}")
	public ModelAndView verVivienda(@PathVariable Integer idOrden) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("ordenes/verOrden"); // Nombre de la vista
		
		return model;
	}
	
	
	/*
	 * Post que añade una orden
	 * 
	 */
	@PostMapping("/ordenes/add")
	public ModelAndView addVivienda(@ModelAttribute Orden orden) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/ordenes");
		
		return model;
	}
	
	/*
	 * Post que edita una orden
	 * 
	 */	
	@PostMapping("/ordenes/update")
	public ModelAndView updateVivienda(@ModelAttribute Orden orden) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/ordenes");
		
		return model;
	}
	
	/*
	 * Post que borra una vivienda
	 * 
	 */
	@PostMapping("/ordenes/delete/{idOrden}")
	public ModelAndView deleteVivienda(@PathVariable Integer idOrden) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/ordenes");
		
		return model;
	}
}
