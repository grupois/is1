package org.hotel.reserva;

import org.hotel.cliente.Cliente;
import org.hotel.servicio.Servicio;

public class Reserva {
	
	private int inicioDia;
	private int inicioMes;
	private int inicioAno;
	
	private int finDia;
	private int finMes;
	private int finAno;
	
	private double precio=0;
	private int establecido=0;
	private int numReserva;
	private String localizacion;
	private Cliente cliente;
	Servicio servicioAsociado;
	
	private VistaReserva vistaRes;
	private ControladorReserva controladorRes;
	private ControladorListaReservas contListRes; 
	
	public void establecerServicio(Servicio serv){
		this.servicioAsociado=serv;
	}
	
	
	public double getPrecio() {
		return this.precio;
	}
	
	public void setFechaInicio(int diaInicio,int mesInicio,int anoInicio) {
		this.inicioDia = diaInicio;
		this.inicioMes = mesInicio;
		this.inicioAno = anoInicio;
	}
	
	public void setFechaFin(int diaFin,int mesFin,int anoFin) {
		this.finDia = diaFin;
		this.finMes = mesFin;
		this.finAno = anoFin;
	}
	
	public void setEstablecido(int establecido){
		this.establecido=establecido;
	}
	
	public int getEstablecido(){
		return this.establecido;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public void setServicioAsociado(Servicio servicioAsociado) {
		this.servicioAsociado = servicioAsociado;
	}
	
	public VistaReserva getVistaReserva() {
		return vistaRes;
	}
	public void setControladorListaReservas(ControladorListaReservas list) {
		this.contListRes=list;
	}
	public ControladorListaReservas getControladorListaReservas() {
		return this.contListRes;
	}

	public Servicio getServicio() {
		return this.servicioAsociado;
	}
	
	public Reserva(int numReserva,Cliente cliente) {
		this.numReserva=numReserva;
		this.cliente = cliente;
		this.controladorRes=new ControladorReserva(this,cliente);
		this.vistaRes=new VistaReserva(this.controladorRes,this);
	}
	
	public Reserva(int inicioDia, int inicioMes, int inicioAno, int finDia,
			int finMes, int finAno, int numReserva, int precio, String localizacion, Cliente cliente) {
		super();
		this.inicioDia = inicioDia;
		this.inicioMes = inicioMes;
		this.inicioAno = inicioAno;
		this.finDia = finDia;
		this.finMes = finMes;
		this.finAno = finAno;
		this.cliente = cliente;
		this.localizacion = localizacion;
		this.numReserva = numReserva;
		this.precio=precio;
		this.vistaRes = new VistaReserva(this.controladorRes,this);
		this.controladorRes = new ControladorReserva(this,cliente);
	}
	
	public VistaReserva getVistaRes(){
		return vistaRes;
	}
	
	public int getNumReserva() {
		return numReserva;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public String getLocalizacion() {
		return localizacion;
	}
	
	public int[] getInicioFechaReserva() {
		int[] res = new int[3];
		res[0]=this.inicioDia;
		res[1]=this.inicioMes;
		res[2]=this.inicioAno;
		return res;
	}
	
	public int[] getFinFechaReserva() {
		int[] res = new int[3];
		res[0]=this.finDia;
		res[1]=this.finMes;
		res[2]=this.finAno;
		return res;
	}
	
	@Override
	public String toString() {
		String servicio=this.servicioAsociado==null? "Sin servicio":this.servicioAsociado.toString();
		return this.numReserva+"  \t\t\t  "+this.inicioDia+"/"+this.inicioMes+"/"+this.inicioAno+"\t - \t"+this.finDia+"/"+this.finMes+"/"+this.finAno+
			"  \t\t\t  "+servicio+"  \t\t\t  "+this.precio+" €";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Reserva)) return false;
		Reserva res=(Reserva) obj;
		return res.getNumReserva()==this.numReserva;
	}
}
