package org.hotel.servicio;

import java.util.ArrayList;

public class PlazaAparcamiento implements Servicio {
	public int numPlaza;
	public double precioBase=30;
	public double modPrecio=1;
	private ArrayList<Fechas> fechas_ocupadas;
	
	public PlazaAparcamiento(int numPlaza) {
		this.numPlaza=numPlaza;
		fechas_ocupadas=new ArrayList<Fechas>();
	}
	
	@Override
	public String getServicio() {
		return "Plaza Aparcamiento ";
	}
	@Override
	public double precioBase() {
		return precioBase*modPrecio;
	}

	@Override
	public double precioDesc(int desc) {
		return precioBase*modPrecio*desc/100;
	}
	
	@Override
	public void establecerModificadorPrecio(double mod) {
		modPrecio=mod;
	}
	@Override
	public Servicio reservar(int diaInic, int mesInic, int anoInic, int diaFin,
			int mesFin, int anoFin) {
		for (Fechas f : fechas_ocupadas) {
			if (f.incluida(diaInic, mesInic, anoInic)||f.incluida(diaFin, mesFin, anoFin)) return null;
			if (f.anterior(diaInic, mesInic, anoInic)&&f.posterior(diaFin, mesFin, anoFin)) return null;
		}
		fechas_ocupadas.add(new Fechas(diaInic, mesInic, anoInic, diaFin, mesFin, anoFin));
		return this;
	}
	@Override
	public boolean cancelar(int diaInic, int mesInic, int anoInic, int diaFin,
			int mesFin, int anoFin) {
		return fechas_ocupadas.remove(new Fechas(diaInic, mesInic, anoInic, diaFin, mesFin, anoFin));
	}
	
	@Override
	public String toString() {
		return this.getServicio()+" "+numPlaza;
	}
}
