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
import logico.Contrato;
import logico.Pago;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class GestionContratos extends JDialog {

    private final JPanel contentPanel = new JPanel();
 
    private JTable table;
    private DefaultTableModel model;
    private Object[] row;
    private Contrato selected = null;

    private JButton btnAgregar;
    private JButton btnCerrarContrato;
    private JButton btnDetalles;
    private JButton btnSalir;

    private JComboBox<String> comboFiltrar;
    private JTextField txtCedulaCliente;
    private JTextField txtCodigoContrato;
    private JLabel lblCodigoContrato;
    private JLabel lblContratosRegistrados;
    private JLabel lblContratosActivos;
    private JLabel lblContratosPendientes;
    private JButton btnBuscar;
    private JButton btnCedula;

    public GestionContratos() {
        setTitle("Gestionar Contratos");
        setResizable(false);
        setBounds(100, 100, 1280, 765);
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
            panel.setBounds(12, 124, 1102, 542);
            contentPanel.add(panel);
            panel.setLayout(new BorderLayout(0, 0));

            JScrollPane scrollPane = new JScrollPane();
            panel.add(scrollPane, BorderLayout.CENTER);

            table = new JTable();
            table.setRowHeight(25);
            table.setFillsViewportHeight(true);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setFont(new Font("Segoe UI", Font.PLAIN, 13));

            model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            String[] headers = {"Código", "Cliente", "Cédula", "Plan", "Fecha Inicio", "Fecha Cierre", "Estado", "Deuda"};
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
                        selected = Altice.getInstance().buscarContratoByCodigo(codigo);

                        btnCerrarContrato.setEnabled(selected != null && selected.isActivo());
                        btnDetalles.setEnabled(true);
                    }
                }
            });
        }

        {
            txtCodigoContrato = new JTextField();
            txtCodigoContrato.setBackground(new Color(0, 0, 51));
            txtCodigoContrato.setForeground(Color.WHITE);
            txtCodigoContrato.setCaretColor(Color.WHITE);
            txtCodigoContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtCodigoContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtCodigoContrato.setBounds(12, 86, 232, 24);
            contentPanel.add(txtCodigoContrato);
        }
        {
            btnBuscar = new JButton("Buscar");
            btnBuscar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		loadContratos();
            	}
            });
            btnBuscar.setForeground(Color.WHITE);
            btnBuscar.setBackground(new Color(0, 0, 51));
            btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnBuscar.setFocusPainted(false);
            btnBuscar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnBuscar.setBounds(256, 86, 97, 25);
            contentPanel.add(btnBuscar);
        }

        // ====================== FILTRO ======================
        {
            comboFiltrar = new JComboBox<>();
            comboFiltrar.setBackground(new Color(0, 0, 51));
            comboFiltrar.setForeground(Color.WHITE);
            comboFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            comboFiltrar.setBounds(797, 83, 208, 24);
            comboFiltrar.addItem("Activos");
            comboFiltrar.addItem("Cerrados");
            comboFiltrar.addItem("Todos");
            contentPanel.add(comboFiltrar);
        }
        {
            JButton btnFiltrar = new JButton("Filtrar");
            btnFiltrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    loadContratos();
                }
            });
            btnFiltrar.setForeground(Color.WHITE);
            btnFiltrar.setBackground(new Color(0, 0, 51));
            btnFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnFiltrar.setFocusPainted(false);
            btnFiltrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnFiltrar.setBounds(1017, 83, 97, 25);
            contentPanel.add(btnFiltrar);
        }

        // ====================== CONTADORES ======================
        {
            lblContratosRegistrados = new JLabel("Contratos registrados: 00");
            lblContratosRegistrados.setForeground(Color.WHITE);
            lblContratosRegistrados.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblContratosRegistrados.setBounds(12, 26, 216, 16);
            contentPanel.add(lblContratosRegistrados);
        }
        {
            lblContratosActivos = new JLabel("Contratos activos: 00");
            lblContratosActivos.setForeground(Color.WHITE);
            lblContratosActivos.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblContratosActivos.setBounds(240, 26, 216, 16);
            contentPanel.add(lblContratosActivos);
        }

        // ====================== BOTONES LATERALES ======================
        {
            btnAgregar = new JButton("Agregar");
            btnAgregar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    RegistrarContrato reg = new RegistrarContrato();
                    reg.setModal(true);
                    reg.setVisible(true);
                    loadContratos();
                }
            });
            btnAgregar.setForeground(Color.WHITE);
            btnAgregar.setBackground(new Color(0, 0, 51));
            btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnAgregar.setFocusPainted(false);
            btnAgregar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnAgregar.setBounds(1142, 110, 97, 25);
            contentPanel.add(btnAgregar);
        }

        {
            btnCerrarContrato = new JButton("Cerrar Contrato");
            btnCerrarContrato.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (selected != null) {
                        cerrarContrato();
                    }
                }
            });
            btnCerrarContrato.setForeground(Color.WHITE);
            btnCerrarContrato.setBackground(new Color(102, 0, 0));
            btnCerrarContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnCerrarContrato.setFocusPainted(false);
            btnCerrarContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnCerrarContrato.setBounds(1142, 148, 97, 25);
            btnCerrarContrato.setEnabled(false);
            contentPanel.add(btnCerrarContrato);
        }

        {
            btnDetalles = new JButton("Detalles");
            btnDetalles.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (selected != null) {
                        DetallesContrato nuevo = new DetallesContrato(selected);
                        nuevo.setModal(true);
                        nuevo.setVisible(true);
                        loadContratos();
                    }
                }
            });
            btnDetalles.setForeground(Color.WHITE);
            btnDetalles.setBackground(new Color(0, 0, 51));
            btnDetalles.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnDetalles.setFocusPainted(false);
            btnDetalles.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnDetalles.setBounds(1142, 201, 97, 25);
            btnDetalles.setEnabled(false);
            contentPanel.add(btnDetalles);
        }
        {
        	txtCedulaCliente = new JTextField();
        	txtCedulaCliente.setForeground(Color.WHITE);
        	txtCedulaCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        	txtCedulaCliente.setCaretColor(Color.WHITE);
        	txtCedulaCliente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        	txtCedulaCliente.setBackground(new Color(0, 0, 51));
        	txtCedulaCliente.setBounds(365, 83, 232, 24);
        	contentPanel.add(txtCedulaCliente);
        }
        {
        	btnCedula = new JButton("Buscar");
        	btnCedula.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			loadContratos();
        		}
        	});
        	btnCedula.setForeground(Color.WHITE);
        	btnCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        	btnCedula.setFocusPainted(false);
        	btnCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        	btnCedula.setBackground(new Color(0, 0, 51));
        	btnCedula.setBounds(609, 83, 97, 25);
        	contentPanel.add(btnCedula);
        }
        {
        	lblCodigoContrato = new JLabel("C\u00F3digo del Contrato");
        	lblCodigoContrato.setForeground(Color.WHITE);
        	lblCodigoContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        	lblCodigoContrato.setBounds(12, 57, 216, 16);
        	contentPanel.add(lblCodigoContrato);
        }
        {
        	JLabel lblCdulaDelCliente = new JLabel("C\u00E9dula del Cliente");
        	lblCdulaDelCliente.setForeground(Color.WHITE);
        	lblCdulaDelCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        	lblCdulaDelCliente.setBounds(365, 57, 216, 16);
        	contentPanel.add(lblCdulaDelCliente);
        }
        {
        	lblContratosPendientes = new JLabel("Contratos pendientes: 00");
        	lblContratosPendientes.setForeground(Color.WHITE);
        	lblContratosPendientes.setFont(new Font("Segoe UI", Font.BOLD, 13));
        	lblContratosPendientes.setBounds(460, 26, 216, 16);
        	contentPanel.add(lblContratosPendientes);
        }

        // ====================== BOTONES INFERIORES ======================
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            btnSalir = new JButton("Salir");
            btnSalir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            btnSalir.setForeground(Color.WHITE);
            btnSalir.setBackground(new Color(102, 0, 0));
            btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnSalir.setFocusPainted(false);
            buttonPane.add(btnSalir);
        }

        loadContratos();
    }

    public void loadContratos() {
        if (model == null) return;
        model.setRowCount(0);
        row = new Object[table.getColumnCount()];

        String filtro = comboFiltrar.getSelectedItem() != null ? 
                        comboFiltrar.getSelectedItem().toString() : "Todos";

        String textoCodigo = txtCodigoContrato.getText().trim();
        String textoCedula = txtCedulaCliente.getText().trim();

        for (Contrato c : Altice.getInstance().getMisContratos()) {
            boolean incluir = false;

            switch (filtro) {
                case "Todos":
                    incluir = true;
                    break;
                case "Activos":
                    incluir = c.isActivo();
                    break;
                case "Cerrados":
                    incluir = !c.isActivo();
                    break;
            }

            if (!incluir) continue;

            if (!textoCodigo.isEmpty()) {
                if (c.getCodigo() == null || 
                    !c.getCodigo().toLowerCase().contains(textoCodigo.toLowerCase())) {
                    continue;
                }
            }

            if (!textoCedula.isEmpty()) {
                if (c.getCliente() == null || c.getCliente().getCedula() == null ||
                    !c.getCliente().getCedula().toLowerCase().contains(textoCedula.toLowerCase())) {
                    continue;
                }
            }

            float deuda = Altice.getInstance().calcularDeudaContrato(c);
            String estado = (deuda > 0) ? "Pendiente" : "Al Día";

            row[0] = c.getCodigo();
            row[1] = c.getCliente() != null ? c.getCliente().getNombre() : "N/A";
            row[2] = c.getCliente() != null ? c.getCliente().getCedula() : "N/A";
            row[3] = c.getPlan() != null ? c.getPlan().getNombre() : "N/A";
            row[4] = c.getFechaInicio() != null ? c.getFechaInicio().toString() : "";
            row[5] = c.getFechaCierre() != null ? c.getFechaCierre().toString() : "";
            row[6] = estado;
            row[7] = String.format("RD$ %.2f", deuda);

            model.addRow(row);
        }

        actualizarContadores();
    }

    private void actualizarContadores() {
        int registrados = 0;
        int activos = 0;
        int pendientes = 0;

        for (Contrato c : Altice.getInstance().getMisContratos()) {
            registrados++;

            if (c.isActivo()) {
                activos++;
            }

            float deuda = Altice.getInstance().calcularDeudaContrato(c);
            if (deuda > 0) {
                pendientes++;
            }
        }

        lblContratosRegistrados.setText("Contratos registrados: " + String.format("%02d", registrados));
        lblContratosActivos.setText("Contratos activos: " + String.format("%02d", activos));
        lblContratosPendientes.setText("Contratos pendientes: " + String.format("%02d", pendientes));
    }


    private void cerrarContrato() {
        if (selected == null) return;

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea cerrar este contrato?",
                "Confirmar Cierre",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (opcion != JOptionPane.YES_OPTION) return;

        if (Altice.getInstance().cerrarContrato(selected.getCodigo())) {
            JOptionPane.showMessageDialog(this, "Contrato cerrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            loadContratos();
            btnCerrarContrato.setEnabled(false);
            btnDetalles.setEnabled(false);
            selected = null;
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo cerrar el contrato", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}