package com.ingenieriaweb.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ingenieriaweb.springboot.app.models.dao.IGeneroDao;
import com.ingenieriaweb.springboot.app.models.entity.Genero2;
import com.ingenieriaweb.springboot.app.models.entity.Cliente;
import com.ingenieriaweb.springboot.app.models.entity.Idioma;
import com.ingenieriaweb.springboot.app.models.entity.Urbanizacion;
import com.ingenieriaweb.springboot.app.models.entity.Video;
import com.ingenieriaweb.springboot.app.models.service.IClienteService;
import com.ingenieriaweb.springboot.app.models.service.IUploadFileService;
import com.ingenieriaweb.springboot.app.util.paginator.PageRender;

@Controller
@RequestMapping("/genero")
@SessionAttributes("genero")
public class GeneroController {
	@Autowired
	private IClienteService clienteService;

	@RequestMapping(value = "/listarGen", method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 5);

		Page<Genero2> generos = clienteService.findAllG(pageRequest);

		PageRender<Genero2> pageRender = new PageRender<Genero2>("/genero/listarGen", generos);
		model.addAttribute("titulo", "Listado de generos");
		model.addAttribute("generos", generos);
		model.addAttribute("page", pageRender);
		return "genero/listarGen";
	}

	@RequestMapping(value = "/formGen")
	public String crear(Map<String, Object> model) {

		Genero2 genero = new Genero2();
		model.put("genero", genero);
		model.put("titulo", "Formulario de Generos");
		return "genero/formGen";
	}

	@RequestMapping(value = "/formGen/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Genero2 genero = null;

		if (id > 0) {
			genero = clienteService.findOneG(id);
			if (genero == null) {
				flash.addFlashAttribute("error", "El ID del genero no existe en la BBDD!");
				return "redirect:/genero/listarGen";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del genero no puede ser cero!");
			return "redirect:/genero/listarGen";
		}
		model.put("genero", genero);
		model.put("titulo", "Editar Genero");
		return "genero/formGen";
	}
	
	@RequestMapping(value = "/formGen", method = RequestMethod.POST)
	public String guardar(@Valid Genero2 genero, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
	 
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Genero");
			return "genero/formGen";
		}

		clienteService.saveGenero(genero);
		status.setComplete();
		flash.addFlashAttribute("success", "Genero creado con éxito!");
		return "redirect:/genero/listarGen";
	}

	@RequestMapping(value = "/eliminarGen/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			clienteService.deleteG(id);
			flash.addFlashAttribute("success", "Genero eliminado con éxito!");
		}
		return "redirect:/genero/listarGen";
	}
}
