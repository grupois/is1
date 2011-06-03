package org.hotel.cliente;

import org.hotel.reserva.Reserva;

public class ControladorCliente {
	
	private Cliente client;
	
	public ControladorCliente(Cliente client) {
		this.client=client;
	}
	public void aceptar(String nombre,String apellidos, String dni, String nacionalidad, String correo, String ruta_foto){
		this.client.setNombre(nombre);
		this.client.setApellidos(apellidos);
		this.client.setDni(dni);
		this.client.setNacionalidad(nacionalidad);
		this.client.setCorreo(correo);
		this.client.setRuta_foto(ruta_foto);
		this.client.setEstablecido(1);
	}
	public Cliente cancelar(){
		if(this.client.getEstablecido()==0)
			GestorClientes.getInstance().eliminarCliente(this.client.getNumeroCliente());
		return this.client;
	}
	
	public Reserva anadirReserva() {
		return this.client.getGestorReservas().anadirReserva();
	}
	
	public boolean borrarReserva(Reserva res){
		return this.client.getGestorReservas().eliminarReserva(res);
	}

}
