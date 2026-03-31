package logico;

public abstract class Servicio {
	public Servicio(String codigo, String nombre, String descripcion, float costoBase) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costoBase = costoBase;
		activo = true;
	}
	protected String codigo;
	protected String nombre;
	protected String descripcion;
	protected float costoBase;
	protected boolean activo;
	
	public abstract float getCosto();
	public abstract float getDetalles();
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getCostoBase() {
		return costoBase;
	}
	public void setCostoBase(float costoBase) {
		this.costoBase = costoBase;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
