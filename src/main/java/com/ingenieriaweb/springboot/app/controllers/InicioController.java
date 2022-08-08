package com.ingenieriaweb.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("")
public class InicioController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String login1() {
		return "login";
	}
    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String listar() {
		return "inicio";
	}
	

	
}
