package logico;

import java.time.LocalDate;

public class Solicitud {
	public Solicitud(String codigo, String codigoCliente, TipoSolicitud tipo, String descripcion) {
		super();
		this.codigo = codigo;
		this.codigoCliente = codigoCliente;
		this.setTipo(tipo);
		this.setDescripcion(descripcion);
		setEstado(EstadoSolicitud.PENDIENTE);
		fechaRegistro = LocalDate.now();
	}
	private String codigo;
	private String codigoCliente;
	private String codigoEmpleado;
	private TipoSolicitud tipo;
	private EstadoSolicitud estado;
	private String descripcion;
	private LocalDate fechaRegistro;
	private LocalDate fechaAtencion;
	
	public void completar()
	{
		setEstado(EstadoSolicitud.COMPLETADA);
		setFechaAtencion(LocalDate.now());
	}
	
	public void asignarEmpleado(String id)
	{
		setCodigoEmpleado(id);
		setEstado(EstadoSolicitud.EN_PROCESO);
	}
	
	public boolean isResuelto()
	{
		return estado == EstadoSolicitud.COMPLETADA;
	}
	public boolean isCancelada()
	{
		return estado == EstadoSolicitud.CANCELADA;
	}
	public void cancelar()
	{
		setEstado(EstadoSolicitud.CANCELADA);
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstadoSolicitud getEstado() {
		return estado;
	}

	public void setEstado(EstadoSolicitud estado) {
		this.estado = estado;
	}

	public TipoSolicitud getTipo() {
		return tipo;
	}

	public void setTipo(TipoSolicitud tipo) {
		this.tipo = tipo;
	}
}
