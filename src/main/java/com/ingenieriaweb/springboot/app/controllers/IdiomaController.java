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

import com.ingenieriaweb.springboot.app.models.dao.IIdiomaDao;
import com.ingenieriaweb.springboot.app.models.entity.Idioma;

@Controller
@SessionAttributes("idioma")
public class IdiomaController {
	/*@Autowired
	private IIdiomaDao idiomaDao;

	@RequestMapping(value = "/listarIdiom", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Idiomas");
		model.addAttribute("generos", idiomaDao.findAll());
		return "listarIdiom";	
	}
	
	@RequestMapping(value = "/formIdiom")
	public String crear(Map<String, Object> model) {

		Idioma idioma = new Idioma();
		model.put("idioma", idioma);
		model.put("titulo", "Formulario de Idiomas");
		return "formIdiom";
	}
	
	@RequestMapping(value="/formIdiom/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Idioma idioma = null;
		
		if(id > 0) {
			idioma = idiomaDao.findOne(id);
		} else {
			return "redirect:/listar";
		}
		model.put("idioma", idioma);
		model.put("titulo", "Editar Idioma");
		return "formIdiom";
	}
	
	 
	@RequestMapping(value = "/formIdiom", method = RequestMethod.POST)
	public String guardar(@Valid Idioma idioma, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Idioma");
			return "form";
		}
		
		idiomaDao.save(idioma);
		status.setComplete();
		return "redirect:listarIdiom";
	}
	
	
	@RequestMapping(value="/eliminarGen/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id > 0) {
			idiomaDao.delete(id);
		}
		return "redirect:/listarIdiom";
	}*/
}
