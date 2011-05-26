package org.hotel.cliente;

import java.util.ArrayList;

public class GestorClientes {
	
	static int numCl=0;

	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	public Cliente anadirCliente(String nom, String apell) {
		Cliente res = new Cliente(numCl++, nom, apell);
		listaClientes.add(res);
		return res;
	}
	
	public Cliente eliminarCliente(int num) {
		Cliente res=null;
		for (Cliente c : listaClientes) {
			if (c.getNum()==num){
				res = c;
				break;
			}
		}
		listaClientes.remove(res);
		return res;
	}
	
	public Cliente getCliente(int num) {
		Cliente res=null;
		for (Cliente c : listaClientes) {
			if (c.getNum()==num){
				res = c;
				break;
			}
		}
		return res;
	}
}
