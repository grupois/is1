package org.hotel.cliente;

import org.hotel.reserva.ControladorListaReservas;
import org.hotel.reserva.GestorReservas;
import org.hotel.reserva.Reserva;

public class Cliente {

	private int numeroCliente;
	private String nombre;
	private String apellidos;
	private String dni;
	private String nacionalidad;
	private String correo;
	private String ruta_foto;
	private VistaCliente vista;
	private ControladorCliente controlador;
	private int establecido=0;
	private GestorReservas gestorReservas;
	private static int numReserva=0;

	public int darNumeroReserva(){
		return numReserva++;
	}

	public GestorReservas getGestorReservas() {
		return gestorReservas;
	}
	public void setEstablecido(int establecido) {
		this.establecido = establecido;
	}
	public int getEstablecido() {
		return establecido;
	}
	public VistaCliente getVista() {
		return vista;
	}
	public ControladorCliente getControlador() {
		return controlador;
	}
	public String getNombre() {
		return nombre;
	}
	public int getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getRuta_foto() {
		return ruta_foto;
	}
	public void setRuta_foto(String ruta_foto) {
		this.ruta_foto = ruta_foto;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Reserva realizar_reserva(ControladorListaReservas contListRes) {
		Reserva res=this.gestorReservas.anadirReserva();
		res.setControladorListaReservas(contListRes);
		return res;
	}
	public void cancelar_reserva(Reserva res) {
		this.gestorReservas.eliminarReserva(res);
	}
	
	public int modificar_reserva() {
		return 0;
	}

	public Cliente(int numCliente){
		super();
		this.numeroCliente=numCliente;
		this.gestorReservas=new GestorReservas(this);
		this.controlador=new ControladorCliente(this);
		this.vista=new VistaCliente(this,this.controlador);
	}

	public Cliente(int numeroCliente, String nombre, String apellidos,
			String dni, String nacionalidad, String correo, String ruta_foto) {
		super();
		this.numeroCliente = numeroCliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.nacionalidad = nacionalidad;
		this.correo = correo;
		this.ruta_foto = ruta_foto;
		this.gestorReservas=new GestorReservas(this);
		this.controlador=new ControladorCliente(this);
		this.vista=new VistaCliente(this,this.controlador);
	}

	@Override
	public boolean equals(Object arg0) {
		if (!(arg0 instanceof Cliente))
			return false;
		Cliente aux = (Cliente) arg0;
		return aux.getNumeroCliente()==this.getNumeroCliente();
	}

}
