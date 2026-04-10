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
    private JButton btnPagar;
    private JButton btnDetalles;
    private JButton btnSalir;
    private JScrollPane scrollPane;
    private static JTable table;
   
    private static DefaultTableModel model;
    private static Object[] row;

    public static void main(String[] args) {
        try {
            GestionClientes dialog = new GestionClientes();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

        // ====================== PANEL PRINCIPAL DE TABLA ======================
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
                        btnDesactivar.setEnabled(true);
                        btnDetalles.setEnabled(true);
                        btnPagar.setEnabled(true);
                    }
                }
            });
        }

        // ====================== CAMPOS DE BÚSQUEDA ======================
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
            comboFiltrar.setModel(new DefaultComboBoxModel<>(new String[] {"Todos", "Personas", "Empresas", "Inactivos"}));
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

        // ====================== ETIQUETAS ======================
        {
            JLabel lblNewLabel = new JLabel("Cedula");
            lblNewLabel.setForeground(Color.WHITE);
            lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblNewLabel.setBounds(12, 88, 56, 16);
            contentPanel.add(lblNewLabel);
        }
        {
            JLabel lblNewLabel_1 = new JLabel("Nombre");
            lblNewLabel_1.setForeground(Color.WHITE);
            lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblNewLabel_1.setBounds(365, 88, 56, 16);
            contentPanel.add(lblNewLabel_1);
        }
        {
            JLabel lblNewLabel_2 = new JLabel("Clientes registrados: 00");
            lblNewLabel_2.setForeground(Color.WHITE);
            lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblNewLabel_2.setBounds(12, 23, 216, 16);
            contentPanel.add(lblNewLabel_2);
        }
        {
            JLabel lblComercialesRegistrados = new JLabel("Clientes activos: 00");
            lblComercialesRegistrados.setForeground(Color.WHITE);
            lblComercialesRegistrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblComercialesRegistrados.setBounds(12, 59, 216, 16);
            contentPanel.add(lblComercialesRegistrados);
        }
        {
            JLabel lblClientesPendientes = new JLabel("Clientes al Dia: 00");
            lblClientesPendientes.setForeground(Color.WHITE);
            lblClientesPendientes.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblClientesPendientes.setBounds(240, 59, 216, 16);
            contentPanel.add(lblClientesPendientes);
        }
        {
            JLabel label = new JLabel("Clientes Pendientes: 00");
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            label.setBounds(468, 59, 216, 16);
            contentPanel.add(label);
        }

        // ====================== BOTONES LATERALES ======================
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
                        btnPagar.setEnabled(false);
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
                    btnPagar.setEnabled(false);
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
            btnPagar = new JButton("Realizar Pago");
            btnPagar.setForeground(Color.WHITE);
            btnPagar.setBackground(new Color(0, 0, 51));
            btnPagar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnPagar.setFocusPainted(false);
            btnPagar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnPagar.setBounds(1143, 302, 97, 25);
            contentPanel.add(btnPagar);
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
                        btnPagar.setEnabled(false);
                        btnDetalles.setEnabled(false);
                    }
                }
            });
            btnDetalles.setForeground(Color.WHITE);
            btnDetalles.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnDetalles.setFocusPainted(false);
            btnDetalles.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnDetalles.setBackground(new Color(0, 0, 51));
            btnDetalles.setBounds(1143, 340, 97, 25);
            contentPanel.add(btnDetalles);
        }

        {
            btnCedula = new JButton("Buscar");
            btnCedula.setForeground(Color.WHITE);
            btnCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnCedula.setFocusPainted(false);
            btnCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnCedula.setBackground(new Color(0, 0, 51));
            btnCedula.setBounds(256, 110, 97, 25);
            contentPanel.add(btnCedula);
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

        loadClientes();

        if (selected == null) {
            btnModificar.setEnabled(false);
            btnDesactivar.setEnabled(false);
            btnPagar.setEnabled(false);
            btnDetalles.setEnabled(false);
        }
    }

    // ====================== MÉTODO loadClientes ACTUALIZADO ======================
    public static void loadClientes() {
        model.setRowCount(0);
        row = new Object[table.getColumnCount()];   // Reinicializamos cada vez

        String filtro = comboFiltrar.getSelectedItem().toString();

        for (Cliente cli : Altice.getInstance().getMisClientes()) {
            boolean incluir = false;

            switch (filtro) {
                case "Todos":
                    incluir = cli.getUsuario() != null && cli.getUsuario().isActivo();
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
            }

            if (incluir) {
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
        }
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
}