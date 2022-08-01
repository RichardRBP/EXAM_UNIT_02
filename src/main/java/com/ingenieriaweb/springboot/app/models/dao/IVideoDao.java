package com.ingenieriaweb.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ingenieriaweb.springboot.app.models.entity.Video;

public interface IVideoDao extends PagingAndSortingRepository<Video, Long>{

	@Query("select p from Video p where p.titulo like %?1%")
	public List<Video> findByTitulo(String term);

	public List<Video> findByTituloLikeIgnoreCase(String term);
	
}