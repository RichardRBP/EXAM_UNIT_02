package com.ingenieriaweb.springboot.app.models.dao;

import java.util.List;

import com.ingenieriaweb.springboot.app.models.entity.Idioma;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IIdiomaDao extends PagingAndSortingRepository<Idioma, Long>{
	
//	public List<Idioma> findAll();
//
//	public void save(Idioma idioma);
//	
//	public Idioma findOne(Long id);
//	
//	public void delete(Long id);
}
