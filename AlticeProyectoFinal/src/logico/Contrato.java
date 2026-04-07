package logico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contrato {
	public Contrato(String codigo, Empleado empleado, Cliente cliente, Plan plan) {
		super();
		this.codigo = codigo;
		this.empleado = empleado;
		this.cliente = cliente;
		pagos = new ArrayList<Pago>();
		this.plan = plan;
		fechaInicio = LocalDate.now();
		activo = true;
	}

	private String codigo;
	private Empleado empleado;
	private Persona cliente;
	private ArrayList<Pago> pagos;
	private Plan plan;
	private LocalDate fechaInicio;
	private boolean activo;
	
	public int getMesesTranscurridos() {
	    LocalDate hoy = LocalDate.now();
	    int anios = hoy.getYear() - fechaInicio.getYear();
	    int meses = hoy.getMonthValue() - fechaInicio.getMonthValue();
	    return (anios * 12) + meses;
	}

	public float getMontoAcumulado() {
	    return getMesesTranscurridos() * plan.getMonto();
	}

	public float getTotalPagado() {
	    float total = 0;
	    for (Pago p : pagos)
	        total += p.getMonto();
	    return total;
	}

	public float getDeuda() {
	    return getMontoAcumulado() - getTotalPagado();
	}

	public int getMesesDeuda() {
	    float precioMensual = plan.getMonto();
	    if (precioMensual == 0) return 0;
	    return (int) (getDeuda() / precioMensual);
	}

	public boolean estaAlDia() {
	    return getDeuda() <= 0;
	}

	public void cancelar() {
	    this.activo = false;
	}
	
	public Pago registrarPago(String codigo, float monto) {
	    Pago p = new Pago(codigo, cliente, monto);
	    pagos.add(p);
	    return p;
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

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
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
}
