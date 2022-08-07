package com.ingenieriaweb.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import com.ingenieriaweb.springboot.app.models.entity.Cliente;
import com.ingenieriaweb.springboot.app.models.entity.DetalleFicha;
import com.ingenieriaweb.springboot.app.models.entity.Ficha;
import com.ingenieriaweb.springboot.app.models.entity.Urbanizacion;
import com.ingenieriaweb.springboot.app.models.entity.Video;
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

}
