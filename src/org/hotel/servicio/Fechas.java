package org.hotel.servicio;

public class Fechas {
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
