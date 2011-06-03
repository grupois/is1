package org.hotel.servicio;

import java.util.ArrayList;

public class GestorHabitaciones implements ServicioGenerico{

	private static int numHab=50;
	private ArrayList<Habitacion> listHabitaciones;
	private static GestorHabitaciones yo;
	
	@Override
	public String getServicio() {
		return "Habitaciones";
	}

	public static GestorHabitaciones getInstance() {
		if(yo==null) {
			yo = new GestorHabitaciones();
		}
		return yo;	
	}
	
	public GestorHabitaciones() {
		listHabitaciones=new ArrayList<Habitacion>();
		for (int i = 0; i < numHab; i++) {
			listHabitaciones.add(new Habitacion(i));
		}
	}

	public int habitacionesLibres(){
		return numHab;
	}

	public Habitacion reservarHabitacion(int diaInic,int mesInic,int anoInic,int diaFin,int mesFin,int anoFin){
		for (Habitacion hab : listHabitaciones) {
			if (hab.reservar(diaInic, mesInic, anoInic, diaFin, mesFin, anoFin)) return hab;
		}
		return null;
	}

	public static void liberarHabitacion(Habitacion hab,int diaInic,int mesInic,int anoInic,int diaFin,int mesFin,int anoFin){
		hab.cancelar(diaInic, mesInic, anoInic, diaFin, mesFin, anoFin);
	}

}
