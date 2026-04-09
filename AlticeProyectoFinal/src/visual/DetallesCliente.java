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
import logico.Cliente;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

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
        setBounds(100, 100, 625, 761);
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

                // Código
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

                // Cédula / RNC
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

                // Correo
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

                // Contraseña
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

                // Contraseña visible
                {
                    txtContraVisible = new JTextField();
                    txtContraVisible.setEditable(false);
                    txtContraVisible.setBackground(new Color(0, 0, 51));
                    txtContraVisible.setForeground(Color.WHITE);
                    txtContraVisible.setCaretColor(Color.WHITE);
                    txtContraVisible.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtContraVisible.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtContraVisible.setBounds(287, 237, 263, 24);
                    panel_1.add(txtContraVisible);
                    txtContraVisible.setVisible(false);
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
                }
                {
                	JLabel label = new JLabel("Fecha Registro");
                	label.setForeground(Color.WHITE);
                	label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                	label.setBounds(12, 273, 91, 16);
                	panel_1.add(label);
                }
                {
                	txtFechaRegistro = new JTextField();
                	txtFechaRegistro.setText((String) null);
                	txtFechaRegistro.setForeground(Color.WHITE);
                	txtFechaRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                	txtFechaRegistro.setEditable(false);
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
                	txtFechaDesactivacion.setText((String) null);
                	txtFechaDesactivacion.setForeground(Color.WHITE);
                	txtFechaDesactivacion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                	txtFechaDesactivacion.setEditable(false);
                	txtFechaDesactivacion.setCaretColor(Color.WHITE);
                	txtFechaDesactivacion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                	txtFechaDesactivacion.setBackground(new Color(0, 0, 51));
                	txtFechaDesactivacion.setBounds(153, 303, 122, 24);
                	panel_1.add(txtFechaDesactivacion);
                }
            }

            // ====================== PANEL HISTORIAL DE CONTRATOS ======================
            {
                JPanel panel_2 = new JPanel();
                panel_2.setLayout(null);
                panel_2.setBackground(new Color(102, 102, 204));
                panel_2.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Historial de Contratos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                panel_2.setBounds(12, 372, 567, 216);
                panel.add(panel_2);

                {
                    JPanel panel_3 = new JPanel();
                    panel_3.setBackground(new Color(0, 0, 51));
                    panel_3.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    panel_3.setBounds(12, 33, 543, 170);
                    panel_2.add(panel_3);
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

        loadCliente();
    }

    private void loadCliente() {
        if (miCliente == null) return;

        txtCodigo.setText(miCliente.getCodigo());
        txtNombre.setText(miCliente.getNombre());
        txtCedula.setText(miCliente.getCedula());
        txtTelefono.setText(miCliente.getTelefono());
        txtDireccion.setText(miCliente.getDireccion());
        txtCorreo.setText(miCliente.getEmail());

        if (miCliente.getUsuario() != null) {
            txtContra.setText(miCliente.getUsuario().getPassword());
            txtContraVisible.setText(miCliente.getUsuario().getPassword());

            if (miCliente.getUsuario().getFechaRegistro() != null) {
                txtFechaRegistro.setText(miCliente.getUsuario().getFechaRegistro().toString());
            }

            if (!miCliente.getUsuario().isActivo()) {
                txtFechaDesactivacion.setText(miCliente.getUsuario().getFechaDesactivacion().toString());
                lblFechaDesactivacion.setVisible(true);
                txtFechaDesactivacion.setVisible(true);
            } else {
                lblFechaDesactivacion.setVisible(false);
                txtFechaDesactivacion.setVisible(false);
            }
        }
    }
}