package org.hotel.reserva;

import org.hotel.cliente.Cliente;
import org.hotel.servicio.Servicio;

public class Reserva {
	
	private int inicioDia;
	private int inicioMes;
	private int inicioAno;
	
	private int finDia;
	private int finMes;
	private int finAno;
	
	private int numReserva;
	private String localizacion;
	private Cliente cliente;
	Servicio servicioAsociado;
	
	private VistaReserva vistaRes;
	private ControladorReserva controladorRes;
	
	public int reservar() {
		return 0;
	}
	public int cancelar() {
		return 0;
	}
	public double getPrecio() {
		return 0;
	}
	

	public Servicio getServicio() {
		return this.servicioAsociado;
	}
	
	public Reserva(int numReserva,Cliente cliente) {
		this.numReserva=numReserva;
		this.cliente = cliente;
		this.vistaRes=new VistaReserva();
		this.controladorRes=new ControladorReserva();
	}
	
	public Reserva(int inicioDia, int inicioMes, int inicioAno, int finDia,
			int finMes, int finAno, int numReserva, String localizacion, Cliente cliente) {
		super();
		this.inicioDia = inicioDia;
		this.inicioMes = inicioMes;
		this.inicioAno = inicioAno;
		this.finDia = finDia;
		this.finMes = finMes;
		this.finAno = finAno;
		this.cliente = cliente;
		this.localizacion=localizacion;
		this.numReserva=numReserva;
		this.vistaRes=new VistaReserva();
		this.controladorRes=new ControladorReserva();
	}
	
	public VistaReserva getVistaRes(){
		return vistaRes;
	}
	
	public int getNumReserva() {
		return numReserva;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public String getLocalizacion() {
		return localizacion;
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
	
	@Override
	public String toString() {
		return this.inicioDia+"/"+this.inicioMes+"/"+"/"+this.inicioAno+"\t - \t"+this.finDia+"/"+this.finMes+"/"+this.finAno+" \t\t\t "+this.numReserva;
	}
}
