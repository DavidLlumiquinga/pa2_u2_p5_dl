package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "celular")
public class Celular {

	@Id

	@SequenceGenerator(name = "generador", sequenceName = "celular_secuencia", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generador")

	@Column(name = "cel_marca")
	private String marca;
	@Column(name = "cel_modelo")
	private String modelo;
	@Column(name = "cel_sistemaOperativo")
	private String sistemaOperativo;
	@Column(name = "capacidadAlmacenamiento")
	private Integer capacidadAlmacenamiento;
	@Column(name = "tamanioPantalla")
	private Double tamanioPantalla;

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

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public Integer getCapacidadAlmacenamiento() {
		return capacidadAlmacenamiento;
	}

	public void setCapacidadAlmacenamiento(Integer capacidadAlmacenamiento) {
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
	}

	public Double getTamanioPantalla() {
		return tamanioPantalla;
	}

	public void setTamanioPantalla(Double tamanioPantalla) {
		this.tamanioPantalla = tamanioPantalla;
	}

}
