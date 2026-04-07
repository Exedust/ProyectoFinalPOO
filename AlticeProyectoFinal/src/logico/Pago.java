package logico;

import java.time.LocalDate;

public class Pago {
	public Pago(String codigo, Persona cliente, float monto) {
		super();
		this.codigo = codigo;
		this.setCliente(cliente);
		this.monto = monto;
		this.setPendiente(true);
		this.setActivo(true);
		fechaRegistro = LocalDate.now();
	}
	private String codigo;
	private Persona cliente;
	private float monto;
	private boolean pendiente;
	private boolean activo;
	private LocalDate fechaRegistro;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Persona getCliente() {
		return cliente;
	}
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	public boolean isPendiente() {
		return pendiente;
	}
	public void setPendiente(boolean pendiente) {
		this.pendiente = pendiente;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
