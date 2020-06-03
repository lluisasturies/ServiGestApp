package com.lluis.ServiGest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lluis.ServiGest.pojos.Aparato;
import com.lluis.ServiGest.pojos.Cliente;
import com.lluis.ServiGest.pojos.Vivienda;
import com.lluis.ServiGest.pojos.ViviendaAparato;
import com.lluis.ServiGest.repositorios.AparatoDAO;
import com.lluis.ServiGest.repositorios.ClienteDAO;
import com.lluis.ServiGest.repositorios.ViviendaAparatoDAO;
import com.lluis.ServiGest.repositorios.ViviendaDAO;

@Controller
public class RutasViviendas {

	@Autowired
	private ViviendaDAO viviendaDAO;
	
	@Autowired
	private AparatoDAO aparatoDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private ViviendaAparatoDAO viviendaAparatoDAO;
	
	
	/*
	 * LISTA de Viviendas
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
	 * VER Vivienda {idVivienda}
	 * 
	 */
	@GetMapping("/viviendas/ver/{idVivienda}")
	public ModelAndView verVivienda(@PathVariable Integer idVivienda) {
		
		ModelAndView model = new ModelAndView();
		
		// Si la vivienda existe...
		if (viviendaDAO.existsById(idVivienda)) {
			
			model.setViewName("viviendas/verVivienda"); // Nombre de la vista
			
			// Obtengo la vivienda concreta
			Vivienda vivienda = viviendaDAO.findById(idVivienda).get();
			
			// Obtengo la lista de aparatos de esta vivienda			
			List<ViviendaAparato> aparatosVivienda = (List<ViviendaAparato>) viviendaAparatoDAO.aparatosPorVivienda(idVivienda);
			
			// Obtengo la lista de TODOS los aparatos
			List<Aparato> todosAparatos = (List<Aparato>) aparatoDAO.findAll();
			
			// Lo añado a la vista...
			model.addObject("vivienda", vivienda);
			model.addObject("listaAparatos", aparatosVivienda);
			model.addObject("todosAparatos", todosAparatos);
			model.addObject("aparato", new Aparato());
			
		} 
		else {
			model.setViewName("redirect:/viviendas");
		}
		
		return model;
	}
	
	/*
	 * ADD Vivienda
	 * 
	 */
	@GetMapping("/viviendas/crear")
	public ModelAndView nuevaVivienda() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("viviendas/crearVivienda");
		
		model.addObject("vivienda", new Vivienda());
		
		List<Cliente> listaClientes = (List<Cliente>) clienteDAO.findAll();
		model.addObject("listaClientes", listaClientes);
		model.addObject("cliente", new Cliente());
		
		return model;
	}
	
	@PostMapping("/viviendas/add")
	public ModelAndView addVivienda(@ModelAttribute Vivienda vivienda) {
		
		ModelAndView model = new ModelAndView();
		
		viviendaDAO.save(vivienda);
		
		model.setViewName("redirect:/viviendas");
		
		return model;
	}
	
	
	/*
	 * UPDATE Vivienda
	 * 
	 */
	@GetMapping("/viviendas/editar/{idVivienda}")
	public ModelAndView editarVivienda(@PathVariable Integer idVivienda) {
		
		ModelAndView model = new ModelAndView();
		
		// Si la vivienda existe...
		if (viviendaDAO.existsById(idVivienda)) {
					
			model.setViewName("viviendas/editarVivienda"); // Nombre de la vista
					
			// Obtengo la vivienda concreta
			Vivienda vivienda = viviendaDAO.findById(idVivienda).get();
					
			// Obtengo la lista de aparatos de esta vivienda
			List<Cliente> listaClientes = (List<Cliente>) clienteDAO.findAll();
					
			// Lo añado a la vista...
			model.addObject("vivienda", vivienda);
			model.addObject("listaClientes", listaClientes);
					
		} 
		else {
			model.setViewName("redirect:/viviendas");
		}
		
		return model;
	}
	
	@PostMapping("/viviendas/update")
	public ModelAndView updateVivienda(@ModelAttribute Vivienda vivienda) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/viviendas/ver/" + vivienda.getIdVivienda());
		
		viviendaDAO.save(vivienda);
		
		return model;
	}
	
	
	/*
	 * DELETE Vivienda
	 * 
	 */
	@PostMapping("/viviendas/delete/{idVivienda}")
	public ModelAndView deleteVivienda(@PathVariable Integer idVivienda) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/viviendas");
		
		return model;
	}
	
	
	/*
	 * ASOCIAR Aparato a Vivienda
	 */
	@PostMapping("/viviendas/{idVivienda}/addAparato")
	@Transactional
	public ModelAndView addAparato(@PathVariable Integer idVivienda, @ModelAttribute Aparato aparato) {
		
		ModelAndView model = new ModelAndView();
		
		Vivienda vivienda = new Vivienda();
		vivienda.setIdVivienda(idVivienda);
		
		ViviendaAparato va = new ViviendaAparato();
		va.setIdVivienda(vivienda);
		va.setIdAparato(aparato);
		
		viviendaAparatoDAO.save(va);
		
		model.setViewName("redirect:/viviendas/ver/" + idVivienda);
		
		return model;
	}
	
	/*
	 * DESVINCULAR Aparato a Vivienda
	 */
	@GetMapping("/viviendas/{idVivienda}/deleteAparato/{id}")
	public String deleteAparato(@PathVariable Integer idVivienda, @PathVariable Integer id) {
		
		viviendaAparatoDAO.deleteById(id);
		
		return "redirect:/viviendas/ver/" + idVivienda;
	}
}
