package logico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contrato {
	public Contrato(String codigo, Empleado empleado, Cliente cliente, ArrayList<Pago> pagos, Plan plan, float monto, 
			LocalDate fechaFin, int diaCobro) {
		super();
		this.codigo = codigo;
		this.empleado = empleado;
		this.cliente = cliente;
		this.pagos = pagos;
		this.plan = plan;
		this.monto = monto;
		activo = true;
		fechaInicio = LocalDate.now();
		this.fechaFin = fechaFin;
		this.diaCobro = diaCobro;
	}

	private String codigo;
	private Empleado empleado;
	private Cliente cliente;
	private ArrayList<Pago> pagos;
	private Plan plan;
	private float monto;
	private boolean activo;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int diaCobro;
	
	public int getMesesFacturados()
	{
		int meses = 0;
		return meses;
	}
	
	public float getDeuda()
	{
		float deuda = 0;
		
		return deuda;
	}
	
	public int getDuracionMeses()
	{
		return 0;
	}
	
	public boolean estaAlDia()
	{
		return false;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(ArrayList<Pago> pagos) {
		this.pagos = pagos;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getDiaCobro() {
		return diaCobro;
	}

	public void setDiaCobro(int diaCobro) {
		this.diaCobro = diaCobro;
	}
}
