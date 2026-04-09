package logico;

import java.io.Serializable;

public abstract class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	public Persona(String nombre, String cedula, String email, String telefono, String direccion, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.usuario = usuario;
	}
	
	protected String nombre;
	protected String cedula;
	protected String email;
	protected String telefono;
	protected String direccion;
	protected Usuario usuario;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getCodigo() {
        if (usuario != null) {
            return usuario.getCodigo();
        }
        return null;
    }
	public boolean isActivo() {
        if (usuario != null) {
            return usuario.isActivo();
        }
        return false;
    }
	
	public Rol getRol()
	{
		return usuario.getRol();
	}
}
