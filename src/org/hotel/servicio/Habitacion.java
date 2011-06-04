package org.hotel.servicio;

import java.util.ArrayList;

public class Habitacion implements Servicio {
	private int numeroHab;
	private final double precioBase=100;
	private double modPrecio=1;
	private ArrayList<Fechas> fechas_ocupadas;
	
	@Override
	public String getServicio() {
		return "Habitación";
	}
	
	@Override
	public double precioBase() {
		return precioBase*modPrecio;
	}

	@Override
	public void establecerModificadorPrecio(double mod) {
		modPrecio=mod;
	}

	@Override
	public double precioDesc(int desc) {
		return precioBase*modPrecio*desc/100;
	}

	public Habitacion(int numeroHab) {
		this.numeroHab=numeroHab;
		fechas_ocupadas=new ArrayList<Fechas>();
	}
	
	public int getNumeroHab(){
		return numeroHab;
	}
	
	@Override
	public Servicio reservar(int diaInic,int mesInic,int anoInic,int diaFin,int mesFin,int anoFin){
		for (Fechas f : fechas_ocupadas) {
			if (f.incluida(diaInic, mesInic, anoInic)||f.incluida(diaFin, mesFin, anoFin)) return null;
			if (f.anterior(diaInic, mesInic, anoInic)&&f.posterior(diaFin, mesFin, anoFin)) return null;
		}
		fechas_ocupadas.add(new Fechas(diaInic, mesInic, anoInic, diaFin, mesFin, anoFin));
		return this;
	}
	
	@Override
	public boolean cancelar(int diaInic,int mesInic,int anoInic,int diaFin,int mesFin,int anoFin){
		return fechas_ocupadas.remove(new Fechas(diaInic, mesInic, anoInic, diaFin, mesFin, anoFin));
	}
	
	@Override
	public String toString() {
		return this.getServicio()+" "+numeroHab;
	}
	
	
}
