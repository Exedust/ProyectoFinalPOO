package logico;

import java.time.LocalDate;

public class Solicitud {
	public Solicitud(String codigo, String codigoCliente, String tipo, String descripcion) {
		super();
		this.codigo = codigo;
		this.codigoCliente = codigoCliente;
		this.setTipo(tipo);
		this.setDescripcion(descripcion);
		estado = "PENDIENTE";
		fechaRegistro = LocalDate.now();
	}
	private String codigo;
	private String codigoCliente;
	private String codigoEmpleado;
	private String tipo;
	private String estado;
	private String descripcion;
	private LocalDate fechaRegistro;
	private LocalDate fechaAtencion;
	
	public void completar()
	{
		setEstado("COMPLETADA");
		setFechaAtencion(LocalDate.now());
	}
	
	public void asignarEmpleado(String id)
	{
		setCodigoEmpleado(id);
		setEstado("EN PROCESO");
	}
	
	public boolean isResuelto()
	{
		return estado.equals("COMPLETADA");
	}
	public boolean isCancelada()
	{
		return estado.equals("CANCELADA");
	}
	public void cancelar()
	{
		setEstado("CANCELADA");
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}
	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public LocalDate getFechaAtencion() {
		return fechaAtencion;
	}
	public void setFechaAtencion(LocalDate fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
