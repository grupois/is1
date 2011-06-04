package org.hotel.servicio;

public interface ServicioGenerico {
	public String getServicio();
	public Servicio reservar(int diaInic,int mesInic,int anoInic,int diaFin,int mesFin,int anoFin);
	public boolean cancelar(Servicio serv,int diaInic,int mesInic,int anoInic,int diaFin,int mesFin,int anoFin);
	public double getPrecioBase();
}
