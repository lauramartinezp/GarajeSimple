package com.everis.alicante.courses.becajava.garage;
import java.util.Scanner;

import com.everis.alicante.courses.becajava.garage.controller.ControladorGarajeConArrays;
import com.everis.alicante.courses.becajava.garage.domain.Garaje;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.interfaces.ControladorGaraje;


public class GarageMain {

	static Garaje garaje;
	
	static ControladorGaraje controlador;
	
	
	public static void main(String[] args) {
		
		//inicializar los componentes de la aplicacion
		
		//5 clientes
		
		//5 vehiculos
		
		//30 plazas de garaje
		
		//1 garaje

		inicializarComponentes();
		
		iniciarAplicacion();
		
	}
	
	private static void iniciarAplicacion() {

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

	public static void inicializarComponentes() {
		
		garaje = new Garaje();
		
		Plaza[] plazas = new Plaza[30];
		
		for (int i = 0; i < plazas.length; i++) {
			Plaza plazaTemp = new Plaza();
			
			plazaTemp.setNumeroPlaza(i+1);
			
			if (i<10) {
				
				plazaTemp.setPrecio(50);
				
			} else if (i<20){
				
				plazaTemp.setPrecio(75);
				
			}else {
				
				plazaTemp.setPrecio(100);
				
			}
			plazas[i]=plazaTemp;
			
			
		}
		
		garaje.setPlazas(plazas);
		
		controlador = new ControladorGarajeConArrays();
		
		
		
	}

	public static Garaje getGaraje() {
		return garaje;
	}
	
	
	
}
