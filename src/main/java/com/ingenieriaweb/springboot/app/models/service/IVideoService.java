package com.ingenieriaweb.springboot.app.models.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ingenieriaweb.springboot.app.models.entity.Video;

public interface IVideoService {
	
	
	public List<Video> findAllV();
	
	public Page<Video> findAllV(Pageable pageable);

	public Video findOneV(Long id);
	 

}
