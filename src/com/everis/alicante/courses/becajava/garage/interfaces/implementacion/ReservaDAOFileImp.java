package com.everis.alicante.courses.becajava.garage.interfaces.implementacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

import com.everis.alicante.courses.becajava.garage.GarageMain;
import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;
import com.everis.alicante.courses.becajava.garage.interfaces.ReservaDAO;

public class ReservaDAOFileImp implements ReservaDAO{

	@Override
	public void createReserva(Reserva reserva) throws IOException {

		File file = new File("src/resources/Reserva.txt");
		FileWriter writer = new FileWriter(file,true);
		BufferedWriter buffer= new BufferedWriter(writer);
		
		buffer.newLine();
		buffer.write(reserva.convierteAFormatoTxt());
		
		
		//for (String string : data) {
		//writer.write(string);
		//writer.newLine();
			
		buffer.close();
		
	}
	
	public static void main (String args[]) throws IOException {
		
		Reserva reserva= new Reserva();
		
		Cliente cliente = new Cliente();
		cliente.setNif("2584685");
		
		Plaza plaza = new Plaza();
		plaza.setNumeroPlaza(1);
	
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMatricula("2584 JUD");
		
		cliente.setVehiculo(vehiculo);
		reserva.setCliente(cliente);
		reserva.setPlaza(plaza);
		reserva.setFechaReserva(Calendar.getInstance().getTime());
		
		
		ReservaDAO dao = new ReservaDAOFileImp();
		
		dao.createReserva(reserva);
		
	}

	@Override
	public Map<String,Reserva> readReserva() throws IOException {
		// Pasos para leer un fichero
		
		//leerlo, buscarlo
		
		Map<String,Reserva> reservas = new TreeMap<String,Reserva>();
		String linea;
		
		File file = new File("src/resources/Reserva.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		
			while((linea=buffer.readLine())!=null) {
				
				if(!linea.contains("CODIGO_RESERVA")) {
					
				Reserva reserva = new Reserva();

				String[] temp = linea.split(";");
				
				reserva.setCodigoReserva(temp[0]);
				
				Plaza plaza = GarageMain.getGaraje().getPlazas().get(Integer.parseInt(temp[1]));
				
				reserva.setPlaza(plaza);
				
				reserva.setCliente(GarageMain.getGaraje().getClientes().get(temp[2]));
				
				reserva.getCliente().setVehiculo(GarageMain.getGaraje().getVehiculos().get(temp[3]));
				
				
				reservas.put(reserva.getCodigoReserva(),reserva);
				
				
				}
			}
		
		reader.close();
		return reservas;
	
		
		
	
	}
	
	
}
