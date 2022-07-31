package com.ingenieriaweb.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.app.models.entity.Genero;

@Repository
public class GeneroDaoImpl implements IGeneroDao {
	@PersistenceContext
	private EntityManager ge;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    @Override
    public List<Genero> findAll() {
        return ge.createQuery("from Genero").getResultList();
    }

    @Override
    @Transactional
    public void save(Genero genero) {
        if (genero.getId() != null && genero.getId() > 0) {
			ge.merge(genero);
		} else {
			ge.persist(genero);
		}
        
    }

    @Override
    @Transactional(readOnly = true)
    public Genero findOne(Long id) {
        return ge.find(Genero.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ge.remove(findOne(id));
}
}