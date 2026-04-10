package logico;

import java.io.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Altice implements Serializable{
	private static final long serialVersionUID = 1L;
	private static Altice altice;
	
	private static Usuario sesion;
	
	private ArrayList<Plan> misPlanes;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Contrato> misContratos;
	private ArrayList<Pago> misPagos;
	private ArrayList<Usuario> misUsuarios;
	private ArrayList<Servicio> misServicios;
	private ArrayList<Solicitud> misSolicitudes;
	
	private static int genClienteid = 0;
	private static int genEmpleadoid = 0;
	private static int genContratoid = 0;
	private static int genPlanid = 0;
	private static int genSolicitudid = 0;
	private static int genPagoid = 0;
	private static int genServicioid = 0;
	
	private Altice()
	{
		misPlanes = new ArrayList<>();
		misClientes = new ArrayList<>();
		misEmpleados = new ArrayList<>();
		misContratos = new ArrayList<>();
		misPagos = new ArrayList<>();
		misUsuarios = new ArrayList<>();
		misServicios = new ArrayList<>();
		misSolicitudes = new ArrayList<>();
	}
	
	public static Altice getInstance()
	{
		if(altice == null)
			altice = new Altice();
		return altice;
	}
	
    public boolean guardarDatos() {
        try {
            FileOutputStream fos = new FileOutputStream("altice.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this);

            oos.close();
            fos.close();

            System.out.println("Datos guardados correctamente en altice.dat");
            return true;

        } catch (IOException e) {
            System.out.println("Error al guardar los datos.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean cargarDatos() {
        try {
            FileInputStream fis = new FileInputStream("altice.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Altice alticeCargada = (Altice) ois.readObject();

            altice = alticeCargada;

            ois.close();
            fis.close();

            System.out.println("Datos cargados correctamente desde altice.dat");
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo altice.dat. Se iniciará con datos vacíos.");
            return false;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos.");
            e.printStackTrace();
            return false;
        }
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(genClienteid);
        oos.writeInt(genEmpleadoid);
        oos.writeInt(genContratoid);
        oos.writeInt(genPlanid);
        oos.writeInt(genSolicitudid);
        oos.writeInt(genPagoid);
        oos.writeInt(genServicioid);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();   
        genClienteid = ois.readInt();
        genEmpleadoid = ois.readInt();
        genContratoid = ois.readInt();
        genPlanid = ois.readInt();
        genSolicitudid = ois.readInt();
        genPagoid = ois.readInt();
        genServicioid = ois.readInt();
    }
    
	
	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}
	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}
	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}
	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}
	public ArrayList<Contrato> getMisContratos() {
		return misContratos;
	}
	public void setMisContratos(ArrayList<Contrato> misContratos) {
		this.misContratos = misContratos;
	}
	public ArrayList<Pago> getMisPagos() {
		return misPagos;
	}
	public void setMisPagos(ArrayList<Pago> misPagos) {
		this.misPagos = misPagos;
	}

	public ArrayList<Usuario> getMisUsuarios() {
		return misUsuarios;
	}

	public void setMisUsuarios(ArrayList<Usuario> misUsuarios) {
		this.misUsuarios = misUsuarios;
	}

	public ArrayList<Servicio> getMisServicios() {
	    return misServicios;
	}

	public void setMisServicios(ArrayList<Servicio> misServicios) {
	    this.misServicios = misServicios;
	}
	
	public void regUsuario(Usuario usuario) {
        if (usuario != null && usuario.getCodigo() != null) {
            misUsuarios.add(usuario);
        }
    }
	
    public float calcularDeudaContrato(Contrato contrato) {
        if (contrato == null || contrato.getPagos() == null) {
            return 0.0f;
        }

        float deuda = 0.0f;
        for (Pago p : contrato.getPagos()) {
            if (p.isPendiente()) {
                deuda += p.getMonto();
            }
        }
        return deuda;
    }
    
    public ArrayList<Pago> getPagosPendientesByCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            return new ArrayList<>();
        }

        ArrayList<Pago> pendientes = new ArrayList<>();

        for (Pago p : misPagos) {
            if (p.getCliente() != null && 
                p.getCliente().getCedula() != null &&
                p.getCliente().getCedula().equalsIgnoreCase(cedula) &&
                p.isPendiente()) {
                
                pendientes.add(p);
            }
        }
        return pendientes;
    }

	public boolean registrarEmpleado(Empleado empleado) {
	    if (empleado == null || empleado.getCodigo() == null) {
	        return false;
	    }
	    String codigo = empleado.getCodigo();

	    if (buscarEmpleadoById(codigo) != null) {
	        return false;
	    }
	    misEmpleados.add(empleado);
	    misUsuarios.add(empleado.getUsuario());
	    genEmpleadoid++;

	    return true;
	}
	
	public boolean modificarEmpleado(Empleado empleadoActualizado) {
	    if (empleadoActualizado == null || empleadoActualizado.getCodigo() == null) {
	        return false;
	    }

	    int indice = buscarIndexEmpleadoById(empleadoActualizado.getCodigo());

	    if (indice == -1) {
	        return false;
	    }
	    misEmpleados.set(indice, empleadoActualizado);
	    
	    if (empleadoActualizado.getUsuario() != null) {
	        int indiceUsuario = buscarIndexUsuarioByCodigo(empleadoActualizado.getCodigo());
	        if (indiceUsuario != -1) {
	            misUsuarios.set(indiceUsuario, empleadoActualizado.getUsuario());
	        }
	    }

	    return true;
	}
	
	public boolean desactivarEmpleado(String codigo) {
	    if (codigo == null) return false;

	    int indice = buscarIndexEmpleadoById(codigo);
	    if (indice == -1) {
	        return false;
	    }

	    Empleado empleado = misEmpleados.get(indice);
	    if (empleado.getUsuario() != null) {
	        empleado.getUsuario().setActivo(false);
	        empleado.getUsuario().setFechaDesactivacion(LocalDate.now());
	    }

	    cancelarPagosPendientesDePersona(empleado.getCedula());

	    return true;
	}
	
	//
	//CLIENTE
	//
	public boolean registrarCliente(Cliente cliente) {
	    if (cliente == null || cliente.getCodigo() == null) {
	        return false;
	    }

	    String codigo = cliente.getCodigo();
	    String cedula = cliente.getCedula();

	    if (buscarClienteById(codigo) != null) {
	        return false;
	    }
	    if (buscarClienteByCedula(cedula) != null) {
	        return false;
	    }

	    misClientes.add(cliente);
	    if (cliente.getUsuario() != null) {
	        misUsuarios.add(cliente.getUsuario());
	    }

	    genClienteid++;
	    return true;
	}
	

	public boolean modificarCliente(Cliente nuevo) {
	    if (nuevo == null || nuevo.getCodigo() == null) {
	        return false;
	    }

	    int indice = buscarIndexClienteById(nuevo.getCodigo());

	    if (indice == -1) {
	        return false;
	    }
	    misClientes.set(indice, nuevo);
	    
	    if (nuevo.getUsuario() != null) {
	        int indiceUsuario = buscarIndexUsuarioByCodigo(nuevo.getCodigo());
	        if (indiceUsuario != -1) {
	            misUsuarios.set(indiceUsuario, nuevo.getUsuario());
	        }
	    }

	    return true;
	}

	public boolean desactivarCliente(String codigo) {
	    if (codigo == null) return false;

	    int indice = buscarIndexClienteById(codigo);
	    if (indice == -1) {
	        return false;
	    }

	    Cliente cliente = misClientes.get(indice);
	    if (cliente.getUsuario() != null) {
	        cliente.getUsuario().setActivo(false);
	        cliente.getUsuario().setFechaDesactivacion(LocalDate.now());
	    }
	    cancelarPagosPendientesDePersona(cliente.getCedula());

	    return true;
	}


	public boolean registrarPlan(Plan plan) {
	    if (plan == null || plan.getCodigo() == null) {
	        return false;
	    }

	    if (buscarPlanByCodigo(plan.getCodigo()) != null) {
	        return false;
	    }

	    misPlanes.add(plan);
	    genPlanid++;
	    return true;
	}

	public boolean modificarPlan(Plan nuevoPlan) {
	    if (nuevoPlan == null || nuevoPlan.getCodigo() == null) {
	        return false;
	    }

	    int indice = buscarIndexPlanByCodigo(nuevoPlan.getCodigo());
	    if (indice == -1) {
	        return false;
	    }

	    misPlanes.set(indice, nuevoPlan);
	    return true;
	}

	public boolean desactivarPlan(String codigo) {
	    if (codigo == null) return false;

	    int indice = buscarIndexPlanByCodigo(codigo);
	    if (indice == -1) {
	        return false;
	    }

	    Plan plan = misPlanes.get(indice);
	    plan.setActivo(false);

	    return true;
	}
	

