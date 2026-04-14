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
import logico.Cliente;
import logico.Pago;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;

public class GestionClientes extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Cliente selected = null;
   
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JButton btnCedula;
    private JButton btnNombre;
    private static JComboBox<String> comboFiltrar;
    private JButton btnFiltrar;
    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnDesactivar;
    private JButton btnDetalles;
    private JButton btnSalir;
    private JScrollPane scrollPane;
    private static JTable table;
   
    private static DefaultTableModel model;
    private static Object[] row;
    private JLabel lblCedula;
    private JLabel lblNombre;
    private JLabel lblClientesPendientes;
    private JLabel lblClientesAldia;
    private JLabel lblClientesActivos;
    private JLabel lblClientesRegistrados;

    public GestionClientes() {
        setTitle("Gestionar Clientes");
        setResizable(false);
        setBounds(100, 100, 1280, 770);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(0, 0, 51));
        getContentPane().setLayout(new BorderLayout());
       
        contentPanel.setBackground(new Color(0, 0, 51));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        {
            JPanel panel = new JPanel();
            panel.setBackground(new Color(102, 102, 204));
            panel.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            panel.setBounds(12, 145, 1102, 496);
            contentPanel.add(panel);
            panel.setLayout(new BorderLayout(0, 0));

            scrollPane = new JScrollPane();
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

            String[] headers = {
                "Código", "Cédula", "Nombre", "Teléfono",
                "Correo", "Tipo", "Estado", "Deuda"
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
                        selected = Altice.getInstance().buscarClienteById(codigo);

                        btnModificar.setEnabled(true);
                        btnDesactivar.setEnabled(selected.isActivo());
                        btnDetalles.setEnabled(true);
                    }
                }
            });
        }

        {
            txtCedula = new JTextField();
            txtCedula.setBackground(new Color(0, 0, 51));
            txtCedula.setForeground(Color.WHITE);
            txtCedula.setCaretColor(Color.WHITE);
            txtCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtCedula.setBounds(12, 110, 232, 24);
            contentPanel.add(txtCedula);
        }
        {
            txtNombre = new JTextField();
            txtNombre.setBackground(new Color(0, 0, 51));
            txtNombre.setForeground(Color.WHITE);
            txtNombre.setCaretColor(Color.WHITE);
            txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtNombre.setBounds(365, 110, 232, 24);
            contentPanel.add(txtNombre);
        }
        {
            btnNombre = new JButton("Buscar");
            btnNombre.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		loadClientes();
            	}
            });
            btnNombre.setForeground(Color.WHITE);
            btnNombre.setBackground(new Color(0, 0, 51));
            btnNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnNombre.setFocusPainted(false);
            btnNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnNombre.setBounds(609, 109, 97, 25);
            contentPanel.add(btnNombre);
        }
        {
            comboFiltrar = new JComboBox<>();
            comboFiltrar.setModel(new DefaultComboBoxModel<>(new String[] {"Activos", "Personas", "Empresas", "Inactivos", "Todos"}));
            comboFiltrar.setBackground(new Color(0, 0, 51));
            comboFiltrar.setForeground(Color.WHITE);
            comboFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            comboFiltrar.setBounds(797, 110, 208, 24);
            contentPanel.add(comboFiltrar);
        }
        {
            btnFiltrar = new JButton("Filtrar");
            btnFiltrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    loadClientes();
                }
            });
            btnFiltrar.setForeground(Color.WHITE);
            btnFiltrar.setBackground(new Color(0, 0, 51));
            btnFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnFiltrar.setFocusPainted(false);
            btnFiltrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnFiltrar.setBounds(1017, 110, 97, 25);
            contentPanel.add(btnFiltrar);
        }

        {
            lblCedula = new JLabel("Cedula/RNC");
            lblCedula.setForeground(Color.WHITE);
            lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblCedula.setBounds(12, 88, 97, 16);
            contentPanel.add(lblCedula);
        }
        {
            lblNombre = new JLabel("Nombre");
            lblNombre.setForeground(Color.WHITE);
            lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblNombre.setBounds(365, 88, 56, 16);
            contentPanel.add(lblNombre);
        }
        {
            lblClientesRegistrados = new JLabel("Clientes registrados: 00");
            lblClientesRegistrados.setForeground(Color.WHITE);
            lblClientesRegistrados.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblClientesRegistrados.setBounds(12, 23, 216, 16);
            contentPanel.add(lblClientesRegistrados);
        }
        {
            lblClientesActivos = new JLabel("Clientes activos: 00");
            lblClientesActivos.setForeground(Color.WHITE);
            lblClientesActivos.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblClientesActivos.setBounds(12, 59, 216, 16);
            contentPanel.add(lblClientesActivos);
        }
        {
            lblClientesAldia = new JLabel("Clientes al Dia: 00");
            lblClientesAldia.setForeground(Color.WHITE);
            lblClientesAldia.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblClientesAldia.setBounds(240, 59, 216, 16);
            contentPanel.add(lblClientesAldia);
        }
        {
            lblClientesPendientes = new JLabel("Clientes Pendientes: 00");
            lblClientesPendientes.setForeground(Color.WHITE);
            lblClientesPendientes.setFont(new Font("Segoe UI", Font.BOLD, 13));
            lblClientesPendientes.setBounds(468, 59, 216, 16);
            contentPanel.add(lblClientesPendientes);
        }

        {
            btnAgregar = new JButton("Agregar");
            btnAgregar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    RegistrarCliente registrar = new RegistrarCliente(null, false);
                    registrar.setModal(true);
                    registrar.setVisible(true);
                    loadClientes();
                }
            });
            btnAgregar.setForeground(Color.WHITE);
            btnAgregar.setBackground(new Color(0, 0, 51));
            btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnAgregar.setFocusPainted(false);
            btnAgregar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnAgregar.setBounds(1143, 145, 97, 25);
            contentPanel.add(btnAgregar);
        }

        {
            btnModificar = new JButton("Modificar");
            btnModificar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (selected != null) {
                        RegistrarCliente modificar = new RegistrarCliente(selected, true);
                        modificar.setModal(true);
                        modificar.setVisible(true);
                        loadClientes();
                        btnModificar.setEnabled(false);
                        btnDesactivar.setEnabled(false);
                        btnDetalles.setEnabled(false);
                    }
                }
            });
            btnModificar.setForeground(Color.WHITE);
            btnModificar.setBackground(new Color(0, 0, 51));
            btnModificar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnModificar.setFocusPainted(false);
            btnModificar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnModificar.setBounds(1143, 183, 97, 25);
            contentPanel.add(btnModificar);
        }

        {
            btnDesactivar = new JButton("Desactivar");
            btnDesactivar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    desactivar();
                    btnModificar.setEnabled(false);
                    btnDesactivar.setEnabled(false);
                    btnDetalles.setEnabled(false);
                    loadClientes();
                }
            });
            btnDesactivar.setForeground(Color.WHITE);
            btnDesactivar.setBackground(new Color(102, 0, 0));
            btnDesactivar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnDesactivar.setFocusPainted(false);
            btnDesactivar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnDesactivar.setBounds(1143, 221, 97, 25);
            contentPanel.add(btnDesactivar);
        }

        {
            btnDetalles = new JButton("Detalles");
            btnDetalles.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (selected != null) {
                        DetallesCliente detalles = new DetallesCliente(selected);
                        detalles.setModal(true);
                        detalles.setVisible(true);
                        btnModificar.setEnabled(false);
                        btnDesactivar.setEnabled(false);
                        btnDetalles.setEnabled(false);
                    }
                }
            });
            btnDetalles.setForeground(Color.WHITE);
            btnDetalles.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnDetalles.setFocusPainted(false);
            btnDetalles.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnDetalles.setBackground(new Color(0, 0, 51));
            btnDetalles.setBounds(1143, 274, 97, 25);
            contentPanel.add(btnDetalles);
        }

        {
            btnCedula = new JButton("Buscar");
            btnCedula.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		loadClientes();
            	}
            });
            btnCedula.setForeground(Color.WHITE);
            btnCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnCedula.setFocusPainted(false);
            btnCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnCedula.setBackground(new Color(0, 0, 51));
            btnCedula.setBounds(256, 110, 97, 25);
            contentPanel.add(btnCedula);
        }
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

        loadClientes();

        if (selected == null) {
            btnModificar.setEnabled(false);
            btnDesactivar.setEnabled(false);
            btnDetalles.setEnabled(false);
        }
    }

    public void loadClientes() {
        model.setRowCount(0);
        row = new Object[table.getColumnCount()];

        String filtroGeneral = comboFiltrar.getSelectedItem().toString();
        String textoCedula = txtCedula.getText().trim();
        String textoNombre = txtNombre.getText().trim();

        for (Cliente cli : Altice.getInstance().getMisClientes()) {
            boolean incluir = false;

            switch (filtroGeneral) {
                case "Todos":
                    incluir = cli.getUsuario() != null;
                    break;
                case "Personas":
                    incluir = cli.getUsuario() != null && 
                              !cli.getUsuario().isEmpresa() && 
                              cli.getUsuario().isActivo();
                    break;
                case "Empresas":
                    incluir = cli.getUsuario() != null && 
                              cli.getUsuario().isEmpresa() && 
                              cli.getUsuario().isActivo();
                    break;
                case "Inactivos":
                    incluir = cli.getUsuario() != null && !cli.getUsuario().isActivo();
                    break;
                case "Activos":
                	incluir = cli.getUsuario().isActivo();
                	break;
            }

            if (!incluir) continue;

            if (!textoCedula.isEmpty()) {
                if (cli.getCedula() == null || 
                    !cli.getCedula().toLowerCase().contains(textoCedula.toLowerCase())) {
                    continue;
                }
            }

            if (!textoNombre.isEmpty()) {
                if (cli.getNombre() == null || 
                    !cli.getNombre().toLowerCase().contains(textoNombre.toLowerCase())) {
                    continue;
                }
            }


            float deuda = calcularDeudaCliente(cli);

            row[0] = cli.getCodigo();
            row[1] = cli.getCedula();
            row[2] = cli.getNombre();
            row[3] = cli.getTelefono();
            row[4] = cli.getEmail();
            row[5] = (cli.getUsuario() != null && cli.getUsuario().isEmpresa()) ? "EMPRESA" : "PERSONA";
            row[6] = (cli.getUsuario() != null && cli.getUsuario().isActivo()) ? "Activo" : "Inactivo";
            row[7] = String.format("RD$ %.2f", deuda);

            model.addRow(row);
        }
        actualizarContadores();
    }

    private static float calcularDeudaCliente(Cliente cli) {
        if (cli == null || cli.getPagos() == null) {
            return 0.0f;
        }

        float totalDeuda = 0.0f;

        for (Pago p : cli.getPagos()) {
            if (p.isPendiente()) {
                totalDeuda += p.getMonto();
            }
        }
        return totalDeuda;
    }

    private void desactivar() {
        if (selected != null) {
            int opcion = JOptionPane.showConfirmDialog(this,
                    "¿Desea desactivar este cliente?",
                    "Desactivar Cliente",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (opcion != JOptionPane.YES_OPTION) return;

            Altice.getInstance().desactivarCliente(selected.getCodigo());
            JOptionPane.showMessageDialog(this, "Cliente desactivado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            loadClientes();
        }
    }
    private void actualizarContadores() {
        int registrados = 0;
        int activos = 0;
        int alDia = 0;
        int pendientes = 0;

        for (Cliente cli : Altice.getInstance().getMisClientes()) {
            if (cli.getUsuario() == null) continue;

            registrados++;

            if (cli.getUsuario().isActivo()) {
                activos++;

                float deuda = calcularDeudaCliente(cli);
                if (deuda <= 0) {
                    alDia++;
                } else {
                    pendientes++;
                }
            }
        }

        lblClientesRegistrados.setText("Clientes registrados: " + String.format("%02d", registrados));
        lblClientesActivos.setText("Clientes activos: " + String.format("%02d", activos));
        lblClientesAldia.setText("Clientes al Dia: " + String.format("%02d", alDia));
        lblClientesPendientes.setText("Clientes Pendientes: " + String.format("%02d", pendientes));
    }
}