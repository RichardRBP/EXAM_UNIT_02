package com.ingenieriaweb.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.app.models.entity.Idioma;

@Repository
public class IdiomaDaoImpl implements IIdiomaDao{
	@PersistenceContext
	private EntityManager idi;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    @Override
    public List<Idioma> findAll() {
        return idi.createQuery("from Idioma").getResultList();
    }

    @Override
    @Transactional
    public void save(Idioma idioma) {
        if (idioma.getId() != null && idioma.getId() > 0) {
			idi.merge(idioma);
		} else {
			idi.persist(idioma);
		}
        
    }

    @Override
    @Transactional(readOnly = true)
    public Idioma findOne(Long id) {
        return idi.find(Idioma.class, id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        idi.remove(findOne(id));
}
}