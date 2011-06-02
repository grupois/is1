package org.hotel.cliente;

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

	public int realizar_reserva() {
		return 0;
	}
	public int cancelar_reserva() {
		return 0;
	}
	public int modificar_reserva() {
		return 0;
	}

	public Cliente(int numCliente){
		super();
		this.numeroCliente=numCliente;
		this.controlador=new ControladorCliente(this);
		this.vista=new VistaCliente(this.controlador);
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
		this.controlador=new ControladorCliente(this);
		this.vista=new VistaCliente(this.controlador);
	}
	
	@Override
	public boolean equals(Object arg0) {
		if (!(arg0 instanceof Cliente))
			return false;
		Cliente aux = (Cliente) arg0;
		if (aux.getNumeroCliente()==this.getNumeroCliente()) {
			return true;
		} else {
			return false;
		}
	}

}
