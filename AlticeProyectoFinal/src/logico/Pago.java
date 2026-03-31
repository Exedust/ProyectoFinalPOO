package logico;

import java.time.LocalDate;

public class Pago {
	public Pago(String codigo, String codigoCliente, float monto, float montoPrevio, LocalDate fechaRegistro) {
		super();
		this.codigo = codigo;
		this.codigoCliente = codigoCliente;
		this.monto = monto;
		this.montoPrevio = montoPrevio;
		fechaRegistro = LocalDate.now();
	}
	private String codigo;
	private String codigoCliente;
	private float monto;
	private float montoPrevio;
	private LocalDate fechaRegistro;
	private String concepto;
	
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
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public float getMontoPrevio() {
		return montoPrevio;
	}
	public void setMontoPrevio(float montoPrevio) {
		this.montoPrevio = montoPrevio;
	}
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
}
