package com.ingenieriaweb.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.app.models.dao.IClienteDao;
import com.ingenieriaweb.springboot.app.models.dao.IDetalleFichaDao;
import com.ingenieriaweb.springboot.app.models.dao.IFichaDao;
import com.ingenieriaweb.springboot.app.models.dao.IGeneroDao;
import com.ingenieriaweb.springboot.app.models.dao.IIdiomaDao;
import com.ingenieriaweb.springboot.app.models.dao.IUrbanizacionDao;
import com.ingenieriaweb.springboot.app.models.dao.IVideoDao;
import com.ingenieriaweb.springboot.app.models.entity.Cliente;
import com.ingenieriaweb.springboot.app.models.entity.DetalleFicha;
import com.ingenieriaweb.springboot.app.models.entity.Ficha;
import com.ingenieriaweb.springboot.app.models.entity.Genero2;
import com.ingenieriaweb.springboot.app.models.entity.Idioma;
import com.ingenieriaweb.springboot.app.models.entity.Urbanizacion;
import com.ingenieriaweb.springboot.app.models.entity.Video;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;

	@Autowired
	private IVideoDao videoDao;

	@Autowired
	private IFichaDao fichaDao;

	@Autowired
	private IUrbanizacionDao urbanizacionDao;

	@Autowired
	private IGeneroDao generoDao;
	@Autowired
	private IDetalleFichaDao detallefichaDao;
	@Autowired
	private IIdiomaDao idiomaDao;
	

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

	@Override
	@Transactional(readOnly = true)
	public List<Urbanizacion> findAllU() {
		// TODO Auto-generated method stub
		return (List<Urbanizacion>) urbanizacionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Urbanizacion findOneU(Long id) {
		// TODO Auto-generated method stub
		return urbanizacionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Urbanizacion> findAllU(Pageable pageable) {
		return urbanizacionDao.findAll(pageable);
	}

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
	@Transactional(readOnly = true)
	public Video findOneV(Long id) {
		// TODO Auto-generated method stub
		return videoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Genero2> findByGenero(String term) {
		// TODO Auto-generated method stub
		return generoDao.findByGeneroLikeIgnoreCase("%" + term + "%");
	}

	@Override
	@Transactional
	public void saveVideo(Video video) {
		// TODO Auto-generated method stub
		videoDao.save(video);
	}
	
	@Override
	@Transactional
	public void deleteV(Long id) {
		videoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public DetalleFicha findOneFicha(Long id) {
		// TODO Auto-generated method stub
		return detallefichaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Idioma> findAllI() {
		// TODO Auto-generated method stub
		return  (List<Idioma>) idiomaDao.findAll();
	}
}
