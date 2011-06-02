package org.hotel.cliente;

public class ControladorListaClientes{

	public void actualizarClientes(VistaListaClientes vista) {
		vista.displayClientes(GestorClientes.getInstance().getArrayClientes());
	}
	
	public void insertarCliente(){
		GestorClientes.getInstance().anadirCliente();
	}
	
	public void insertarCliente(String nom, String apell,String dni, String nacionalidad, String correo, String ruta_foto) {
		GestorClientes.getInstance().anadirCliente(nom, apell, dni, nacionalidad, correo, ruta_foto);
	}
	
	public void eliminarCliente(int num) {
		GestorClientes.getInstance().eliminarCliente(num);
	}

}