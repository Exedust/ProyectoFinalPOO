package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Empleado extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	public Empleado(String nombre, String cedula, String email, String telefono, String direccion, Usuario usuario,
			float comision, float salario) {
		super(nombre, cedula, email, telefono, direccion, usuario);
		this.comision = comision;
		this.salario = salario;
	}
	private Float comision;
	private Float salario;
	
	public Float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	public Float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
}
