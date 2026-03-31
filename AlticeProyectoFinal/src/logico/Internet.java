package logico;

public class Internet extends Servicio {
	public Internet(String codigo, String nombre, String descripcion, float costoBase, float mbps, String tipo) {
		super(codigo, nombre, descripcion, costoBase);
		this.mbps = mbps;
		this.tipo = tipo;
	}
	private float mbps;
	private String tipo;
	
	public float getMbps() {
		return mbps;
	}
	public void setMbps(float mbps) {
		this.mbps = mbps;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public float getCosto() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public float getDetalles() {
		// TODO Auto-generated method stub
		return 0;
	}
}
