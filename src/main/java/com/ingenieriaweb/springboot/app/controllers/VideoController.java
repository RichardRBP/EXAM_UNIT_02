package com.ingenieriaweb.springboot.app.controllers;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ingenieriaweb.springboot.app.models.entity.DetalleFicha;
import com.ingenieriaweb.springboot.app.models.entity.Genero2;
import com.ingenieriaweb.springboot.app.models.entity.Video;
import com.ingenieriaweb.springboot.app.models.service.IClienteService;
import com.ingenieriaweb.springboot.app.models.service.IUploadFileService;
import com.ingenieriaweb.springboot.app.models.service.IVideoService;
import com.ingenieriaweb.springboot.app.util.paginator.PageRender;


@Controller
@RequestMapping("/video")
@SessionAttributes("video")
public class VideoController {
	
    @Autowired
	private IClienteService videoService;
	@Autowired
	private IUploadFileService uploadFileService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Video video = videoService.findOneV(id);
		if (video == null) {
			flash.addFlashAttribute("error", "El video no existe en la base de datos");
			return "redirect:/video/listar";
		}

		model.put("video", video);
		model.put("titulo", "Detalle Video: " + video.getTitulo());
		return "video/ver";
	}

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		PageRequest pageRequest = PageRequest.of(page, 4);

		Page<Video> videos = videoService.findAllV(pageRequest);

		PageRender<Video> pageRender = new PageRender<Video>("/video/listar", videos);
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("videos", videos);
		model.addAttribute("page", pageRender);
		return "video/listar";
	}

	@RequestMapping(value = "/verBonitos", method = RequestMethod.GET)
	public String listarVideos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		PageRequest pageRequest = PageRequest.of(page, 20);

		Page<Video> videos = videoService.findAllV(pageRequest);

		PageRender<Video> pageRender = new PageRender<Video>("/video/verBonitos", videos);
		model.addAttribute("titulo", "Las Mejores Peliculas");
		model.addAttribute("videos", videos);
		model.addAttribute("page", pageRender);
		return "video/verBonitos";
	}

    @RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		Video video = new Video();

		model.put("video", video);
		model.put("idiomas", videoService.findAllI());
		model.put("generos", videoService.findAllG());
		model.put("formatos", videoService.findAllF());
		model.put("titulo", "Formulario de Video");
		return "video/form";
	}

    @PostMapping("/form")
	public String guardar(@Valid Video video, 
			BindingResult result, Model model,@RequestParam("file") MultipartFile foto,
			RedirectAttributes flash,
			SessionStatus status) {
		 
		if (!foto.isEmpty()) {

			if (video.getId() != null && video.getId() > 0 && video.getImagenPortada() != null
					&& video.getImagenPortada().length() > 0) {

				uploadFileService.delete(video.getImagenPortada());
			}

			String uniqueFilename = null;
			try {
				uniqueFilename = uploadFileService.copy(foto);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");

			video.setImagenPortada(uniqueFilename);
		}
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Video");
			model.addAttribute("idiomas", videoService.findAllI());
			model.addAttribute("generos", videoService.findAllG());
			model.addAttribute("formatos", videoService.findAllF());
			return "video/form";
		}
 
		videoService.saveVideo(video);
		status.setComplete();

		flash.addFlashAttribute("success", "Video creado con éxito!");

		 
		return "redirect:/video/listar"; 
	}


	@RequestMapping(value = "/formE/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Video video = null;

		if (id > 0) {
			video = videoService.findOneV(id);
			if (video == null) {
				flash.addFlashAttribute("error", "El ID del video no existe en la BBDD!");
				return "redirect:/video/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del video no puede ser cero!");
			return "redirect:/video/listar";
		}
		model.put("video", video);
		model.put("titulo", "Editar Video");
		model.put("generos", videoService.findAllG());
		model.put("idiomas", videoService.findAllI());
		model.put("formatos", videoService.findAllF());
		return "video/form";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			Video video = videoService.findOneV(id);
			
			
			videoService.deleteV(id);
			flash.addFlashAttribute("success", "Video eliminado con éxito!");
			
			if (uploadFileService.delete(video.getImagenPortada())) {
				//flash.addFlashAttribute("info", "Foto " + cliente.getFoto() + " eliminada con exito!");
			}

		}
		return "redirect:/video/listar";
	}

}
