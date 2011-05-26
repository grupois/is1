package org.hotel.cliente;

public class Cliente {

	private int numeroCliente;
	private String nombreCliente;
	private String apellidosCliente;

	public int realizar_reserva() {
		return 0;
	}
	public int cancelar_reserva() {
		return 0;
	}
	public int modificar_reserva() {
		return 0;
	}

	public String getNombre() {
		return this.apellidosCliente + ", " + this.nombreCliente;
	}

	public int getNum() {
		return this.numeroCliente;
	}
	public Cliente(int numeroCliente, String nombreCliente,
			String apellidosCliente) {
		super();
		this.numeroCliente = numeroCliente;
		this.nombreCliente = nombreCliente;
		this.apellidosCliente = apellidosCliente;
	}

	@Override
	public boolean equals(Object arg0) {
		if (!(arg0 instanceof Cliente))
			return false;
		Cliente aux = (Cliente) arg0;
		if (aux.getNum()==this.getNum()) {
			return true;
		} else {
			return false;
		}
	}


}
