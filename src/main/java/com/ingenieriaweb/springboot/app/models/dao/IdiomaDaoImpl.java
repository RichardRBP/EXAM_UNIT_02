package com.ingenieriaweb.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ingenieriaweb.springboot.app.models.entity.Idioma;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public class IdiomaDaoImpl {
	@PersistenceContext
	private EntityManager idi;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public List<Idioma> findAll() {
        return idi.createQuery("from Idioma").getResultList();
    }

    @Transactional
    public void save(Idioma idioma) {
        if (idioma.getId() != null && idioma.getId() > 0) {
			idi.merge(idioma);
		} else {
			idi.persist(idioma);
		}
        
    }

    @Transactional(readOnly = true)
    public Idioma findOne(Long id) {
        return idi.find(Idioma.class, id);
    }

    @Transactional
    public void delete(Long id) {
        idi.remove(findOne(id));
}
}