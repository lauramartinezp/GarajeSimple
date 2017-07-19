package com.everis.alicante.courses.becajava.garage.interfaces.implementacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.becajava.garage.domain.Plaza;
import com.everis.alicante.courses.becajava.garage.interfaces.PlazaDAO;

public class PlazaDAOFileImp implements PlazaDAO{

	@Override
	public List<Plaza> readPlazas() throws IOException {
		// Pasos para leer un fichero
		
		//leerlo, buscarlo
		
		List<Plaza> plazas = new ArrayList<Plaza>();
		String linea;
		
		File file = new File("src/resources/Plazas.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		
			while((linea=buffer.readLine())!=null) {
				
				if(!linea.contains("NUMERO_PLAZA")) {
					
				Plaza plazaTemp = new Plaza();

				String[] temp = linea.split(";");
				
				plazaTemp.setNumeroPlaza(Integer.parseInt(temp[0]));
				
				plazaTemp.setPrecio(Double.parseDouble(temp[1]));
				
				//plazaTemp.setPrecio(Double.parseDouble(linea.substring(linea.indexOf(";",1)+1,linea.indexOf(";",2))));
				
				
				plazas.add(plazaTemp);
				
				
				}
			}
		
		reader.close();
		return plazas;
	
		
		
	
	}


	public static void main(String args[]) throws IOException {
		
		PlazaDAO dao = new PlazaDAOFileImp();
		
		dao.readPlazas();
		
		
	}

	@Override
	public void createPlaza(Plaza[] plazas) {
		// TODO Auto-generated method stub
		
	}
	
}
