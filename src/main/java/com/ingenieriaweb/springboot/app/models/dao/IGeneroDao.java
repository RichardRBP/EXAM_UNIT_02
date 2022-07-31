package com.ingenieriaweb.springboot.app.models.dao;

import java.util.List;

import com.ingenieriaweb.springboot.app.models.entity.Genero2;

public interface IGeneroDao {
	public List<Genero2> findAll();

	public void save(Genero2 genero);
	
	public Genero2 findOne(Long id);
	
	public void delete(Long id);
}
