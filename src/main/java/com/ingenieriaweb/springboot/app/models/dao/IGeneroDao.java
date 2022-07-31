package com.ingenieriaweb.springboot.app.models.dao;

import java.util.List;

import com.ingenieriaweb.springboot.app.models.entity.Genero;

public interface IGeneroDao {
	public List<Genero> findAll();

	public void save(Genero genero);
	
	public Genero findOne(Long id);
	
	public void delete(Long id);
}
