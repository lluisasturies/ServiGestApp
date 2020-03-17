package com.lluis.ServiGest.datos.viviendas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lluis.ServiGest.datos.aparatos.Aparato;
import com.lluis.ServiGest.datos.aparatos.AparatoDAO;

@Controller
public class RutasViviendas {

	@Autowired
	public ViviendaDAO viviendaDAO;
	
	@Autowired
	public AparatoDAO aparatoDAO;
	
	/*
	 * Ruta de la lista de viviendas
	 * 
	 */
	@GetMapping("/viviendas")
	public ModelAndView viviendas() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("viviendas/viviendas"); // Nombre de la vista
		
		List<Vivienda> listaViviendas = (List<Vivienda>) viviendaDAO.findAll();
		model.addObject("listaViviendas", listaViviendas);
		
		return model;
	}
	
	/*
	 * Ruta de una vivienda {idVivienda}
	 * 
	 */
	@GetMapping("/viviendas/ver/{idVivienda}")
	public ModelAndView verVivienda(@PathVariable Integer idVivienda) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("viviendas/verVivienda"); // Nombre de la vista
		
		// Obtengo la vivienda concreta
		Vivienda vivienda = viviendaDAO.findById(idVivienda).get();
		
		// Obtengo la lista de aparatos de esta vivienda
		List<Aparato> aparato = (List<Aparato>) aparatoDAO.aparatosPorVivienda(idVivienda);
		
		// Lo añado a la vista...
		model.addObject("vivienda", vivienda);
		model.addObject("listaAparatos", aparato);
		
		return model;
	}
	
	
	/*
	 * Post que añade una vivienda
	 * 
	 */
	@PostMapping("/viviendas/add")
	public ModelAndView addVivienda(@ModelAttribute Vivienda vivienda) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/viviendas");
		
		return model;
	}
	
	/*
	 * Post que edita una vivienda
	 * 
	 */	
	@PostMapping("/viviendas/update")
	public ModelAndView updateVivienda(@ModelAttribute Vivienda vivienda) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/viviendas");
		
		return model;
	}
	
	/*
	 * Post que borra una vivienda
	 * 
	 */
	@PostMapping("/viviendas/delete/{idVivienda}")
	public ModelAndView deleteVivienda(@PathVariable Integer idVivienda) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/viviendas");
		
		return model;
	}
}
