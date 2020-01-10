package com.lluis.ServiGest.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lluis.ServiGest.beans.Empresa;

@Controller
public class RutasEmpresas {

	/*
	 * Ruta de la lista de empresas
	 * 
	 */
	@GetMapping("/empresas")
	public ModelAndView empresas() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("empresas/empresas"); // Nombre de la vista
		
		return model;
	}
	
	/*
	 * Ruta de una empresa {idEmpresa}
	 * 
	 */
	@GetMapping("/empresas/ver/{idEmpresa}")
	public ModelAndView verEmpresa(@PathVariable Integer idEmpresa) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("empresas/verEmpresa"); // Nombre de la vista
		
		return model;
	}
	
	
	/*
	 * Post que añade una empresa
	 * 
	 */
	@PostMapping("/ordenes/add")
	public ModelAndView addVivienda(@ModelAttribute Empresa empresa) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/empresas");
		
		return model;
	}
	
	/*
	 * Post que edita una empresa
	 * 
	 */	
	@PostMapping("/empresas/update")
	public ModelAndView updateVivienda(@ModelAttribute Empresa empresa) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/empresas");
		
		return model;
	}
	
	/*
	 * Post que borra una empresa
	 * 
	 */
	@PostMapping("/empresas/delete/{idEmpresa}")
	public ModelAndView deleteVivienda(@PathVariable Integer idEmpresa) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/empresas");
		
		return model;
	}
}
