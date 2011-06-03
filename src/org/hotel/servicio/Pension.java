package org.hotel.servicio;

public class Pension implements Servicio, ServicioGenerico {

	private double precioBase=10;
	private double modPrecio=1;
	private static Pension yo;
	
	public static Pension getInstance() {
		if(yo==null) {
			yo = new Pension();
		}
		return yo;	
	}
	
	@Override
	public String getServicio() {
		return "Pension";
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
