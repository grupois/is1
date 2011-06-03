package org.hotel.servicio;

public interface Servicio {
	public String getServicio();
	public double precioBase();
	public double precioDesc(int desc);
	public void establecerModificadorPrecio(double mod);
}
