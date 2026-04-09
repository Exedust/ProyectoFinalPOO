package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import logico.Altice;
import logico.Solicitud;
import logico.Cliente;
import logico.Empleado;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionSolicitudes extends JDialog {

    private final JPanel contentPanel = new JPanel();
    
    private static JTable table;
    private static DefaultTableModel model;
    private static Object[] row;
    private Solicitud selected = null;

    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnCancelar;
    private JButton btnVerDetalles;
    private JButton btnSalir;

    public static void main(String[] args) {
        try {
            GestionSolicitudes dialog = new GestionSolicitudes();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GestionSolicitudes() {
        setTitle("Gestionar Solicitudes");
        setResizable(false);
        setBounds(100, 100, 1280, 770);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(0, 0, 51));
        getContentPane().setLayout(new BorderLayout());

        contentPanel.setBackground(new Color(0, 0, 51));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        // ====================== PANEL PRINCIPAL DE TABLA ======================
        {
            JPanel panel = new JPanel();
            panel.setBackground(new Color(102, 102, 204));
            panel.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            panel.setBounds(12, 145, 1102, 496);
            contentPanel.add(panel);
            panel.setLayout(new BorderLayout(0, 0));

            JScrollPane scrollPane = new JScrollPane();
            panel.add(scrollPane, BorderLayout.CENTER);

            table = new JTable();
            table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setRowHeight(25);

            String[] headers = {
                "Código", "Tipo", "Cliente", "Cédula", "Empleado Asignado", 
                "Estado", "Fecha Emisión", "Fecha Atención"
            };

            model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            model.setColumnIdentifiers(headers);
            table.setModel(model);
            table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            scrollPane.setViewportView(table);

            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int ind = table.getSelectedRow();
                    if (ind != -1) {
                        String codigo = table.getValueAt(ind, 0).toString();
                        selected = Altice.getInstance().buscarSolicitudByCodigo(codigo);
                        
                        btnModificar.setEnabled(true);
                        btnCancelar.setEnabled(true);
                        btnVerDetalles.setEnabled(true);
                    }
                }
            });
        }

        // ====================== CAMPOS DE BÚSQUEDA ======================
        {
            JTextField txtCedula = new JTextField();
            txtCedula.setBackground(new Color(0, 0, 51));
            txtCedula.setForeground(Color.WHITE);
            txtCedula.setCaretColor(Color.WHITE);
            txtCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtCedula.setBounds(12, 110, 232, 24);
            contentPanel.add(txtCedula);
        }
        {
            JTextField txtNombre = new JTextField();
            txtNombre.setBackground(new Color(0, 0, 51));
            txtNombre.setForeground(Color.WHITE);
            txtNombre.setCaretColor(Color.WHITE);
            txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtNombre.setBounds(256, 110, 232, 24);
            contentPanel.add(txtNombre);
        }
        {
            JButton btnBuscar = new JButton("Buscar");
            btnBuscar.setForeground(Color.WHITE);
            btnBuscar.setBackground(new Color(0, 0, 51));
            btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnBuscar.setFocusPainted(false);
            btnBuscar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnBuscar.setBounds(500, 109, 97, 25);
            contentPanel.add(btnBuscar);
        }
        {
            JComboBox<String> comboFiltro = new JComboBox<>();
            comboFiltro.setBackground(new Color(0, 0, 51));
            comboFiltro.setForeground(Color.WHITE);
            comboFiltro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            comboFiltro.setBounds(797, 110, 208, 24);
            comboFiltro.addItem("Todos");
            comboFiltro.addItem("Pendientes");
            comboFiltro.addItem("En Proceso");
            comboFiltro.addItem("Completadas");
            comboFiltro.addItem("Canceladas");
            contentPanel.add(comboFiltro);
        }
        {
            JButton btnFiltrar = new JButton("Filtrar");
            btnFiltrar.setForeground(Color.WHITE);
            btnFiltrar.setBackground(new Color(0, 0, 51));
            btnFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnFiltrar.setFocusPainted(false);
            btnFiltrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnFiltrar.setBounds(1017, 110, 97, 25);
            btnFiltrar.addActionListener(e -> loadSolicitudes());
            contentPanel.add(btnFiltrar);
        }

        // Etiquetas
        {
            JLabel lblCedula = new JLabel("Cédula");
            lblCedula.setForeground(Color.WHITE);
            lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblCedula.setBounds(12, 88, 56, 16);
            contentPanel.add(lblCedula);
        }
        {
            JLabel lblNombre = new JLabel("Nombre");
            lblNombre.setForeground(Color.WHITE);
            lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblNombre.setBounds(256, 88, 56, 16);
            contentPanel.add(lblNombre);
        }
        {
            JLabel lblSolicitudesRegistradas = new JLabel("Solicitudes Registradas: 00");
            lblSolicitudesRegistradas.setForeground(Color.WHITE);
            lblSolicitudesRegistradas.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblSolicitudesRegistradas.setBounds(12, 23, 216, 16);
            contentPanel.add(lblSolicitudesRegistradas);
        }
        {
            JLabel lblPendientes = new JLabel("Solicitudes Pendientes: 00");
            lblPendientes.setForeground(Color.WHITE);
            lblPendientes.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblPendientes.setBounds(12, 59, 216, 16);
            contentPanel.add(lblPendientes);
        }
        {
            JLabel lblEnProceso = new JLabel("Solicitudes En Proceso: 00");
            lblEnProceso.setForeground(Color.WHITE);
            lblEnProceso.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblEnProceso.setBounds(240, 59, 216, 16);
            contentPanel.add(lblEnProceso);
        }
        {
            JLabel lblCompletadas = new JLabel("Solicitudes Completadas: 00");
            lblCompletadas.setForeground(Color.WHITE);
            lblCompletadas.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblCompletadas.setBounds(468, 59, 216, 16);
            contentPanel.add(lblCompletadas);
        }
        {
            JLabel lblCanceladas = new JLabel("Solicitudes Canceladas: 00");
            lblCanceladas.setForeground(Color.WHITE);
            lblCanceladas.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblCanceladas.setBounds(696, 59, 216, 16);
            contentPanel.add(lblCanceladas);
        }

        // ====================== BOTONES LATERALES ======================
        {
            btnAgregar = new JButton("Agregar");
            btnAgregar.setForeground(Color.WHITE);
            btnAgregar.setBackground(new Color(0, 0, 51));
            btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnAgregar.setFocusPainted(false);
            btnAgregar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnAgregar.setBounds(1143, 145, 97, 25);
            btnAgregar.addActionListener(e -> {
                RegistrarSolicitud reg = new RegistrarSolicitud(null, false);
                reg.setModal(true);
                reg.setVisible(true);
                loadSolicitudes();
            });
            contentPanel.add(btnAgregar);
        }
        {
            btnModificar = new JButton("Modificar");
            btnModificar.setForeground(Color.WHITE);
            btnModificar.setBackground(new Color(0, 0, 51));
            btnModificar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnModificar.setFocusPainted(false);
            btnModificar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnModificar.setBounds(1143, 183, 97, 25);
            btnModificar.setEnabled(false);
            btnModificar.addActionListener(e -> {
                if (selected != null) {
                    RegistrarSolicitud reg = new RegistrarSolicitud(selected, false);
                    reg.setModal(true);
                    reg.setVisible(true);
                    loadSolicitudes();
                    btnModificar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnVerDetalles.setEnabled(false);
                }
            });
            contentPanel.add(btnModificar);
        }
        {
            btnCancelar = new JButton("Cancelar");
            btnCancelar.setForeground(Color.WHITE);
            btnCancelar.setBackground(new Color(102, 0, 0));
            btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnCancelar.setFocusPainted(false);
            btnCancelar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnCancelar.setBounds(1143, 221, 97, 25);
            btnCancelar.setEnabled(false);
            btnCancelar.addActionListener(e -> cancelarSolicitud());
            contentPanel.add(btnCancelar);
        }
        {
            btnVerDetalles = new JButton("Ver Detalles");
            btnVerDetalles.setForeground(Color.WHITE);
            btnVerDetalles.setBackground(new Color(0, 0, 51));
            btnVerDetalles.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnVerDetalles.setFocusPainted(false);
            btnVerDetalles.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnVerDetalles.setBounds(1143, 259, 97, 25);
            btnVerDetalles.setEnabled(false);
            btnVerDetalles.addActionListener(e -> {
                if (selected != null) {
                    // Aquí abrirías DetallesSolicitud cuando la tengas
                    JOptionPane.showMessageDialog(this, "Detalles de solicitud (pendiente de implementar)", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            contentPanel.add(btnVerDetalles);
        }

        // Botón Salir
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            btnSalir = new JButton("Salir");
            btnSalir.setForeground(Color.WHITE);
            btnSalir.setBackground(new Color(102, 0, 0));
            btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnSalir.setFocusPainted(false);
            btnSalir.addActionListener(e -> dispose());
            buttonPane.add(btnSalir);
        }

        loadSolicitudes();
    }

    private void loadSolicitudes() {
        model.setRowCount(0);
        row = new Object[8];

        for (Solicitud s : Altice.getInstance().getMisSolicitudes()) {
            Cliente cli = s.getCliente();
            Empleado emp = s.getEmpleado();

            row[0] = s.getCodigo();
            row[1] = s.getTipo().name();
            row[2] = (cli != null) ? cli.getNombre() : "N/A";
            row[3] = (cli != null) ? cli.getCedula() : "N/A";
            row[4] = (emp != null) ? emp.getNombre() : "No asignado";
            row[5] = s.getEstado().name();
            row[6] = s.getFechaRegistro() != null ? s.getFechaRegistro().toString() : "";
            row[7] = s.getFechaAtencion() != null ? s.getFechaAtencion().toString() : "";

            model.addRow(row);
        }
    }

    private void cancelarSolicitud() {
        if (selected == null) return;

        if (selected.isResuelto() || selected.isCancelada()) {
            JOptionPane.showMessageDialog(this, "No se puede cancelar una solicitud ya completada o cancelada.", 
                    "Acción no permitida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea cancelar esta solicitud?",
                "Confirmar Cancelación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            if (Altice.getInstance().cancelarSolicitud(selected.getCodigo())) {
                JOptionPane.showMessageDialog(this, "Solicitud cancelada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                loadSolicitudes();
                btnModificar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnVerDetalles.setEnabled(false);
                selected = null;
            }
        }
    }
}