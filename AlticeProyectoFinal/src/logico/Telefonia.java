package logico;

public class Telefonia extends Servicio {
	public Telefonia(String codigo, String nombre, String descripcion, float costoBase, int minutos, float gbDatos,
			boolean roaming) {
		super(codigo, nombre, descripcion, costoBase);
		this.minutos = minutos;
		this.gbDatos = gbDatos;
		this.roaming = roaming;
	}
	private int minutos;
	private float gbDatos;
	private boolean roaming;
	
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
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	public float getGbDatos() {
		return gbDatos;
	}
	public void setGbDatos(float gbDatos) {
		this.gbDatos = gbDatos;
	}
	public boolean isRoaming() {
		return roaming;
	}
	public void setRoaming(boolean roaming) {
		this.roaming = roaming;
	}
}
