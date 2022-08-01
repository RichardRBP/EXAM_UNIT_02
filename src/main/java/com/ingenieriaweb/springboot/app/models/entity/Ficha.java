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
@Table(name = "fichas")
public class Ficha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String fechaAlquiler;
    @NotEmpty
    private String fechaEntrega;
    @NotNull
    private Double costo;
    @NotEmpty
    private String mora;
    @NotEmpty
    private String comentarios;
    @NotEmpty
    private String devuelto;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ficha_id")
    private List<DetalleFicha> items;

    public Ficha() {
        this.items = new ArrayList<DetalleFicha>();
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getFechaAlquiler() {
        return fechaAlquiler;
    }


    public void setFechaAlquiler(String fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }


    public String getFechaEntrega() {
        return fechaEntrega;
    }


    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }


    public Double getCosto() {
        return costo;
    }


    public void setCosto(Double costo) {
        this.costo = costo;
    }


    public String getMora() {
        return mora;
    }


    public void setMora(String mora) {
        this.mora = mora;
    }


    public String getComentarios() {
        return comentarios;
    }


    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }


    public String getDevuelto() {
        return devuelto;
    }


    public void setDevuelto(String devuelto) {
        this.devuelto = devuelto;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public List<DetalleFicha> getItems() {
        return items;
    }


    public void setItems(List<DetalleFicha> items) {
        this.items = items;
    }

    public void addDetalleFicha(DetalleFicha item) {
        this.items.add(item);
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    private static final long serialVersionUID = 1L;
}
