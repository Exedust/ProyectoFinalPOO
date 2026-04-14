package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import logico.Altice;
import logico.Pago;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistrarPagoDirecto extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Pago miPago;

    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JTextField txtDireccion;
    private JTextField txtCodigoContrato;
    private JTextField txtPlan;
    private JTextField txtMonto;

    private JButton btnRealizar;
    private JButton btnCancelar;


    public RegistrarPagoDirecto(Pago pago) {
        miPago = pago;

        setTitle("Realizar Pago");
        setResizable(false);
        setBounds(100, 100, 629, 647);
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
            panel.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            contentPanel.add(panel, BorderLayout.CENTER);
            panel.setLayout(null);

            // ====================== PANEL CLIENTE ======================
            {
                JPanel panelCliente = new JPanel();
                panelCliente.setLayout(null);
                panelCliente.setBackground(new Color(102, 102, 204));
                panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                panelCliente.setBounds(12, 13, 574, 255);
                panel.add(panelCliente);

                JLabel lblCedula = new JLabel("Cédula");
                lblCedula.setForeground(Color.WHITE);
                lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCedula.setBounds(12, 33, 56, 16);
                panelCliente.add(lblCedula);

                txtCedula = new JTextField();
                txtCedula.setEditable(false);
                txtCedula.setBackground(new Color(0, 0, 51));
                txtCedula.setForeground(Color.WHITE);
                txtCedula.setCaretColor(Color.WHITE);
                txtCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCedula.setBounds(12, 62, 263, 24);
                panelCliente.add(txtCedula);

                JLabel lblNombre = new JLabel("Nombre");
                lblNombre.setForeground(Color.WHITE);
                lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblNombre.setBounds(12, 99, 56, 16);
                panelCliente.add(lblNombre);

                txtNombre = new JTextField();
                txtNombre.setEditable(false);
                txtNombre.setBackground(new Color(0, 0, 51));
                txtNombre.setForeground(Color.WHITE);
                txtNombre.setCaretColor(Color.WHITE);
                txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtNombre.setBounds(12, 128, 263, 24);
                panelCliente.add(txtNombre);

                JLabel lblTelefono = new JLabel("Teléfono");
                lblTelefono.setForeground(Color.WHITE);
                lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblTelefono.setBounds(12, 163, 56, 16);
                panelCliente.add(lblTelefono);

                txtTelefono = new JTextField();
                txtTelefono.setEditable(false);
                txtTelefono.setBackground(new Color(0, 0, 51));
                txtTelefono.setForeground(Color.WHITE);
                txtTelefono.setCaretColor(Color.WHITE);
                txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtTelefono.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtTelefono.setBounds(12, 192, 263, 24);
                panelCliente.add(txtTelefono);

                JLabel lblCorreo = new JLabel("Correo");
                lblCorreo.setForeground(Color.WHITE);
                lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCorreo.setBounds(287, 99, 56, 16);
                panelCliente.add(lblCorreo);

                txtCorreo = new JTextField();
                txtCorreo.setEditable(false);
                txtCorreo.setBackground(new Color(0, 0, 51));
                txtCorreo.setForeground(Color.WHITE);
                txtCorreo.setCaretColor(Color.WHITE);
                txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCorreo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCorreo.setBounds(287, 128, 263, 24);
                panelCliente.add(txtCorreo);

                JLabel lblDireccion = new JLabel("Dirección");
                lblDireccion.setForeground(Color.WHITE);
                lblDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblDireccion.setBounds(287, 33, 56, 16);
                panelCliente.add(lblDireccion);

                txtDireccion = new JTextField();
                txtDireccion.setEditable(false);
                txtDireccion.setBackground(new Color(0, 0, 51));
                txtDireccion.setForeground(Color.WHITE);
                txtDireccion.setCaretColor(Color.WHITE);
                txtDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtDireccion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtDireccion.setBounds(287, 62, 263, 24);
                panelCliente.add(txtDireccion);
            }

            // ====================== PANEL CONTRATO ======================
            {
                JPanel panelContrato = new JPanel();
                panelContrato.setLayout(null);
                panelContrato.setBackground(new Color(102, 102, 204));
                panelContrato.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Contrato", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                panelContrato.setBounds(12, 281, 574, 122);
                panel.add(panelContrato);

                JLabel lblCodigoContrato = new JLabel("Código Contrato");
                lblCodigoContrato.setForeground(Color.WHITE);
                lblCodigoContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCodigoContrato.setBounds(12, 30, 100, 16);
                panelContrato.add(lblCodigoContrato);

                txtCodigoContrato = new JTextField();
                txtCodigoContrato.setEditable(false);
                txtCodigoContrato.setBackground(new Color(0, 0, 51));
                txtCodigoContrato.setForeground(Color.WHITE);
                txtCodigoContrato.setCaretColor(Color.WHITE);
                txtCodigoContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCodigoContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCodigoContrato.setBounds(12, 59, 150, 24);
                panelContrato.add(txtCodigoContrato);

                JLabel lblPlan = new JLabel("Plan");
                lblPlan.setForeground(Color.WHITE);
                lblPlan.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblPlan.setBounds(180, 30, 56, 16);
                panelContrato.add(lblPlan);

                txtPlan = new JTextField();
                txtPlan.setEditable(false);
                txtPlan.setBackground(new Color(0, 0, 51));
                txtPlan.setForeground(Color.WHITE);
                txtPlan.setCaretColor(Color.WHITE);
                txtPlan.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtPlan.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtPlan.setBounds(180, 59, 370, 24);
                panelContrato.add(txtPlan);
            }

            // ====================== PANEL MONTO ======================
            {
                JPanel panelMonto = new JPanel();
                panelMonto.setLayout(null);
                panelMonto.setBackground(new Color(102, 102, 204));
                panelMonto.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                panelMonto.setBounds(12, 416, 574, 108);
                panel.add(panelMonto);

                JLabel lblMonto = new JLabel("Monto a Pagar");
                lblMonto.setFont(new Font("Segoe UI", Font.BOLD, 15));
                lblMonto.setForeground(Color.WHITE);
                lblMonto.setBounds(240, 13, 120, 16);
                panelMonto.add(lblMonto);

                txtMonto = new JTextField();
                txtMonto.setEditable(false);
                txtMonto.setHorizontalAlignment(JTextField.CENTER);
                txtMonto.setBackground(new Color(0, 0, 51));
                txtMonto.setForeground(Color.WHITE);
                txtMonto.setCaretColor(Color.WHITE);
                txtMonto.setFont(new Font("Segoe UI", Font.BOLD, 18));
                txtMonto.setBorder(new LineBorder(new Color(150, 150, 220), 2, true));
                txtMonto.setBounds(225, 42, 150, 45);
                panelMonto.add(txtMonto);
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

            btnRealizar = new JButton("Realizar Pago");
            btnRealizar.setForeground(Color.WHITE);
            btnRealizar.setBackground(new Color(0, 0, 51));
            btnRealizar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnRealizar.setFocusPainted(false);
            btnRealizar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    realizarPago();
                }
            });
            buttonPane.add(btnRealizar);
            getRootPane().setDefaultButton(btnRealizar);

            btnCancelar = new JButton("Cancelar");
            btnCancelar.setForeground(Color.WHITE);
            btnCancelar.setBackground(new Color(102, 0, 0));
            btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnCancelar.setFocusPainted(false);
            btnCancelar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            buttonPane.add(btnCancelar);
        }

        // Cargar datos si se pasó un pago
        if (miPago != null) {
            loadPago(miPago);
        }
    }

    // ====================== MÉTODO LOAD PAGO ======================
    private void loadPago(Pago pago) {
        if (pago == null) return;

        txtCedula.setText(pago.getCliente().getCedula());
        txtNombre.setText(pago.getCliente().getNombre());
        txtTelefono.setText(pago.getCliente().getTelefono());
        txtCorreo.setText(pago.getCliente().getEmail());
        txtDireccion.setText(pago.getCliente().getDireccion());

        txtCodigoContrato.setText(pago.getContrato() != null ? pago.getContrato().getCodigo() : "N/A");
        txtPlan.setText(pago.getContrato() != null && pago.getContrato().getPlan() != null 
                        ? pago.getContrato().getPlan().getNombre() : "N/A");

        txtMonto.setText(String.format("RD$ %.2f", pago.getMonto()));
    }

    // ====================== REALIZAR PAGO ======================
    private void realizarPago() {
        if (miPago == null) {
            JOptionPane.showMessageDialog(this, "No hay pago seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea realizar este pago por RD$ " + String.format("%.2f", miPago.getMonto()) + "?",
                "Confirmar Pago",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcion != JOptionPane.YES_OPTION) return;

        if (Altice.getInstance().realizarPago(miPago.getCodigo())) {
            JOptionPane.showMessageDialog(this, "Pago realizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo realizar el pago.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}