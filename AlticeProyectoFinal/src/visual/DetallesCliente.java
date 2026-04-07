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
import javax.swing.JCheckBox;

public class DetallesCliente extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;          // Nombre
    private JTextField textField_1;        // Cedula
    private JTextField textField_2;        // Telefono
    private JTextField textField_3;        // Direccion
    private JTextField textField_4;        // Correo
    private JPasswordField passwordField;  // Contraseña oculta
    private JTextField textField_5;        // Código
    private JTextField passwordMostrar;    // Contraseña visible

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            DetallesCliente dialog = new DetallesCliente();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public DetallesCliente() {
        setResizable(false);
        setTitle("Detalles del Cliente");
        setBounds(100, 100, 625, 761);
        
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

                // Nombre
                {
                    JLabel label = new JLabel("Nombre");
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label.setBounds(12, 79, 56, 16);
                    panel_1.add(label);
                }
                {
                    textField = new JTextField();
                    textField.setEditable(false);
                    textField.setBackground(new Color(0, 0, 51));
                    textField.setForeground(Color.WHITE);
                    textField.setCaretColor(Color.WHITE);
                    textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    textField.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    textField.setBounds(12, 108, 263, 24);
                    panel_1.add(textField);
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
                    textField_1 = new JTextField();
                    textField_1.setEditable(false);
                    textField_1.setBackground(new Color(0, 0, 51));
                    textField_1.setForeground(Color.WHITE);
                    textField_1.setCaretColor(Color.WHITE);
                    textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    textField_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    textField_1.setBounds(12, 172, 263, 24);
                    panel_1.add(textField_1);
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
                    textField_2 = new JTextField();
                    textField_2.setEditable(false);
                    textField_2.setBackground(new Color(0, 0, 51));
                    textField_2.setForeground(Color.WHITE);
                    textField_2.setCaretColor(Color.WHITE);
                    textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    textField_2.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    textField_2.setBounds(12, 236, 263, 24);
                    panel_1.add(textField_2);
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
                    textField_3 = new JTextField();
                    textField_3.setEditable(false);
                    textField_3.setBackground(new Color(0, 0, 51));
                    textField_3.setForeground(Color.WHITE);
                    textField_3.setCaretColor(Color.WHITE);
                    textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    textField_3.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    textField_3.setBounds(287, 172, 263, 24);
                    panel_1.add(textField_3);
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
                    textField_4 = new JTextField();
                    textField_4.setEditable(false);
                    textField_4.setBackground(new Color(0, 0, 51));
                    textField_4.setForeground(Color.WHITE);
                    textField_4.setCaretColor(Color.WHITE);
                    textField_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    textField_4.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    textField_4.setBounds(287, 108, 263, 24);
                    panel_1.add(textField_4);
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
                    passwordField = new JPasswordField();
                    passwordField.setEditable(false);
                    passwordField.setBackground(new Color(0, 0, 51));
                    passwordField.setForeground(Color.WHITE);
                    passwordField.setCaretColor(Color.WHITE);
                    passwordField.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    passwordField.setBounds(287, 236, 263, 24);
                    panel_1.add(passwordField);
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

                // Checkbox Activo
                {
                    JCheckBox chckbxNewCheckBox = new JCheckBox("Activo");
                    chckbxNewCheckBox.setSelected(true);
                    chckbxNewCheckBox.setForeground(Color.WHITE);
                    chckbxNewCheckBox.setBackground(new Color(102, 102, 204));
                    chckbxNewCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chckbxNewCheckBox.setBounds(12, 273, 113, 25);
                    panel_1.add(chckbxNewCheckBox);
                }

                // Botón Mostrar Contraseña
                {
                    JButton btnMostrar = new JButton("Mostrar Contraseña");
                    btnMostrar.setForeground(Color.WHITE);
                    btnMostrar.setBackground(new Color(0, 0, 51));
                    btnMostrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    btnMostrar.setFocusPainted(false);
                    btnMostrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    btnMostrar.setBounds(405, 273, 145, 25);
                    panel_1.add(btnMostrar);

                    // Funcionalidad básica del botón (mostrar/ocultar contraseña)
                    btnMostrar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (passwordMostrar.isVisible()) {
                                passwordMostrar.setVisible(false);
                                passwordField.setVisible(true);
                                btnMostrar.setText("Mostrar Contraseña");
                            } else {
                                passwordMostrar.setText(new String(passwordField.getPassword()));
                                passwordMostrar.setVisible(true);
                                passwordField.setVisible(false);
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
                        "Historial de Contratos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                panel_2.setBounds(12, 372, 567, 216);
                panel.add(panel_2);

                {
                    JPanel panel_3 = new JPanel();
                    panel_3.setBackground(new Color(0, 0, 51));
                    panel_3.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    panel_3.setBounds(12, 33, 543, 170);
                    panel_2.add(panel_3);
                    // Aquí irá tu JTable o lista de contratos más adelante
                }
            }

            // ====================== BOTONES DE ACCIÓN ======================
            {
                JButton btnRealizarPago = new JButton("Realizar Pago");
                btnRealizarPago.setForeground(Color.WHITE);
                btnRealizarPago.setBackground(new Color(0, 0, 51));
                btnRealizarPago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                btnRealizarPago.setFocusPainted(false);
                btnRealizarPago.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                btnRealizarPago.setBounds(462, 610, 117, 25);
                panel.add(btnRealizarPago);
            }
            {
                JButton btnCerrarContrato = new JButton("Cerrar Contrato");
                btnCerrarContrato.setForeground(Color.WHITE);
                btnCerrarContrato.setBackground(new Color(102, 0, 0)); // Rojo oscuro
                btnCerrarContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                btnCerrarContrato.setFocusPainted(false);
                btnCerrarContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                btnCerrarContrato.setBounds(12, 610, 123, 25);
                panel.add(btnCerrarContrato);
            }
        }

        // ====================== BOTONES INFERIORES OK / CANCEL ======================
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