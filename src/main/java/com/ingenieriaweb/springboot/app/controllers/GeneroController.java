package com.ingenieriaweb.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ingenieriaweb.springboot.app.models.dao.IGeneroDao;
import com.ingenieriaweb.springboot.app.models.entity.Genero;

@Controller
@SessionAttributes("genero")
public class GeneroController {
	@Autowired
	private IGeneroDao generoDao;

	@RequestMapping(value = "/listarGen", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Generos");
		model.addAttribute("generos", generoDao.findAll());
		return "listarGen";	
	}
	
	@RequestMapping(value = "/formGen")
	public String crear(Map<String, Object> model) {

		Genero genero = new Genero();
		model.put("genero", genero);
		model.put("titulo", "Formulario de Generos");
		return "formGen";
	}
	
	@RequestMapping(value="/formGen/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Genero genero = null;
		
		if(id > 0) {
			genero = generoDao.findOne(id);
		} else {
			return "redirect:/listar";
		}
		model.put("genero", genero);
		model.put("titulo", "Editar Genero");
		return "formGen";
	}
	
	
	@RequestMapping(value = "/formGen", method = RequestMethod.POST)
	public String guardar(@Valid Genero genero, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Genero");
			return "form";
		}
		
		generoDao.save(genero);
		status.setComplete();
		return "redirect:listarGen";
	}
	
	
	@RequestMapping(value="/eliminarGen/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id > 0) {
			generoDao.delete(id);
		}
		return "redirect:/listarGen";
	}
}
