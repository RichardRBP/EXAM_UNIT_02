package com.ingenieriaweb.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.ingenieriaweb.springboot.app.models.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.ingenieriaweb.springboot.app.models.service.IClienteService;
import com.ingenieriaweb.springboot.app.util.paginator.PageRender;



@Controller
@RequestMapping("/urbanizacion")
@SessionAttributes("urbanizacion")
public class UrbanizacionController {

	@Autowired
	private IClienteService clienteService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Urbanizacion> urbanizacion = clienteService.findAllU(pageRequest);

		PageRender<Urbanizacion> pageRender = new PageRender<Urbanizacion>("/urbanizacion/listar", urbanizacion);
		model.addAttribute("titulo", "Listado de urbanizaciones");
		model.addAttribute("urbanizaciones", urbanizacion);
		model.addAttribute("page", pageRender);
		return "urbanizacion/listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Urbanizacion urbanizacion = new Urbanizacion();
		model.put("urbanizacion", urbanizacion);
		model.put("titulo", "Formulario de Urbanizaciones");
		return "urbanizacion/form";
	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Urbanizacion urbanizacion = null;

		if (id > 0) {
			urbanizacion = clienteService.findOneU(id);
			if (urbanizacion == null) {
				flash.addFlashAttribute("error", "El ID de la urbanización no existe en la BBDD!");
				return "redirect:/urbanizacion/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID de la urbanizacion no puede ser cero!");
			return "redirect:/urbanizacion/listar";
		}
		model.put("urbanizacion", urbanizacion);
		model.put("titulo", "Editar urbanizacion");
		return "urbanizacion/form";
	}

//	make the guardar and eliminar to Urbanizacion
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Urbanizacion urbanizacion, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Urbanizacion");
			return "urbanizacion/form";
		}

		clienteService.saveUrbanizacion(urbanizacion);
		status.setComplete();
		flash.addFlashAttribute("success", "Urbanizacion creada con éxito!");
		return "redirect:/urbanizacion/listar";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			clienteService.deleteU(id);
			flash.addFlashAttribute("success", "Urbanizacion eliminada con éxito!");
		}
		return "redirect:/urbanizacion/listar";
	}

}
