package org.hotel.reserva;

import org.hotel.cliente.Cliente;

public class ControladorListaReservas {
	
	public Cliente client;
	
	public ControladorListaReservas(Cliente client) {
		this.client=client;
	}

	public void actualizarClientes(VistaListaReservas vista) {
		vista.displayReservas(client.getListaReservas().toArray());
	}

}
