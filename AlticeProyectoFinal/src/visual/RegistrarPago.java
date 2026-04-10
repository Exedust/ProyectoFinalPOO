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
import logico.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.ArrayList;

public class RegistrarPago extends JDialog {

    private final JPanel contentPanel = new JPanel();

    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JTextField txtDireccion;

    private JComboBox<String> comboPagos;

    private JButton btnBuscar;
    private JButton btnRealizar;
    private JButton btnCancelar;

    public static void main(String[] args) {
        try {
            RegistrarPago dialog = new RegistrarPago();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegistrarPago() {
        setBackground(new Color(0, 0, 51));
        setTitle("Registrar Pago");
        setResizable(false);
        setBounds(100, 100, 629, 489);
        setLocationRelativeTo(null);

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
                panelCliente.setBackground(new Color(102, 102, 204));
                panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
                panelCliente.setBounds(12, 13, 574, 222);
                panel.add(panelCliente);
                panelCliente.setLayout(null);

                JLabel lblCedula = new JLabel("Cédula");
                lblCedula.setForeground(Color.WHITE);
                lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCedula.setBounds(12, 13, 56, 16);
                panelCliente.add(lblCedula);

                txtCedula = new JTextField();
                txtCedula.setBackground(new Color(0, 0, 51));
                txtCedula.setForeground(Color.WHITE);
                txtCedula.setCaretColor(Color.WHITE);
                txtCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCedula.setBounds(12, 42, 263, 24);
                panelCliente.add(txtCedula);

                btnBuscar = new JButton("Buscar");
                btnBuscar.setForeground(Color.WHITE);
                btnBuscar.setBackground(new Color(0, 0, 51));
                btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                btnBuscar.setFocusPainted(false);
                btnBuscar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                btnBuscar.setBounds(287, 42, 97, 25);
                btnBuscar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        buscarCliente();
                    }
                });
                panelCliente.add(btnBuscar);

                JLabel lblNombre = new JLabel("Nombre");
                lblNombre.setForeground(Color.WHITE);
                lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblNombre.setBounds(12, 79, 56, 16);
                panelCliente.add(lblNombre);

                txtNombre = new JTextField();
                txtNombre.setEditable(false);
                txtNombre.setBackground(new Color(0, 0, 51));
                txtNombre.setForeground(Color.WHITE);
                txtNombre.setCaretColor(Color.WHITE);
                txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtNombre.setBounds(12, 108, 263, 24);
                panelCliente.add(txtNombre);

                JLabel lblTelefono = new JLabel("Teléfono");
                lblTelefono.setForeground(Color.WHITE);
                lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblTelefono.setBounds(12, 143, 56, 16);
                panelCliente.add(lblTelefono);

                txtTelefono = new JTextField();
                txtTelefono.setEditable(false);
                txtTelefono.setBackground(new Color(0, 0, 51));
                txtTelefono.setForeground(Color.WHITE);
                txtTelefono.setCaretColor(Color.WHITE);
                txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtTelefono.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtTelefono.setBounds(12, 172, 263, 24);
                panelCliente.add(txtTelefono);

                JLabel lblCorreo = new JLabel("Correo");
                lblCorreo.setForeground(Color.WHITE);
                lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCorreo.setBounds(287, 79, 56, 16);
                panelCliente.add(lblCorreo);

                txtCorreo = new JTextField();
                txtCorreo.setEditable(false);
                txtCorreo.setBackground(new Color(0, 0, 51));
                txtCorreo.setForeground(Color.WHITE);
                txtCorreo.setCaretColor(Color.WHITE);
                txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCorreo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCorreo.setBounds(287, 108, 263, 24);
                panelCliente.add(txtCorreo);

                JLabel lblDireccion = new JLabel("Dirección");
                lblDireccion.setForeground(Color.WHITE);
                lblDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblDireccion.setBounds(287, 143, 56, 16);
                panelCliente.add(lblDireccion);

                txtDireccion = new JTextField();
                txtDireccion.setEditable(false);
                txtDireccion.setBackground(new Color(0, 0, 51));
                txtDireccion.setForeground(Color.WHITE);
                txtDireccion.setCaretColor(Color.WHITE);
                txtDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtDireccion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtDireccion.setBounds(287, 172, 263, 24);
                panelCliente.add(txtDireccion);
            }

            // ====================== PANEL SELECCIÓN DE PAGO ======================
            {
                JPanel panelPago = new JPanel();
                panelPago.setLayout(null);
                panelPago.setBackground(new Color(102, 102, 204));
                panelPago.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
                panelPago.setBounds(12, 248, 574, 122);
                panel.add(panelPago);

                JLabel lblSeleccionar = new JLabel("Seleccionar Pago Pendiente");
                lblSeleccionar.setForeground(Color.WHITE);
                lblSeleccionar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblSeleccionar.setBounds(200, 13, 180, 16);
                panelPago.add(lblSeleccionar);

                comboPagos = new JComboBox<>();
                comboPagos.setBackground(new Color(0, 0, 51));
                comboPagos.setForeground(Color.WHITE);
                comboPagos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                comboPagos.setBounds(19, 44, 536, 33);
                panelPago.add(comboPagos);
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
                    realizarPagoSeleccionado();
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
    }

    // ====================== BUSCAR CLIENTE ======================
    private void buscarCliente() {
        String cedula = txtCedula.getText().trim();
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una cédula", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Persona cliente = Altice.getInstance().buscarPersonaByCedula(cedula);

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado con esa cédula", "Error", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
            return;
        }

        txtNombre.setText(cliente.getNombre());
        txtTelefono.setText(cliente.getTelefono());
        txtCorreo.setText(cliente.getEmail());
        txtDireccion.setText(cliente.getDireccion());

        ArrayList<Pago> pagosPendientes = Altice.getInstance().getPagosPendientesByCedula(cedula);

        if (pagosPendientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "El cliente está al día.\nNo tiene pagos pendientes.", 
                "Información", JOptionPane.INFORMATION_MESSAGE);
            
            comboPagos.removeAllItems();
            comboPagos.addItem("No hay pagos pendientes");
            return;
        }

        comboPagos.removeAllItems();
        for (Pago p : pagosPendientes) {
            String item = p.getCodigo() + " - RD$ " + String.format("%.2f", p.getMonto()) 
                        + " - " + p.getFechaRegistro();
            comboPagos.addItem(item);
        }
    }

    // ====================== REALIZAR PAGO SELECCIONADO ======================
    private void realizarPagoSeleccionado() {
        if (comboPagos.getSelectedItem() == null || 
            comboPagos.getSelectedItem().toString().contains("No hay")) {
            
            JOptionPane.showMessageDialog(this, "No hay pagos pendientes para realizar", 
                                        "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String item = comboPagos.getSelectedItem().toString();
        String codigoPago = item.substring(0, item.indexOf(" - "));

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea realizar este pago?",
                "Confirmar Pago",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcion != JOptionPane.YES_OPTION) return;

        if (Altice.getInstance().realizarPago(codigoPago)) {
            JOptionPane.showMessageDialog(this, "Pago realizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            buscarCliente(); // Recargar la información
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo realizar el pago", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        comboPagos.removeAllItems();
    }
}