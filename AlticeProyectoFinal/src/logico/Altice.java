package logico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Altice {
	
	private static Altice altice;
	
	private static Usuario sesion;
	
	private ArrayList<Plan> misPlanes;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Contrato> misContratos;
	private ArrayList<Pago> misPagos;
	private ArrayList<Usuario> misUsuarios;
	private ArrayList<Servicio> misServicios;
	
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
	}
	
	public static Altice getInstance()
	{
		if(altice == null)
			altice = new Altice();
		return altice;
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
	    }
	    empleado.getUsuario().setFechaDesactivacion(LocalDate.now());

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
	    return true;
	}

	// ====================== REGISTRAR PLAN ======================
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
//METODOS DE BUSQUEDA
//

	
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

    
//VALIDACIONES
///       

    public boolean existeServicio(TipoServicio tipo) {
        if (tipo == null) {
            return false;
        }

        for (Servicio serv : misServicios) {
            if (serv.getTipo() == tipo && serv.isActivo()) {  
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

	public Object tieneDeuda(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Usuario getUser() {
		return sesion;
	}

	public static void setUser(Usuario user) {
		Altice.sesion = user;
	}

	
	
}