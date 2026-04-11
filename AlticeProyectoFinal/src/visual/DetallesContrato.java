package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Contrato;
import logico.Empleado;
import logico.Pago;
import logico.Persona;
import logico.Altice;
import logico.Cliente;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DetallesContrato extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Contrato miContrato;

    // Campos del Contrato
    private JTextField txtCodigoContrato;
    private JTextField txtFechaInicio;
    private JTextField txtFechaCierre;

    // Campos del Empleado a cargo
    private JTextField txtNombreEmpleado;
    private JTextField txtCedulaEmpleado;

    // Campos del Cliente
    private JTextField txtNombreCliente;
    private JTextField txtCedulaCliente;
    private JTextField txtCorreoCliente;
    private JTextField txtTelefonoCliente;

    // Botones de acción
    private JButton btnCancelarPago;
    private JButton btnRealizarPago;
    private JLabel lblFechaCierre;
    private JTable table;
    
    private DefaultTableModel model;
    private Object[] row;
    private JComboBox<String> comboFiltrarPagos;
    private JLabel lblPagosPendientes;
    private JLabel lblMontoPendiente;

    public static void main(String[] args) {
        try {
            DetallesContrato dialog = new DetallesContrato(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DetallesContrato(Contrato contrato) {
        miContrato = contrato;

        setResizable(false);
        setTitle("Detalles del Contrato");
        setBounds(100, 100, 679, 945);
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

            // ====================== PANEL DATOS DEL CONTRATO ======================
            {
                JPanel panelContrato = new JPanel();
                panelContrato.setLayout(null);
                panelContrato.setBackground(new Color(102, 102, 204));
                panelContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                panelContrato.setBounds(12, 13, 616, 101);
                panel.add(panelContrato);

                JLabel lblCodigo = new JLabel("Código del Contrato");
                lblCodigo.setForeground(Color.WHITE);
                lblCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCodigo.setBounds(12, 13, 120, 16);
                panelContrato.add(lblCodigo);

                txtCodigoContrato = new JTextField();
                txtCodigoContrato.setEditable(false);
                txtCodigoContrato.setBackground(new Color(0, 0, 51));
                txtCodigoContrato.setForeground(Color.WHITE);
                txtCodigoContrato.setCaretColor(Color.WHITE);
                txtCodigoContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCodigoContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCodigoContrato.setBounds(12, 42, 150, 24);
                panelContrato.add(txtCodigoContrato);

                JLabel lblFechaInicio = new JLabel("Fecha de Inicio");
                lblFechaInicio.setForeground(Color.WHITE);
                lblFechaInicio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblFechaInicio.setBounds(180, 13, 100, 16);
                panelContrato.add(lblFechaInicio);

                txtFechaInicio = new JTextField();
                txtFechaInicio.setEditable(false);
                txtFechaInicio.setBackground(new Color(0, 0, 51));
                txtFechaInicio.setForeground(Color.WHITE);
                txtFechaInicio.setCaretColor(Color.WHITE);
                txtFechaInicio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtFechaInicio.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtFechaInicio.setBounds(180, 42, 150, 24);
                panelContrato.add(txtFechaInicio);

                lblFechaCierre = new JLabel("Fecha de Cierre");
                lblFechaCierre.setForeground(Color.WHITE);
                lblFechaCierre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblFechaCierre.setBounds(348, 13, 100, 16);
                panelContrato.add(lblFechaCierre);

                txtFechaCierre = new JTextField();
                txtFechaCierre.setEditable(false);
                txtFechaCierre.setBackground(new Color(0, 0, 51));
                txtFechaCierre.setForeground(Color.WHITE);
                txtFechaCierre.setCaretColor(Color.WHITE);
                txtFechaCierre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtFechaCierre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtFechaCierre.setBounds(348, 42, 150, 24);
                panelContrato.add(txtFechaCierre);
            }

            // ====================== PANEL EMPLEADO A CARGO ======================
            {
                JPanel panelEmpleado = new JPanel();
                panelEmpleado.setLayout(null);
                panelEmpleado.setBackground(new Color(102, 102, 204));
                panelEmpleado.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Empleado a Cargo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                panelEmpleado.setBounds(12, 127, 616, 129);
                panel.add(panelEmpleado);

                JLabel lblNombreEmp = new JLabel("Nombre");
                lblNombreEmp.setForeground(Color.WHITE);
                lblNombreEmp.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblNombreEmp.setBounds(12, 36, 56, 16);
                panelEmpleado.add(lblNombreEmp);

                txtNombreEmpleado = new JTextField();
                txtNombreEmpleado.setEditable(false);
                txtNombreEmpleado.setBackground(new Color(0, 0, 51));
                txtNombreEmpleado.setForeground(Color.WHITE);
                txtNombreEmpleado.setCaretColor(Color.WHITE);
                txtNombreEmpleado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtNombreEmpleado.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtNombreEmpleado.setBounds(12, 65, 280, 24);
                panelEmpleado.add(txtNombreEmpleado);

                JLabel lblCedulaEmp = new JLabel("Cédula");
                lblCedulaEmp.setForeground(Color.WHITE);
                lblCedulaEmp.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCedulaEmp.setBounds(304, 36, 56, 16);
                panelEmpleado.add(lblCedulaEmp);

                txtCedulaEmpleado = new JTextField();
                txtCedulaEmpleado.setEditable(false);
                txtCedulaEmpleado.setBackground(new Color(0, 0, 51));
                txtCedulaEmpleado.setForeground(Color.WHITE);
                txtCedulaEmpleado.setCaretColor(Color.WHITE);
                txtCedulaEmpleado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCedulaEmpleado.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCedulaEmpleado.setBounds(304, 65, 280, 24);
                panelEmpleado.add(txtCedulaEmpleado);
            }

            // ====================== PANEL CLIENTE ======================
            {
                JPanel panelCliente = new JPanel();
                panelCliente.setLayout(null);
                panelCliente.setBackground(new Color(102, 102, 204));
                panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                panelCliente.setBounds(12, 269, 616, 180);
                panel.add(panelCliente);

                JLabel lblNombreCli = new JLabel("Nombre");
                lblNombreCli.setForeground(Color.WHITE);
                lblNombreCli.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblNombreCli.setBounds(12, 36, 56, 16);
                panelCliente.add(lblNombreCli);

                txtNombreCliente = new JTextField();
                txtNombreCliente.setEditable(false);
                txtNombreCliente.setBackground(new Color(0, 0, 51));
                txtNombreCliente.setForeground(Color.WHITE);
                txtNombreCliente.setCaretColor(Color.WHITE);
                txtNombreCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtNombreCliente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtNombreCliente.setBounds(12, 65, 280, 24);
                panelCliente.add(txtNombreCliente);

                JLabel lblCedulaCli = new JLabel("Cédula");
                lblCedulaCli.setForeground(Color.WHITE);
                lblCedulaCli.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCedulaCli.setBounds(12, 100, 56, 16);
                panelCliente.add(lblCedulaCli);

                txtCedulaCliente = new JTextField();
                txtCedulaCliente.setEditable(false);
                txtCedulaCliente.setBackground(new Color(0, 0, 51));
                txtCedulaCliente.setForeground(Color.WHITE);
                txtCedulaCliente.setCaretColor(Color.WHITE);
                txtCedulaCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCedulaCliente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCedulaCliente.setBounds(12, 129, 280, 24);
                panelCliente.add(txtCedulaCliente);

                JLabel lblCorreoCli = new JLabel("Correo");
                lblCorreoCli.setForeground(Color.WHITE);
                lblCorreoCli.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCorreoCli.setBounds(310, 36, 56, 16);
                panelCliente.add(lblCorreoCli);

                txtCorreoCliente = new JTextField();
                txtCorreoCliente.setEditable(false);
                txtCorreoCliente.setBackground(new Color(0, 0, 51));
                txtCorreoCliente.setForeground(Color.WHITE);
                txtCorreoCliente.setCaretColor(Color.WHITE);
                txtCorreoCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCorreoCliente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCorreoCliente.setBounds(310, 65, 280, 24);
                panelCliente.add(txtCorreoCliente);

                JLabel lblTelefonoCli = new JLabel("Teléfono");
                lblTelefonoCli.setForeground(Color.WHITE);
                lblTelefonoCli.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblTelefonoCli.setBounds(310, 100, 56, 16);
                panelCliente.add(lblTelefonoCli);

                txtTelefonoCliente = new JTextField();
                txtTelefonoCliente.setEditable(false);
                txtTelefonoCliente.setBackground(new Color(0, 0, 51));
                txtTelefonoCliente.setForeground(Color.WHITE);
                txtTelefonoCliente.setCaretColor(Color.WHITE);
                txtTelefonoCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtTelefonoCliente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtTelefonoCliente.setBounds(310, 129, 280, 24);
                panelCliente.add(txtTelefonoCliente);
            }
            
            // ====================== PANEL HISTORIAL DE PAGOS ======================
            {
                JPanel panel_1 = new JPanel();
                panel_1.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), 
                        "Historial de Pagos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
                panel_1.setBackground(new Color(102, 102, 204));
                panel_1.setBounds(12, 462, 616, 373);
                panel.add(panel_1);

                // Filtro
                comboFiltrarPagos = new JComboBox<>();
                comboFiltrarPagos.setBounds(15, 40, 223, 24);
                comboFiltrarPagos.setForeground(Color.WHITE);
                comboFiltrarPagos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                comboFiltrarPagos.setBackground(new Color(0, 0, 51));
                comboFiltrarPagos.addItem("Pendientes");
                comboFiltrarPagos.addItem("Realizados");
                comboFiltrarPagos.addItem("Cancelados");
                comboFiltrarPagos.addItem("Todos");
                panel_1.setLayout(null);
                panel_1.add(comboFiltrarPagos);

                JButton btnFiltrarPagos = new JButton("Filtrar");
                btnFiltrarPagos.setBounds(250, 38, 96, 29);
                btnFiltrarPagos.setForeground(Color.WHITE);
                btnFiltrarPagos.setBackground(new Color(0, 0, 51));
                btnFiltrarPagos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                btnFiltrarPagos.setFocusPainted(false);
                btnFiltrarPagos.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                panel_1.add(btnFiltrarPagos);

                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(5, 85, 599, 222);
                panel_1.add(scrollPane);

                table = new JTable();
                table.setFillsViewportHeight(true);
                scrollPane.setViewportView(table);
                {
                    btnCancelarPago = new JButton("Cancelar Pago");
                    btnCancelarPago.setBounds(15, 320, 123, 25);
                    panel_1.add(btnCancelarPago);
                    btnCancelarPago.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		cancelarPago();
                    	}
                    });
                    btnCancelarPago.setForeground(Color.WHITE);
                    btnCancelarPago.setBackground(new Color(102, 0, 0));
                    btnCancelarPago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    btnCancelarPago.setFocusPainted(false);
                    btnCancelarPago.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                }
                
                            // ====================== BOTONES DE ACCIÓN ======================
                            {
                                btnRealizarPago = new JButton("Realizar Pago");
                                btnRealizarPago.addActionListener(new ActionListener() {
                                	public void actionPerformed(ActionEvent e) {
                                		String codigoPago = table.getValueAt(table.getSelectedRow(), 0).toString();
                                		RegistrarPagoDirecto pago = new RegistrarPagoDirecto(Altice.getInstance().buscarPagoByCodigo(codigoPago));
                                		pago.setModal(true);
                                		pago.setVisible(true);
                                		loadHistorialPagos(comboFiltrarPagos.getSelectedItem().toString());
                                	}
                                });
                                btnRealizarPago.setBounds(487, 322, 117, 25);
                                panel_1.add(btnRealizarPago);
                                btnRealizarPago.setForeground(Color.WHITE);
                                btnRealizarPago.setBackground(new Color(0, 0, 51));
                                btnRealizarPago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                                btnRealizarPago.setFocusPainted(false);
                                btnRealizarPago.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                            }
                            
                            lblMontoPendiente = new JLabel("Monto pendiente: 00");
                            lblMontoPendiente.setForeground(Color.WHITE);
                            lblMontoPendiente.setFont(new Font("Tahoma", Font.PLAIN, 15));
                            lblMontoPendiente.setBounds(383, 23, 221, 16);
                            panel_1.add(lblMontoPendiente);
                            
                            lblPagosPendientes = new JLabel("Pagos Pendientes: 00");
                            lblPagosPendientes.setForeground(Color.WHITE);
                            lblPagosPendientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
                            lblPagosPendientes.setBounds(383, 48, 221, 16);
                            panel_1.add(lblPagosPendientes);

 
                table.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        actualizarBotonesPagos();
                    }
                });

                btnFiltrarPagos.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        loadHistorialPagos(comboFiltrarPagos.getSelectedItem().toString());
                    }
                });
            }
        }

        // ====================== BOTONES INFERIORES ======================
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            JButton cancelButton = new JButton("Salir");
            cancelButton.setForeground(Color.WHITE);
            cancelButton.setBackground(new Color(102, 0, 0));
            cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            cancelButton.setFocusPainted(false);
            cancelButton.addActionListener(e -> dispose());
            buttonPane.add(cancelButton);
        }

        if (miContrato != null) {
            loadContrato(miContrato);
        }

    }

    private void loadContrato(Contrato contrato) {
        if (contrato == null) return;

        txtCodigoContrato.setText(contrato.getCodigo() != null ? contrato.getCodigo() : "");
        txtFechaInicio.setText(contrato.getFechaInicio() != null ? contrato.getFechaInicio().toString() : "");
        txtFechaCierre.setText(contrato.getFechaCierre() != null ? contrato.getFechaCierre().toString() : "");

        Empleado emp = contrato.getEmpleado();
        if (emp != null) {
            txtNombreEmpleado.setText(emp.getNombre() != null ? emp.getNombre() : "");
            txtCedulaEmpleado.setText(emp.getCedula() != null ? emp.getCedula() : "");
        }

        Persona cli = contrato.getCliente();
        if (cli != null) {
            txtNombreCliente.setText(cli.getNombre() != null ? cli.getNombre() : "");
            txtCedulaCliente.setText(cli.getCedula() != null ? cli.getCedula() : "");
            txtCorreoCliente.setText(cli.getEmail() != null ? cli.getEmail() : "");
            txtTelefonoCliente.setText(cli.getTelefono() != null ? cli.getTelefono() : "");
        }

        if (contrato.isActivo()) {
            lblFechaCierre.setVisible(false);
            txtFechaCierre.setVisible(false);
        } else {
            lblFechaCierre.setVisible(true);
            txtFechaCierre.setVisible(true);
        }

        loadHistorialPagos("Pendientes");
    }

    private void loadHistorialPagos(String filtro) {
        // Crear el modelo solo una vez
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
        row = new Object[5];

        // Siempre definir los headers (para que nunca desaparezcan)
        String[] headers = {"Código Pago", "Monto", "Fecha Registro", "Fecha Pago", "Estado"};
        model.setColumnIdentifiers(headers);

        // ====================== CALCULAR VALORES REALES (independientes del filtro) ======================
        int pagosPendientes = 0;
        float montoPendienteTotal = 0.0f;

        if (miContrato != null && miContrato.getPagos() != null) {
            for (Pago p : miContrato.getPagos()) {
                if (p.isPendiente() && p.isActivo()) {
                    pagosPendientes++;
                    montoPendienteTotal += p.getMonto();
                }
            }
        }

        lblPagosPendientes.setText("Pagos Pendientes: " + String.format("%02d", pagosPendientes));
        lblMontoPendiente.setText("Monto pendiente: RD$ " + String.format("%.2f", montoPendienteTotal));

        // ====================== LLENAR LA TABLA SEGÚN EL FILTRO ======================
        if (miContrato != null && miContrato.getPagos() != null) {
            for (Pago p : miContrato.getPagos()) {
                boolean incluir = false;

                switch (filtro) {
                    case "Todos":
                        incluir = true;
                        break;
                    case "Pendientes":
                        incluir = p.isPendiente() && p.isActivo();
                        break;
                    case "Realizados":
                        incluir = !p.isPendiente() && p.isActivo();
                        break;
                    case "Cancelados":
                        incluir = !p.isActivo();
                        break;
                }

                if (incluir) {
                    row[0] = p.getCodigo() != null ? p.getCodigo() : "";
                    row[1] = String.format("RD$ %.2f", p.getMonto());
                    row[2] = p.getFechaRegistro() != null ? p.getFechaRegistro().toString() : "";
                    row[3] = p.getFechaPago() != null ? p.getFechaPago().toString() : "";

                    String estado = "REALIZADO";
                    if (!p.isActivo()) {
                        estado = "CANCELADO";
                    } else if (p.isPendiente()) {
                        estado = "PENDIENTE";
                    }
                    row[4] = estado;

                    model.addRow(row);
                }
            }
        }

        actualizarBotonesPagos();
    }
    private void cancelarPago() {
        int fila = table.getSelectedRow();
        if (fila == -1) {
            return;
        }

        String codigoPago = table.getValueAt(fila, 0).toString();

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea cancelar este pago pendiente?",
                "Confirmar Cancelación de Pago",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }

        if (Altice.getInstance().cancelarPago(codigoPago)) {
            JOptionPane.showMessageDialog(this,
                    "Pago cancelado correctamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

            loadHistorialPagos(comboFiltrarPagos.getSelectedItem().toString());
        } else {
            JOptionPane.showMessageDialog(this,
                    "No se pudo cancelar el pago",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarBotonesPagos() {
        int fila = table.getSelectedRow();
        boolean haySeleccion = fila != -1;

        if (haySeleccion) {
            String estadoPago = table.getValueAt(fila, 4).toString();

            boolean esPendiente = estadoPago.equals("PENDIENTE");
            boolean esRealizado = estadoPago.equals("REALIZADO");

            btnRealizarPago.setEnabled(esPendiente);
            btnCancelarPago.setEnabled(esPendiente || esRealizado);
        } else {
            btnRealizarPago.setEnabled(false);
            btnCancelarPago.setEnabled(false);
        }
    }
}