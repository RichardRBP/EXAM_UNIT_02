package com.ingenieriaweb.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ingenieriaweb.springboot.app.models.entity.Ficha;

public interface IFichaDao extends CrudRepository<Ficha, Long>{

}