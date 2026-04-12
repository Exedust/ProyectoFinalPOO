package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Cliente(String nombre, String cedula, String email, String telefono, String direccion, Usuario usuario) {
		super(nombre, cedula, email, telefono, direccion, usuario);
		contratos = new ArrayList<Contrato>();
		pagos = new ArrayList<Pago>();
		deuda = 0;
	}

	private ArrayList<Contrato> contratos;
	private ArrayList<Pago> pagos;
	
	private float deuda;

	public ArrayList<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(ArrayList<Contrato> contratos) {
		this.contratos = contratos;
	}

    public void agregarPago(Pago pago) {
        if (pago != null && !this.pagos.contains(pago)) {
            this.pagos.add(pago);
        }
    }

    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    public ArrayList<Pago> getPagosPendientes() {
        ArrayList<Pago> pendientes = new ArrayList<>();
        for (Pago p : pagos) {
            if (p.isPendiente()) {
                pendientes.add(p);
            }
        }
        return pendientes;
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
