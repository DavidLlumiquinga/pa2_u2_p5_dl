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
		

		Ciudadano cuid=new Ciudadano();
		cuid.setNombre("David");
		cuid.setApellido("Llumiquinga");
		this.iCiudadanoService.guardar(cuid);
		
	
//		Empleado empl=new Empleado();
//		empl.setFechaIngreso(LocalDateTime.now());
//		empl.setSalario(new BigDecimal(2500));
//		


		
		Ciudadano cuid1=new Ciudadano();
		cuid1.setNombre("Manuel");
		cuid1.setApellido("Tasiguano");
		
		Empleado empl1=new Empleado();
		empl1.setFechaIngreso(LocalDateTime.now());
		empl1.setSalario(new BigDecimal(1500));
		empl1.setCiudadano(cuid1);
		this.iEmpleadoService.guardar(empl1);
		
		Ciudadano cuid2=new Ciudadano();
		cuid2.setNombre("Juan");
		cuid2.setApellido("Lopez");
		
		Empleado empl2=new Empleado();
		empl2.setFechaIngreso(LocalDateTime.now());
		empl2.setSalario(new BigDecimal(750));
		empl2.setCiudadano(cuid2);
		this.iEmpleadoService.guardar(empl2);
		
	}

}
