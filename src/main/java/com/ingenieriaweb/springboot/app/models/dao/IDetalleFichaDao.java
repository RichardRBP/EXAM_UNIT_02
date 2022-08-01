package com.ingenieriaweb.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ingenieriaweb.springboot.app.models.entity.DetalleFicha;

public interface IDetalleFichaDao extends PagingAndSortingRepository<DetalleFicha, Long>{

}
