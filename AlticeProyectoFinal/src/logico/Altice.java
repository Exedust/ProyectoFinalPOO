package logico;

import java.util.ArrayList;

public class Altice {
	
	public Altice(ArrayList<Plan> misPlanes, ArrayList<Cliente> misClientes, ArrayList<Empleado> misEmpleados,
		ArrayList<Contrato> misContratos, ArrayList<Pago> misPagos) {
		super();
		this.misPlanes = misPlanes;
		this.misClientes = misClientes;
		this.misEmpleados = misEmpleados;
		this.misContratos = misContratos;
		this.misPagos = misPagos;
	}
	
	private ArrayList<Plan> misPlanes;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Contrato> misContratos;
	private ArrayList<Pago> misPagos;
	
	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}
	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}
	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}
	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}
	public ArrayList<Contrato> getMisContratos() {
		return misContratos;
	}
	public void setMisContratos(ArrayList<Contrato> misContratos) {
		this.misContratos = misContratos;
	}
	public ArrayList<Pago> getMisPagos() {
		return misPagos;
	}
	public void setMisPagos(ArrayList<Pago> misPagos) {
		this.misPagos = misPagos;
	}
	
	// metodos complejos 
	
	public void regitrarCliente() {
		
	}
	
	public void registrarEmpleado(){
	 
	}
	
	public void crearContrato(String idEmpleado, String idCliente) {
		
	}
	

	// Reportes
	
	
}