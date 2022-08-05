package com.ingenieriaweb.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ingenieriaweb.springboot.app.models.entity.Formato;

public interface IFormatoDao extends PagingAndSortingRepository<Formato, Long>{

}
