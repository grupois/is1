package org.hotel.servicio;

public interface Servicio {
	public String getServicio();
	public double precioBase();
	public double precioDesc(int desc);
	public void establecerModificadorPrecio(double mod);
	public Servicio reservar(int diaInic,int mesInic,int anoInic,int diaFin,int mesFin,int anoFin);
	public boolean cancelar(int diaInic,int mesInic,int anoInic,int diaFin,int mesFin,int anoFin);
	@Override
	public String toString();
}
