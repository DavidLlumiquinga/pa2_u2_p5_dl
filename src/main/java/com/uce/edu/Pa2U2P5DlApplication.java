package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;

@SpringBootApplication
public class Pa2U2P5DlApplication implements CommandLineRunner {

	//1. Query (Usa JPQL)
	//1.1 TypedQuery: Conocemos el tipo de dato retornamos
	//1.2 NamedQuery: Declarar de una manera centralizada 
	
	//2 Native Query
	//3. Criteria API Query
	
	@Autowired
	private ICiudadanoService iCiudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub


		Empleado empl= this.iCiudadanoService.buscarPorCedula("172586110");
		System.out.println(empl);
			
		}
	}


