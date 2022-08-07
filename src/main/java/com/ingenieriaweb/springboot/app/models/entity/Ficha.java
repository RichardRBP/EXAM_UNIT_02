package com.ingenieriaweb.springboot.app.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fichas")
public class Ficha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "fecha_alquiler")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaAlquiler;

    @NotNull
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntrega;

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


    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }


    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }


    public Date getFechaEntrega() {
        return fechaEntrega;
    }


    public void setFechaEntrega(Date fechaEntrega) {
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
