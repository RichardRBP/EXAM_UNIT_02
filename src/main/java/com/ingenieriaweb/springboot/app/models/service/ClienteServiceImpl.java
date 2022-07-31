package com.ingenieriaweb.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.app.models.dao.IClienteDao;
import com.ingenieriaweb.springboot.app.models.dao.IFichaDao;
import com.ingenieriaweb.springboot.app.models.dao.IVideoDao;
import com.ingenieriaweb.springboot.app.models.entity.Cliente;
import com.ingenieriaweb.springboot.app.models.entity.Ficha;
import com.ingenieriaweb.springboot.app.models.entity.Video;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;

	@Autowired
	private IVideoDao videoDao;

	@Autowired
	private IFichaDao fichaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);

	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Video> findByTitulo(String term) {
		return videoDao.findByTituloLikeIgnoreCase("%" + term + "%");
	}

	@Override
	@Transactional
	public void saveFicha(Ficha ficha) {
		fichaDao.save(ficha);
	}

	@Override
	@Transactional(readOnly=true)
	public Video findVideoById(Long id) {
		// TODO Auto-generated method stub
		return videoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Ficha findFichaById(Long id) {
		// TODO Auto-generated method stub
		return fichaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteFicha(Long id) {
		fichaDao.deleteById(id);
	}
}
