package logico;

import java.io.Serializable;
import java.time.LocalDate;

public class Solicitud implements Serializable {
	private static final long serialVersionUID = 1L;
	public Solicitud(String codigo, Cliente cliente, TipoSolicitud tipo, String descripcion) {
		super();
		this.codigo = codigo;
		this.setCliente(cliente);
		this.setTipo(tipo);
		this.setDescripcion(descripcion);
		setEstado(EstadoSolicitud.PENDIENTE);
		fechaRegistro = LocalDate.now();
	}
	private String codigo;
	private Cliente cliente;
	private Empleado empleado;
	private TipoSolicitud tipo;
	private EstadoSolicitud estado;
	private String descripcion;
	private LocalDate fechaRegistro;
	private LocalDate fechaAtencion;
	
	public boolean isResuelto()
	{
		return estado == EstadoSolicitud.COMPLETADA;
	}
	public boolean isCancelada()
	{
		return estado == EstadoSolicitud.CANCELADA;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}
