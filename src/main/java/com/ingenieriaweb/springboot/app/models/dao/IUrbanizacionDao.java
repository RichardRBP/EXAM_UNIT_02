package com.ingenieriaweb.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ingenieriaweb.springboot.app.models.entity.Urbanizacion;

public interface IUrbanizacionDao extends PagingAndSortingRepository<Urbanizacion, Long>{

}
