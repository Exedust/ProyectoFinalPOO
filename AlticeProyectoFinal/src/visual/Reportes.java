package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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

import logico.Altice;

public class Reportes extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTabbedPane tabbedPane;

    // Variables para controlar visibilidad en la pestaña Clientes
    private ChartPanel chartPanelActual = null;
    private JLabel lblInfoClientes;

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

        // ====================== TABBED PANE ======================
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabbedPane.setBackground(new Color(0, 0, 51));
        tabbedPane.setForeground(Color.WHITE);
        contentPanel.add(tabbedPane, BorderLayout.CENTER);

        crearPestanaClientes();
        crearPestanaContratos();
        crearPestanaPagos();
        crearPestanaSolicitudes();
        crearPestanaPlanes();
        crearPestanaNomina();

        // ====================== BOTÓN SALIR ======================
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

        // Panel de botones a la izquierda
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(0, 0, 51));
        panelBotones.setBounds(30, 30, 280, 400);
        panelBotones.setLayout(new GridLayout(0, 1, 0, 10));

        JButton btnEstadoPago = new JButton("Estado de Pago");
        btnEstadoPago.addActionListener(e -> mostrarGraficoEstadoPago(panel));
        agregarBotonEstilo(btnEstadoPago);
        panelBotones.add(btnEstadoPago);

        JButton btnDistribucionDeuda = new JButton("Distribución por Deuda");
        agregarBotonEstilo(btnDistribucionDeuda);
        panelBotones.add(btnDistribucionDeuda);

        JButton btnMesRegistro = new JButton("Mes de Registro");
        agregarBotonEstilo(btnMesRegistro);
        panelBotones.add(btnMesRegistro);

        // Botón Resumen
        JButton btnResumen = new JButton("Resumen");
        btnResumen.addActionListener(e -> mostrarResumen(panel));
        agregarBotonEstilo(btnResumen);
        panelBotones.add(btnResumen);

        panel.add(panelBotones);

        // Información por defecto (resumen)
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

    private void mostrarGraficoEstadoPago(JPanel panel) {
        if (chartPanelActual != null) {
            panel.remove(chartPanelActual);
            chartPanelActual = null;
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int alDia = Altice.getInstance().contarClientesAlDia();
        int pendientes = Altice.getInstance().contarClientesPendientes();

        dataset.setValue(alDia, "Estado", "Al Día");
        dataset.setValue(pendientes, "Estado", "Pendientes");

        JFreeChart chart = ChartFactory.createBarChart(
                "Estado de Pago de Clientes",
                "Estado",
                "Cantidad de Clientes",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        chartPanelActual = new ChartPanel(chart);
        chartPanelActual.setBounds(350, 30, 750, 500);

        panel.add(chartPanelActual);
        lblInfoClientes.setVisible(false);   // Ocultar resumen
        panel.revalidate();
        panel.repaint();
    }

    private void mostrarResumen(JPanel panel) {
        if (chartPanelActual != null) {
            panel.remove(chartPanelActual);
            chartPanelActual = null;
        }
        lblInfoClientes.setVisible(true);   // Mostrar resumen
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
    private void crearPestanaContratos() {
        JPanel panel = crearPanelBase("Contratos");
        tabbedPane.addTab("Contratos", panel);
    }

    private void crearPestanaPagos() {
        JPanel panel = crearPanelBase("Pagos");
        tabbedPane.addTab("Pagos", panel);
    }

    private void crearPestanaSolicitudes() {
        JPanel panel = crearPanelBase("Solicitudes");
        tabbedPane.addTab("Solicitudes", panel);
    }

    private void crearPestanaPlanes() {
        JPanel panel = crearPanelBase("Planes");
        tabbedPane.addTab("Planes", panel);
    }

    private void crearPestanaNomina() {
        JPanel panel = crearPanelBase("Nómina");
        tabbedPane.addTab("Nómina", panel);
    }

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