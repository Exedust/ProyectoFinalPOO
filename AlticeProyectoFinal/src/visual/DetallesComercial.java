package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import logico.Empleado;
import logico.Rol;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

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

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            DetallesComercial dialog = new DetallesComercial(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
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
                panel_2.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "Contratos Realizados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
                panel_2.setBounds(12, 499, 567, 318);
                panel.add(panel_2);

                {
                    JPanel panel_3 = new JPanel();
                    panel_3.setBackground(new Color(0, 0, 51));
                    panel_3.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    panel_3.setBounds(12, 66, 543, 201);
                    panel_2.add(panel_3);
                    // Aquí irá tu JTable o lista de contratos más adelante
                }
                
                            // ====================== BOTONES DE ACCIÓN ======================
                            {
                                JButton btnRealizarPago = new JButton("Ver Detalles");
                                btnRealizarPago.setBounds(438, 280, 117, 25);
                                panel_2.add(btnRealizarPago);
                                btnRealizarPago.setForeground(Color.WHITE);
                                btnRealizarPago.setBackground(new Color(0, 0, 51));
                                btnRealizarPago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                                btnRealizarPago.setFocusPainted(false);
                                btnRealizarPago.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                            }
                            
                            JComboBox comboBox = new JComboBox();
                            comboBox.setForeground(Color.WHITE);
                            comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                            comboBox.setBackground(new Color(0, 0, 51));
                            comboBox.setBounds(238, 27, 208, 24);
                            panel_2.add(comboBox);
                            
                            JButton button = new JButton("Filtrar");
                            button.setForeground(Color.WHITE);
                            button.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                            button.setFocusPainted(false);
                            button.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                            button.setBackground(new Color(0, 0, 51));
                            button.setBounds(458, 27, 97, 25);
                            panel_2.add(button);
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
            		JLabel lblContratosRegistrados = new JLabel("Contratos Activos: 00");
            		lblContratosRegistrados.setForeground(Color.WHITE);
            		lblContratosRegistrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            		lblContratosRegistrados.setBounds(12, 42, 175, 16);
            		panel_1.add(lblContratosRegistrados);
            	}
            	{
            		JLabel label = new JLabel("Contratos Registrados: 00");
            		label.setForeground(Color.WHITE);
            		label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            		label.setBounds(12, 13, 175, 16);
            		panel_1.add(label);
            	}
            	{
            		JLabel lblContratosCerrados = new JLabel("Contratos Cerrados: 00");
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
        
    }
}