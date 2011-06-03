package org.hotel.reserva;

import java.util.ArrayList;

import org.hotel.cliente.Cliente;

public class GestorReservas {
	private ArrayList<Reserva> listaReservas;
	private int numReserva=0;
	private Cliente client;
	
	public GestorReservas(Cliente client) {
		this.client=client;
		this.listaReservas=new ArrayList<Reserva>();
	}
	
	public Reserva anadirReserva() {
		Reserva res=new Reserva(Integer.parseInt(client.getNumeroCliente()+""+numReserva++),this.client);
		this.listaReservas.add(res);
		return res;
	}
	
	public boolean eliminarReserva(Reserva res) {
		return listaReservas.remove(res);
	}
	
	public Reserva getReserva() {
		for (Reserva res : listaReservas) {
			if (res.getNumReserva()==numReserva) return res;
		}
		return null;
	}
	
	public Object[] getArrayReservas() {
		return this.listaReservas.toArray();
	}

}
