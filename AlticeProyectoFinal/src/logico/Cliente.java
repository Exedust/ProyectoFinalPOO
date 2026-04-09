package logico;

import java.util.ArrayList;

public class Cliente extends Persona {
	
	public Cliente(String nombre, String cedula, String email, String telefono, String direccion, Usuario usuario) {
		super(nombre, cedula, email, telefono, direccion, usuario);
		contratos = new ArrayList<Contrato>();
		pagos = new ArrayList<Pago>();
		deuda = 0;
	}

	private ArrayList<Contrato> contratos;
	private ArrayList<Pago> pagos;
	
	float deuda;

	public ArrayList<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(ArrayList<Contrato> contratos) {
		this.contratos = contratos;
	}

	public ArrayList<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(ArrayList<Pago> pagos) {
		this.pagos = pagos;
	}

	public float getDeuda() {
		return deuda;
	}

	public void setDeuda(float deuda) {
		this.deuda = deuda;
	}
	
	
}
