package org.hotel.servicio;

import java.util.ArrayList;

public class GestorAparcamientos implements ServicioGenerico {

	private static int plazasLibres=50;
	private double precioBase=30;
	private static GestorAparcamientos yo;
	private ArrayList<PlazaAparcamiento> listPlazas;

	public static GestorAparcamientos getInstance() {
		if(yo==null) {
			yo = new GestorAparcamientos();
		}
		return yo;	
	}
	
	
	@Override
	public String getServicio() {
		return "Aparcamiento";
	}

	
	
	public int plazasLibres() {
		return plazasLibres;
	}
	
	public static boolean reservarPlaza() {
		if(plazasLibres==0) return false;
		plazasLibres--;
		return true;
	}
	
	public static void liberarPlaza() {
		plazasLibres++;
	}
	
	public GestorAparcamientos() {
		listPlazas=new ArrayList<PlazaAparcamiento>();
		for (int i = 0; i < plazasLibres; i++) {
			listPlazas.add(new PlazaAparcamiento(i));
		}
	}


	@Override
	public Servicio reservar(int diaInic, int mesInic, int anoInic, int diaFin,
			int mesFin, int anoFin) {
		for (PlazaAparcamiento pl : listPlazas) {
			if (pl.reservar(diaInic, mesInic, anoInic, diaFin, mesFin, anoFin) != null) return pl;
		}
		return null;
	}


	@Override
	public boolean cancelar(Servicio serv, int diaInic, int mesInic,
			int anoInic, int diaFin, int mesFin, int anoFin) {
		return serv.cancelar(diaInic, mesInic, anoInic, diaFin, mesFin, anoFin);

	}


	@Override
	public double getPrecioBase() {
		return precioBase;
	}

}
