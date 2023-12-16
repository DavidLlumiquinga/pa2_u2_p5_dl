package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5DlApplication implements CommandLineRunner {

	
		@Autowired
		private IEstudianteService iEstudianteService;
		@Autowired
		private IAlumnoService iAlumnoService;
		
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		
//	Estudiante estu=new Estudiante();
//	
//	estu.setNombre("Daniela");
//	estu.setApellido("Muela");
//	estu.setCedula("175456132");
//	estu.setFechaNacimiento(LocalDateTime.now());
//	
//	this.iEstudianteService.guardar(estu);
	
	Alumno alum=new Alumno();

	alum.setNombre("David");
	
	this.iAlumnoService.registrar(alum);
	
	this.iAlumnoService.eliminar("2");
	
	this.iAlumnoService.actualizar(alum);
	
	this.iAlumnoService.buscar("3");

	}

}
