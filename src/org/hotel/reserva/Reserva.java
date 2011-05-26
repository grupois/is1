package org.hotel.reserva;

import org.hotel.cliente.Cliente;
import org.hotel.servicio.Servicio;

public abstract class Reserva {
	
	private int inicioDia;
	private int inicioMes;
	private int inicioAno;
	
	private int finDia;
	private int finMes;
	private int finAno;
	
	private Cliente cliente;
	Servicio servicioAsociado;
	
	public abstract int reservar();
	public abstract  int cancelar();
	public abstract double getPrecio();
	

	public Servicio getServicio() {
		return this.servicioAsociado;
	}
	
	public Reserva(int inicioDia, int inicioMes, int inicioAno, int finDia,
			int finMes, int finAno, Cliente cliente) {
		super();
		this.inicioDia = inicioDia;
		this.inicioMes = inicioMes;
		this.inicioAno = inicioAno;
		this.finDia = finDia;
		this.finMes = finMes;
		this.finAno = finAno;
		this.cliente = cliente;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public int[] getInicioFechaReserva() {
		int[] res = new int[3];
		res[0]=this.inicioDia;
		res[1]=this.inicioMes;
		res[2]=this.inicioAno;
		return res;
	}
	
	public int[] getFinFechaReserva() {
		int[] res = new int[3];
		res[0]=this.finDia;
		res[1]=this.finMes;
		res[2]=this.finAno;
		return res;
	}
	
}