//
//SERVICIOS
//
	
public boolean registrarServicio(Servicio servicio) {
    if (servicio == null || servicio.getCodigo() == null) 
        return false;

    if (existeServicio(servicio.getTipo())) 
        return false;
    
    for (Servicio s : misServicios) 
        if (s.getCodigo() != null && s.getCodigo().equalsIgnoreCase(servicio.getCodigo())) 
            return false;

    misServicios.add(servicio);
    genServicioid++;
    return true;
}

public boolean modificarServicio(Servicio servicioActualizado) {
    if (servicioActualizado == null || servicioActualizado.getCodigo() == null) 
        return false;
    

    int indice = buscarIndexServicioByCodigo(servicioActualizado.getCodigo());
    if (indice == -1) 
        return false; 

    misServicios.set(indice, servicioActualizado);
    return true;
}

public boolean desactivarServicio(String codigo) {
    if (codigo == null || codigo.trim().isEmpty()) 
        return false;
   
    int indice = buscarIndexServicioByCodigo(codigo);
    if (indice == -1) 
        return false; 
    
    Servicio servicio = misServicios.get(indice);
    if (!servicio.isActivo()) 
        return false; 

    servicio.setActivo(false);   
    return true;
}

//
//SOLICITUDES
//

public boolean registrarSolicitud(Solicitud solicitud) {
    if (solicitud == null || solicitud.getCodigo() == null) 
        return false;
    if (buscarSolicitudByCodigo(solicitud.getCodigo()) != null) 
        return false;
    
    misSolicitudes.add(solicitud);
    genSolicitudid++;
    return true;
}

