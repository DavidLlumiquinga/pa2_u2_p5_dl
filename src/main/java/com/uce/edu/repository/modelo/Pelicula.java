package com.uce.edu.repository.modelo;

import java.sql.Time;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {

	@Id

	@SequenceGenerator(name = "generador", sequenceName = "pelicula_secuencia", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generador")

	@Column(name = "peli_titulo")
	private String titulo;
	@Column(name = "peli_director")
	private String director;
	@Column(name = "peli_genero")
	private String genero;
	@Column(name = "peli_duracion")
	private Time duracion;
	@Column(name = "peli_anioEstreno")
	private LocalDate anioEstreno;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Time getDuracion() {
		return duracion;
	}

	public void setDuracion(Time duracion) {
		this.duracion = duracion;
	}

	public LocalDate getAnioEstreno() {
		return anioEstreno;
	}

	public void setAnioEstreno(LocalDate anioEstreno) {
		this.anioEstreno = anioEstreno;
	}

}
