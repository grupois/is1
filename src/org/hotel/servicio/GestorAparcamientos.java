package org.hotel.servicio;

public class GestorAparcamientos implements ServicioGenerico {

	public static int plazasLibres=50;

	public static GestorAparcamientos yo;
	
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

}
