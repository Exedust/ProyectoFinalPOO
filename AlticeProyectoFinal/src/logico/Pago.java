package logico;

import java.time.LocalDate;

public class Pago {
	public Pago(String codigo, Persona cliente, float monto) {
		super();
		this.codigo = codigo;
		this.setCliente(cliente);
		this.monto = monto;
		fechaRegistro = LocalDate.now();
	}
	private String codigo;
	private Persona cliente;
	private float monto;
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
}
