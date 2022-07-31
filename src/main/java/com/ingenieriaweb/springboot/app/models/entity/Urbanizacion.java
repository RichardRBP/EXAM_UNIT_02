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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name = "urbanizaciones")
public class Urbanizacion implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String distrito;
	@NotEmpty
	private String provincia;
	
	@OneToMany(mappedBy = "urbanizacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Cliente> clientes;
	
	public Urbanizacion() {
		clientes = new ArrayList<Cliente>();
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDistrito() {
		return distrito;
	}


	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	 
	
	private static final long serialVersionUID = 1L;
}

