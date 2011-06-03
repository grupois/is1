package org.hotel.servicio;

import java.util.ArrayList;

public class GestorServicios {
	
	private ArrayList<ServicioGenerico> servicios;
	private static GestorServicios yo;
	
	public static GestorServicios getInstance() {
		if(yo==null) {
			yo = new GestorServicios();
		}
		return yo;	
	}
	
	
	private GestorServicios() {
		servicios=new ArrayList<ServicioGenerico>();
		servicios.add(GestorAparcamientos.getInstance());
		servicios.add(GestorHabitaciones.getInstance());
		servicios.add(Pension.getInstance());
	}
	
	public void anadirServicio(ServicioGenerico serv) {
		servicios.add(serv);
	}
	
	public void eliminarServicio(ServicioGenerico serv) {
		servicios.remove(serv);
	}
	
	public Object[] getArrayServicios(){
		return servicios.toArray();
	}
	
	

}
