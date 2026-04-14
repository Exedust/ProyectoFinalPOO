package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.Component;

import logico.Altice;
import logico.Empleado;
import logico.EstadoSolicitud;
import logico.TipoSolicitud;

public class Reportes extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTabbedPane tabbedPane;

    private ChartPanel chartPanelActual = null;

    private JLabel lblInfoClientes;
    private JLabel lblInfoContratos;
    private JLabel lblInfoPagos;
    private JLabel lblInfoSolicitudes;
    private JLabel lblInfoPlanes;
    private JTable tablaNomina;
    private DefaultTableModel modeloNomina;
    private JComboBox<String> comboPeriodo;
    private JComboBox<String> comboPeriodoContratos;  
    private JComboBox<String> comboPeriodoPagos;   

    public static void main(String[] args) {
        try {
            Reportes dialog = new Reportes();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Reportes() {
        setTitle("Reportes - Altice");
        setResizable(false);
        setBounds(100, 100, 1250, 750);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(0, 0, 51));
        getContentPane().setLayout(new BorderLayout());

        contentPanel.setBackground(new Color(0, 0, 51));
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabbedPane.setBackground(new Color(0, 0, 51));
        tabbedPane.setForeground(Color.WHITE);
        contentPanel.add(tabbedPane, BorderLayout.CENTER);

        // === Todas las pestañas ===
        crearPestanaClientes();
        crearPestanaContratos();
        crearPestanaPagos();
        crearPestanaSolicitudes();
        crearPestanaPlanes();
        crearPestanaNomina();

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(0, 0, 51));
        buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBackground(new Color(102, 0, 0));
        btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnSalir.setFocusPainted(false);
        btnSalir.addActionListener(e -> dispose());
        buttonPane.add(btnSalir);
    }

    // ====================== PESTAÑA CLIENTES ======================
    private void crearPestanaClientes() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setLayout(null);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(0, 0, 51));
        panelBotones.setBounds(30, 30, 280, 420);
        panelBotones.setLayout(new GridLayout(0, 1, 0, 10));

        JButton btnEstadoPago = new JButton("Estado de Pago");
        btnEstadoPago.addActionListener(e -> mostrarGraficoEstadoPago(panel));
        agregarBotonEstilo(btnEstadoPago);
        panelBotones.add(btnEstadoPago);

        JButton btnDistribucionDeuda = new JButton("Distribución por Deuda");
        btnDistribucionDeuda.addActionListener(e -> mostrarGraficoDistribucionDeuda(panel));
        agregarBotonEstilo(btnDistribucionDeuda);
        panelBotones.add(btnDistribucionDeuda);

        JButton btnMesRegistro = new JButton("Mes de Registro");
        btnMesRegistro.addActionListener(e -> mostrarGraficoMesRegistro(panel));
        agregarBotonEstilo(btnMesRegistro);
        panelBotones.add(btnMesRegistro);

        JButton btnResumen = new JButton("Resumen");
        btnResumen.addActionListener(e -> mostrarResumen(panel));
        agregarBotonEstilo(btnResumen);
        panelBotones.add(btnResumen);

        panel.add(panelBotones);

        lblInfoClientes = new JLabel("<html><b>Información General de Clientes:</b><br><br>" +
                "Total de clientes: " + Altice.getInstance().contarClientesTotal() + "<br>" +
                "Clientes activos: " + Altice.getInstance().contarClientesActivos() + "<br>" +
                "Clientes al día: " + Altice.getInstance().contarClientesAlDia() + "<br>" +
                "Clientes con deuda: " + Altice.getInstance().contarClientesPendientes() + "<br>" +
                "Deuda total: RD$ " + String.format("%.2f", Altice.getInstance().calcularDeudaTotalClientes()) +
                "</html>");
        lblInfoClientes.setForeground(Color.WHITE);
        lblInfoClientes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblInfoClientes.setBounds(350, 30, 550, 220);
        panel.add(lblInfoClientes);

        tabbedPane.addTab("Clientes", panel);
    }

    // ====================== PESTAÑA CONTRATOS ======================
    private void crearPestanaContratos() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setLayout(null);

        // Panel de botones a la izquierda
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(0, 0, 51));
        panelBotones.setBounds(30, 30, 280, 380);
        panelBotones.setLayout(new GridLayout(0, 1, 0, 10));

        JButton btnEstado = new JButton("Contratos por Estado");
        btnEstado.addActionListener(e -> mostrarGraficoContratosPorEstado(panel));
        agregarBotonEstilo(btnEstado);
        panelBotones.add(btnEstado);

        JButton btnPorPlan = new JButton("Contratos por Plan");
        btnPorPlan.addActionListener(e -> mostrarGraficoContratosPorPlan(panel));
        agregarBotonEstilo(btnPorPlan);
        panelBotones.add(btnPorPlan);

        JButton btnIngresosContratos = new JButton("Ingresos por Mes");
        btnIngresosContratos.addActionListener(e -> mostrarGraficoIngresosContratosPorMes(panel));
        agregarBotonEstilo(btnIngresosContratos);
        panelBotones.add(btnIngresosContratos);

        JButton btnResumen = new JButton("Resumen");
        btnResumen.addActionListener(e -> mostrarResumenContratos(panel));
        agregarBotonEstilo(btnResumen);
        panelBotones.add(btnResumen);

        panel.add(panelBotones);

        // ==================== COMBOBOX GLOBAL + BOTÓN MOSTRAR ====================
        JPanel panelFiltro = new JPanel();
        panelFiltro.setBackground(new Color(0, 0, 51));
        panelFiltro.setBounds(30, 430, 280, 50);
        panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));

        JLabel lblPeriodo = new JLabel("Período:");
        lblPeriodo.setForeground(Color.WHITE);
        lblPeriodo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panelFiltro.add(lblPeriodo);

        comboPeriodoContratos = new JComboBox<String>(new String[]{
                "Todos los tiempos",
                "Último mes",
                "Últimos 3 meses",
                "Últimos 6 meses",
                "Último año"
        });
        comboPeriodoContratos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        panelFiltro.add(comboPeriodoContratos);

        // BOTÓN MOSTRAR
        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.setForeground(Color.WHITE);
        btnMostrar.setBackground(new Color(0, 102, 0));
        btnMostrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btnMostrar.setFocusPainted(false);
        btnMostrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        btnMostrar.addActionListener(e -> actualizarGraficoActualContratos(panel));
        panelFiltro.add(btnMostrar);

        panel.add(panelFiltro);

        // Label de información general
        lblInfoContratos = new JLabel("<html><b>Información General de Contratos:</b><br><br>" +
                "Total de contratos: " + Altice.getInstance().contarContratosTotal() + "<br>" +
                "Contratos activos: " + Altice.getInstance().contarContratosActivos() + "<br>" +
                "Contratos cerrados: " + Altice.getInstance().contarContratosCerrados() + "<br>" +
                "Deuda total: RD$ " + String.format("%.2f", Altice.getInstance().calcularDeudaTotalClientes()) +
                "</html>");

        lblInfoContratos.setForeground(Color.WHITE);
        lblInfoContratos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblInfoContratos.setBounds(350, 30, 550, 220);
        panel.add(lblInfoContratos);

        // Mostrar resumen por defecto al entrar a la pestaña
        mostrarResumenContratos(panel);

        tabbedPane.addTab("Contratos", panel);
    }
    
    // ====================== PESTAÑA PAGOS ======================
    private void crearPestanaPagos() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setLayout(null);

        // Panel de botones a la izquierda
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(0, 0, 51));
        panelBotones.setBounds(30, 30, 280, 380);
        panelBotones.setLayout(new GridLayout(0, 1, 0, 10));

        JButton btnIngresos = new JButton("Ingresos");
        btnIngresos.addActionListener(e -> mostrarGraficoIngresosMensuales(panel));
        agregarBotonEstilo(btnIngresos);
        panelBotones.add(btnIngresos);

        JButton btnMontoPendiente = new JButton("Monto Pendiente");
        btnMontoPendiente.addActionListener(e -> mostrarGraficoMontoPendienteVsRecaudado(panel));
        agregarBotonEstilo(btnMontoPendiente);
        panelBotones.add(btnMontoPendiente);

        JButton btnResumen = new JButton("Resumen");
        btnResumen.addActionListener(e -> mostrarResumenPagos(panel));
        agregarBotonEstilo(btnResumen);
        panelBotones.add(btnResumen);

        panel.add(panelBotones);

        // ==================== COMBOBOX GLOBAL + BOTÓN MOSTRAR ====================
        JPanel panelFiltro = new JPanel();
        panelFiltro.setBackground(new Color(0, 0, 51));
        panelFiltro.setBounds(30, 430, 280, 50);
        panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));

        JLabel lblPeriodo = new JLabel("Período:");
        lblPeriodo.setForeground(Color.WHITE);
        lblPeriodo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panelFiltro.add(lblPeriodo);

        comboPeriodoPagos = new JComboBox<String>(new String[]{
                "Todos los tiempos",
                "Último mes",
                "Últimos 3 meses",
                "Últimos 6 meses",
                "Último año"
        });
        comboPeriodoPagos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        panelFiltro.add(comboPeriodoPagos);

        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.setForeground(Color.WHITE);
        btnMostrar.setBackground(new Color(0, 102, 0));
        btnMostrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btnMostrar.setFocusPainted(false);
        btnMostrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        btnMostrar.addActionListener(e -> actualizarGraficoActualPagos(panel));
        panelFiltro.add(btnMostrar);

        panel.add(panelFiltro);

        // Label de información general
        lblInfoPagos = new JLabel("<html><b>Información General de Pagos:</b><br><br>" +
                "Total de pagos: " + Altice.getInstance().contarPagosTotal() + "<br>" +
                "Pagos realizados: " + Altice.getInstance().contarPagosRealizados() + "<br>" +
                "Pagos pendientes: " + Altice.getInstance().contarPagosPendientes() + "<br>" +
                "Pagos cancelados: " + Altice.getInstance().contarPagosCancelados() + "<br>" +
                "Monto pendiente total: RD$ " + String.format("%.2f", Altice.getInstance().calcularMontoPendienteTotal()) +
                "</html>");

        lblInfoPagos.setForeground(Color.WHITE);
        lblInfoPagos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblInfoPagos.setBounds(350, 30, 550, 220);
        panel.add(lblInfoPagos);

        // Mostrar resumen por defecto
        mostrarResumenPagos(panel);

        tabbedPane.addTab("Pagos", panel);
    }
    // ====================== PESTAÑA SOLICITUDES ======================
    private void crearPestanaSolicitudes() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setLayout(null);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(0, 0, 51));
        panelBotones.setBounds(30, 30, 280, 420);
        panelBotones.setLayout(new GridLayout(0, 1, 0, 10));

        JButton btnTipo = new JButton("Tipo");
        btnTipo.addActionListener(e -> mostrarGraficoSolicitudesPorTipo(panel));
        agregarBotonEstilo(btnTipo);
        panelBotones.add(btnTipo);

        JButton btnEstado = new JButton("Estado");
        btnEstado.addActionListener(e -> mostrarGraficoEstado(panel));
        agregarBotonEstilo(btnEstado);
        panelBotones.add(btnEstado);

        JButton btnResumen = new JButton("Resumen");
        btnResumen.addActionListener(e -> mostrarResumenSolicitudes(panel));
        agregarBotonEstilo(btnResumen);
        panelBotones.add(btnResumen);

        panel.add(panelBotones);

        lblInfoSolicitudes = new JLabel("<html><b>Información General de Solicitudes:</b><br><br>" +
                "Total de solicitudes: " + Altice.getInstance().contarSolicitudesTotal() + "<br>" +
                "Solicitudes pendientes: " + Altice.getInstance().contarSolicitudesPorEstado(EstadoSolicitud.PENDIENTE) + "<br>" +
                "Solicitudes en proceso: " + Altice.getInstance().contarSolicitudesPorEstado(EstadoSolicitud.EN_PROCESO) + "<br>" +
                "Solicitudes resueltas: " + Altice.getInstance().contarSolicitudesPorEstado(EstadoSolicitud.COMPLETADA) + "<br>" +
                "Solicitudes canceladas: " + Altice.getInstance().contarSolicitudesPorEstado(EstadoSolicitud.CANCELADA) +
                "</html>");
        lblInfoSolicitudes.setForeground(Color.WHITE);
        lblInfoSolicitudes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblInfoSolicitudes.setBounds(350, 30, 550, 220);
        panel.add(lblInfoSolicitudes);

        tabbedPane.addTab("Solicitudes", panel);
    }

    // ====================== PESTAÑA PLANES ======================
    private void crearPestanaPlanes() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setLayout(null);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(0, 0, 51));
        panelBotones.setBounds(30, 30, 280, 420);
        panelBotones.setLayout(new GridLayout(0, 1, 0, 10));

        JButton btnDistribucionPlanes = new JButton("Distribución de Planes");
        btnDistribucionPlanes.addActionListener(e -> mostrarGraficoDistribucionPlanes(panel));
        agregarBotonEstilo(btnDistribucionPlanes);
        panelBotones.add(btnDistribucionPlanes);

        JButton btnIngresosPorPlan = new JButton("Ingresos por Plan");
        btnIngresosPorPlan.addActionListener(e -> mostrarGraficoIngresosPorPlan(panel));
        agregarBotonEstilo(btnIngresosPorPlan);
        panelBotones.add(btnIngresosPorPlan);

        JButton btnResumen = new JButton("Resumen");
        btnResumen.addActionListener(e -> mostrarResumenPlanes(panel));
        agregarBotonEstilo(btnResumen);
        panelBotones.add(btnResumen);

        panel.add(panelBotones);

        lblInfoPlanes = new JLabel("<html><b>Información General de Planes:</b><br><br>" +
                "Total de planes: " + Altice.getInstance().contarPlanesTotal() + "<br>" +
                "Planes activos: " + Altice.getInstance().contarPlanesActivos() + "<br>" +
                "Planes inactivos: " + (Altice.getInstance().contarPlanesTotal() - Altice.getInstance().contarPlanesActivos()) + "<br>" +
                "Total de contratos: " + Altice.getInstance().contarContratosTotal() + "<br>" +
                "Contrato promedio por plan: " +
                (Altice.getInstance().contarContratosTotal() > 0 ?
                String.format("%.1f", (double) Altice.getInstance().contarContratosTotal() / Altice.getInstance().contarPlanesTotal()) : "0") +
                "</html>");
        lblInfoPlanes.setForeground(Color.WHITE);
        lblInfoPlanes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblInfoPlanes.setBounds(350, 30, 550, 250);
        panel.add(lblInfoPlanes);

        tabbedPane.addTab("Planes", panel);
    }
    
    private void mostrarGraficoIngresosPorPlan(JPanel panel) {
        ocultarGraficoActual(panel);

        Map<String, Float> ingresosPorPlan = Altice.getInstance().calcularIngresosPorPlan();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Ordenamos los planes alfabéticamente para mejor visualización
        ingresosPorPlan.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    dataset.setValue(entry.getValue(), "Ingresos (RD$)", entry.getKey());
                });

        String titulo = ingresosPorPlan.isEmpty() 
                ? "Ingresos por Plan (Sin datos aún)" 
                : "Ingresos Generados por Plan";

        JFreeChart chart = ChartFactory.createBarChart(
                titulo,
                "Plan",
                "Ingresos (RD$)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);

        panel.add(chartPanelActual);
        if (lblInfoPlanes != null) lblInfoPlanes.setVisible(false);

        panel.revalidate();
        panel.repaint();
    }

    // ====================== GRÁFICOS DE PLANES ======================
 
        private void mostrarResumenPlanes(JPanel panel) {
        ocultarGraficoActual(panel);
        if (lblInfoPlanes != null) lblInfoPlanes.setVisible(true);
        panel.revalidate();
        panel.repaint();
    }

    // ====================== MÉTODOS AUXILIARES ======================
    
    private void mostrarResumen(JPanel panel) {
        ocultarGraficoActual(panel);
        if (lblInfoClientes != null) lblInfoClientes.setVisible(true);
        panel.revalidate();
        panel.repaint();
    }

    private void mostrarResumenContratos(JPanel panel) {
        ocultarGraficoActual(panel);        	
        if (lblInfoContratos != null) {
            lblInfoContratos.setVisible(true);
        }
        panel.revalidate();
        panel.repaint();
    }
    private void mostrarResumenPagos(JPanel panel) {
        ocultarGraficoActual(panel);
        if (lblInfoPagos != null) lblInfoPagos.setVisible(true);
        panel.revalidate();
        panel.repaint();
    }

    private void mostrarResumenSolicitudes(JPanel panel) {
        ocultarGraficoActual(panel);
        if (lblInfoSolicitudes != null) lblInfoSolicitudes.setVisible(true);
        panel.revalidate();
        panel.repaint();
    }

    private void agregarBotonEstilo(JButton boton) {
        boton.setForeground(Color.WHITE);
        boton.setBackground(new Color(0, 0, 51));
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        boton.setFocusPainted(false);
        boton.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
    }

    // ====================== OTRAS PESTAÑAS ======================
    // ====================== PESTAÑA NÓMINA ======================
    private void crearPestanaNomina() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setLayout(null);

        // Panel de filtro
        JPanel panelFiltro = new JPanel();
        panelFiltro.setBackground(new Color(0, 0, 51));
        panelFiltro.setBounds(30, 30, 800, 50);
        panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

        JLabel lblPeriodo = new JLabel("Período:");
        lblPeriodo.setForeground(Color.WHITE);
        lblPeriodo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panelFiltro.add(lblPeriodo);

        comboPeriodo = new JComboBox<String>(new String[]{
                "Último mes", "Últimos 3 meses", "Últimos 6 meses", "Último año"
        });
        comboPeriodo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panelFiltro.add(comboPeriodo);

        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setForeground(Color.WHITE);
        btnFiltrar.setBackground(new Color(0, 102, 0));
        btnFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnFiltrar.addActionListener(e -> cargarTablaNomina());
        panelFiltro.add(btnFiltrar);

        panel.add(panelFiltro);

        // Tabla de Nómina
        String[] columnas = {"Cédula", "Nombre", "Rol", "Sueldo", "Comisión", "Total"};
        modeloNomina = new DefaultTableModel(columnas, 0);
        tablaNomina = new JTable(modeloNomina);
        tablaNomina.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tablaNomina.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tablaNomina.setRowHeight(30);

        JScrollPane scroll = new JScrollPane(tablaNomina);
        scroll.setBounds(30, 100, 1150, 500);
        panel.add(scroll);

        // Cargar datos iniciales
        cargarTablaNomina();

        tabbedPane.addTab("Nómina", panel);
    }

    private void cargarTablaNomina() {
        modeloNomina.setRowCount(0);

        String periodo = (String) comboPeriodo.getSelectedItem();
        int mesesAtras = 0;   // Por defecto = mes actual

        if (periodo != null) {
            switch (periodo) {
                case "Último mes":      mesesAtras = 0; break;
                case "Últimos 3 meses": mesesAtras = 3; break;
                case "Últimos 6 meses": mesesAtras = 6; break;
                case "Último año":      mesesAtras = 12; break;
            }
        }

        ArrayList<Empleado> empleados = Altice.getInstance().getTodosLosEmpleados();

        for (Empleado emp : empleados) {
            if (!emp.isActivo()) continue;

            int numContratos = Altice.getInstance().contarContratosEmpleadoEnPeriodo(emp.getCodigo(), mesesAtras);
            
            float comision = 0f;
            if (emp.getRol() == logico.Rol.COMERCIAL && emp.getComision() != null) {
                comision = numContratos * emp.getComision();
            }

            float total = emp.getSalario() + comision;
            
            modeloNomina.addRow(new Object[]{
                emp.getCedula(),
                emp.getNombre(),
                emp.getRol().toString(),
                String.format("RD$ %.2f", emp.getSalario()),
                String.format("RD$ %.2f", comision),
                String.format("RD$ %.2f", total)
            });
        }
    }
    
    private void ocultarGraficoActual(JPanel panel) {
        Component[] componentes = panel.getComponents();
        for (Component comp : componentes) {
            if (comp instanceof ChartPanel) {
                panel.remove(comp);
            }
        }
        chartPanelActual = null;

        if (lblInfoClientes != null) lblInfoClientes.setVisible(false);
        if (lblInfoContratos != null) lblInfoContratos.setVisible(false);
        if (lblInfoPagos != null) lblInfoPagos.setVisible(false);
        if (lblInfoSolicitudes != null) lblInfoSolicitudes.setVisible(false);
        if (lblInfoPlanes != null) lblInfoPlanes.setVisible(false);

        panel.revalidate();
        panel.repaint();
    }


    // ====================== GRÁFICOS ANTERIORES (resumidos) ======================
    private void mostrarGraficoEstadoPago(JPanel panel) {
        ocultarGraficoActual(panel);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(Altice.getInstance().contarClientesAlDia(), "Estado", "Al Día");
        dataset.setValue(Altice.getInstance().contarClientesPendientes(), "Estado", "Pendientes");
        JFreeChart chart = ChartFactory.createBarChart("Estado de Pago de Clientes",
                "Estado", "Cantidad de Clientes", dataset, PlotOrientation.VERTICAL, true, true, false);
        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);
        panel.add(chartPanelActual);
        lblInfoClientes.setVisible(false);
        panel.revalidate();
        panel.repaint();
    }

    private void mostrarGraficoDistribucionDeuda(JPanel panel) {
        ocultarGraficoActual(panel);
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Sin Deuda", Altice.getInstance().contarClientesSinDeuda());
        dataset.setValue("Deuda Baja", Altice.getInstance().contarClientesDeudaBaja());
        dataset.setValue("Deuda Media", Altice.getInstance().contarClientesDeudaMedia());
        dataset.setValue("Deuda Alta", Altice.getInstance().contarClientesDeudaAlta());
        JFreeChart chart = ChartFactory.createPieChart("Distribución de Clientes por Nivel de Deuda",
                dataset, true, true, false);
        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);
        panel.add(chartPanelActual);
        lblInfoClientes.setVisible(false);
        panel.revalidate();
        panel.repaint();
    }

    private void mostrarGraficoMesRegistro(JPanel panel) {
        ocultarGraficoActual(panel);
        int[] clientesPorMes = Altice.getInstance().getClientesPorMesUltimoAno();
        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 12; i++) {
            dataset.setValue(clientesPorMes[i], "Clientes", meses[i]);
        }
        JFreeChart chart = ChartFactory.createBarChart("Clientes Registrados por Mes (Último Año)",
                "Mes", "Cantidad de Clientes", dataset, PlotOrientation.VERTICAL, true, true, false);
        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);
        panel.add(chartPanelActual);
        lblInfoClientes.setVisible(false);
        panel.revalidate();
        panel.repaint();
    }

   
    private void mostrarGraficoContratosPorEstado(JPanel panel) {
        ocultarGraficoActual(panel);
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Activos", Altice.getInstance().contarContratosActivos());
        dataset.setValue("Cerrados", Altice.getInstance().contarContratosCerrados());

        JFreeChart chart = ChartFactory.createPieChart(
                "Distribución de Contratos por Estado",
                dataset, true, true, false);

        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);
        panel.add(chartPanelActual);

        if (lblInfoContratos != null) lblInfoContratos.setVisible(false);
        panel.revalidate();
        panel.repaint();
    }

    private void mostrarGraficoContratosPorPlan(JPanel panel) {
        ocultarGraficoActual(panel);

        Map<String, Integer> contratosPorPlan = Altice.getInstance().contarContratosPorPlan();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entry : contratosPorPlan.entrySet()) {
            dataset.setValue(entry.getValue(), "Contratos", entry.getKey());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Cantidad de Contratos por Plan",
                "Plan", 
                "Número de Contratos", 
                dataset, 
                PlotOrientation.VERTICAL, 
                true, true, false);

        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);
        panel.add(chartPanelActual);

        if (lblInfoContratos != null) lblInfoContratos.setVisible(false);
        panel.revalidate();
        panel.repaint();
    }
    
    private void mostrarGraficoSolicitudesPorTipo(JPanel panel) {
        ocultarGraficoActual(panel);
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Instalación", Altice.getInstance().contarSolicitudesPorTipo(TipoSolicitud.INSTALACION));
        dataset.setValue("Soporte", Altice.getInstance().contarSolicitudesPorTipo(TipoSolicitud.SOPORTE));
        JFreeChart chart = ChartFactory.createPieChart("Solicitudes por Tipo", dataset, true, true, false);
        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);
        panel.add(chartPanelActual);
        if (lblInfoSolicitudes != null) lblInfoSolicitudes.setVisible(false);
        panel.revalidate();
        panel.repaint();
    }
    
    private void mostrarGraficoIngresosContratosPorMes(JPanel panel) {
        ocultarGraficoActual(panel);

        // Obtener el período seleccionado del ComboBox global
        int meses = 0;
        String seleccion = (String) comboPeriodoContratos.getSelectedItem();

        switch (seleccion) {
            case "Último mes":      meses = 1; break;
            case "Últimos 3 meses": meses = 3; break;
            case "Últimos 6 meses": meses = 6; break;
            case "Último año":      meses = 12; break;
            default:                meses = 0; // Todos los tiempos
        }

        double ingresos = Altice.getInstance().calcularIngresosContratosPorPeriodo(meses);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(ingresos, "Ingresos Generados", "Contratos");

        JFreeChart chart = ChartFactory.createBarChart(
                "Ingresos Generados por Contratos - " + seleccion,
                "Período",
                "Monto Total (RD$)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);

        panel.add(chartPanelActual);

        if (lblInfoContratos != null) lblInfoContratos.setVisible(false);

        panel.revalidate();
        panel.repaint();
    }
    
    private void actualizarGraficoActualContratos(JPanel panel) {
        // Si no hay gráfico visible, mostramos el resumen
        if (chartPanelActual == null || chartPanelActual.getChart() == null) {
            mostrarResumenContratos(panel);
            return;
        }

        // Obtenemos el título del gráfico actual antes de ocultarlo
        JFreeChart chartActual = chartPanelActual.getChart();
        String titulo = (chartActual != null && chartActual.getTitle() != null) 
                        ? chartActual.getTitle().getText().toLowerCase() 
                        : "";

        // Ocultamos el gráfico actual
        ocultarGraficoActual(panel);

        // Decidimos qué gráfico volver a mostrar según su título
        if (titulo.contains("ingresos generados por contratos")) {
            mostrarGraficoIngresosContratosPorMes(panel);
        }
        else if (titulo.contains("cantidad de contratos por plan")) {
            mostrarGraficoContratosPorPlan(panel);
        }
        else if (titulo.contains("distribución de contratos por estado")) {
            mostrarGraficoContratosPorEstado(panel);
        }
        else {
            // Por defecto, mostramos Ingresos por Mes (el más importante)
            mostrarGraficoIngresosContratosPorMes(panel);
        }
    }
    /**
     * Obtiene la cantidad de meses seleccionada en el ComboBox global de Pagos
     */
    private int obtenerMesesDelFiltroPagos() {
        if (comboPeriodoPagos == null) return 0;

        String seleccion = (String) comboPeriodoPagos.getSelectedItem();
        if (seleccion == null) return 0;

        switch (seleccion) {
            case "Último mes": return 1;
            case "Últimos 3 meses": return 3;
            case "Últimos 6 meses": return 6;
            case "Último año": return 12;
            default: return 0; // Todos los tiempos
        }
    }
    
    private String getTextoPeriodo(int meses) {
        switch (meses) {
            case 1: return "Último mes";
            case 3: return "Últimos 3 meses";
            case 6: return "Últimos 6 meses";
            case 12: return "Último año";
            default: return "Todos los tiempos";
        }
    }
    
    // ====================== GRÁFICOS DE PAGOS ======================

    
    private void mostrarGraficoMontoPendienteVsRecaudado(JPanel panel) {
        ocultarGraficoActual(panel);

        int meses = obtenerMesesDelFiltroPagos();
        String tituloPeriodo = getTextoPeriodo(meses);

        double montoPendiente = Altice.getInstance().calcularMontoPendientePorPeriodo(meses);
        double montoRecaudado = Altice.getInstance().calcularIngresosPagosPorPeriodo(meses);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(montoRecaudado, "Monto", "Recaudado");
        dataset.setValue(montoPendiente, "Monto", "Pendiente");

        JFreeChart chart = ChartFactory.createBarChart(
                "Pendiente vs Recaudado - " + tituloPeriodo,
                "Categoría",
                "Monto (RD$)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);

        panel.add(chartPanelActual);
        if (lblInfoPagos != null) lblInfoPagos.setVisible(false);

        panel.revalidate();
        panel.repaint();
    }
    
     private void mostrarGraficoIngresosMensuales(JPanel panel) {
        ocultarGraficoActual(panel);

        int mesesFiltro = obtenerMesesDelFiltroPagos();
        String tituloPeriodo = getTextoPeriodo(mesesFiltro);

        // Obtenemos los ingresos mensuales del último año
        float[] ingresosPorMes = Altice.getInstance().getIngresosMensualesUltimoAno();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String[] nombresMeses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};

        // Llenamos el dataset con los 12 meses
        for (int i = 0; i < 12; i++) {
            dataset.setValue(ingresosPorMes[i], "Ingresos", nombresMeses[i]);
        }

        JFreeChart chart = ChartFactory.createLineChart(
                "Ingresos Mensuales - " + tituloPeriodo,
                "Mes",
                "Monto (RD$)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);

        panel.add(chartPanelActual);
        if (lblInfoPagos != null) lblInfoPagos.setVisible(false);

        panel.revalidate();
        panel.repaint();
    }
    private void actualizarGraficoActualPagos(JPanel panel) {
        if (chartPanelActual == null || chartPanelActual.getChart() == null) {
            mostrarResumenPagos(panel);
            return;
        }

        ocultarGraficoActual(panel);

        String titulo = chartPanelActual.getChart().getTitle().getText().toLowerCase();

        if (titulo.contains("ingresos mensuales")) {
            mostrarGraficoIngresosMensuales(panel);
        } 
        else if (titulo.contains("pendiente vs recaudado") || titulo.contains("monto pendiente")) {
            mostrarGraficoMontoPendienteVsRecaudado(panel);
        } 
        else {
            mostrarGraficoIngresosMensuales(panel); // por defecto
        }
    }
    
    
    private void mostrarGraficoDistribucionPlanes(JPanel panel) {
        ocultarGraficoActual(panel);

        Map<String, Integer> contratosPorPlan = Altice.getInstance().contarContratosActivosPorPlan();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entry : contratosPorPlan.entrySet()) {
            dataset.setValue(entry.getValue(), "Cantidad", entry.getKey());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                contratosPorPlan.isEmpty() ? "Contratos Activos por Plan (Sin datos)" : "Contratos Activos por Plan",
                "Plan",
                "Cantidad de Contratos",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);

        panel.add(chartPanelActual);
        if (lblInfoPlanes != null) lblInfoPlanes.setVisible(false);

        panel.revalidate();
        panel.repaint();
    }
    
    
    private void mostrarGraficoEstado(JPanel panel) {
        ocultarGraficoActual(panel);
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Pendientes", Altice.getInstance().contarSolicitudesPorEstado(EstadoSolicitud.PENDIENTE));
        dataset.setValue("En Proceso", Altice.getInstance().contarSolicitudesPorEstado(EstadoSolicitud.EN_PROCESO));
        dataset.setValue("Completadas", Altice.getInstance().contarSolicitudesPorEstado(EstadoSolicitud.COMPLETADA));
        dataset.setValue("Canceladas", Altice.getInstance().contarSolicitudesPorEstado(EstadoSolicitud.CANCELADA));
        JFreeChart chart = ChartFactory.createPieChart("Estado de las Solicitudes", dataset, true, true, false);
        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);
        panel.add(chartPanelActual);
        if (lblInfoSolicitudes != null) lblInfoSolicitudes.setVisible(false);
        panel.revalidate();
        panel.repaint();
    }
}