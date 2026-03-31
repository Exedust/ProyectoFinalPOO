package logico;

import java.time.LocalDate;

public class Usuario {
	public Usuario(String codigo, String user, String password, String rol) {
		super();
		this.codigo = codigo;
		this.user = user;
		this.password = password;
		this.rol = rol;
		activo = true;
		fechaRegistro = LocalDate.now();
	}
	private String codigo;
	private String user;
	private String password;
	private String rol;
	private LocalDate fechaRegistro;
	private boolean activo;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
