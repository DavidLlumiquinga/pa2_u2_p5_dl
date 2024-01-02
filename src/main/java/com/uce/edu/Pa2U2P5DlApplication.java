package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;

@SpringBootApplication
public class Pa2U2P5DlApplication implements CommandLineRunner{

	@Autowired
	private ICiudadanoService iCiudadanoService;
	
	@Autowired
	private IEmpleadoService iEmpleadoService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		

//		Ciudadano cuid=new Ciudadano();
//		cuid.setNombre("David");
//		cuid.setApellido("Llumiquinga");
//		this.iCiudadanoService.guardar(cuid);
		
	
//		Empleado empl=new Empleado();
//		empl.setFechaIngreso(LocalDateTime.now());
//		empl.setSalario(new BigDecimal(2500));
//		
		Ciudadano ciu1=this.iCiudadanoService.buscar(1);
		System.out.println(ciu1);
		
		Empleado empl=new Empleado();
		empl.setFechaIngreso(LocalDateTime.now());
		empl.setSalario(new BigDecimal(2500));
		empl.setCiudadano(ciu1);
		this.iEmpleadoService.guardar(empl);
		System.out.println("Hola mundo");
		
	}

}
