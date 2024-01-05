package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5DlApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5DlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		Hotel hotel=new Hotel();
		hotel.setNombre("Hotel La Basilica");
		hotel.setDireccion("Basilica Nacional");
		
		
		
		Habitacion h1=new Habitacion();
		h1.setClase("Economica");
		h1.setNumero("1A");
		h1.setHotel(hotel);
		
		Habitacion h2=new Habitacion();
		h2.setClase("Premiun");
		h2.setNumero("8B");
		h2.setHotel(hotel);
		
		Habitacion h3=new Habitacion();
		h3.setClase("Estatal");
		h3.setNumero("10C");
		h3.setHotel(hotel);
		
		List<Habitacion> habitaciones=new ArrayList<>();
		habitaciones.add(h1);
		habitaciones.add(h2);
		habitaciones.add(h3);
		
		hotel.setHabitaciones(habitaciones);
		this.hotelService.guardar(hotel);
	}

}
