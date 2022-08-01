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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ingenieriaweb.springboot.app.models.entity.Cliente;
import com.ingenieriaweb.springboot.app.models.entity.DetalleFicha;
import com.ingenieriaweb.springboot.app.models.entity.Ficha;
import com.ingenieriaweb.springboot.app.models.entity.Video;
import com.ingenieriaweb.springboot.app.models.service.IClienteService;


@Controller
@RequestMapping("/ficha")
@SessionAttributes("ficha")
public class FichaController {

    @Autowired
    private IClienteService clienteService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable(value = "id") Long id,
                      Model model,
                      RedirectAttributes flash) {
        Ficha ficha = clienteService.findFichaById(id);

        if (ficha == null) {
            flash.addFlashAttribute("error", "La Ficha no existe en la base de datos!");
            return "redirect:/cliente/listar";
        }

        model.addAttribute("ficha", ficha);
        model.addAttribute("titulo", "Ficha: ".concat(ficha.getComentarios()));

        return "ficha/ver";
    }

    @GetMapping("/form/{clienteId}")
    public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model,
                        RedirectAttributes flash) {

        Cliente cliente = clienteService.findOne(clienteId);

        if (cliente == null) {
            flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
            return "redirect:/cliente/listar";
        }

        Ficha ficha = new Ficha();
        ficha.setCliente(cliente);

        model.put("ficha", ficha);
        model.put("titulo", "Crear Ficha");

        return "ficha/form";
    }

    @GetMapping(value = "/cargar-videos/{term}", produces = {"application/json"})
    public @ResponseBody List<Video> cargarVideos(@PathVariable String term) {
        return clienteService.findByTitulo(term);
    }

    @PostMapping("/form")
    public String guardar(@Valid Ficha ficha, BindingResult result,
                          Model model, @RequestParam(name = "item_id[]", required = false) Long[] itemId,
                          @RequestParam(name = "cantidad[]", required = false) Integer[] cantidad,
                          RedirectAttributes flash,
                          SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Crear Ficha");
            return "ficha/form";
        }

        if (itemId == null || itemId.length == 0) {
            model.addAttribute("titulo", "Crear Ficha");
            model.addAttribute("error", "Error: La ficha NO puede no tener líneas!");
            return "ficha/form";
        }

        for (int i = 0; i < itemId.length; i++) {
            Video video = clienteService.findVideoById(itemId[i]);

            DetalleFicha linea = new DetalleFicha();
            linea.setVideo(video);
            ficha.addDetalleFicha(linea);

            log.info("ID: " + itemId[i].toString());
        }

        clienteService.saveFicha(ficha);
        status.setComplete();

        flash.addFlashAttribute("success", "Ficha creada con éxito!");

        return "redirect:/cliente/ver/" + ficha.getCliente().getId();
    }

    @GetMapping("/eliminarFicha/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

        Ficha ficha = clienteService.findFichaById(id);

        if (ficha != null) {
            clienteService.deleteFicha(id);
            flash.addFlashAttribute("success", "Ficha eliminada con éxito!");
            return "redirect:/cliente/ver/" + ficha.getCliente().getId();
        }
        flash.addFlashAttribute("error", "La ficha no existe en la base de datos, no se pudo eliminar!");

        return "redirect:/cliente/listar";
    }

}
