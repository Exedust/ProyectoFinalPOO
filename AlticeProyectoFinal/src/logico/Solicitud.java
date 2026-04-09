package logico;

import java.time.LocalDate;

public class Solicitud {

    public Solicitud(String codigo, Cliente cliente, TipoSolicitud tipo, String descripcion) {
        this.codigo = codigo;
        this.setCliente(cliente);
        this.setTipo(tipo);
        this.setDescripcion(descripcion);
        setEstado(EstadoSolicitud.PENDIENTE);
        fechaRegistro = LocalDate.now();
    }

    private String codigo;
    private Cliente cliente;
    private Empleado empleado;
    private TipoSolicitud tipo;
    private EstadoSolicitud estado;
    private String descripcion;
    private LocalDate fechaRegistro;
    private LocalDate fechaAtencion;


    public void completar() {
        setEstado(EstadoSolicitud.COMPLETADA);
        setFechaAtencion(LocalDate.now());
    }

    public void cancelar() {
        setEstado(EstadoSolicitud.CANCELADA);
        setFechaAtencion(LocalDate.now());
    }

    public void asignarEmpleado(Empleado empleado) {
        this.empleado = empleado;
        setEstado(EstadoSolicitud.EN_PROCESO);
    }

    public boolean isResuelto() {
        return estado == EstadoSolicitud.COMPLETADA;
    }

    public boolean isCancelada() {
        return estado == EstadoSolicitud.CANCELADA;
    }

    public boolean isEnProceso() {
        return estado == EstadoSolicitud.EN_PROCESO;
    }

    // ==================== GETTERS Y SETTERS ====================

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(LocalDate fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public TipoSolicitud getTipo() {
        return tipo;
    }

    public void setTipo(TipoSolicitud tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}