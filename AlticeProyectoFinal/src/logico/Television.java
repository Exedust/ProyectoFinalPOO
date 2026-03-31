package logico;

public class Television extends Servicio {
	public Television(String codigo, String nombre, String descripcion, float costoBase, boolean hd,
			boolean streaming) {
		super(codigo, nombre, descripcion, costoBase);
		this.hd = hd;
		this.streaming = streaming;
	}
	private boolean hd;
	private boolean streaming;
	
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
	public boolean isHd() {
		return hd;
	}
	public void setHd(boolean hd) {
		this.hd = hd;
	}
	public boolean isStreaming() {
		return streaming;
	}
	public void setStreaming(boolean streaming) {
		this.streaming = streaming;
	}
}
