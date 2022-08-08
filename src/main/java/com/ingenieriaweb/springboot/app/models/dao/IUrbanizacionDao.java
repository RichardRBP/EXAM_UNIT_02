package com.ingenieriaweb.springboot.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ingenieriaweb.springboot.app.models.entity.Urbanizacion;

import java.util.List;

public interface IUrbanizacionDao extends PagingAndSortingRepository<Urbanizacion, Long>{

//    make a query to find all the urbanizaciones that have the name like the term

    @Query("select p from Urbanizacion p where p.nombre like %?1%")
    public List<Urbanizacion> findByUrbanizacion(String term);

    public List<Urbanizacion> findByNombreLikeIgnoreCase(String term);

}
