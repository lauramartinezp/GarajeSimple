package com.everis.alicante.courses.becajava.garage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.everis.alicante.courses.becajava.garage.controller.ControladorGarajeConArrays;
import com.everis.alicante.courses.becajava.garage.domain.Garaje;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.interfaces.ControladorGaraje;
import com.everis.alicante.courses.becajava.garage.interfaces.PlazaDAO;
import com.everis.alicante.courses.becajava.garage.interfaces.PlazaDAOFileImp;


public class GarageMain {

	static Garaje garaje;
	
	static ControladorGaraje controlador;
	
	
	public static void main(String[] args) throws IOException {
		
		//inicializar los componentes de la aplicacion
		
		//5 clientes
		
		//5 vehiculos
		
		//30 plazas de garaje
		
		//1 garaje

		inicializarComponentes();
		
		iniciarAplicacion();
		
	}
	
	private static void iniciarAplicacion() throws IOException {
		System.out.println("*****************************************************************************");
		System.out.println("Bienvenido a nuestro garaje, seleccione una opcion: ");
		System.out.println("1:Listar Plazas Garaje Libre");
		System.out.println("2:Listar Plazas Garaje Ocupadas");
		System.out.println("3:Reservar Plazas");
		System.out.println("4:Ver Ingresos");
		System.out.println("5:Listar Clientes");
		System.out.println("6:Listar Vehiculos");
		
		Scanner in = new Scanner(System.in);
		Integer opcion = in.nextInt();
		Boolean resultado = true;
		
		System.out.println("Ha elegido la opcion :" + opcion);
		
		switch (opcion) {
		case 1:	
			
			controlador.listarPlazasLibres();
			
			break;
			
		case 2:
		
			controlador.listarPlazasOcupadas();
			
			break;
			
		case 3:
			
			resultado=controlador.reservarPlaza();
			
			break;

		case 4:
			
			
			
			break;
			
		case 5:
			
			
			
			break;
			
		case 6:
			
			
			
			break;
			
		case 7:
			
			
			
			break;
			
		default:
			
			System.out.println("Error");
			
			break;
		}
		
		//logica de si habiaplaza o no
		
		if (opcion==3&&resultado) {
			System.out.println("Se ha reservado su plaza.");
		} else if(opcion==3) {
			System.out.println("No hay plazas disponibles");
		}
		
		iniciarAplicacion();
	}

	public static void inicializarComponentes() throws IOException {
		
		garaje = new Garaje();
		
		PlazaDAO plazaDAO = new PlazaDAOFileImp();
		
	//	Plaza [] plazas = plazaDAO.readPlazas();
		
		
		List<Plaza> plazasTemp = plazaDAO.readPlazas();
			
			
		
		
		garaje.setPlazas(plazasTemp);
		
		controlador = new ControladorGarajeConArrays();
		
		
	}
	

	public static Garaje getGaraje() {
		return garaje;
	}
	
	
	
}