public boolean modificarSolicitud(Solicitud solicitudActualizada) {
    if (solicitudActualizada == null || solicitudActualizada.getCodigo() == null) 
        return false;
    int indice = buscarIndexSolicitudByCodigo(solicitudActualizada.getCodigo());
    if (indice == -1) 
        return false;
    
    misSolicitudes.set(indice, solicitudActualizada);
    return true;
}
//
public boolean cancelarSolicitud(String codigo) {
    if (codigo == null || codigo.trim().isEmpty()) 
        return false;
    int indice = buscarIndexSolicitudByCodigo(codigo);
    if (indice == -1) 
        return false;
    Solicitud solicitud = misSolicitudes.get(indice);
    solicitud.cancelar();       
    return true;
}

//
//METODOS DE BUSQUEDA
//
public Solicitud buscarSolicitudByCodigo(String codigo) {
    if (codigo == null) return null;

    for (Solicitud s : getMisSolicitudes()) {
        if (s.getCodigo() != null && s.getCodigo().equalsIgnoreCase(codigo)) {
            return s;
        }
    }
    return null;
}

private int buscarIndexSolicitudByCodigo(String codigo) {
    if (codigo == null) return -1;

    for (int i = 0; i < getMisSolicitudes().size(); i++) {
        Solicitud s = getMisSolicitudes().get(i);
        if (s.getCodigo() != null && s.getCodigo().equalsIgnoreCase(codigo)) {
            return i;
        }
    }
    return -1;
}
	
	public Empleado buscarEmpleadoById(String codigo) {
	    if (codigo == null) return null;

	    for (Empleado e : misEmpleados) {
	        if (e.getCodigo() != null && e.getCodigo().equalsIgnoreCase(codigo)) {
	            return e;
	        }
	    }
	    return null;
	}

    public Empleado buscarEmpleadoByCedula(String cedula) {
        for (Empleado e : misEmpleados) {
            if (e.getCedula() != null && e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    public int buscarIndexEmpleadoById(String codigo) {
        if (codigo == null) return -1;

        for (int i = 0; i < misEmpleados.size(); i++) {
            Empleado e = misEmpleados.get(i);
            if (e.getCodigo() != null && e.getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }

    public Cliente buscarClienteById(String codigo) {
        if (codigo == null) return null;
        for (Cliente c : misClientes) {
            if (c.getCodigo() != null && c.getCodigo().equalsIgnoreCase(codigo)) {
                return c;
            }
        }
        return null;
    }

    private int buscarIndexClienteById(String codigo) {
        if (codigo == null) return -1;
        for (int i = 0; i < misClientes.size(); i++) {
            Cliente c = misClientes.get(i);
            if (c.getCodigo() != null && c.getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }
	
    public int buscarIndexUsuarioByCodigo(String codigo) {
        if (codigo == null) return -1;

        for (int i = 0; i < misUsuarios.size(); i++) {
            Usuario u = misUsuarios.get(i);
            if (u.getCodigo() != null && u.getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }
    
    public Cliente buscarClienteByCedula(String cedula) {
        if (cedula == null) return null;
        for (Cliente c : misClientes) {
            if (c.getCedula() != null && c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public Persona buscarPersonaByCedula(String cedula) {
        Cliente cliente = buscarClienteByCedula(cedula);
        if (cliente != null) {
            return cliente;
        }

        Empleado empleado = buscarEmpleadoByCedula(cedula);
        if (empleado != null) {
            return empleado;
        }

        return null;
    }
    public int contarSolicitudesTotal() {
        return misSolicitudes.size();
    }

    public int contarSolicitudesPorEstado(EstadoSolicitud estado) {
        if (estado == null) return 0;
        int count = 0;
        for (Solicitud s : misSolicitudes) {
            if (s.getEstado() == estado) {
                count++;
            }
        }
        return count;
    }

    public Contrato buscarContratoByCodigo(String codigo) {
        for (Contrato c : misContratos) {
            if (c.getCodigo() != null && c.getCodigo().equalsIgnoreCase(codigo)) {
                return c;
            }
        }
        return null;
    }
    
    public Plan buscarPlanByNombre(String nombre)
    {
    	for(Plan p: misPlanes)
    	{
    		if(p.getNombre().equalsIgnoreCase(nombre))
    			return p;
    	}
    	return null;
    }
    
    public Plan buscarPlanByCodigo(String codigo) {
        for (Plan p : misPlanes) {
            if (p.getCodigo() != null && p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public int buscarIndexPlanByCodigo(String codigo) {
        for (int i = 0; i < misPlanes.size(); i++) {
            Plan p = misPlanes.get(i);
            if (p.getCodigo() != null && p.getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }

    private int buscarIndexServicioByCodigo(String codigo) {
        if (codigo == null) return -1;

        for (int i = 0; i < misServicios.size(); i++) {
            Servicio s = misServicios.get(i);
            if (s.getCodigo() != null && s.getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }
    
    public Servicio buscarServicioByCodigo(String codigo) {
        if (codigo == null) return null;

        for (Servicio s : misServicios) {
            if (s.getCodigo() != null && s.getCodigo().equalsIgnoreCase(codigo)) {
                return s;
            }
        }
        return null;
    }
    
    public Pago buscarPagoByCodigo(String codigo) {
        if (codigo == null) return null;
        for (Pago p : misPagos) {
            if (p.getCodigo() != null && p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    private int buscarIndexPagoByCodigo(String codigo) {
        if (codigo == null) return -1;
        for (int i = 0; i < misPagos.size(); i++) {
            Pago p = misPagos.get(i);
            if (p.getCodigo() != null && p.getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }
    
//VALIDACIONES
///       

    public boolean existeServicio(TipoServicio tipo) {
        if (tipo == null) {
            return false;
        }

        for (Servicio serv : misServicios) {
            if (serv.getTipo() == tipo) {  
                return true;
            }
        }
        return false;
    }
    
    
	public static int getGenClienteid() {
		return genClienteid;
	}

	public static void setGenClienteid(int genClienteid) {
		Altice.genClienteid = genClienteid;
	}

	public static int getGenEmpleadoid() {
		return genEmpleadoid;
	}

	public static void setGenEmpleadoid(int genEmpleadoid) {
		Altice.genEmpleadoid = genEmpleadoid;
	}

	public static int getGenContratoid() {
		return genContratoid;
	}

	public static void setGenContratoid(int genContratoid) {
		Altice.genContratoid = genContratoid;
	}

	public static int getGenPlanid() {
		return genPlanid;
	}

	public static void setGenPlanid(int genPlanid) {
		Altice.genPlanid = genPlanid;
	}

	public static int getGenSolicitudid() {
		return genSolicitudid;
	}

	public static void setGenSolicitudid(int genSolicitudid) {
		Altice.genSolicitudid = genSolicitudid;
	}

	public static int getGenPagoid() {
		return genPagoid;
	}

	public static void setGenPagoid(int genPagoid) {
		Altice.genPagoid = genPagoid;
	}

	public static int getGenServicioid() {
		return genServicioid;
	}

	public static void setGenServicioid(int genServicioid) {
		Altice.genServicioid = genServicioid;
	}

    public boolean tieneDeuda(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            return false;
        }

        for (Pago pago : misPagos) {
            if (pago.getCliente() != null && 
                pago.getCliente().getCedula() != null &&
                pago.getCliente().getCedula().equalsIgnoreCase(cedula) &&
                pago.isPendiente()) {
                
                return true;
            }
        }

        return false;
    }
	
//	
//PAGOS
//
    public boolean registrarPago(Pago pago) {
        if (pago == null || pago.getCodigo() == null || pago.getContrato() == null) {
            return false;
        }
        if (buscarPagoByCodigo(pago.getCodigo()) != null) {
            return false;
        }

        misPagos.add(pago);
        genPagoid++;

        Contrato contrato = pago.getContrato();
        if (contrato != null) {
            contrato.agregarPago(pago);
        }
        Persona cliente = pago.getCliente();
        if (cliente instanceof Cliente) {
            ((Cliente) cliente).agregarPago(pago);
        }

        return true;
    }
    // ====================== GENERACIÓN DE PAGOS MENSUALES ======================
    public void producirPagos() {
        LocalDate hoy = LocalDate.now();
        int diaActual = hoy.getDayOfMonth();
        int mesActual = hoy.getMonthValue();
        int añoActual = hoy.getYear();

        for (Contrato contrato : misContratos) {
            if (!contrato.isActivo()) continue;

            int diaDePago = contrato.getFechaInicio().getDayOfMonth();

            if (diaActual != diaDePago) continue;

            boolean yaTienePagoEsteMes = false;

            for (Pago pago : contrato.getPagos()) {
                if (pago.getFechaRegistro() != null &&
                    pago.getFechaRegistro().getDayOfMonth() == diaDePago &&
                    pago.getFechaRegistro().getMonthValue() == mesActual &&
                    pago.getFechaRegistro().getYear() == añoActual) {
                    
                    yaTienePagoEsteMes = true;
                    break;
                }
            }
            if (!yaTienePagoEsteMes) {
                String codigoPago = String.format("P-%05d", genPagoid + 1);
                float monto = contrato.getPlan().getMonto();

                Pago nuevoPago = new Pago(codigoPago, contrato.getCliente(), contrato, monto);

                LocalDate fechaCorrecta = LocalDate.of(añoActual, mesActual, diaDePago);
                nuevoPago.setFechaRegistro(fechaCorrecta);

                registrarPago(nuevoPago);
            }
        }
    }
    
    public boolean realizarPago(String codigoPago) {
        if (codigoPago == null || codigoPago.trim().isEmpty()) {
            return false;
        }

        Pago pago = buscarPagoByCodigo(codigoPago);
        if (pago == null) {
            return false;
        }

        if (!pago.isPendiente()) {
            return false;
        }

        pago.setPendiente(false);
        pago.setFechaPago(LocalDate.now());

        return true;
    }
    
    public boolean cancelarPago(String codigoPago) {
        if (codigoPago == null || codigoPago.trim().isEmpty()) {
            return false;
        }

        Pago pago = buscarPagoByCodigo(codigoPago);
        if (pago == null) {
            return false;
        }

        pago.setPendiente(false);
        pago.setActivo(false);                   
        pago.setFechaPago(LocalDate.now());      

        return true;
    }
    
    public boolean cancelarPagosPendientesDePersona(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            return false;
        }

        boolean seCanceloAlgo = false;

        for (Pago pago : misPagos) {
            if (pago.isPendiente() && 
                pago.getCliente() != null && 
                pago.getCliente().getCedula() != null &&
                pago.getCliente().getCedula().equalsIgnoreCase(cedula)) {
                
                pago.setPendiente(false);
                pago.setActivo(false);
                pago.setFechaPago(LocalDate.now());
                seCanceloAlgo = true;
            }
        }

        return seCanceloAlgo;
    }
    
//	
//CONTRATO
//
    public boolean registrarContrato(Contrato contrato) {
        if (contrato == null || contrato.getCodigo() == null) {
            return false;
        }
        if (buscarContratoByCodigo(contrato.getCodigo()) != null) {
            return false;
        }

        misContratos.add(contrato);
        genContratoid++;

        Persona persona = contrato.getCliente();
        if (persona instanceof Cliente) {
            Cliente cliente = (Cliente) persona;

            if (cliente.getContratos() == null) {
                cliente.setContratos(new ArrayList<Contrato>());
            }
            
            cliente.getContratos().add(contrato);
        }

        return true;
    }

	public boolean cerrarContrato(String codigo) {
	    if (codigo == null) return false;

	    int indice = buscarIndexContratoByCodigo(codigo);
	    if (indice == -1) {
	        return false;
	    }

	    Contrato contrato = misContratos.get(indice);
	    contrato.setActivo(false);
	    contrato.setFechaCierre(LocalDate.now());

	    return true;
	}

	public int buscarIndexContratoByCodigo(String codigo) {
	    for (int i = 0; i < misContratos.size(); i++) {
	        Contrato c = misContratos.get(i);
	        if (c.getCodigo() != null && c.getCodigo().equalsIgnoreCase(codigo)) {
	            return i;
	        }
	    }
	    return -1;
	}
	
    public static Usuario getSesion() {
        return sesion;
    }

    public static void setSesion(Usuario usuario) {
        sesion = usuario;
    }


    public boolean confirmarLogin(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        for (Usuario u : misUsuarios) {
            if (u.getUser() != null && u.getUser().equals(username) &&
                u.getPassword() != null && u.getPassword().equals(password)) {
                
                if (u.isActivo()) {
                    sesion = u;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void cerrarSesion() {
        sesion = null;
    }

    public boolean haySesionActiva() {
        return sesion != null;
    }

    public Rol getRolUsuarioLogueado() {
        if (sesion != null && sesion.getRol() != null) {
            return sesion.getRol();
        }
        return null;
    }

	public ArrayList<Solicitud> getMisSolicitudes() {
		return misSolicitudes;
	}

	public void setMisSolicitudes(ArrayList<Solicitud> misSolicitudes) {
		this.misSolicitudes = misSolicitudes;
	}
}