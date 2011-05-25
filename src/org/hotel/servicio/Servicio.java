package org.hotel.servicio;

import java.util.ArrayList;

public interface Servicio {
	public String getServicio();
	public int precioBase();
	public ArrayList<String> caracteristicas();
}
