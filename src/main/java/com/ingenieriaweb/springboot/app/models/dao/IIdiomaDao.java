package com.ingenieriaweb.springboot.app.models.dao;

import java.util.List;

import com.ingenieriaweb.springboot.app.models.entity.Idioma;

public interface IIdiomaDao {
	public List<Idioma> findAll();

	public void save(Idioma idioma);
	
	public Idioma findOne(Long id);
	
	public void delete(Long id);
}
