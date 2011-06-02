package org.hotel.cliente;

import java.util.ArrayList;

public class GestorClientes { //singleton
	
	private static GestorClientes yo;
	
	static int numCl=1;

	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	public static GestorClientes getInstance() {
		if(yo==null) {
			yo = new GestorClientes();
		}
		return yo;	
	}
	
	private GestorClientes() {
		super();
	}

	public Cliente anadirCliente(){
		Cliente res=new Cliente(numCl++);
		System.out.println(numCl);
		listaClientes.add(res);
		return res;
		
	}
	public Cliente anadirCliente(String nom, String apell, String dni, String nacionalidad,
			String correo, String ruta_foto) {
		Cliente res = new Cliente(numCl++, nom, apell, dni, nacionalidad, correo, ruta_foto);
		System.out.println(numCl);
		listaClientes.add(res);
		return res;
	}
	
	public Cliente eliminarCliente(int num) {
		Cliente res=null;
		for (Cliente c : listaClientes) {
			if (c.getNumeroCliente()==num){
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
			if (c.getNumeroCliente()==num){
				res = c;
				break;
			}
		}
		return res;
	}
	
	public Object[] getArrayClientes() {
		return listaClientes.toArray();
	}
}
