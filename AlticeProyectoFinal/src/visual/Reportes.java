package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import logico.Altice;
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

        // Llamadas corregidas y completas
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

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(0, 0, 51));
        panelBotones.setBounds(30, 30, 280, 420);
        panelBotones.setLayout(new GridLayout(0, 1, 0, 10));

        JButton btnEstado = new JButton("Contratos por Estado");
        btnEstado.addActionListener(e -> mostrarGraficoContratosPorEstado(panel));
        agregarBotonEstilo(btnEstado);
        panelBotones.add(btnEstado);

        JButton btnPorPlan = new JButton("Contratos por Plan");
        btnPorPlan.addActionListener(e -> mostrarGraficoContratosPorPlan(panel));
        agregarBotonEstilo(btnPorPlan);
        panelBotones.add(btnPorPlan);

        JButton btnMontoDeuda = new JButton("Monto Total de Deuda");
        btnMontoDeuda.addActionListener(e -> mostrarGraficoMontoDeudaPorMes(panel));
        agregarBotonEstilo(btnMontoDeuda);
        panelBotones.add(btnMontoDeuda);

        JButton btnResumen = new JButton("Resumen");
        btnResumen.addActionListener(e -> mostrarResumenContratos(panel));
        agregarBotonEstilo(btnResumen);
        panelBotones.add(btnResumen);

        panel.add(panelBotones);

        lblInfoContratos = new JLabel("<html><b>Información General de Contratos:</b><br><br>" +
                "Total de contratos: " + Altice.getInstance().contarContratosTotal() + "<br>" +
                "Contratos activos: " + Altice.getInstance().contarContratosActivos() + "<br>" +
                "Contratos cerrados: " + Altice.getInstance().contarContratosCerrados() + "<br>" +
                "Deuda total de contratos: RD$ " + String.format("%.2f", Altice.getInstance().calcularDeudaTotalClientes()) +
                "</html>");
        lblInfoContratos.setForeground(Color.WHITE);
        lblInfoContratos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblInfoContratos.setBounds(350, 30, 550, 220);
        panel.add(lblInfoContratos);

        tabbedPane.addTab("Contratos", panel);
    }

    // ====================== PESTAÑA PAGOS ======================
    private void crearPestanaPagos() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setLayout(null);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(0, 0, 51));
        panelBotones.setBounds(30, 30, 280, 420);
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

        JButton btnTiempoResolucion = new JButton("Estado");
        btnTiempoResolucion.addActionListener(e -> mostrarGraficoEstado(panel));
        agregarBotonEstilo(btnTiempoResolucion);
        panelBotones.add(btnTiempoResolucion);

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

    // ====================== GRÁFICOS ======================
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

        JFreeChart chart = ChartFactory.createPieChart("Distribución de Contratos por Estado",
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

        JFreeChart chart = ChartFactory.createBarChart("Cantidad de Contratos por Plan",
                "Plan", "Número de Contratos", dataset, PlotOrientation.VERTICAL, true, true, false);

        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);
        panel.add(chartPanelActual);
        if (lblInfoContratos != null) lblInfoContratos.setVisible(false);
        panel.revalidate();
        panel.repaint();
    }

    private void mostrarGraficoMontoDeudaPorMes(JPanel panel) {
        ocultarGraficoActual(panel);
        float[] deudaPorMes = Altice.getInstance().getDeudaTotalPorMesUltimoAno();
        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 12; i++) {
            dataset.setValue(deudaPorMes[i], "Deuda", meses[i]);
        }

        JFreeChart chart = ChartFactory.createLineChart("Monto Total de Deuda por Mes (Último Año)",
                "Mes", "Monto de Deuda (RD$)", dataset, PlotOrientation.VERTICAL, true, true, false);

        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);
        panel.add(chartPanelActual);
        if (lblInfoContratos != null) lblInfoContratos.setVisible(false);
        panel.revalidate();
        panel.repaint();
    }

    private void mostrarGraficoIngresosMensuales(JPanel panel) {
        ocultarGraficoActual(panel);
        float[] ingresosPorMes = Altice.getInstance().getIngresosMensualesUltimoAno();
        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 12; i++) {
            dataset.setValue(ingresosPorMes[i], "Ingresos", meses[i]);
        }

        JFreeChart chart = ChartFactory.createLineChart("Ingresos Mensuales (Último Año)",
                "Mes", "Monto de Ingresos (RD$)", dataset, PlotOrientation.VERTICAL, true, true, false);

        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);
        panel.add(chartPanelActual);
        if (lblInfoPagos != null) lblInfoPagos.setVisible(false);
        panel.revalidate();
        panel.repaint();
    }

    private void mostrarGraficoMontoPendienteVsRecaudado(JPanel panel) {
        ocultarGraficoActual(panel);
        double montoPendiente = Altice.getInstance().calcularMontoPendienteTotal();
        double montoRecaudado = Altice.getInstance().calcularMontoRecaudadoTotal();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(montoPendiente, "Monto", "Pendiente");
        dataset.setValue(montoRecaudado, "Monto", "Recaudado");

        JFreeChart chart = ChartFactory.createBarChart("Monto Pendiente Total vs Recaudado",
                "Categoría", "Monto (RD$)", dataset, PlotOrientation.VERTICAL, true, true, false);

        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);
        panel.add(chartPanelActual);
        if (lblInfoPagos != null) lblInfoPagos.setVisible(false);
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

        JFreeChart chart = ChartFactory.createPieChart(
                "Estado de las Solicitudes",
                dataset, 
                true,   // legend
                true,   // tooltips
                false); // urls

        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);
        panel.add(chartPanelActual);

        if (lblInfoSolicitudes != null) lblInfoSolicitudes.setVisible(false);
        
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

    private void ocultarGraficoActual(JPanel panel) {
        if (chartPanelActual != null) {
            panel.remove(chartPanelActual);
            chartPanelActual = null;
        }
    }

    private void mostrarResumen(JPanel panel) {
        ocultarGraficoActual(panel);
        if (lblInfoClientes != null) lblInfoClientes.setVisible(true);
        panel.revalidate();
        panel.repaint();
    }

    private void mostrarResumenContratos(JPanel panel) {
        ocultarGraficoActual(panel);
        if (lblInfoContratos != null) lblInfoContratos.setVisible(true);
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
    private void crearPestanaPlanes() { JPanel panel = crearPanelBase("Planes"); tabbedPane.addTab("Planes", panel); }
    private void crearPestanaNomina() { JPanel panel = crearPanelBase("Nómina"); tabbedPane.addTab("Nómina", panel); }

    private JPanel crearPanelBase(String titulo) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        panel.setLayout(null);
        JLabel lbl = new JLabel("Reportes de " + titulo + " - En desarrollo");
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lbl.setBounds(100, 100, 600, 40);
        panel.add(lbl);
        return panel;
    }
}