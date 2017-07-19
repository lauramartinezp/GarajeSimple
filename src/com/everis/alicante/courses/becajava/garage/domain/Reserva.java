package com.everis.alicante.courses.becajava.garage.domain;

import java.util.Date;

public class Reserva {
	
	private String codigoReserva;
	
	private Plaza plaza;
	
	private Cliente cliente;
	
	private Date fechaReserva;
	
	private Date fechaInicio;
	
	private Date fechaFin;

	public Plaza getPlaza() {
		return plaza;
	}

	public void setPlaza(Plaza plaza) {
		this.plaza = plaza;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String getCodigoReserva() {
		
		//logica del codigo de reserva
		
		//codigoReserva="";
		//codigoReserva=codigoReserva.concat(String.valueOf(this.plaza.getNumeroPlaza()));
		//codigoReserva=codigoReserva.concat(this.GUION);
		//codigoReserva=codigoReserva.concat(String.valueOf(this.plaza.getCliente().getNif()));
		//codigoReserva=codigoReserva.concat(this.GUION);
		//codigoReserva.concat(String.valueOf(Math.random()*1000000));
		
		return codigoReserva;
	}
	
	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}


	@Override
	public String toString() {
		return "Reserva [plaza=" + plaza + ", cliente=" + cliente + ", fechaReserva=" + fechaReserva + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	public String convierteAFormatoTxt() {
		String str="";
		
		str = str.concat(String.valueOf(this.getCodigoReserva()));
		str = str.concat(";");
		str = str.concat(String.valueOf(this.plaza.getNumeroPlaza()));
		str = str.concat(";");
		str = str.concat(this.cliente.getNif());
		str = str.concat(";");
		str = str.concat(this.cliente.getVehiculo().getMatricula());
		str = str.concat(";");
		str = str.concat(this.fechaReserva.toString());
		
		return str;
		
		
	}

	public void add(Reserva reservas) {
		// TODO Auto-generated method stub
		
	}

}
