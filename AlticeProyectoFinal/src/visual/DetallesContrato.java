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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class DetallesContrato extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTextField textField_5;   // Código del contrato
    private JTextField textField_1;   // Nombre empleado
    private JTextField textField_6;   // Cédula empleado
    private JTextField textField_7;   // Correo empleado
    private JTextField textField_8;   // Teléfono empleado
    private JTextField textField_9;   // Nombre cliente
    private JTextField textField_10;  // Cédula cliente
    private JTextField textField_11;  // Correo cliente
    private JTextField textField_12;  // Teléfono cliente

    public static void main(String[] args) {
        try {
            DetallesContrato dialog = new DetallesContrato();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DetallesContrato() {
        setResizable(false);
        setTitle("Detalles del Contrato");
        setBounds(100, 100, 679, 945);
        
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

            // PANEL DATOS DEL CONTRATO
            {
                JPanel panel_1 = new JPanel();
                panel_1.setLayout(null);
                panel_1.setBackground(new Color(102, 102, 204));
                panel_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                panel_1.setBounds(12, 13, 616, 479);
                panel.add(panel_1);

                // Código del contrato
                {
                    JLabel lblCódigo = new JLabel("Código");
                    lblCódigo.setForeground(Color.WHITE);
                    lblCódigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblCódigo.setBounds(12, 13, 56, 16);
                    panel_1.add(lblCódigo);
                }
                {
                    textField_5 = new JTextField();
                    textField_5.setEditable(false);
                    textField_5.setBackground(new Color(0, 0, 51));
                    textField_5.setForeground(Color.WHITE);
                    textField_5.setCaretColor(Color.WHITE);
                    textField_5.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    textField_5.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    textField_5.setBounds(12, 42, 113, 24);
                    panel_1.add(textField_5);
                }

                // SUBPANEL: Empleado a cargo
                {
                    JPanel panelEmpleado = new JPanel();
                    panelEmpleado.setLayout(null);
                    panelEmpleado.setBackground(new Color(102, 102, 204));
                    panelEmpleado.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), 
                            "Empleado a cargo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                    panelEmpleado.setBounds(12, 87, 592, 183);
                    panel_1.add(panelEmpleado);

                    {
                        JLabel lblNombre = new JLabel("Nombre");
                        lblNombre.setForeground(Color.WHITE);
                        lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        lblNombre.setBounds(12, 36, 56, 16);
                        panelEmpleado.add(lblNombre);
                    }
                    {
                        textField_1 = new JTextField();
                        textField_1.setEditable(false);
                        textField_1.setBackground(new Color(0, 0, 51));
                        textField_1.setForeground(Color.WHITE);
                        textField_1.setCaretColor(Color.WHITE);
                        textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        textField_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                        textField_1.setBounds(12, 65, 263, 24);
                        panelEmpleado.add(textField_1);
                    }
                    {
                        JLabel lblCedula = new JLabel("Cedula");
                        lblCedula.setForeground(Color.WHITE);
                        lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        lblCedula.setBounds(12, 100, 56, 16);
                        panelEmpleado.add(lblCedula);
                    }
                    {
                        textField_6 = new JTextField();
                        textField_6.setEditable(false);
                        textField_6.setBackground(new Color(0, 0, 51));
                        textField_6.setForeground(Color.WHITE);
                        textField_6.setCaretColor(Color.WHITE);
                        textField_6.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        textField_6.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                        textField_6.setBounds(12, 129, 263, 24);
                        panelEmpleado.add(textField_6);
                    }
                    {
                        JLabel lblCorreo = new JLabel("Correo");
                        lblCorreo.setForeground(Color.WHITE);
                        lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        lblCorreo.setBounds(287, 36, 56, 16);
                        panelEmpleado.add(lblCorreo);
                    }
                    {
                        textField_7 = new JTextField();
                        textField_7.setEditable(false);
                        textField_7.setBackground(new Color(0, 0, 51));
                        textField_7.setForeground(Color.WHITE);
                        textField_7.setCaretColor(Color.WHITE);
                        textField_7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        textField_7.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                        textField_7.setBounds(287, 65, 263, 24);
                        panelEmpleado.add(textField_7);
                    }
                    {
                        JLabel lblTelefono = new JLabel("Telefono");
                        lblTelefono.setForeground(Color.WHITE);
                        lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        lblTelefono.setBounds(287, 100, 56, 16);
                        panelEmpleado.add(lblTelefono);
                    }
                    {
                        textField_8 = new JTextField();
                        textField_8.setEditable(false);
                        textField_8.setBackground(new Color(0, 0, 51));
                        textField_8.setForeground(Color.WHITE);
                        textField_8.setCaretColor(Color.WHITE);
                        textField_8.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        textField_8.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                        textField_8.setBounds(287, 129, 263, 24);
                        panelEmpleado.add(textField_8);
                    }
                }

                // SUBPANEL: Datos del Cliente
                {
                    JPanel panelCliente = new JPanel();
                    panelCliente.setLayout(null);
                    panelCliente.setBackground(new Color(102, 102, 204));
                    panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), 
                            "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                    panelCliente.setBounds(12, 283, 592, 183);
                    panel_1.add(panelCliente);

                    {
                        JLabel lblNombre = new JLabel("Nombre");
                        lblNombre.setForeground(Color.WHITE);
                        lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        lblNombre.setBounds(12, 36, 56, 16);
                        panelCliente.add(lblNombre);
                    }
                    {
                        textField_9 = new JTextField();
                        textField_9.setEditable(false);
                        textField_9.setBackground(new Color(0, 0, 51));
                        textField_9.setForeground(Color.WHITE);
                        textField_9.setCaretColor(Color.WHITE);
                        textField_9.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        textField_9.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                        textField_9.setBounds(12, 65, 263, 24);
                        panelCliente.add(textField_9);
                    }
                    {
                        JLabel lblCedula = new JLabel("Cedula");
                        lblCedula.setForeground(Color.WHITE);
                        lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        lblCedula.setBounds(12, 100, 56, 16);
                        panelCliente.add(lblCedula);
                    }
                    {
                        textField_10 = new JTextField();
                        textField_10.setEditable(false);
                        textField_10.setBackground(new Color(0, 0, 51));
                        textField_10.setForeground(Color.WHITE);
                        textField_10.setCaretColor(Color.WHITE);
                        textField_10.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        textField_10.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                        textField_10.setBounds(12, 129, 263, 24);
                        panelCliente.add(textField_10);
                    }
                    {
                        JLabel lblCorreo = new JLabel("Correo");
                        lblCorreo.setForeground(Color.WHITE);
                        lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        lblCorreo.setBounds(287, 36, 56, 16);
                        panelCliente.add(lblCorreo);
                    }
                    {
                        textField_11 = new JTextField();
                        textField_11.setEditable(false);
                        textField_11.setBackground(new Color(0, 0, 51));
                        textField_11.setForeground(Color.WHITE);
                        textField_11.setCaretColor(Color.WHITE);
                        textField_11.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        textField_11.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                        textField_11.setBounds(287, 65, 263, 24);
                        panelCliente.add(textField_11);
                    }
                    {
                        JLabel lblTelefono = new JLabel("Telefono");
                        lblTelefono.setForeground(Color.WHITE);
                        lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        lblTelefono.setBounds(287, 100, 56, 16);
                        panelCliente.add(lblTelefono);
                    }
                    {
                        textField_12 = new JTextField();
                        textField_12.setEditable(false);
                        textField_12.setBackground(new Color(0, 0, 51));
                        textField_12.setForeground(Color.WHITE);
                        textField_12.setCaretColor(Color.WHITE);
                        textField_12.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                        textField_12.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                        textField_12.setBounds(287, 129, 263, 24);
                        panelCliente.add(textField_12);
                    }
                }
            }

            // PANEL HISTORIAL DE PAGOS
            {
                JPanel panelHistorial = new JPanel();
                panelHistorial.setLayout(null);
                panelHistorial.setBackground(new Color(102, 102, 204));
                panelHistorial.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), 
                        "Historial de Pagos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                panelHistorial.setBounds(12, 520, 616, 216);
                panel.add(panelHistorial);

                {
                    JPanel panelTabla = new JPanel();
                    panelTabla.setBackground(new Color(0, 0, 51));
                    panelTabla.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    panelTabla.setBounds(12, 33, 592, 170);
                    panelHistorial.add(panelTabla);
                }
            }

            // BOTONES DE ACCIÓN
            {
                JButton btnRealizarPago = new JButton("Realizar Pago");
                btnRealizarPago.setForeground(Color.WHITE);
                btnRealizarPago.setBackground(new Color(0, 0, 51));
                btnRealizarPago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                btnRealizarPago.setFocusPainted(false);
                btnRealizarPago.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                btnRealizarPago.setBounds(511, 800, 117, 25);
                panel.add(btnRealizarPago);
            }
            {
                JButton btnCerrarContrato = new JButton("Cerrar Contrato");
                btnCerrarContrato.setForeground(Color.WHITE);
                btnCerrarContrato.setBackground(new Color(102, 0, 0));
                btnCerrarContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                btnCerrarContrato.setFocusPainted(false);
                btnCerrarContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                btnCerrarContrato.setBounds(12, 800, 123, 25);
                panel.add(btnCerrarContrato);
            }
            {
                JLabel lblPendiente = new JLabel("PENDIENTE DE PAGO");
                lblPendiente.setForeground(Color.RED);
                lblPendiente.setFont(new Font("Segoe UI", Font.BOLD, 15));
                lblPendiente.setBounds(250, 802, 180, 16);
                panel.add(lblPendiente);
            }
        }

        // BOTONES INFERIORES
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            JButton okButton = new JButton("OK");
            okButton.setForeground(Color.WHITE);
            okButton.setBackground(new Color(0, 0, 51));
            okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            okButton.setFocusPainted(false);
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setForeground(Color.WHITE);
            cancelButton.setBackground(new Color(102, 0, 0));
            cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            cancelButton.setFocusPainted(false);
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);
        }
    }
}