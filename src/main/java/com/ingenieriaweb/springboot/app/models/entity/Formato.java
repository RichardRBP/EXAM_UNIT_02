package com.ingenieriaweb.springboot.app.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "formatos")
public class Formato implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String formato;

	@JsonManagedReference
	@OneToMany(mappedBy = "formato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Video> videos;
	
	public Formato() {
		videos = new ArrayList<Video>();
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFormato() {
		return formato;
	}


	public void setFormato(String formato) {
		this.formato = formato;
	}


	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
	public void addVideo(Video video) {
		videos.add(video);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	private static final long serialVersionUID = 1L;

}
