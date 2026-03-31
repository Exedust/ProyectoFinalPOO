package logico;

public class Empleado extends Persona {
	public Empleado(String nombre, String cedula, String email, String telefono, String direccion, Usuario usuario,
			float comision, float salario) {
		super(nombre, cedula, email, telefono, direccion, usuario);
		this.comision = comision;
		this.salario = salario;
	}
	private float comision;
	private float salario;
	
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
}
