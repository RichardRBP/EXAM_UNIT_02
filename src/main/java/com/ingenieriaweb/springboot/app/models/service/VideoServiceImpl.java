package com.ingenieriaweb.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;


import com.ingenieriaweb.springboot.app.models.dao.IVideoDao;


import com.ingenieriaweb.springboot.app.models.entity.Video;

public class VideoServiceImpl implements IVideoService {

	@Autowired
	private IVideoDao videoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Video> findAllV() {
		// TODO Auto-generated method stub
		return  (List<Video>) videoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Video> findAllV(Pageable pageable) {
		// TODO Auto-generated method stub
		return videoDao.findAll(pageable);
	}
	
	 

	@Override
	public Video findOneV(Long id) {
		// TODO Auto-generated method stub
		return videoDao.findById(id).orElse(null);
	}

	 
	
	
}
