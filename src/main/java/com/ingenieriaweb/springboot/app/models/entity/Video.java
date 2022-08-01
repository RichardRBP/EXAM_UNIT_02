package com.ingenieriaweb.springboot.app.models.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
  
@Entity
@Table(name = "videos")
public class Video implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String titulo;
    @NotNull
    private Integer anio;
    @NotNull
    private Integer cantidad;

    @NotNull
    private Double precio;

    private String imagenPortada;

    @NotEmpty
    private String trailer;

    @NotNull
    private Integer mes;

    

    @ManyToOne(fetch = FetchType.LAZY)
    private Idioma idioma;

    @ManyToOne(fetch = FetchType.LAZY)
    private Formato formato;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genero2 genero;

     

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public Integer getAnio() {
        return anio;
    }


    public void setAnio(Integer anio) {
        this.anio = anio;
    }


    public Integer getCantidad() {
        return cantidad;
    }


    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagenPortada() {
        return imagenPortada;
    }


    public void setImagenPortada(String imagenPortada) {
        this.imagenPortada = imagenPortada;
    }


    public String getTrailer() {
        return trailer;
    }


    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }


    public Integer getMes() {
        return mes;
    }


    public void setMes(Integer mes) {
        this.mes = mes;
    }
 
    

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }
    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Genero2 getGenero() {
        return genero;
    }


    public void setGenero(Genero2 genero) {
        this.genero = genero;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    private static final long serialVersionUID = 1L;



    
    

}
