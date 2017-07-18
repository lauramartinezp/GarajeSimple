package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import com.everis.alicante.courses.becajava.garage.domain.Cliente;
import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.domain.Reserva;
import com.everis.alicante.courses.becajava.garage.domain.Vehiculo;

public class ReservaDAOFileImp implements ReservaDAO{

	@Override
	public void saveReserva(Reserva reserva) throws IOException {

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
		
		dao.saveReserva(reserva);
		
	}

}
