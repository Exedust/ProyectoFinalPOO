package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import logico.Altice;
import logico.Cliente;
import logico.Contrato;
import logico.Pago;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class DetallesCliente extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Cliente miCliente;

    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtCorreo;
    private JPasswordField txtContra;
    private JTextField txtContraVisible;
    private JLabel lblCedula;
    private JButton btnMostrar;
    private JButton btnRealizarPago;
    private JButton btnCerrarContrato;
    private JTextField txtFechaRegistro;
    private JTextField txtFechaDesactivacion;
    private JLabel lblFechaDesactivacion;
    private JButton cancelButton;
    private JLabel lblFechaRegistro;
    private JLabel lblTelefono;
    private JLabel lblContra;
    private JLabel lblDireccion;
    private JLabel lblCorreo;
    private JLabel lblNombre;
    private JLabel lblCodigo;

    private JPanel panelHistorial;
    private JTable table;
    private JRadioButton radioContratos;
    private JRadioButton radioPagos;
    private JButton btnCancelarPago;
    private JButton btnVerContrato;

    private DefaultTableModel model;
    private Object[] row;
    private JLabel lblEstado;

    public static void main(String[] args) {
        try {
            DetallesCliente dialog = new DetallesCliente(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DetallesCliente(Cliente cliente) {
        miCliente = cliente;

        setResizable(false);
        setTitle("Detalles del Cliente");
        setBounds(100, 100, 625, 781);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(0, 0, 51));
        getContentPane().setLayout(new BorderLayout());

        contentPanel.setBackground(new Color(0, 0, 51));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        {
            JPanel panel = new JPanel();
            panel.setBackground(new Color(0, 0, 51));
            panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            contentPanel.add(panel, BorderLayout.CENTER);
            panel.setLayout(null);

            // ====================== PANEL DATOS DEL CLIENTE ======================
            {
                JPanel panel_1 = new JPanel();
                panel_1.setLayout(null);
                panel_1.setBackground(new Color(102, 102, 204));
                panel_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                panel_1.setBounds(12, 13, 567, 336);
                panel.add(panel_1);

                {
                    lblCodigo = new JLabel("Codigo");
                    lblCodigo.setForeground(Color.WHITE);
                    lblCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblCodigo.setBounds(12, 13, 56, 16);
                    panel_1.add(lblCodigo);
                }
                {
                    txtCodigo = new JTextField();
                    txtCodigo.setEditable(false);
                    txtCodigo.setBackground(new Color(0, 0, 51));
                    txtCodigo.setForeground(Color.WHITE);
                    txtCodigo.setCaretColor(Color.WHITE);
                    txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtCodigo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtCodigo.setBounds(12, 42, 113, 24);
                    panel_1.add(txtCodigo);
                }
                {
                    lblNombre = new JLabel("Nombre");
                    lblNombre.setForeground(Color.WHITE);
                    lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblNombre.setBounds(12, 79, 56, 16);
                    panel_1.add(lblNombre);
                }
                {
                    txtNombre = new JTextField();
                    txtNombre.setEditable(false);
                    txtNombre.setBackground(new Color(0, 0, 51));
                    txtNombre.setForeground(Color.WHITE);
                    txtNombre.setCaretColor(Color.WHITE);
                    txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtNombre.setBounds(12, 108, 263, 24);
                    panel_1.add(txtNombre);
                }
                {
                    lblCedula = new JLabel("Cedula");
                    lblCedula.setForeground(Color.WHITE);
                    lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblCedula.setBounds(12, 143, 56, 16);
                    panel_1.add(lblCedula);
                }
                {
                    txtCedula = new JTextField();
                    txtCedula.setEditable(false);
                    txtCedula.setBackground(new Color(0, 0, 51));
                    txtCedula.setForeground(Color.WHITE);
                    txtCedula.setCaretColor(Color.WHITE);
                    txtCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtCedula.setBounds(12, 172, 263, 24);
                    panel_1.add(txtCedula);
                }
                {
                    lblTelefono = new JLabel("Telefono");
                    lblTelefono.setForeground(Color.WHITE);
                    lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblTelefono.setBounds(12, 207, 56, 16);
                    panel_1.add(lblTelefono);
                }
                {
                    txtTelefono = new JTextField();
                    txtTelefono.setEditable(false);
                    txtTelefono.setBackground(new Color(0, 0, 51));
                    txtTelefono.setForeground(Color.WHITE);
                    txtTelefono.setCaretColor(Color.WHITE);
                    txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtTelefono.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtTelefono.setBounds(12, 236, 263, 24);
                    panel_1.add(txtTelefono);
                }
                {
                    lblDireccion = new JLabel("Direccion");
                    lblDireccion.setForeground(Color.WHITE);
                    lblDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblDireccion.setBounds(287, 143, 122, 16);
                    panel_1.add(lblDireccion);
                }
                {
                    txtDireccion = new JTextField();
                    txtDireccion.setEditable(false);
                    txtDireccion.setBackground(new Color(0, 0, 51));
                    txtDireccion.setForeground(Color.WHITE);
                    txtDireccion.setCaretColor(Color.WHITE);
                    txtDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtDireccion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtDireccion.setBounds(287, 172, 263, 24);
                    panel_1.add(txtDireccion);
                }
                {
                    lblCorreo = new JLabel("Correo electronico");
                    lblCorreo.setForeground(Color.WHITE);
                    lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblCorreo.setBounds(287, 79, 122, 16);
                    panel_1.add(lblCorreo);
                }
                {
                    txtCorreo = new JTextField();
                    txtCorreo.setEditable(false);
                    txtCorreo.setBackground(new Color(0, 0, 51));
                    txtCorreo.setForeground(Color.WHITE);
                    txtCorreo.setCaretColor(Color.WHITE);
                    txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtCorreo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtCorreo.setBounds(287, 108, 263, 24);
                    panel_1.add(txtCorreo);
                }
                {
                    lblContra = new JLabel("Contraseña");
                    lblContra.setForeground(Color.WHITE);
                    lblContra.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblContra.setBounds(287, 207, 122, 16);
                    panel_1.add(lblContra);
                }
                {
                    txtContra = new JPasswordField();
                    txtContra.setEditable(false);
                    txtContra.setBackground(new Color(0, 0, 51));
                    txtContra.setForeground(Color.WHITE);
                    txtContra.setCaretColor(Color.WHITE);
                    txtContra.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtContra.setBounds(287, 236, 263, 24);
                    panel_1.add(txtContra);
                }
                {
                    txtContraVisible = new JTextField();
                    txtContraVisible.setEditable(false);
                    txtContraVisible.setBackground(new Color(0, 0, 51));
                    txtContraVisible.setForeground(Color.WHITE);
                    txtContraVisible.setCaretColor(Color.WHITE);
                    txtContraVisible.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtContraVisible.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtContraVisible.setBounds(287, 237, 263, 24);
                    txtContraVisible.setVisible(false);
                    panel_1.add(txtContraVisible);
                }
                {
                    btnMostrar = new JButton("Mostrar Contraseña");
                    btnMostrar.setForeground(Color.WHITE);
                    btnMostrar.setBackground(new Color(0, 0, 51));
                    btnMostrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    btnMostrar.setFocusPainted(false);
                    btnMostrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    btnMostrar.setBounds(405, 273, 145, 25);
                    panel_1.add(btnMostrar);
                }
                {
                    lblFechaRegistro = new JLabel("Fecha Registro");
                    lblFechaRegistro.setForeground(Color.WHITE);
                    lblFechaRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblFechaRegistro.setBounds(12, 273, 91, 16);
                    panel_1.add(lblFechaRegistro);
                }
                {
                    txtFechaRegistro = new JTextField();
                    txtFechaRegistro.setEditable(false);
                    txtFechaRegistro.setForeground(Color.WHITE);
                    txtFechaRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtFechaRegistro.setCaretColor(Color.WHITE);
                    txtFechaRegistro.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtFechaRegistro.setBackground(new Color(0, 0, 51));
                    txtFechaRegistro.setBounds(12, 303, 122, 24);
                    panel_1.add(txtFechaRegistro);
                }
                {
                    lblFechaDesactivacion = new JLabel("Fecha Desactivacion");
                    lblFechaDesactivacion.setForeground(Color.WHITE);
                    lblFechaDesactivacion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblFechaDesactivacion.setBounds(153, 274, 122, 16);
                    panel_1.add(lblFechaDesactivacion);
                }
                {
                    txtFechaDesactivacion = new JTextField();
                    txtFechaDesactivacion.setEditable(false);
                    txtFechaDesactivacion.setForeground(Color.WHITE);
                    txtFechaDesactivacion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtFechaDesactivacion.setCaretColor(Color.WHITE);
                    txtFechaDesactivacion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtFechaDesactivacion.setBackground(new Color(0, 0, 51));
                    txtFechaDesactivacion.setBounds(153, 303, 122, 24);
                    panel_1.add(txtFechaDesactivacion);
                }
            }

            // ====================== PANEL HISTORIAL ======================
            {
                panelHistorial = new JPanel();
                panelHistorial.setLayout(null);
                panelHistorial.setBackground(new Color(102, 102, 204));
                panelHistorial.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
                panelHistorial.setBounds(12, 372, 567, 216);
                panel.add(panelHistorial);

                radioContratos = new JRadioButton("Contratos");
                radioContratos.setSelected(true);
                radioContratos.setForeground(Color.WHITE);
                radioContratos.setBackground(new Color(102, 102, 204));
                radioContratos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                radioContratos.setBounds(12, 9, 94, 25);
                panelHistorial.add(radioContratos);

                radioPagos = new JRadioButton("Pagos");
                radioPagos.setForeground(Color.WHITE);
                radioPagos.setBackground(new Color(102, 102, 204));
                radioPagos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                radioPagos.setBounds(110, 9, 94, 25);
                panelHistorial.add(radioPagos);

                ButtonGroup group = new ButtonGroup();
                group.add(radioContratos);
                group.add(radioPagos);

                radioContratos.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        loadTablaHistorial();
                    }
                });

                radioPagos.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        loadTablaHistorial();
                    }
                });

                {
                    JPanel panel_3 = new JPanel();
                    panel_3.setBackground(new Color(0, 0, 51));
                    panel_3.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    panel_3.setBounds(12, 33, 543, 170);
                    panelHistorial.add(panel_3);
                    panel_3.setLayout(new BorderLayout(0, 0));

                    JScrollPane scrollPane = new JScrollPane();
                    panel_3.add(scrollPane, BorderLayout.CENTER);

                    table = new JTable();
                    table.setFillsViewportHeight(true);
                    scrollPane.setViewportView(table);

                    table.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            actualizarBotonesSegunSeleccion();
                        }
                    });
                }
            }

            // ====================== BOTONES DE ACCIÓN ======================
            {
                btnRealizarPago = new JButton("Realizar Pago");
                btnRealizarPago.setForeground(Color.WHITE);
                btnRealizarPago.setBackground(new Color(0, 0, 51));
                btnRealizarPago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                btnRealizarPago.setFocusPainted(false);
                btnRealizarPago.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                btnRealizarPago.setBounds(462, 610, 117, 25);
                panel.add(btnRealizarPago);
            }
            {
                btnCerrarContrato = new JButton("Cerrar Contrato");
                btnCerrarContrato.setForeground(Color.WHITE);
                btnCerrarContrato.setBackground(new Color(102, 0, 0));
                btnCerrarContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                btnCerrarContrato.setFocusPainted(false);
                btnCerrarContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                btnCerrarContrato.setBounds(12, 610, 123, 25);
                panel.add(btnCerrarContrato);
            }
            {
                btnVerContrato = new JButton("Ver Contrato");
                btnVerContrato.setForeground(Color.WHITE);
                btnVerContrato.setBackground(new Color(0, 0, 51));
                btnVerContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                btnVerContrato.setFocusPainted(false);
                btnVerContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                btnVerContrato.setBounds(240, 610, 117, 25);
                panel.add(btnVerContrato);
            }
            {
                btnCancelarPago = new JButton("Cancelar Pago");
                btnCancelarPago.setForeground(Color.WHITE);
                btnCancelarPago.setBackground(new Color(102, 0, 0));
                btnCancelarPago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                btnCancelarPago.setFocusPainted(false);
                btnCancelarPago.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                btnCancelarPago.setBounds(12, 610, 123, 25);
                panel.add(btnCancelarPago);
                btnCancelarPago.setVisible(false);
            }

            lblEstado = new JLabel("AL DÍA");
            lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
            lblEstado.setForeground(new Color(0, 200, 0));
            lblEstado.setFont(new Font("Segoe UI", Font.BOLD, 15));
            lblEstado.setBounds(220, 648, 150, 20);
            panel.add(lblEstado);
        }

        // ====================== BOTONES INFERIORES ======================
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            cancelButton = new JButton("Salir");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            cancelButton.setForeground(Color.WHITE);
            cancelButton.setBackground(new Color(102, 0, 0));
            cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            cancelButton.setFocusPainted(false);
            buttonPane.add(cancelButton);
        }

        // ====================== BOTÓN MOSTRAR CONTRASEÑA ======================
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtContraVisible.isVisible()) {
                    txtContraVisible.setVisible(false);
                    txtContra.setVisible(true);
                    btnMostrar.setText("Mostrar Contraseña");
                } else {
                    txtContraVisible.setText(new String(txtContra.getPassword()));
                    txtContraVisible.setVisible(true);
                    txtContra.setVisible(false);
                    btnMostrar.setText("Ocultar Contraseña");
                }
            }
        });

        // ====================== BOTÓN CERRAR CONTRATO ======================
        btnCerrarContrato.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = table.getSelectedRow();
                if (fila == -1) return;

                int opcion = JOptionPane.showConfirmDialog(DetallesCliente.this,
                        "¿Desea cerrar este contrato?",
                        "Confirmar Cierre",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (opcion != JOptionPane.YES_OPTION) return;

                String codigoContrato = table.getValueAt(fila, 0).toString();
                if (Altice.getInstance().cerrarContrato(codigoContrato)) {
                    JOptionPane.showMessageDialog(DetallesCliente.this,
                            "Contrato cerrado correctamente",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                    loadTablaHistorial();
                    actualizarEstadoDeuda();
                } else {
                    JOptionPane.showMessageDialog(DetallesCliente.this,
                            "No se pudo cerrar el contrato",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ====================== BOTÓN VER CONTRATO ======================
        btnVerContrato.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = table.getSelectedRow();
                if (fila == -1) return;

                String codigoContrato = table.getValueAt(fila, 0).toString();
                Contrato contratoSeleccionado = Altice.getInstance().buscarContratoByCodigo(codigoContrato);

                if (contratoSeleccionado != null) {
                    DetallesContrato dialog = new DetallesContrato(contratoSeleccionado);
                    dialog.setModal(true);
                    dialog.setVisible(true);
                }
            }
        });

        // ====================== BOTÓN REALIZAR PAGO ======================
        btnRealizarPago.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = table.getSelectedRow();
                if (fila == -1) return;

                String codigoPago = table.getValueAt(fila, 0).toString();
                Pago pagoSeleccionado = Altice.getInstance().buscarPagoByCodigo(codigoPago);

                if (pagoSeleccionado != null) {
                    RegistrarPagoDirecto dialog = new RegistrarPagoDirecto(pagoSeleccionado);
                    dialog.setModal(true);
                    dialog.setVisible(true);
                    loadTablaHistorial();
                    actualizarEstadoDeuda();
                }
            }
        });

        if (miCliente != null) {
            loadCliente();
            loadTablaHistorial();
        }
    }

    private void loadCliente() {
        if (miCliente == null) return;

        txtCodigo.setText(miCliente.getCodigo() != null ? miCliente.getCodigo() : "");
        txtNombre.setText(miCliente.getNombre() != null ? miCliente.getNombre() : "");
        txtCedula.setText(miCliente.getCedula() != null ? miCliente.getCedula() : "");
        txtTelefono.setText(miCliente.getTelefono() != null ? miCliente.getTelefono() : "");
        txtDireccion.setText(miCliente.getDireccion() != null ? miCliente.getDireccion() : "");
        txtCorreo.setText(miCliente.getEmail() != null ? miCliente.getEmail() : "");

        if (miCliente.getUsuario() != null) {
            txtContra.setText(miCliente.getUsuario().getPassword() != null ? miCliente.getUsuario().getPassword() : "");
            txtContraVisible.setText(miCliente.getUsuario().getPassword() != null ? miCliente.getUsuario().getPassword() : "");

            if (miCliente.getUsuario().getFechaRegistro() != null) {
                txtFechaRegistro.setText(miCliente.getUsuario().getFechaRegistro().toString());
            }

            if (!miCliente.getUsuario().isActivo() && miCliente.getUsuario().getFechaDesactivacion() != null) {
                txtFechaDesactivacion.setText(miCliente.getUsuario().getFechaDesactivacion().toString());
                lblFechaDesactivacion.setVisible(true);
                txtFechaDesactivacion.setVisible(true);
            } else {
                lblFechaDesactivacion.setVisible(false);
                txtFechaDesactivacion.setVisible(false);
            }
        }

        actualizarEstadoDeuda();
    }

    private void actualizarEstadoDeuda() {
        if (miCliente == null) {
            lblEstado.setText("AL DÍA");
            lblEstado.setForeground(new Color(0, 200, 0));
            return;
        }
        boolean tieneDeuda = Altice.getInstance().tieneDeuda(miCliente.getCedula());
        lblEstado.setText(tieneDeuda ? "PENDIENTE" : "AL DÍA");
        lblEstado.setForeground(tieneDeuda ? Color.RED : new Color(0, 200, 0));
    }

    private void loadTablaHistorial() {
        if (model == null) {
            model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table.setModel(model);
        }

        model.setRowCount(0);
        row = new Object[8];

        if (radioContratos.isSelected()) {
            String[] headers = {"Código Contrato", "Plan", "Fecha Inicio", "Fecha Cierre", "Estado"};
            model.setColumnIdentifiers(headers);

            if (miCliente.getContratos() != null) {
                for (Contrato c : miCliente.getContratos()) {
                    row[0] = c.getCodigo();
                    row[1] = c.getPlan() != null ? c.getPlan().getNombre() : "N/A";
                    row[2] = c.getFechaInicio() != null ? c.getFechaInicio().toString() : "";
                    row[3] = c.getFechaCierre() != null ? c.getFechaCierre().toString() : "";
                    row[4] = c.isActivo() ? "Activo" : "Cerrado";
                    model.addRow(row);
                }
            }
        } else {
            String[] headers = {"Código Pago", "Monto", "Fecha Registro", "Fecha Pago", "Estado"};
            model.setColumnIdentifiers(headers);

            if (miCliente.getPagos() != null) {
                for (Pago p : miCliente.getPagos()) {
                    row[0] = p.getCodigo();
                    row[1] = String.format("RD$ %.2f", p.getMonto());
                    row[2] = p.getFechaRegistro() != null ? p.getFechaRegistro().toString() : "";
                    row[3] = p.getFechaPago() != null ? p.getFechaPago().toString() : "";
                    row[4] = p.isPendiente() ? "Pendiente" : "Realizado";
                    model.addRow(row);
                }
            }
        }

        actualizarBotonesSegunSeleccion();
    }

    private void actualizarBotonesSegunSeleccion() {
        int fila = table.getSelectedRow();
        boolean haySeleccion = fila != -1;

        if (radioContratos.isSelected()) {
            btnCerrarContrato.setVisible(haySeleccion);
            btnVerContrato.setVisible(haySeleccion);
            btnRealizarPago.setVisible(false);
            btnCancelarPago.setVisible(false);
        } else {
            btnCerrarContrato.setVisible(false);
            btnVerContrato.setVisible(false);
            btnRealizarPago.setVisible(haySeleccion);
            btnCancelarPago.setVisible(false);
        }
    }
}