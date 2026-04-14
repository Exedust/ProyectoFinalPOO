package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import logico.Empleado;
import logico.Rol;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DetallesComercial extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Empleado miEmpleado;
    
    private JTextField txtNombre;          // Nombre
    private JTextField txtCedula;        // Cedula
    private JTextField txtTelefono;        // Telefono
    private JTextField txtDireccion;        // Direccion
    private JTextField txtCorreo;        // Correo
    private JPasswordField txtContra;  // Contraseña oculta
    private JTextField txtCodigo;        // Código
    private JTextField passwordMostrar;    // Contraseña visible
    private JTextField txtSalario;
    private JTextField txtComision;
    private JButton btnMostrar;
    private JButton btnCancelar;
    private JTextField txtRol;
    private JTextField txtDesactivado;
    private JTextField txtRegistro;
    private JLabel lblFechaDesactivacion;
    private JLabel lblContratosRegistrados;
    private JLabel lblContratosActivos;
    private JLabel lblContratosCerrados;
    private JComboBox comboFiltrar;
    private JButton btnFiltrar;
    private JTable table;
    private JButton btnDetalles;
    
    private DefaultTableModel model;
    private Object[] row;

    public DetallesComercial(Empleado emp) {
        setResizable(false);
        miEmpleado = emp;
        setTitle("Detalles del Empleado");
        setBounds(100, 100, 625, 929);
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

            {
                JPanel panel_1 = new JPanel();
                panel_1.setLayout(null);
                panel_1.setBackground(new Color(102, 102, 204));
                panel_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                panel_1.setBounds(12, 13, 567, 336);
                panel.add(panel_1);

                {
                    JLabel lblCódigo = new JLabel("Código");
                    lblCódigo.setForeground(Color.WHITE);
                    lblCódigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblCódigo.setBounds(12, 13, 56, 16);
                    panel_1.add(lblCódigo);
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

                // Nombre
                {
                    JLabel label = new JLabel("Nombre");
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label.setBounds(12, 79, 56, 16);
                    panel_1.add(label);
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

                // Cédula
                {
                    JLabel label_1 = new JLabel("Cedula");
                    label_1.setForeground(Color.WHITE);
                    label_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label_1.setBounds(12, 143, 56, 16);
                    panel_1.add(label_1);
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

                // Teléfono
                {
                    JLabel label_2 = new JLabel("Telefono");
                    label_2.setForeground(Color.WHITE);
                    label_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label_2.setBounds(12, 207, 56, 16);
                    panel_1.add(label_2);
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

                // Dirección
                {
                    JLabel label_3 = new JLabel("Direccion");
                    label_3.setForeground(Color.WHITE);
                    label_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label_3.setBounds(287, 143, 122, 16);
                    panel_1.add(label_3);
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

                // Correo electrónico
                {
                    JLabel label_4 = new JLabel("Correo electronico");
                    label_4.setForeground(Color.WHITE);
                    label_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label_4.setBounds(287, 79, 122, 16);
                    panel_1.add(label_4);
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

                // Contraseña (campo oculto)
                {
                    JLabel label_5 = new JLabel("Contraseña");
                    label_5.setForeground(Color.WHITE);
                    label_5.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label_5.setBounds(287, 207, 122, 16);
                    panel_1.add(label_5);
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

                // Campo para mostrar contraseña
                {
                    passwordMostrar = new JTextField();
                    passwordMostrar.setEditable(false);
                    passwordMostrar.setBackground(new Color(0, 0, 51));
                    passwordMostrar.setForeground(Color.WHITE);
                    passwordMostrar.setCaretColor(Color.WHITE);
                    passwordMostrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    passwordMostrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    passwordMostrar.setBounds(287, 237, 263, 24);
                    panel_1.add(passwordMostrar);
                    passwordMostrar.setVisible(false); // Oculto por defecto
                }

                // Botón Mostrar Contraseña
                {
                    btnMostrar = new JButton("Mostrar Contraseña");
                    btnMostrar.setForeground(Color.WHITE);
                    btnMostrar.setBackground(new Color(0, 0, 51));
                    btnMostrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    btnMostrar.setFocusPainted(false);
                    btnMostrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    btnMostrar.setBounds(405, 273, 145, 25);
                    panel_1.add(btnMostrar);
                    
                    JLabel Rol = new JLabel("Rol");
                    Rol.setForeground(Color.WHITE);
                    Rol.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    Rol.setBounds(137, 13, 56, 16);
                    panel_1.add(Rol);
                    
                    txtRol = new JTextField();
                    txtRol.setForeground(Color.WHITE);
                    txtRol.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtRol.setEditable(false);
                    txtRol.setCaretColor(Color.WHITE);
                    txtRol.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtRol.setBackground(new Color(0, 0, 51));
                    txtRol.setBounds(137, 42, 138, 24);
                    panel_1.add(txtRol);
                    {
                    	JLabel lblFechaRegistro = new JLabel("Fecha Registro");
                    	lblFechaRegistro.setForeground(Color.WHITE);
                    	lblFechaRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    	lblFechaRegistro.setBounds(12, 270, 91, 16);
                    	panel_1.add(lblFechaRegistro);
                    }
                    {
                    	lblFechaDesactivacion = new JLabel("Fecha Desactivacion");
                    	lblFechaDesactivacion.setForeground(Color.WHITE);
                    	lblFechaDesactivacion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    	lblFechaDesactivacion.setBounds(153, 271, 122, 16);
                    	panel_1.add(lblFechaDesactivacion);
                    }
                    {
                    	txtDesactivado = new JTextField();
                    	txtDesactivado.setText((String) null);
                    	txtDesactivado.setForeground(Color.WHITE);
                    	txtDesactivado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    	txtDesactivado.setEditable(false);
                    	txtDesactivado.setCaretColor(Color.WHITE);
                    	txtDesactivado.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    	txtDesactivado.setBackground(new Color(0, 0, 51));
                    	txtDesactivado.setBounds(153, 300, 122, 24);
                    	panel_1.add(txtDesactivado);

                    }
                    {
                    	txtRegistro = new JTextField();
                    	txtRegistro.setText((String) null);
                    	txtRegistro.setForeground(Color.WHITE);
                    	txtRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    	txtRegistro.setEditable(false);
                    	txtRegistro.setCaretColor(Color.WHITE);
                    	txtRegistro.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    	txtRegistro.setBackground(new Color(0, 0, 51));
                    	txtRegistro.setBounds(12, 300, 122, 24);
                    	panel_1.add(txtRegistro);
                    }

                    btnMostrar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (passwordMostrar.isVisible()) {
                                passwordMostrar.setVisible(false);
                                txtContra.setVisible(true);
                                btnMostrar.setText("Mostrar Contraseña");
                            } else {
                                passwordMostrar.setText(new String(txtContra.getPassword()));
                                passwordMostrar.setVisible(true);
                                txtContra.setVisible(false);
                                btnMostrar.setText("Ocultar Contraseña");
                            }
                        }
                    });
                }
            }

            // ====================== PANEL HISTORIAL DE CONTRATOS ======================
            {
                JPanel panel_2 = new JPanel();
                panel_2.setLayout(null);
                panel_2.setBackground(new Color(102, 102, 204));
                panel_2.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), 
                        "Contratos Realizados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
                panel_2.setBounds(12, 499, 567, 318);
                panel.add(panel_2);

                // Combo de filtro
                comboFiltrar = new JComboBox<>();
                comboFiltrar.setForeground(Color.WHITE);
                comboFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                comboFiltrar.setBackground(new Color(0, 0, 51));
                comboFiltrar.setBounds(12, 27, 208, 24);
                comboFiltrar.addItem("Activos");
                comboFiltrar.addItem("Cerrados");
                comboFiltrar.addItem("Todos");
                panel_2.add(comboFiltrar);

                btnFiltrar = new JButton("Filtrar");
                btnFiltrar.setForeground(Color.WHITE);
                btnFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                btnFiltrar.setFocusPainted(false);
                btnFiltrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                btnFiltrar.setBackground(new Color(0, 0, 51));
                btnFiltrar.setBounds(230, 27, 97, 25);
                panel_2.add(btnFiltrar);

                // Panel de la tabla
                {
                    JPanel panel_3 = new JPanel();
                    panel_3.setBackground(new Color(0, 0, 51));
                    panel_3.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    panel_3.setBounds(12, 66, 543, 201);
                    panel_2.add(panel_3);
                    panel_3.setLayout(new BorderLayout(0, 0));

                    JScrollPane scrollPane = new JScrollPane();
                    panel_3.add(scrollPane, BorderLayout.CENTER);

                    table = new JTable();
                    table.setFillsViewportHeight(true);
                    scrollPane.setViewportView(table);

                    table.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            btnDetalles.setEnabled(table.getSelectedRow() != -1);
                        }
                    });
                }

                // Botón Ver Detalles
                {
                    btnDetalles = new JButton("Ver Detalles");
                    btnDetalles.setBounds(438, 280, 117, 25);
                    btnDetalles.setForeground(Color.WHITE);
                    btnDetalles.setBackground(new Color(0, 0, 51));
                    btnDetalles.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    btnDetalles.setFocusPainted(false);
                    btnDetalles.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    btnDetalles.setEnabled(false);   // Inicialmente deshabilitado
                    panel_2.add(btnDetalles);

                    btnDetalles.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            int fila = table.getSelectedRow();
                            if (fila == -1) return;

                            String codigoContrato = table.getValueAt(fila, 0).toString();
                            Contrato contratoSeleccionado = Altice.getInstance().buscarContratoByCodigo(codigoContrato);

                            if (contratoSeleccionado != null) {
                                DetallesContrato dialog = new DetallesContrato(contratoSeleccionado);
                                dialog.setModal(true);
                                dialog.setVisible(true);
                                loadEmpleado();
                            }
                        }
                    });
                }

                // Acción del botón Filtrar
                btnFiltrar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        loadContratosEmpleado();
                    }
                });
            }
            {
            	JPanel panel_1 = new JPanel();
            	panel_1.setLayout(null);
            	panel_1.setBorder(new LineBorder(Color.WHITE));
            	panel_1.setBackground(new Color(102, 102, 204));
            	panel_1.setBounds(12, 362, 314, 114);
            	panel.add(panel_1);
            	{
            		JLabel lblSalario = new JLabel("Salario");
            		lblSalario.setForeground(Color.WHITE);
            		lblSalario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            		lblSalario.setBounds(12, 24, 56, 16);
            		panel_1.add(lblSalario);
            	}
            	{
            		txtSalario = new JTextField();
            		txtSalario.setForeground(Color.WHITE);
            		txtSalario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            		txtSalario.setEditable(false);
            		txtSalario.setCaretColor(Color.WHITE);
            		txtSalario.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            		txtSalario.setBackground(new Color(0, 0, 51));
            		txtSalario.setBounds(12, 53, 135, 24);
            		panel_1.add(txtSalario);
            	}
            	{
            		txtComision = new JTextField();
            		txtComision.setForeground(Color.WHITE);
            		txtComision.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            		txtComision.setEditable(false);
            		txtComision.setCaretColor(Color.WHITE);
            		txtComision.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            		txtComision.setBackground(new Color(0, 0, 51));
            		txtComision.setBounds(159, 53, 135, 24);
            		panel_1.add(txtComision);
            	}
            	{
            		JLabel lblComision = new JLabel("Comision");
            		lblComision.setForeground(Color.WHITE);
            		lblComision.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            		lblComision.setBounds(159, 24, 56, 16);
            		panel_1.add(lblComision);
            	}
            }
            {
            	JPanel panel_1 = new JPanel();
            	panel_1.setLayout(null);
            	panel_1.setBorder(new LineBorder(Color.WHITE));
            	panel_1.setBackground(new Color(102, 102, 204));
            	panel_1.setBounds(338, 362, 241, 114);
            	panel.add(panel_1);
            	{
            		lblContratosActivos = new JLabel("Contratos Activos: 00");
            		lblContratosActivos.setForeground(Color.WHITE);
            		lblContratosActivos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            		lblContratosActivos.setBounds(12, 42, 175, 16);
            		panel_1.add(lblContratosActivos);
            	}
            	{
            		lblContratosRegistrados = new JLabel("Contratos Registrados: 00");
            		lblContratosRegistrados.setForeground(Color.WHITE);
            		lblContratosRegistrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            		lblContratosRegistrados.setBounds(12, 13, 175, 16);
            		panel_1.add(lblContratosRegistrados);
            	}
            	{
            		lblContratosCerrados = new JLabel("Contratos Cerrados: 00");
            		lblContratosCerrados.setForeground(Color.WHITE);
            		lblContratosCerrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            		lblContratosCerrados.setBounds(12, 71, 175, 16);
            		panel_1.add(lblContratosCerrados);
            	}
            }
        }

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            btnCancelar = new JButton("Salir");
            btnCancelar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		dispose();
            	}
            });
            btnCancelar.setForeground(Color.WHITE);
            btnCancelar.setBackground(new Color(102, 0, 0));
            btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnCancelar.setFocusPainted(false);
            btnCancelar.setActionCommand("Cancel");
            buttonPane.add(btnCancelar);
        }
    	if(miEmpleado.isActivo())
    	{
    		lblFechaDesactivacion.setVisible(false);
    		txtDesactivado.setVisible(false);
    	}
        loadEmpleado();
    }
    private void loadEmpleado() {
        if (miEmpleado == null) return;

        txtCodigo.setText(miEmpleado.getCodigo());
        txtNombre.setText(miEmpleado.getNombre());
        txtCedula.setText(miEmpleado.getCedula());
        txtTelefono.setText(miEmpleado.getTelefono());
        txtDireccion.setText(miEmpleado.getDireccion());
        txtCorreo.setText(miEmpleado.getEmail());

        txtContra.setText(miEmpleado.getUsuario().getPassword());
        passwordMostrar.setText(miEmpleado.getUsuario().getPassword());

        txtSalario.setText(("RD$")+miEmpleado.getSalario().toString());
        if(miEmpleado.getComision() == null)
        	txtComision.setText(("RD$")+miEmpleado.getComision().toString());
        else
        	txtComision.setText(("RD$")+miEmpleado.getComision().toString());

        txtRol.setText(miEmpleado.getRol().name());
        txtRegistro.setText(miEmpleado.getUsuario().getFechaRegistro().toString());
        if(!miEmpleado.isActivo())
        	txtDesactivado.setText(miEmpleado.getUsuario().getFechaDesactivacion().toString());
        
        loadContratosEmpleado();
    }
    
    private void loadContratosEmpleado() {
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
        row = new Object[6];   // 6 columnas

        String filtro = (comboFiltrar.getSelectedItem() != null) 
                        ? comboFiltrar.getSelectedItem().toString() : "Todos";

        // Headers completos
        String[] headers = {"Código", "Plan", "Fecha Inicio", "Fecha Cierre", "Estado", "Cliente"};
        model.setColumnIdentifiers(headers);

        int totalRegistrados = 0;
        int totalActivos = 0;
        int totalCerrados = 0;

        // Recorremos TODOS los contratos del sistema
        for (Contrato c : Altice.getInstance().getMisContratos()) {
            boolean esDelEmpleado = false;

            // Caso 1: El empleado fue quien registró el contrato
            if (c.getEmpleado() != null && c.getEmpleado().getCodigo() != null &&
                c.getEmpleado().getCodigo().equals(miEmpleado.getCodigo())) {
                esDelEmpleado = true;
            }

            // Caso 2: El empleado es el cliente del contrato (contrato propio)
            if (!esDelEmpleado && c.getCliente() != null && c.getCliente().getCedula() != null &&
                c.getCliente().getCedula().equals(miEmpleado.getCedula())) {
                esDelEmpleado = true;
            }

            if (!esDelEmpleado) continue;

            // Aplicar filtro
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

            if (incluir) {
                row[0] = c.getCodigo() != null ? c.getCodigo() : "";
                row[1] = c.getPlan() != null ? c.getPlan().getNombre() : "N/A";
                row[2] = c.getFechaInicio() != null ? c.getFechaInicio().toString() : "";
                row[3] = c.getFechaCierre() != null ? c.getFechaCierre().toString() : "";
                row[4] = c.isActivo() ? "Activo" : "Cerrado";
                row[5] = (c.getCliente() != null) ? c.getCliente().getNombre() : "N/A";

                model.addRow(row);

                totalRegistrados++;
                if (c.isActivo()) totalActivos++;
                else totalCerrados++;
            }
        }

        // Actualizar contadores
        lblContratosRegistrados.setText("Contratos Registrados: " + String.format("%02d", totalRegistrados));
        lblContratosActivos.setText("Contratos Activos: " + String.format("%02d", totalActivos));
        lblContratosCerrados.setText("Contratos Cerrados: " + String.format("%02d", totalCerrados));
    }
}