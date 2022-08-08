package com.ingenieriaweb.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ingenieriaweb.springboot.app.models.entity.Cliente;
import com.ingenieriaweb.springboot.app.models.entity.DetalleFicha;
import com.ingenieriaweb.springboot.app.models.entity.Video;
import com.ingenieriaweb.springboot.app.models.entity.Urbanizacion;
import com.ingenieriaweb.springboot.app.models.entity.Ficha;
import com.ingenieriaweb.springboot.app.models.entity.Genero2;
import com.ingenieriaweb.springboot.app.models.entity.Idioma;
import com.ingenieriaweb.springboot.app.models.entity.Formato;

public interface IClienteService {

    //CLIENTE
    public List<Cliente> findAll();

    public Page<Cliente> findAll(Pageable pageable);

    public void save(Cliente cliente);

    public Cliente findOne(Long id);

    public void delete(Long id);

    //	FICHA
    public void saveFicha(Ficha ficha);

    public Ficha findFichaById(Long id);

    //	DETALLE FICHA
    public void deleteFicha(Long id);

    public DetalleFicha findOneFicha(Long id);

    //	FORMATO

    public List<Formato> findByFormato(String term);

    public List<Formato> findAllF();

    public Page<Formato> findAllF(Pageable pageable);

    public Formato findOneF(Long id);

    public void saveFormato(Formato formato);

    public void deleteF(Long id);

//	URBANIZACION
//	make the functions as the same as genero in urbanizacion

    public List<Urbanizacion> findByUrbanizacion(String term);

    public List<Urbanizacion> findAllU();

    public Page<Urbanizacion> findAllU(Pageable pageable);

    public Urbanizacion findOneU(Long id);

    public void saveUrbanizacion(Urbanizacion urbanizacion);

    public void deleteU(Long id);

    //	VIDEO
    public List<Video> findByTitulo(String term);

    public Video findVideoById(Long id);

    public List<Video> findAllV();

    public Page<Video> findAllV(Pageable pageable);

    public Video findOneV(Long id);

    public void saveVideo(Video video);

    public void deleteV(Long id);

    //	IDIOMA
    public List<Idioma> findAllI();

    public Page<Idioma> findAllI(Pageable pageable);

    public Idioma findOneI(Long id);

    public void saveIdioma(Idioma idioma);

    public void deleteI(Long id);

    //	GENERO
    public List<Genero2> findByGenero(String term);

    public List<Genero2> findAllG();

    public Page<Genero2> findAllG(Pageable pageable);

    public Genero2 findOneG(Long id);

    public void saveGenero(Genero2 genero);

    public void deleteG(Long id);

}
