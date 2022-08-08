package com.ingenieriaweb.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ingenieriaweb.springboot.app.models.dao.IGeneroDao;
import com.ingenieriaweb.springboot.app.models.entity.Idioma;
import com.ingenieriaweb.springboot.app.models.entity.Cliente;
import com.ingenieriaweb.springboot.app.models.entity.Genero2;
import com.ingenieriaweb.springboot.app.models.entity.Urbanizacion;
import com.ingenieriaweb.springboot.app.models.entity.Video;
import com.ingenieriaweb.springboot.app.models.service.IClienteService;
import com.ingenieriaweb.springboot.app.models.service.IUploadFileService;
import com.ingenieriaweb.springboot.app.util.paginator.PageRender;

@Controller
@RequestMapping("/idioma")
@SessionAttributes("idioma")
public class IdiomaController {
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value = "/listarIdiom", method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 5);

		Page<Idioma> idiomas = clienteService.findAllI(pageRequest);

		PageRender<Idioma> pageRender = new PageRender<Idioma>("/idioma/listarIdiom", idiomas);
		model.addAttribute("titulo", "Listado de idiomas");
		model.addAttribute("idiomas", idiomas);
		model.addAttribute("page", pageRender);
		return "idioma/listarIdiom";
	}
	
	@RequestMapping(value = "/formIdiom")
	public String crear(Map<String, Object> model) {

		Idioma idioma = new Idioma();
		model.put("idioma", idioma);
		model.put("titulo", "Formulario de Idiomas");
		return "idioma/formIdiom";
	}
	
	@RequestMapping(value="/formIdiom/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		
		Idioma idioma = null;
		
		if (id > 0) {
			idioma = clienteService.findOneI(id);
			if (idioma == null) {
				flash.addFlashAttribute("error", "El ID del idioma no existe en la BBDD!");
				return "redirect:/idioma/listarIdiom";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del idioma no puede ser cero!");
			return "redirect:/idioma/listarIdiom";
		}
		model.put("idioma", idioma);
		model.put("titulo", "Editar Idioma");
		return "idioma/formIdiom";
	}
	
	 
	@RequestMapping(value = "/formIdiom", method = RequestMethod.POST)
	public String guardar(@Valid Idioma idioma, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Idioma");
			return "idioma/formIdiom";
		}
		
		clienteService.saveIdioma(idioma);
		status.setComplete();
		flash.addFlashAttribute("success", "Idioma creado con éxito!");
		return "redirect:/idioma/listarIdiom";
	}
	
	
	@RequestMapping(value="/eliminarIdiom/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if(id > 0) {
			clienteService.deleteI(id);
			flash.addFlashAttribute("success", "Idioma eliminado con éxito!");
		}
		return "redirect:/idioma/listarIdiom";
	}
}
