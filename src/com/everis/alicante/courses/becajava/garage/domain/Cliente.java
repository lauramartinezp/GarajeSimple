package com.everis.alicante.courses.becajava.garage.domain;

public class Cliente {


	private String nif;
	
	private String nombreCompleto;
	
	private Vehiculo vehiculo;

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	@Override
	public String toString() {
		return "Cliente= " + nombreCompleto +", nif=" + nif + ", vehiculo=" + vehiculo;
	}
}
