package logico;

import java.time.LocalDate;

public class Pago {
	public Pago(String codigo, Cliente cliente, float monto) {
		super();
		this.codigo = codigo;
		this.setCliente(cliente);
		this.monto = monto;
		fechaRegistro = LocalDate.now();
	}
	private String codigo;
	private Cliente cliente;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
