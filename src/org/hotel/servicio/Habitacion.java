package org.hotel.servicio;

import java.util.ArrayList;

public class Habitacion implements Servicio {
	private int numeroHab;
	private final double precioBase=100;
	private double modPrecio=1;
	private ArrayList<Fechas> fechas_ocupadas;
	
	@Override
	public String getServicio() {
		return "Habitación";
	}
	
	@Override
	public double precioBase() {
		return precioBase*modPrecio;
	}

	@Override
	public void establecerModificadorPrecio(double mod) {
		modPrecio=mod;
	}

	@Override
	public double precioDesc(int desc) {
		return precioBase*modPrecio*desc/100;
	}

	public Habitacion(int numeroHab) {
		this.numeroHab=numeroHab;
		fechas_ocupadas=new ArrayList<Habitacion.Fechas>();
	}
	
	public int getNumeroHab(){
		return numeroHab;
	}
	
	public boolean reservar(int diaInic,int mesInic,int anoInic,int diaFin,int mesFin,int anoFin){
		for (Fechas f : fechas_ocupadas) {
			if (f.incluida(diaInic, mesInic, anoInic)||f.incluida(diaFin, mesFin, anoFin)) return false;
			if (f.anterior(diaInic, mesInic, anoInic)&&f.posterior(diaFin, mesFin, anoFin)) return false;
		}
		fechas_ocupadas.add(new Fechas(diaInic, mesInic, anoInic, diaFin, mesFin, anoFin));
		return true;
	}
	
	public boolean cancelar(int diaInic,int mesInic,int anoInic,int diaFin,int mesFin,int anoFin){
		return fechas_ocupadas.remove(new Fechas(diaInic, mesInic, anoInic, diaFin, mesFin, anoFin));
	}
	
	class Fechas {
		int diaInic;
		int mesInic;
		int anoInic;
		int diaFin;
		int mesFin;
		int anoFin;
		
		public Fechas(int diaInic, int mesInic, int anoInic, int diaFin,
				int mesFin, int anoFin) {
			super();
			this.diaInic = diaInic;
			this.mesInic = mesInic;
			this.anoInic = anoInic;
			this.diaFin = diaFin;
			this.mesFin = mesFin;
			this.anoFin = anoFin;
		}
		public boolean incluida(int dia,int mes,int ano){
			return (ano>=anoInic&&ano<=anoFin&&mes>=mesInic&&mes<=mesFin&&dia>=diaInic&&dia<=diaFin);
		}
		public boolean posterior(int dia,int mes,int ano){
			return ano>=anoFin&&mes>=mesFin&&dia>diaFin;
		}
		public boolean anterior(int dia,int mes,int ano){
			return ano<=anoInic&&mes<=mesInic&&dia<diaInic;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Fechas)) return false;
			Fechas fech=(Fechas) obj;
			return fech.diaInic==this.diaInic&&fech.mesInic==this.mesInic&&fech.anoInic==this.anoInic
					&&fech.diaFin==this.diaFin&&fech.mesFin==this.mesFin&&fech.anoFin==this.anoFin; 
		}
	}
}
