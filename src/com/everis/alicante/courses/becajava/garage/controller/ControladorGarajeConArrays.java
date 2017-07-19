package com.everis.alicante.courses.becajava.garage.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.everis.alicante.courses.becajava.garage.GarageMain;
import com.everis.alicante.courses.becajava.garage.domain.Camion;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Coche;
import com.everis.alicante.courses.becajava.garage.domain.Garaje;
import com.everis.alicante.courses.becajava.garage.domain.Moto;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.garage.interfaces.Aparcable;
import com.everis.alicante.courses.becajava.garage.interfaces.ReservaDAO;
import com.everis.alicante.courses.becajava.garage.interfaces.implementacion.ReservaDAOFileImp;

public class ControladorGarajeConArrays implements ControladorGaraje{

	@Override
	public void listarPlazasLibres() {
		
		List<Plaza> plazaslibres= new ArrayList<Plaza>();
		
		List<Plaza> plazas=GarageMain.getGaraje().getPlazas();
		
		
		for (int i = 0; i < plazas.size(); i++) {
			Plaza plaza = plazas.get(i);
			
			if(plaza.getLibre()) {
				plazaslibres.add(plaza);
			}
		}
		//listar por pantalla
		
		for (Plaza plaza : plazaslibres) {
			System.out.println(plaza);
		}
		
	}

	@Override
	public void listarPlazasOcupadas() {
		
		List<Plaza> plazasOcupadas= new ArrayList<Plaza>();
		
		List<Plaza> plazas=GarageMain.getGaraje().getPlazas();
		
		for (int i = 0; i < plazas.size(); i++) {
			Plaza plaza = plazas.get(i);
			
			if(!plaza.getLibre()) {
				plazasOcupadas.add(plaza);
			}
		}
		//listar por pantalla
		
		for (Plaza plaza : plazasOcupadas) {
			System.out.println(plaza);
		}
	
	}

	@Override
	public boolean reservarPlaza() throws IOException {
		
		//logica de crear cliente
		
		Cliente cliente= new Cliente();
		
		ReservaDAO dao = new ReservaDAOFileImp();
		
		
		//vasmoa a escribir por pantalla un mentodo para meter los datos del cliente

		Scanner in = new Scanner(System.in);
		

		System.out.println("Inserta su nif: ");
		String nif = in.nextLine();
		cliente.setNif(nif);
		System.out.println("Inserte su nombre completo: ");
		String nombreCompleto = in.nextLine();
		cliente.setNombreCompleto(nombreCompleto);
		
		System.out.println("Tipo de vehículo del cliente: ");
		System.out.println("1: Coche");
		System.out.println("2: Moto");
		System.out.println("3.Camion");
		
		in = new Scanner(System.in);
		
		Vehiculo vehiculo = null;

		switch (in.nextInt()) {
		case 1:
			vehiculo = new Coche();
			break;
		case 2:
			vehiculo = new Moto();
			break;
		case 3:
			vehiculo = new Camion();
			
		default:
			break;
		}
		
		System.out.println("inserte la matricula del vehiuclo: ");
		in =new Scanner(System.in);
		vehiculo.setMatricula(in.nextLine());
		
		
		
		cliente.setVehiculo(vehiculo);
		
		

		
		
		//definimos una plaza ocupada y si esta libre que reserve

		boolean hayplaza=false;
		
		Garaje garaje = GarageMain.getGaraje();
		
		List<Plaza> plazas=garaje.getPlazas();
		
		for (int i = 0; i < plazas.size(); i++) {
			Plaza plaza = plazas.get(i);
			
			if (plaza.getLibre()&& vehiculo instanceof Aparcable) {
				plaza.setCliente(cliente);
				hayplaza=true;
				
				
				Reserva reserva = new Reserva();
				reserva.setCliente(cliente);
				reserva.setPlaza(plaza);
				reserva.setFechaReserva(Calendar.getInstance().getTime());
				reserva.setCodigoReserva("AUN NO PO");
				
				dao.readReserva();
				
				return hayplaza;
			}
		}
		return hayplaza;
		
		//si hay plazas libres seteamos un cliente a la plaza que queramos
		
		
	}

	@Override
	public void listarClientes() {
		
		Map<String, Cliente> clientes = GarageMain.getGaraje().getClientes();
		
		Collection<Cliente> collection =clientes.values();
		
		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			Cliente cliente =(Cliente) iterator.next();
			
			System.out.println(cliente.getNombreCompleto());
		}
		
	}

	@Override
	public void listarReservas() throws IOException {
	
		
		ReservaDAO reservaDao= new ReservaDAOFileImp();
		
		Map<String, Reserva> reservas = reservaDao.readReserva();
		
		 Collection<Reserva> listaReservas = reservas.values();
		 
		 for (Reserva reserva : listaReservas) {
			 
			 System.out.println("numero de plaza reservada: " +reserva.getPlaza().getNumeroPlaza());
			 System.out.println("cliente: " +reserva.getCliente().getNombreCompleto());
			 System.out.println("vehiculo: " +reserva.getCliente().getVehiculo().getMatricula() +" - " + reserva.getCliente().getVehiculo().getTipoVehiculo());
			
		}
		
	}

	
	
}
