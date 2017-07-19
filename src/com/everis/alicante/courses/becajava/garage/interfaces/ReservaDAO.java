package com.everis.alicante.courses.becajava.garage.interfaces;

import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.becajava.garage.domain.Reserva;

public interface ReservaDAO {

	void createReserva(Reserva reserva) throws IOException;
	
	Map<String,Reserva> readReserva() throws IOException;
	

}
