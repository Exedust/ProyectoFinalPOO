package logico;

import java.io.*;
import java.io.Serializable;
import java.net.Socket;
import java.time.LocalDate;
import java.util.ArrayList;

public class Altice implements Serializable {
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

	private Altice() {
		misPlanes = new ArrayList<>();
		misClientes = new ArrayList<>();
		misEmpleados = new ArrayList<>();
		misContratos = new ArrayList<>();
		misPagos = new ArrayList<>();
		misUsuarios = new ArrayList<>();
		misServicios = new ArrayList<>();
		misSolicitudes = new ArrayList<>();
	}

	public static Altice getInstance() {
		if (altice == null)
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
	
	private void enviarLog(String mensaje) {
	    try {
	        Socket nsfd = new Socket("localhost", 7000);
	        DataOutputStream salida = new DataOutputStream(nsfd.getOutputStream());

	        salida.writeUTF("LOG");
	        
	        salida.writeUTF(mensaje);

	        salida.close();
	        nsfd.close();

	        System.out.println("Log enviado: " + mensaje);

	    } catch (Exception e) {
	        System.out.println("No se pudo enviar el log: " + e.getMessage());
	    }
	}
	
	private void registrarLog(Persona persona, String accion) {
	    if (persona == null || accion == null || accion.trim().isEmpty()) {
	        return;
	    }

	    String codigo = persona.getCodigo() != null ? persona.getCodigo() : "SIN_CODIGO";
	    String nombre = persona.getNombre() != null ? persona.getNombre() : "Sin nombre";

	    String linea = String.format("[%s] %s - %s - %s",
	            java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
	            codigo,
	            nombre,
	            accion);

	    enviarLog(linea);
	}
	
	private Persona getPersonaActual() {
	    if (getSesion() == null) return null;
	    
	    String codigoSesion = getSesion().getCodigo();
	    if (codigoSesion == null) return null;

	    Persona persona = buscarEmpleadoById(codigoSesion);
	    if (persona != null) return persona;

	    persona = buscarClienteById(codigoSesion);
	    return persona;
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

	public boolean tieneContratoActivo(String cedula) {
	    if (cedula == null || cedula.trim().isEmpty()) {
	        return false;
	    }

	    for (Contrato contrato : misContratos) {
	        if (!contrato.isActivo()) {
	            continue;
	        }

	        Persona persona = contrato.getCliente();
	        if (persona != null && persona.getCedula() != null) {
	            if (persona.getCedula().equalsIgnoreCase(cedula)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	public String buscarCedulaById(String codigoUsuario) {
	    if (codigoUsuario == null || codigoUsuario.trim().isEmpty()) {
	        return null;
	    }

	    Empleado empleado = buscarEmpleadoById(codigoUsuario);
	    if (empleado != null) {
	        return empleado.getCedula();
	    }

	    Cliente cliente = buscarClienteById(codigoUsuario);
	    if (cliente != null) {
	        return cliente.getCedula();
	    }

	    return null;
	}

	public Contrato buscarContratoActivoByCedula(String cedula) {
	    if (cedula == null || cedula.trim().isEmpty()) {
	        return null;
	    }

	    for (Contrato c : misContratos) {
	        if (c.isActivo()) {
	            Persona persona = c.getCliente();
	            if (persona != null && persona.getCedula() != null &&
	                persona.getCedula().equalsIgnoreCase(cedula)) {
	                return c;
	            }
	        }
	    }
	    return null;
	}
	
	public boolean estaDisponibleTecnico(String codigo) {
		Empleado emp = buscarEmpleadoById(codigo);
		if (emp == null || emp.getRol() != Rol.TECNICO) {
			return false;
		}

		for (Solicitud s : misSolicitudes) {
			if (s.getEmpleado() != null && 
					s.getEmpleado().getCodigo().equals(emp.getCodigo()) &&
					s.getEstado() == EstadoSolicitud.EN_PROCESO) {

				return false;
			}
		}
		return true; 
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
			if (p.getCliente() != null && p.getCliente().getCedula() != null
					&& p.getCliente().getCedula().equalsIgnoreCase(cedula) && p.isPendiente()) {

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

		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Registró empleado " + empleado.getCodigo() + " (" + empleado.getNombre() + ")");
	    }
	    
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
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Modificó empleado " + empleadoActualizado.getCodigo() + " (" + empleadoActualizado.getNombre() + ")");
	    }

		return true;
	}

	public boolean desactivarEmpleado(String codigo) {
		if (codigo == null)
			return false;

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

		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Desactivó empleado " + codigo + " (" + empleado.getNombre() + ")");
	    }
	    
		return true;
	}

	//
	// CLIENTE
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
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Registró cliente " + cliente.getCodigo() + " (" + cliente.getNombre() + ")");
	    }
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
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Modificó cliente " + nuevo.getCodigo() + " (" + nuevo.getNombre() + ")");
	    }

		return true;
	}

	public boolean desactivarCliente(String codigo) {
		if (codigo == null)
			return false;

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

		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Desactivó cliente " + codigo + " (" + cliente.getNombre() + ")");
	    }
	    
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
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Registró plan " + plan.getCodigo() + " (" + plan.getNombre() + ")");
	    }
	    
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
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Modificó plan " + nuevoPlan.getCodigo() + " (" + nuevoPlan.getNombre() + ")");
	    }
	    
		return true;
	}

	public boolean desactivarPlan(String codigo) {
		if (codigo == null)
			return false;

		int indice = buscarIndexPlanByCodigo(codigo);
		if (indice == -1) {
			return false;
		}

		Plan plan = misPlanes.get(indice);
		plan.setActivo(false);
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Desactivó plan " + codigo + " (" + plan.getNombre() + ")");
	    }

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
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Registró servicio " + servicio.getCodigo() + " (" + servicio.getTipo() + ")");
	    }
	    
		return true;
	}

	public boolean modificarServicio(Servicio servicioActualizado) {
		if (servicioActualizado == null || servicioActualizado.getCodigo() == null)
			return false;

		int indice = buscarIndexServicioByCodigo(servicioActualizado.getCodigo());
		if (indice == -1)
			return false;

		misServicios.set(indice, servicioActualizado);
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Modificó servicio " + servicioActualizado.getCodigo());
	    }
	    
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
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Desactivó servicio " + codigo);
	    }
	    
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
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Registró solicitud " + solicitud.getCodigo() + " (" + solicitud.getTipo() + ")");
	    }
	    
		return true;
	}

	public boolean modificarSolicitud(Solicitud solicitudActualizada) {
		if (solicitudActualizada == null || solicitudActualizada.getCodigo() == null)
			return false;
		int indice = buscarIndexSolicitudByCodigo(solicitudActualizada.getCodigo());
		if (indice == -1)
			return false;

		misSolicitudes.set(indice, solicitudActualizada);
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Modificó solicitud " + solicitudActualizada.getCodigo());
	    }
		return true;
	}

	public boolean cancelarSolicitud(String codigoSolicitud) {
		if (codigoSolicitud == null || codigoSolicitud.trim().isEmpty()) {
			return false;
		}

		int indice = buscarIndexSolicitudByCodigo(codigoSolicitud);
		if (indice == -1) {
			return false;
		}

		Solicitud solicitud = misSolicitudes.get(indice);

		if (solicitud.isResuelto() || solicitud.isCancelada()) {
			return false;
		}

		solicitud.cancelar();
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Canceló solicitud " + codigoSolicitud);
	    }
	    
		return true;
	}


	public boolean completarSolicitud(String codigoSolicitud) {
		if (codigoSolicitud == null || codigoSolicitud.trim().isEmpty()) {
			return false;
		}

		int indice = buscarIndexSolicitudByCodigo(codigoSolicitud);
		if (indice == -1) {
			return false;
		}
		Solicitud solicitud = misSolicitudes.get(indice);

		if (solicitud.isResuelto() || solicitud.isCancelada()) {
			return false;
		}

		solicitud.completar();
		solicitud.getEmpleado().getSolicitudes().add(solicitud);
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Completó solicitud " + codigoSolicitud);
	    }
	    
		return true;
	}

	public boolean asignarTecnicoASolicitud(String codigoSolicitud, String codigoTecnico) {
		if (codigoSolicitud == null || codigoTecnico == null) {
			return false;
		}

		int indiceSolicitud = buscarIndexSolicitudByCodigo(codigoSolicitud);
		if (indiceSolicitud == -1) {
			return false;
		}

		Empleado tecnico = buscarEmpleadoById(codigoTecnico);
		if (tecnico == null) {
			return false;
		}

		if (tecnico.getRol() != Rol.TECNICO) {
			return false;
		}
		Solicitud solicitud = misSolicitudes.get(indiceSolicitud);
		if (solicitud.isResuelto() || solicitud.isCancelada()) {
			return false;
		}
		solicitud.asignarEmpleado(tecnico);
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Asignó técnico " + codigoTecnico + " a la solicitud " + codigoSolicitud);
	    }
		return true;
	}

	//
	//METODOS DE BUSQUEDA
	//
	public Solicitud buscarSolicitudByCodigo(String codigo) {
		if (codigo == null)
			return null;

		for (Solicitud s : getMisSolicitudes()) {
			if (s.getCodigo() != null && s.getCodigo().equalsIgnoreCase(codigo)) {
				return s;
			}
		}
		return null;
	}

	private int buscarIndexSolicitudByCodigo(String codigo) {
		if (codigo == null)
			return -1;

		for (int i = 0; i < getMisSolicitudes().size(); i++) {
			Solicitud s = getMisSolicitudes().get(i);
			if (s.getCodigo() != null && s.getCodigo().equalsIgnoreCase(codigo)) {
				return i;
			}
		}
		return -1;
	}

	public Empleado buscarEmpleadoById(String codigo) {
		if (codigo == null)
			return null;

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
		if (codigo == null)
			return -1;

		for (int i = 0; i < misEmpleados.size(); i++) {
			Empleado e = misEmpleados.get(i);
			if (e.getCodigo() != null && e.getCodigo().equalsIgnoreCase(codigo)) {
				return i;
			}
		}
		return -1;
	}

	public Cliente buscarClienteById(String codigo) {
		if (codigo == null)
			return null;
		for (Cliente c : misClientes) {
			if (c.getCodigo() != null && c.getCodigo().equalsIgnoreCase(codigo)) {
				return c;
			}
		}
		return null;
	}

	private int buscarIndexClienteById(String codigo) {
		if (codigo == null)
			return -1;
		for (int i = 0; i < misClientes.size(); i++) {
			Cliente c = misClientes.get(i);
			if (c.getCodigo() != null && c.getCodigo().equalsIgnoreCase(codigo)) {
				return i;
			}
		}
		return -1;
	}

	public int buscarIndexUsuarioByCodigo(String codigo) {
		if (codigo == null)
			return -1;

		for (int i = 0; i < misUsuarios.size(); i++) {
			Usuario u = misUsuarios.get(i);
			if (u.getCodigo() != null && u.getCodigo().equalsIgnoreCase(codigo)) {
				return i;
			}
		}
		return -1;
	}

	public Cliente buscarClienteByCedula(String cedula) {
		if (cedula == null)
			return null;
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

	public boolean existeCorreo(String correo) {
		if (correo == null || correo.trim().isEmpty()) {
			return false;
		}

		String correoNormalizado = correo.trim().toLowerCase();

		for (Cliente c : misClientes) {
			if (c.getEmail() != null && c.getEmail().trim().toLowerCase().equals(correoNormalizado)) {
				return true;
			}
		}

		for (Empleado e : misEmpleados) {
			if (e.getEmail() != null && e.getEmail().trim().toLowerCase().equals(correoNormalizado)) {
				return true;
			}
		}

		for (Usuario u : misUsuarios) {
			if (u.getUser() != null && u.getUser().trim().toLowerCase().equals(correoNormalizado)) {
				return true;
			}
		}

		return false;
	}

	public int contarSolicitudesTotal() {
		return misSolicitudes.size();
	}

	

	public Contrato buscarContratoByCodigo(String codigo) {
		for (Contrato c : misContratos) {
			if (c.getCodigo() != null && c.getCodigo().equalsIgnoreCase(codigo)) {
				return c;
			}
		}
		return null;
	}

	public Plan buscarPlanByNombre(String nombre) {
		for (Plan p : misPlanes) {
			if (p.getNombre().equalsIgnoreCase(nombre))
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
		if (codigo == null)
			return -1;

		for (int i = 0; i < misServicios.size(); i++) {
			Servicio s = misServicios.get(i);
			if (s.getCodigo() != null && s.getCodigo().equalsIgnoreCase(codigo)) {
				return i;
			}
		}
		return -1;
	}

	public Servicio buscarServicioByCodigo(String codigo) {
		if (codigo == null)
			return null;

		for (Servicio s : misServicios) {
			if (s.getCodigo() != null && s.getCodigo().equalsIgnoreCase(codigo)) {
				return s;
			}
		}
		return null;
	}

	public Pago buscarPagoByCodigo(String codigo) {
		if (codigo == null)
			return null;
		for (Pago p : misPagos) {
			if (p.getCodigo() != null && p.getCodigo().equalsIgnoreCase(codigo)) {
				return p;
			}
		}
		return null;
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
	
    /**
     * Calcula los ingresos REALIZADOS (pagos completados) en un período específico.
     */
    public float calcularIngresosPagosPorPeriodo(int mesesAtras) {
        float total = 0f;
        LocalDate fechaLimite = (mesesAtras > 0) ? LocalDate.now().minusMonths(mesesAtras) : null;

        for (Pago pago : misPagos) {
            if (pago.isActivo() && !pago.isPendiente() && pago.getFechaPago() != null) {
                if (fechaLimite != null && pago.getFechaPago().isBefore(fechaLimite)) {
                    continue;
                }
                total += pago.getMonto();
            }
        }
        return total;
    }

    /**
     * Calcula el monto pendiente en un período específico.
     */
    public float calcularMontoPendientePorPeriodo(int mesesAtras) {
        float total = 0f;
        LocalDate fechaLimite = (mesesAtras > 0) ? LocalDate.now().minusMonths(mesesAtras) : null;

        for (Pago pago : misPagos) {
            if (pago.isActivo() && pago.isPendiente()) {
                if (fechaLimite != null && pago.getFechaRegistro() != null 
                    && pago.getFechaRegistro().isBefore(fechaLimite)) {
                    continue;
                }
                total += pago.getMonto();
            }
        }
        return total;
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
			if (pago.getCliente() != null && pago.getCliente().getCedula() != null
					&& pago.getCliente().getCedula().equalsIgnoreCase(cedula) && pago.isPendiente()) {

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
		
		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Registró pago " + pago.getCodigo() + 
	                    " del contrato " + (contrato != null ? contrato.getCodigo() : "N/A"));
	    }

		return true;
	}

	public void producirPagos() {
		LocalDate hoy = LocalDate.now();
		int diaActual = hoy.getDayOfMonth();
		int mesActual = hoy.getMonthValue();
		int añoActual = hoy.getYear();

		for (Contrato contrato : misContratos) {
			if (!contrato.isActivo())
				continue;

			int diaDePago = contrato.getFechaInicio().getDayOfMonth();

			if (diaActual != diaDePago)
				continue;

			boolean yaTienePagoEsteMes = false;

			for (Pago pago : contrato.getPagos()) {
				if (pago.getFechaRegistro() != null && pago.getFechaRegistro().getDayOfMonth() == diaDePago
						&& pago.getFechaRegistro().getMonthValue() == mesActual
						&& pago.getFechaRegistro().getYear() == añoActual) {

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

		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Realizó el pago " + codigoPago);
	    }
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

		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Canceló pago " + codigoPago);
	    }
	    
		return true;
	}

	public boolean cancelarPagosPendientesDePersona(String cedula) {
		if (cedula == null || cedula.trim().isEmpty()) {
			return false;
		}

		boolean seCanceloAlgo = false;

		for (Pago pago : misPagos) {
			if (pago.isPendiente() && pago.getCliente() != null && pago.getCliente().getCedula() != null
					&& pago.getCliente().getCedula().equalsIgnoreCase(cedula)) {

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
			contrato.getEmpleado().getContratos().add(contrato);
		}

		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, 
	            "Registró contrato " + contrato.getCodigo() + 
	            " (" + (contrato.getPlan() != null ? contrato.getPlan().getNombre() : "Sin plan") + ")");
	    }
	    
		return true;
	}

	public boolean cerrarContrato(String codigo) {
		if (codigo == null)
			return false;

		int indice = buscarIndexContratoByCodigo(codigo);
		if (indice == -1) {
			return false;
		}

		Contrato contrato = misContratos.get(indice);
		contrato.setActivo(false);
		contrato.setFechaCierre(LocalDate.now());

		Persona personaActual = getPersonaActual();
	    if (personaActual != null) {
	        registrarLog(personaActual, "Cerró contrato " + codigo);
	    }
	    
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
			if (u.getUser() != null && u.getUser().equals(username) && u.getPassword() != null
					&& u.getPassword().equals(password)) {

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

	public int contarClientesPersonas() {
		int count = 0;
		for (Cliente c : misClientes) {
			if (c.getUsuario() != null && !c.getUsuario().isEmpresa() && c.isActivo()) count++;
		}
		return count;
	}

	public int contarClientesEmpresas() {
		int count = 0;
		for (Cliente c : misClientes) {
			if (c.getUsuario() != null && c.getUsuario().isEmpresa() && c.isActivo()) count++;
		}
		return count;
	}

	public int contarEmpleadosTotal() {
		return misEmpleados.size();
	}

	public int contarTecnicos() {
		int count = 0;
		for (Empleado e : misEmpleados) {
			if (e.getRol() == Rol.TECNICO) count++;
		}
		return count;
	}

	public int contarComerciales() {
		int count = 0;
		for (Empleado e : misEmpleados) {
			if (e.getRol() == Rol.COMERCIAL) count++;
		}
		return count;
	}

	public int contarAdministradores() {
		int count = 0;
		for (Empleado e : misEmpleados) {
			if (e.getRol() == Rol.ADMINISTRADOR) count++;
		}
		return count;
	}

	public int contarSolicitudesCompletadasPorTecnico(String codigoTecnico) {
		int count = 0;
		for (Solicitud s : misSolicitudes) {
			if (s.getEmpleado() != null && 
					s.getEmpleado().getCodigo().equals(codigoTecnico) && 
					s.isResuelto()) {
				count++;
			}
		}
		return count;
	}


	public int contarSolicitudesPorTecnico(String codigoTecnico) {
		int count = 0;
		for (Solicitud s : misSolicitudes) {
			if (s.getEmpleado() != null && s.getEmpleado().getCodigo().equals(codigoTecnico)) {
				count++;
			}
		}
		return count;
	}

	// ====================== REPORTES - PLANES ======================

	public int contarPlanesTotal() {
		return misPlanes.size();
	}

	public int contarPlanesActivos() {
		int count = 0;
		for (Plan p : misPlanes) {
			if (p.isActivo()) count++;
		}
		return count;
	}
	public int contarPagosTotal() {
		return misPagos.size();
	}

	public int contarPagosPendientes() {
		int count = 0;
		for (Pago p : misPagos) {
			if (p.isPendiente() && p.isActivo()) count++;
		}
		return count;
	}

	public int contarPagosRealizados() {
		int count = 0;
		for (Pago p : misPagos) {
			if (!p.isPendiente() && p.isActivo()) count++;
		}
		return count;
	}

	public int contarPagosCancelados() {
		int count = 0;
		for (Pago p : misPagos) {
			if (!p.isActivo()) count++;
		}
		return count;
	}

	public double calcularMontoPendienteTotal() {
		double total = 0;
		for (Pago p : misPagos) {
			if (p.isPendiente() && p.isActivo()) {
				total += p.getMonto();
			}
		}
		return total;
	}

	public double calcularIngresosMensuales(int mes, int año) {
		double total = 0;
		for (Pago p : misPagos) {
			if (p.getFechaPago() != null && 
					p.getFechaPago().getMonthValue() == mes && 
					p.getFechaPago().getYear() == año && 
					!p.isPendiente() && p.isActivo()) {
				total += p.getMonto();
			}
		}
		return total;
	}

	// ====================== REPORTES - CLIENTES ======================

	public int contarClientesTotal() {
		return misClientes.size();
	}

	public int contarClientesActivos() {
		int count = 0;
		for (Cliente c : misClientes) {
			if (c.isActivo()) count++;
		}
		return count;
	}

	public int contarClientesInactivos() {
		return misClientes.size() - contarClientesActivos();
	}

	public int contarClientesAlDia() {
		int count = 0;
		for (Cliente c : misClientes) {
			if (c.isActivo() && calcularDeudaCliente(c) <= 0) {
				count++;
			}
		}
		return count;
	}

	public int contarClientesPendientes() {
		int count = 0;
		for (Cliente c : misClientes) {
			if (c.isActivo() && calcularDeudaCliente(c) > 0) {
				count++;
			}
		}
		return count;
	}

	public double calcularDeudaCliente(Cliente cli) {
		if (cli == null || cli.getPagos() == null) return 0.0;
		double deuda = 0.0;
		for (Pago p : cli.getPagos()) {
			if (p.isPendiente() && p.isActivo()) {
				deuda += p.getMonto();
			}
		}
		return deuda;
	}

	public float calcularDeudaCedula(String cedula) {
	    if (cedula == null || cedula.trim().isEmpty()) {
	        return 0.0f;
	    }

	    float deudaTotal = 0.0f;

	    for (Pago p : misPagos) {
	        if (p.isPendiente() && p.isActivo()) {
	            Persona cliente = p.getCliente();
	            if (cliente != null && cliente.getCedula() != null &&
	                cliente.getCedula().equalsIgnoreCase(cedula)) {
	                
	                deudaTotal += p.getMonto();
	            }
	        }
	    }

	    return deudaTotal;
	}
	
	public int contarPagosPendientesPorCedula(String cedula) {
	    if (cedula == null || cedula.trim().isEmpty()) {
	        return 0;
	    }

	    int cantidad = 0;

	    for (Pago p : misPagos) {
	        if (p.isPendiente() && p.isActivo()) {
	            if (p.getCliente() != null && 
	                p.getCliente().getCedula() != null &&
	                p.getCliente().getCedula().equalsIgnoreCase(cedula)) {
	                cantidad++;
	            }
	        }
	    }
	    return cantidad;
	}

	// ====================== DISTRIBUCIÓN POR DEUDA ======================

	public int contarClientesSinDeuda() {
		int count = 0;
		for (Cliente c : misClientes) {
			if (c.isActivo() && calcularDeudaCliente(c) <= 0) {
				count++;
			}
		}
		return count;
	}

	public int contarClientesDeudaBaja() {
		int count = 0;
		for (Cliente c : misClientes) {
			double deuda = calcularDeudaCliente(c);
			if (c.isActivo() && deuda > 0 && deuda <= 5000) {
				count++;
			}
		}
		return count;
	}

	public int contarClientesDeudaMedia() {
		int count = 0;
		for (Cliente c : misClientes) {
			double deuda = calcularDeudaCliente(c);
			if (c.isActivo() && deuda > 5000 && deuda <= 15000) {
				count++;
			}
		}
		return count;
	}

	public int[] getClientesPorMesUltimoAno() {
		int[] clientesPorMes = new int[12]; // 12 meses

		LocalDate hoy = LocalDate.now();
		int añoActual = hoy.getYear();

		for (Cliente c : misClientes) {
			if (c.getUsuario() != null && c.getUsuario().getFechaRegistro() != null) {
				LocalDate fechaReg = c.getUsuario().getFechaRegistro();
				if (fechaReg.getYear() == añoActual) {
					int mes = fechaReg.getMonthValue() - 1; // 0 = Enero, 11 = Diciembre
					clientesPorMes[mes]++;
				}
			}
		}
		return clientesPorMes;
	}


	public int contarClientesDeudaAlta() {
		int count = 0;
		for (Cliente c : misClientes) {
			double deuda = calcularDeudaCliente(c);
			if (c.isActivo() && deuda > 15000) {
				count++;
			}
		}
		return count;
	}

    public java.util.Map<String, Integer> contarContratosPorPlan() {
        java.util.Map<String, Integer> mapa = new java.util.HashMap<>();
        
        for (Contrato c : misContratos) {
            if (c.getPlan() != null) {
                String nombrePlan = c.getPlan().getNombre();
                mapa.put(nombrePlan, mapa.getOrDefault(nombrePlan, 0) + 1);
            }
        }
        return mapa;
    }
	public float calcularDeudaTotalClientes() {
		float total = 0;
		for (Cliente c : misClientes) {
			total += calcularDeudaCliente(c);
		}
		return total;
	}
	
    public int contarContratosCerrados() {
        return misContratos.size() - contarContratosActivos();
    }
    
    public float[] getDeudaTotalPorMesUltimoAno() {
        float[] deudaPorMes = new float[12];
        LocalDate hoy = LocalDate.now();
        int añoActual = hoy.getYear();

        for (Contrato c : misContratos) {
            if (!c.isActivo()) continue;
            LocalDate fechaInicio = c.getFechaInicio();
            if (fechaInicio.getYear() == añoActual) {
                int mes = fechaInicio.getMonthValue() - 1;
                deudaPorMes[mes] += c.getDeuda();
            }
        }
        return deudaPorMes;
    }

    
    public int contarContratosTotal() {
        return misContratos.size();
    }
    
    public int contarContratosActivos() {
        int count = 0;
        for (Contrato c : misContratos) {
            if (c.isActivo()) count++;
        }
        return count;
    }
    
    public float[] getIngresosMensualesUltimoAno() {
        float[] ingresosPorMes = new float[12]; 
        LocalDate hoy = LocalDate.now();
        int añoActual = hoy.getYear();

        for (Pago p : misPagos) {
            if (p.getFechaPago() != null && 
                p.getFechaPago().getYear() == añoActual && 
                !p.isPendiente() && p.isActivo()) {
                
                int mes = p.getFechaPago().getMonthValue() - 1;
                ingresosPorMes[mes] += p.getMonto();
            }
        }
        return ingresosPorMes;
    }    // ====================== MONTO RECAUDADO TOTAL ======================
    public float calcularMontoRecaudadoTotal() {
        float total = 0;
        for (Pago p : misPagos) {
            if (!p.isPendiente() && p.isActivo() && p.getFechaPago() != null) {
                total += p.getMonto();
            }
        }
        return total;
    }
    
    // ====================== REPORTES - SOLICITUDES ======================

    /**
     * Cuenta solicitudes por tipo (corregido para que coincida con tu enum)
     */
    public int contarSolicitudesPorTipo(TipoSolicitud tipo) {
        if (tipo == null) return 0;
        int count = 0;
        for (Solicitud s : misSolicitudes) {
            if (s.getTipo() == tipo) {
                count++;
            }
        }
        return count;
    }

    /**
     * Cuenta solicitudes por estado (corregido para que coincida con tu enum)
     */
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

    /**
     * Tiempo promedio de resolución en días (solo para solicitudes RESUELTO)
     * Retorna 0 si no hay datos suficientes
     */
    public double calcularTiempoPromedioResolucion() {
        int count = 0;
        long totalDias = 0;

        for (Solicitud s : misSolicitudes) {
            if (s.isResuelto() && s.getFechaRegistro() != null && s.getFechaAtencion() != null) {
                long dias = java.time.temporal.ChronoUnit.DAYS.between(
                    s.getFechaRegistro(), s.getFechaAtencion());
                
                if (dias > 0) {
                    totalDias += dias;
                    count++;
                }
            }
        }

        return (count > 0) ? (double) totalDias / count : 0.0;
    }

    /**
     * Tiempo promedio de resolución por tipo de solicitud
     */
    public double calcularTiempoPromedioResolucionPorTipo(TipoSolicitud tipo) {
        if (tipo == null) return 0.0;

        int count = 0;
        long totalDias = 0;

        for (Solicitud s : misSolicitudes) {
            if (s.getTipo() == tipo && s.isResuelto() && 
                s.getFechaRegistro() != null && s.getFechaAtencion() != null) {
                
                long dias = java.time.temporal.ChronoUnit.DAYS.between(
                    s.getFechaRegistro(), s.getFechaAtencion());
                
                if (dias > 0) {
                    totalDias += dias;
                    count++;
                }
            }
        }

        return (count > 0) ? (double) totalDias / count : 0.0;
    }
    
    // ====================== REPORTES - NÓMINA ======================

    /**
     * Retorna el número de contratos realizados por un empleado en los últimos N meses
     */
    public int contarContratosEmpleadoEnPeriodo(String codigoEmpleado, int mesesAtras) {
        if (codigoEmpleado == null || mesesAtras < 1) return 0;

        Empleado emp = buscarEmpleadoById(codigoEmpleado);
        if (emp == null || emp.getContratos() == null) return 0;

        LocalDate hoy = LocalDate.now();
        LocalDate fechaLimite = hoy.minusMonths(mesesAtras);

        int count = 0;
        for (Contrato c : emp.getContratos()) {
            if (c.getFechaInicio() != null && !c.getFechaInicio().isBefore(fechaLimite)) {
                count++;
            }
        }
        return count;
    }
    
    public ArrayList<Empleado> getTodosLosEmpleados() {
        return new ArrayList<>(misEmpleados);
    }

    public float calcularIngresosContratosPorPeriodo(int mesesAtras) {
        float total = 0f;
        LocalDate fechaLimite = (mesesAtras > 0) ? LocalDate.now().minusMonths(mesesAtras) : null;

        for (Contrato contrato : misContratos) {
            if (contrato.getPagos() != null) {
                for (Pago pago : contrato.getPagos()) {
                    if (pago.isActivo() && !pago.isPendiente() && pago.getFechaPago() != null) {
                        if (fechaLimite != null && pago.getFechaPago().isBefore(fechaLimite)) {
                            continue;
                        }
                        total += pago.getMonto();
                    }
                }
            }
        }
        return total;
    }

    
    
    public float[] getIngresosContratosPorMesUltimoAno() {
        float[] ingresosPorMes = new float[12];
        LocalDate hoy = LocalDate.now();
        int añoActual = hoy.getYear();

        for (Contrato contrato : misContratos) {
            if (contrato.getPagos() != null) {
                for (Pago pago : contrato.getPagos()) {
                    if (pago.isActivo() && !pago.isPendiente() && pago.getFechaPago() != null) {
                        if (pago.getFechaPago().getYear() == añoActual) {
                            int mes = pago.getFechaPago().getMonthValue() - 1; // 0 = Enero
                            ingresosPorMes[mes] += pago.getMonto();
                        }
                    }
                }
            }
        }
        return ingresosPorMes;
    }
}