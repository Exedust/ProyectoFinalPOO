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
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import logico.Altice;
import logico.Cliente;
import logico.Persona;
import logico.Solicitud;
import logico.TipoSolicitud;

public class RegistrarSolicitud extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Solicitud miSolicitud;
    private boolean cerrarAlRegistrar;

    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JTextField txtDireccion;
    private JComboBox<TipoSolicitud> comboTipo;
    private JTextPane txtDescripcion;

    private JButton okButton;
    private JButton cancelButton;

    public static void main(String[] args) {
        try {
            RegistrarSolicitud dialog = new RegistrarSolicitud(null, false);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegistrarSolicitud(Solicitud solicitud, boolean cerrarAlRegistrar) {
        this.miSolicitud = solicitud;
        this.cerrarAlRegistrar = cerrarAlRegistrar;

        setTitle(miSolicitud == null ? "Registrar Solicitud" : "Modificar Solicitud");
        setResizable(false);
        setBounds(100, 100, 629, 597);
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

            // ====================== PANEL DATOS DEL CLIENTE ======================
            {
                JPanel panelCliente = new JPanel();
                panelCliente.setBackground(new Color(102, 102, 204));
                panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                panelCliente.setBounds(12, 13, 574, 222);
                panel.add(panelCliente);
                panelCliente.setLayout(null);

                {
                    JLabel lblCedula = new JLabel("Cédula / RNC");
                    lblCedula.setForeground(Color.WHITE);
                    lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblCedula.setBounds(12, 13, 90, 16);
                    panelCliente.add(lblCedula);
                }
                {
                    txtCedula = new JTextField();
                    txtCedula.setBackground(new Color(0, 0, 51));
                    txtCedula.setForeground(Color.WHITE);
                    txtCedula.setCaretColor(Color.WHITE);
                    txtCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtCedula.setBounds(12, 42, 263, 24);
                    panelCliente.add(txtCedula);
                }
                {
                    JButton btnBuscar = new JButton("Buscar");
                    btnBuscar.setForeground(Color.WHITE);
                    btnBuscar.setBackground(new Color(0, 0, 51));
                    btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    btnBuscar.setFocusPainted(false);
                    btnBuscar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    btnBuscar.setBounds(287, 42, 97, 25);
                    btnBuscar.addActionListener(e -> buscarCliente());
                    panelCliente.add(btnBuscar);
                }
                {
                    JLabel lblNombre = new JLabel("Nombre");
                    lblNombre.setForeground(Color.WHITE);
                    lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblNombre.setBounds(12, 79, 56, 16);
                    panelCliente.add(lblNombre);
                }
                {
                    txtNombre = new JTextField();
                    txtNombre.setEditable(false);
                    txtNombre.setBackground(new Color(60, 60, 100));
                    txtNombre.setForeground(Color.WHITE);
                    txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtNombre.setBounds(12, 108, 263, 24);
                    panelCliente.add(txtNombre);
                }
                {
                    JLabel lblTelefono = new JLabel("Teléfono");
                    lblTelefono.setForeground(Color.WHITE);
                    lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblTelefono.setBounds(12, 143, 56, 16);
                    panelCliente.add(lblTelefono);
                }
                {
                    txtTelefono = new JTextField();
                    txtTelefono.setEditable(false);
                    txtTelefono.setBackground(new Color(60, 60, 100));
                    txtTelefono.setForeground(Color.WHITE);
                    txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtTelefono.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtTelefono.setBounds(12, 172, 263, 24);
                    panelCliente.add(txtTelefono);
                }
                {
                    JLabel lblCorreo = new JLabel("Correo");
                    lblCorreo.setForeground(Color.WHITE);
                    lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblCorreo.setBounds(287, 79, 56, 16);
                    panelCliente.add(lblCorreo);
                }
                {
                    txtCorreo = new JTextField();
                    txtCorreo.setEditable(false);
                    txtCorreo.setBackground(new Color(60, 60, 100));
                    txtCorreo.setForeground(Color.WHITE);
                    txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtCorreo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtCorreo.setBounds(287, 108, 263, 24);
                    panelCliente.add(txtCorreo);
                }
                {
                    JLabel lblDireccion = new JLabel("Dirección");
                    lblDireccion.setForeground(Color.WHITE);
                    lblDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblDireccion.setBounds(287, 143, 56, 16);
                    panelCliente.add(lblDireccion);
                }
                {
                    txtDireccion = new JTextField();
                    txtDireccion.setEditable(false);
                    txtDireccion.setBackground(new Color(60, 60, 100));
                    txtDireccion.setForeground(Color.WHITE);
                    txtDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtDireccion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtDireccion.setBounds(287, 172, 263, 24);
                    panelCliente.add(txtDireccion);
                }
            }

            // ====================== PANEL DATOS DE LA SOLICITUD ======================
            {
                JPanel panelSolicitud = new JPanel();
                panelSolicitud.setLayout(null);
                panelSolicitud.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Datos de la Solicitud", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                panelSolicitud.setBackground(new Color(102, 102, 204));
                panelSolicitud.setBounds(12, 248, 574, 223);
                panel.add(panelSolicitud);

                {
                    JLabel lblTipo = new JLabel("Tipo de Solicitud");
                    lblTipo.setForeground(Color.WHITE);
                    lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblTipo.setBounds(248, 13, 120, 16);
                    panelSolicitud.add(lblTipo);
                }
                {
                    comboTipo = new JComboBox<>();
                    comboTipo.setBackground(new Color(0, 0, 51));
                    comboTipo.setForeground(Color.WHITE);
                    comboTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    comboTipo.setBounds(203, 44, 167, 28);
                    panelSolicitud.add(comboTipo);
                }
                {
                    JLabel lblDescripcion = new JLabel("Descripción");
                    lblDescripcion.setForeground(Color.WHITE);
                    lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblDescripcion.setBounds(248, 79, 77, 16);
                    panelSolicitud.add(lblDescripcion);
                }
                {
                    txtDescripcion = new JTextPane();
                    txtDescripcion.setBackground(new Color(0, 0, 51));
                    txtDescripcion.setForeground(Color.WHITE);
                    txtDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtDescripcion.setBounds(82, 108, 410, 91);
                    panelSolicitud.add(txtDescripcion);
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

            okButton = new JButton("OK");
            okButton.setForeground(Color.WHITE);
            okButton.setBackground(new Color(0, 0, 51));
            okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            okButton.setFocusPainted(false);
            okButton.addActionListener(e -> registrarSolicitud());
            buttonPane.add(okButton);

            cancelButton = new JButton("Cancelar");
            cancelButton.setForeground(Color.WHITE);
            cancelButton.setBackground(new Color(102, 0, 0));
            cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            cancelButton.setFocusPainted(false);
            cancelButton.addActionListener(e -> dispose());
            buttonPane.add(cancelButton);
        }

        cargarTiposSolicitud();
    }

    private void cargarTiposSolicitud() {
        comboTipo.removeAllItems();
        for (TipoSolicitud tipo : TipoSolicitud.values()) {
            comboTipo.addItem(tipo);
        }
    }

    private void buscarCliente() {
        String cedula = txtCedula.getText().trim();
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una cédula o RNC", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Persona persona = Altice.getInstance().buscarPersonaByCedula(cedula);

        if (persona == null) {
            JOptionPane.showMessageDialog(this, "No se encontró ningún cliente con esa cédula.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!(persona instanceof Cliente)) {
            JOptionPane.showMessageDialog(this, "Solo se pueden crear solicitudes para clientes.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Cliente cliente = (Cliente) persona;

        // ASIGNACIÓN CORRECTA DE CAMPOS
        txtNombre.setText(cliente.getNombre());
        txtTelefono.setText(cliente.getTelefono());
        txtCorreo.setText(cliente.getEmail() != null ? cliente.getEmail() : "");
        txtDireccion.setText(cliente.getDireccion() != null ? cliente.getDireccion() : "");
    }

    private void registrarSolicitud() {
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe buscar y seleccionar un cliente primero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (comboTipo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de solicitud", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una descripción", "Error", JOptionPane.ERROR_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }

        // Obtener cliente
        Cliente cliente = (Cliente) Altice.getInstance().buscarPersonaByCedula(txtCedula.getText().trim());
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        TipoSolicitud tipo = (TipoSolicitud) comboTipo.getSelectedItem();
        String descripcion = txtDescripcion.getText().trim();

        // Generar código automático
        String codigo = "SOL-" + String.format("%04d", Altice.getInstance().getGenSolicitudid() + 1);

        // Crear la solicitud
        Solicitud nuevaSolicitud = new Solicitud(codigo, cliente, tipo, descripcion);

        // Registrar en Altice
        if (Altice.getInstance().registrarSolicitud(nuevaSolicitud)) {
            JOptionPane.showMessageDialog(this, "Solicitud registrada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            if (cerrarAlRegistrar) {
                dispose();
            } else {
                // Limpiar para registrar otra
                txtCedula.setText("");
                txtNombre.setText("");
                txtTelefono.setText("");
                txtCorreo.setText("");
                txtDireccion.setText("");
                txtDescripcion.setText("");
                comboTipo.setSelectedIndex(0);
                txtCedula.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la solicitud", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}