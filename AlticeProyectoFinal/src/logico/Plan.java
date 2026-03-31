package logico;

import java.util.ArrayList;

public class Plan {
	public Plan(String codigo, String nombre, String descripcion, float descuento, ArrayList<Servicio> servicios) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.servicios = servicios;
	}

	private String codigo;
	private String nombre;
	private String descripcion;
	private float descuento;
	private ArrayList<Servicio> servicios;
	
	public void agregar(Servicio s)
	{
		if(s!=null)
		{
			servicios.add(s);			
		}
	}
	public void quitar(Servicio s)
	{
		if(s!=null)
		{
			servicios.remove(s);			
		}
	}
	
	public float getCosto()
	{
		float total = 0;
		for(Servicio s: servicios)
		{
			total +=s.getCosto();
		}
		return total - total*descuento;
	}

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

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}
}
