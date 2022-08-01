package com.ingenieriaweb.springboot.app.models.entity;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "video_id")
    private List<DetalleGenero> itemsG;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "video_id")
    private List<DetalleIdioma> itemsI;

    @ManyToOne(fetch = FetchType.LAZY)
    private Formato formato;

    public Video() {
        this.itemsG = new ArrayList<DetalleGenero>();
        this.itemsI = new ArrayList<DetalleIdioma>();
    }

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

    public void addDetalleGenero(DetalleGenero itemG) {
        this.itemsG.add(itemG);
    }

    public void addDetalleIdioma(DetalleIdioma itemI) {
        this.itemsI.add(itemI);
    }


    public List<DetalleGenero> getItemsG() {
        return itemsG;
    }

    public void setItemsG(List<DetalleGenero> itemsG) {
        this.itemsG = itemsG;
    }

    public List<DetalleIdioma> getItemsI() {
        return itemsI;
    }

    public void setItemsI(List<DetalleIdioma> itemsI) {
        this.itemsI = itemsI;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    private static final long serialVersionUID = 1L;

}
