package com.uce.edu.repository.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "carro")
public class Carro {

	@Id
	@SequenceGenerator(name = "generador", sequenceName = "carro_secu", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generador")

	@Column(name = "carro_marca")
	private String marca;

	@Column(name = "carro_modelo")
	private String modelo;

	@Column(name = "carro_anioFabricacion")
	private LocalDate anioFabricacion;

	@Column(name = "carro_color")
	private String color;

	@Column(name = "carro_numeroPuertas")
	private Integer numeroPuertas;

	// GET y SET
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(LocalDate anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(Integer numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

}
