package com.ingenieriaweb.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ingenieriaweb.springboot.app.models.entity.Cliente;
import com.ingenieriaweb.springboot.app.models.entity.Video;
import com.ingenieriaweb.springboot.app.models.entity.Urbanizacion;
import com.ingenieriaweb.springboot.app.models.entity.Ficha;
import com.ingenieriaweb.springboot.app.models.entity.Genero2;
import com.ingenieriaweb.springboot.app.models.entity.Idioma;
import com.ingenieriaweb.springboot.app.models.entity.Formato;

public interface IClienteService {

	public List<Cliente> findAll();

	public Page<Cliente> findAll(Pageable pageable);

	public void save(Cliente cliente);

	public Cliente findOne(Long id);

	public void delete(Long id);

	public List<Video> findByTitulo(String term);
	
	public void saveFicha(Ficha ficha);
	
	public Video findVideoById(Long id);
	
	public Ficha findFichaById(Long id);
	
	public void deleteFicha(Long id);

	public List<Urbanizacion> findAllU();
	public Page<Urbanizacion> findAllU(Pageable pageable);

	public Urbanizacion findOneU(Long id);

	public List<Video> findAllV();
	
	public Page<Video> findAllV(Pageable pageable);

	public Video findOneV(Long id);

	public List<Genero2> findByGenero(String term);

	public void saveVideo(Video video);

}
