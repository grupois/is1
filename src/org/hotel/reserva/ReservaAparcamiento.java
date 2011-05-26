package org.hotel.reserva;

import org.hotel.cliente.Cliente;
import org.hotel.servicio.Aparcamiento;
import org.hotel.servicio.Servicio;

public class ReservaAparcamiento extends Reserva {

	public ReservaAparcamiento(int inicioDia, int inicioMes, int inicioAno,
			int finDia, int finMes, int finAno, Cliente cliente) {
		super(inicioDia, inicioMes, inicioAno, finDia, finMes, finAno, cliente);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int reservar() {
		this.servicioAsociado = new Aparcamiento();
	}

	@Override
	public int cancelar() {
		return 0;
	}

	@Override
	public Servicio getServicio() {
		return null;
	}

	@Override
	public double getPrecio() {
		return 0;
	}


	
}
