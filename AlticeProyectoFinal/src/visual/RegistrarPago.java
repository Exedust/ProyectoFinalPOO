package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import logico.Altice;
import logico.Cliente;
import logico.Contrato;
import logico.Pago;
import logico.Persona;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class RegistrarPago extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtCedula;
    private JComboBox<String> comboClientes;
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
        setTitle("Registrar Pago");
        setResizable(false);
        setBounds(100, 100, 629, 480);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(0, 0, 51));
        getContentPane().setLayout(new BorderLayout());

        contentPanel.setBackground(new Color(0, 0, 51));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        // ====================== PANEL CLIENTE ======================
        {
            JPanel panelCliente = new JPanel();
            panelCliente.setBackground(new Color(102, 102, 204));
            panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
            panelCliente.setBounds(12, 13, 574, 200);
            panelCliente.setLayout(null);
            contentPanel.add(panelCliente);

            JLabel lblCedula = new JLabel("Cédula");
            lblCedula.setForeground(Color.WHITE);
            lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 15));
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
            panelCliente.add(btnBuscar);

            JLabel lblCliente = new JLabel("Cliente");
            lblCliente.setForeground(Color.WHITE);
            lblCliente.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            lblCliente.setBounds(12, 80, 56, 16);
            panelCliente.add(lblCliente);

            comboClientes = new JComboBox<>();
            comboClientes.setForeground(Color.WHITE);
            comboClientes.setFont(new Font("Segoe UI", Font.BOLD, 16));
            comboClientes.setBackground(new Color(0, 0, 51));
            comboClientes.setBounds(12, 109, 550, 40);
            panelCliente.add(comboClientes);
        }

        {
            JPanel panelPago = new JPanel();
            panelPago.setLayout(null);
            panelPago.setBackground(new Color(102, 102, 204));
            panelPago.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
            panelPago.setBounds(12, 225, 574, 125);
            contentPanel.add(panelPago);

            JLabel lblSeleccionar = new JLabel("Seleccionar Pago Pendiente");
            lblSeleccionar.setForeground(Color.WHITE);
            lblSeleccionar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            lblSeleccionar.setBounds(180, 13, 200, 16);
            panelPago.add(lblSeleccionar);

            comboPagos = new JComboBox<>();
            comboPagos.setBackground(new Color(0, 0, 51));
            comboPagos.setForeground(Color.WHITE);
            comboPagos.setFont(new Font("Segoe UI", Font.BOLD, 16));
            comboPagos.setBounds(19, 44, 536, 40);
            panelPago.add(comboPagos);
        }

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
            btnRealizar.addActionListener(e -> realizarPagoSeleccionado());
            buttonPane.add(btnRealizar);

            btnCancelar = new JButton("Cancelar");
            btnCancelar.setForeground(Color.WHITE);
            btnCancelar.setBackground(new Color(102, 0, 0));
            btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnCancelar.setFocusPainted(false);
            btnCancelar.addActionListener(e -> dispose());
            buttonPane.add(btnCancelar);
        }

        btnBuscar.addActionListener(e -> buscarCliente());
        comboClientes.addActionListener(e -> cargarPagosPendientesDelClienteSeleccionado());

        cargarClientesConContratoActivo();
    }

    private void cargarClientesConContratoActivo() {
        comboClientes.removeAllItems();

        for (Contrato contrato : Altice.getInstance().getMisContratos()) {
            if (contrato.isActivo() && contrato.getCliente() != null) {
                Persona cli = contrato.getCliente();
                String item = cli.getCedula() + " - " + cli.getNombre();

                if (!existeEnCombo(item)) {
                    comboClientes.addItem(item);
                }
            }
        }

        if (comboClientes.getItemCount() == 0) {
            comboClientes.addItem("No hay clientes con contratos activos");
        }
    }

    private boolean existeEnCombo(String item) {
        for (int i = 0; i < comboClientes.getItemCount(); i++) {
            if (comboClientes.getItemAt(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    private void buscarCliente() {
        String cedula = txtCedula.getText().trim();
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una cédula", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        comboClientes.removeAllItems();
        boolean encontrado = false;

        for (Contrato contrato : Altice.getInstance().getMisContratos()) {
            if (contrato.isActivo() && contrato.getCliente() != null) {
                Persona cli = contrato.getCliente();

                if (cli.getCedula() != null && 
                    cli.getCedula().toLowerCase().contains(cedula.toLowerCase())) {
                    
                    String item = cli.getCedula() + " - " + cli.getNombre();
                    if (!existeEnCombo(item)) {
                        comboClientes.addItem(item);
                        encontrado = true;
                    }
                }
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(this,
                "No se encontró ningún cliente con contrato activo que coincida con esa cédula.",
                "No encontrado", JOptionPane.WARNING_MESSAGE);
            
            cargarClientesConContratoActivo();
        } 
        else if (comboClientes.getItemCount() == 1) {
            comboClientes.setSelectedIndex(0);
        }
    }

    private void cargarPagosPendientesDelClienteSeleccionado() {
        comboPagos.removeAllItems();

        String itemSeleccionado = (String) comboClientes.getSelectedItem();
        if (itemSeleccionado == null || itemSeleccionado.contains("No hay")) return;

        String cedula = itemSeleccionado.substring(0, itemSeleccionado.indexOf(" - ")).trim();

        ArrayList<Pago> pagosPendientes = Altice.getInstance().getPagosPendientesByCedula(cedula);

        if (pagosPendientes.isEmpty()) {
            comboPagos.addItem("No hay pagos pendientes");
            return;
        }

        for (Pago p : pagosPendientes) {
            String item = p.getCodigo() + " - Monto: RD$ " + String.format("%.2f", p.getMonto())
                        + " - Fecha: " + p.getFechaRegistro();
            comboPagos.addItem(item);
        }
    }

    private void realizarPagoSeleccionado() {
        if (comboClientes.getSelectedItem() == null || 
            comboClientes.getSelectedItem().toString().contains("No hay")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente con contrato activo", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (comboPagos.getSelectedItem() == null || 
            comboPagos.getSelectedItem().toString().contains("No hay")) {
            JOptionPane.showMessageDialog(this, "No hay pagos pendientes para realizar", 
                                        "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String itemPago = (String) comboPagos.getSelectedItem();
        String codigoPago = itemPago.substring(0, itemPago.indexOf(" - "));

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea realizar este pago?",
                "Confirmar Pago",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcion != JOptionPane.YES_OPTION) return;

        if (Altice.getInstance().realizarPago(codigoPago)) {
            JOptionPane.showMessageDialog(this, "Pago realizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarPagosPendientesDelClienteSeleccionado();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo realizar el pago", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}