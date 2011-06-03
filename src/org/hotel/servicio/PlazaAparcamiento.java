package org.hotel.servicio;

public class PlazaAparcamiento implements Servicio {
	public double precioBase=100;
	public double modPrecio=1;
	
	@Override
	public String getServicio() {
		return "Aparcamiento";
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
}
