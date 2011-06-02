package org.hotel.cliente;

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
	}
	public Cliente cancelar(){
		return client;
	}

}
