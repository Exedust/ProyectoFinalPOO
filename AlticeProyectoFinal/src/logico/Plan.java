package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;
	public Plan(String codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.servicios = new ArrayList<Servicio>();
		precioInternet = 0;
		precioMovil = 0;
		precioCable = 0;
		activo = true;
	}
	private String codigo;
	private String nombre;
	private String descripcion;
	private ArrayList<Servicio> servicios;
	
	private boolean tieneInternet;
	private int bajadamegas;
	private int subidamegas;
	
	private boolean tieneMovil;
	private int minutos;
	private int gb;
	
	private boolean tieneCable;
	private boolean packBasico;
	private boolean packHD;
	
	private float precioInternet;
	private float precioMovil;
	private float precioCable;
	
	private boolean activo;
	
	public void agregar(Servicio s, float precio)
	{
		if(s!=null)
		{
			TipoServicio tipo = s.getTipo();
			
			if(tipo == TipoServicio.INTERNET)
			{
				tieneInternet = true;
				precioInternet = precio;				
			}
			else if(tipo == TipoServicio.MOVIL)
			{
				tieneMovil = true;
				precioMovil = precio;
			}
			else if(tipo == TipoServicio.CABLE)
			{
				tieneCable = true;
				precioCable = precio;
			}
			
			servicios.add(s);
		}
	}
	public void quitar(Servicio s)
	{
		if(s!=null)
		{
			TipoServicio tipo = s.getTipo();
			
			if(tipo == TipoServicio.INTERNET)
			{
				tieneInternet = false;
				precioInternet = 0;				
			}
			else if(tipo == TipoServicio.MOVIL)
			{
				tieneMovil = false;
				precioMovil = 0;
			}
			else if(tipo == TipoServicio.CABLE)
			{
				tieneCable = false;
				precioCable = 0;
			}
			
			servicios.remove(s);
		}
	}
	
	public Float getMonto()
	{
		return precioInternet + precioMovil + precioCable;
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

	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}
	public boolean isTieneInternet() {
		return tieneInternet;
	}
	public void setTieneInternet(boolean tieneInternet) {
		this.tieneInternet = tieneInternet;
	}
	public int getBajadamegas() {
		return bajadamegas;
	}
	public void setBajadamegas(int bajadamegas) {
		this.bajadamegas = bajadamegas;
	}
	public int getSubidamegas() {
		return subidamegas;
	}
	public void setSubidamegas(int subidamegas) {
		this.subidamegas = subidamegas;
	}
	public boolean isTieneMovil() {
		return tieneMovil;
	}
	public void setTieneMovil(boolean tieneMovil) {
		this.tieneMovil = tieneMovil;
	}
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	public int getGb() {
		return gb;
	}
	public void setGb(int gb) {
		this.gb = gb;
	}
	public boolean isTieneCable() {
		return tieneCable;
	}
	public void setTieneCable(boolean tieneCable) {
		this.tieneCable = tieneCable;
	}
	public boolean isPackBasico() {
		return packBasico;
	}
	public void setPackBasico(boolean packBasico) {
		this.packBasico = packBasico;
	}
	public boolean isPackHD() {
		return packHD;
	}
	public void setPackHD(boolean packHD) {
		this.packHD = packHD;
	}
	public float getPrecioInternet() {
		return precioInternet;
	}
	public void setPrecioInternet(float precioInternet) {
		this.precioInternet = precioInternet;
	}
	public float getPrecioMovil() {
		return precioMovil;
	}
	public void setPrecioMovil(float precioMovil) {
		this.precioMovil = precioMovil;
	}
	public float getPrecioCable() {
		return precioCable;
	}
	public void setPrecioCable(float precioCable) {
		this.precioCable = precioCable;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
