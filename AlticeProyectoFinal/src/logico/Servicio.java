package logico;

import java.io.Serializable;

public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;
	public Servicio(TipoServicio tipo, String descripcion) {
	    this.codigo = "SERV-" + String.format("%04d", Altice.getInstance().getGenServicioid() + 1);
	    this.tipo = tipo;
	    this.descripcion = descripcion;
	    this.activo = true;
	}
	
	private String codigo;
	private TipoServicio tipo;
	private String descripcion;
	private boolean activo;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public TipoServicio getTipo() {
		return tipo;
	}
	public void setTipo(TipoServicio tipo) {
		this.tipo = tipo;
	}
}
