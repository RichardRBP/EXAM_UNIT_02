package com.ingenieriaweb.springboot.app.models.entity;

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
@Table(name = "generos")
public class Genero2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String genero;
	
	@OneToMany(mappedBy = "genero", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Video> videos;
	
	public Genero2() {
		videos = new ArrayList<Video>();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
 
	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
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

	private static final long serialVersionUID = 1L;

	
	
}
