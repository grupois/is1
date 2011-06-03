package org.hotel.reserva;

import org.hotel.cliente.Cliente;
import org.hotel.servicio.Servicio;

public class ControladorReserva {

	private Reserva res;
	private Cliente client;
	
	public ControladorReserva(Reserva res,Cliente client) {
		this.res=res;
		this.client=client;
	}
	
	public void aceptarReserva(int diaInicio,int mesInicio,int anoInicio,int diaFin,int mesFin,int anoFin,Servicio serv) {
		this.res.setFechaInicio(diaInicio, mesInicio, anoInicio);
		this.res.setFechaFin(diaFin, mesFin, anoFin);
		this.res.setServicioAsociado(serv);
		this.res.setEstablecido(1);
	}
	
	public boolean cancelarReserva() {
		if(this.res.getEstablecido()==0){
			client.cancelar_reserva(this.res);
			return true;
		}
		return false;
	}
}
