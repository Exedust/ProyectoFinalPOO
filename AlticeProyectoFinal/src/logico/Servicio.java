package logico;

public class Servicio {
	public Servicio(String codigo, TipoServicio tipo, String descripcion) {
		super();
		this.codigo = codigo;
		this.setTipo(tipo);
		this.descripcion = descripcion;
		activo = true;
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
