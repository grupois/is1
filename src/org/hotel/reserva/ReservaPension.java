package org.hotel.reserva;

import org.hotel.cliente.Cliente;

public class ReservaPension extends Reserva {

	public ReservaPension(int inicioDia, int inicioMes, int inicioAno,
			int finDia, int finMes, int finAno, Cliente cliente) {
		super(inicioDia, inicioMes, inicioAno, finDia, finMes, finAno, cliente);
	}

	@Override
	public int reservar() {
		return 0;
	}

	@Override
	public int cancelar() {
		return 0;
	}

	@Override
	public double getPrecio() {
		return 0;
	}

}

