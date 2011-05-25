package org.hotel.cliente;

public interface Cliente {
	public int realizar_reserva();
	public int cancelar_reserva();
	public int modificar_reserva();
	public String getNombre();
	public String getDatos();
}
