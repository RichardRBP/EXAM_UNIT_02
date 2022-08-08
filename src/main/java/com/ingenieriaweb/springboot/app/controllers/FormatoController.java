package com.ingenieriaweb.springboot.app.controllers;

import com.ingenieriaweb.springboot.app.models.entity.Formato;
import com.ingenieriaweb.springboot.app.models.entity.Formato;
import com.ingenieriaweb.springboot.app.models.entity.Genero2;
import com.ingenieriaweb.springboot.app.models.service.IClienteService;
import com.ingenieriaweb.springboot.app.util.paginator.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/formato")
@SessionAttributes("formato")
public class FormatoController {
    @Autowired
    private IClienteService clienteService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 5);

        Page<Formato> formato = clienteService.findAllF(pageRequest);

        PageRender<Formato> pageRender = new PageRender<Formato>("/formato/listar", formato);
        model.addAttribute("titulo", "Listado de formatos");
        model.addAttribute("formatos", formato);
        model.addAttribute("page", pageRender);
        return "formato/listar";
    }

    @RequestMapping(value = "/form")
    public String crear(Map<String, Object> model) {

        Formato formato = new Formato();
        model.put("formato", formato);
        model.put("titulo", "Formulario de Formato");
        return "formato/form";
    }

    @RequestMapping(value = "/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

        Formato formato = null;

        if (id > 0) {
            formato = clienteService.findOneF(id);
            if (formato == null) {
                flash.addFlashAttribute("error", "El ID del formato no existe en la BBDD!");
                return "redirect:/formato/listar";
            }
        } else {
            flash.addFlashAttribute("error", "El ID del formato no puede ser cero!");
            return "redirect:/formato/listar";
        }
        model.put("formato", formato);
        model.put("titulo", "Editar Formato");
        return "formato/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Formato formato, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Formato");
            return "/formato/form";
        }

        clienteService.saveFormato(formato);
        status.setComplete();
        flash.addFlashAttribute("success", "Formato creado con éxito!");
        return "redirect:/formato/listar";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
        if (id > 0) {
            clienteService.deleteF(id);
            flash.addFlashAttribute("success", "Formato eliminado con éxito!");
        }
        return "redirect:/formato/listar";
    }


}
