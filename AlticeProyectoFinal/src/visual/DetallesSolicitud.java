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
import logico.Solicitud;
import logico.Cliente;
import logico.Empleado;
import logico.Persona;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class DetallesSolicitud extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Solicitud miSolicitud;

    private JTextField txtCodigo;
    private JTextField txtTipo;
    private JTextPane txtDescripcion;
    private JTextField txtClienteNombre;
    private JTextField txtClienteCedula;
    private JTextField txtEmpleadoAsignado;
    private JTextField txtEstado;
    private JTextField txtFechaRegistro;
    private JTextField txtFechaAtencion;

    private JLabel lblDescripcion;
    private JTextField txtTelefono;
    private JTextField txtDireccion;

    public DetallesSolicitud(Solicitud solicitud) {
        this.miSolicitud = solicitud;

        setResizable(false);
        setTitle("Detalles de Solicitud");
        setBounds(100, 100, 650, 780);
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
                JPanel panelInfo = new JPanel();
                panelInfo.setLayout(null);
                panelInfo.setBackground(new Color(102, 102, 204));
                panelInfo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                panelInfo.setBounds(12, 13, 600, 235);
                panel.add(panelInfo);

                {
                    JLabel lblCodigo = new JLabel("C\u00F3digo");
                    lblCodigo.setForeground(Color.WHITE);
                    lblCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblCodigo.setBounds(12, 13, 140, 16);
                    panelInfo.add(lblCodigo);
                }
                {
                    txtCodigo = new JTextField();
                    txtCodigo.setEditable(false);
                    txtCodigo.setBackground(new Color(0, 0, 51));
                    txtCodigo.setForeground(Color.WHITE);
                    txtCodigo.setCaretColor(Color.WHITE);
                    txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtCodigo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtCodigo.setBounds(12, 42, 180, 24);
                    panelInfo.add(txtCodigo);
                }
                {
                    JLabel lblTipo = new JLabel("Tipo de Solicitud");
                    lblTipo.setForeground(Color.WHITE);
                    lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblTipo.setBounds(12, 80, 140, 16);
                    panelInfo.add(lblTipo);
                }
                {
                    txtTipo = new JTextField();
                    txtTipo.setEditable(false);
                    txtTipo.setBackground(new Color(0, 0, 51));
                    txtTipo.setForeground(Color.WHITE);
                    txtTipo.setCaretColor(Color.WHITE);
                    txtTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtTipo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtTipo.setBounds(12, 109, 180, 24);
                    panelInfo.add(txtTipo);
                }
                {
                    JLabel lblEstado = new JLabel("Estado");
                    lblEstado.setForeground(Color.WHITE);
                    lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblEstado.setBounds(220, 80, 100, 16);
                    panelInfo.add(lblEstado);
                }
                {
                    txtEstado = new JTextField();
                    txtEstado.setEditable(false);
                    txtEstado.setBackground(new Color(0, 0, 51));
                    txtEstado.setForeground(Color.WHITE);
                    txtEstado.setCaretColor(Color.WHITE);
                    txtEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtEstado.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtEstado.setBounds(220, 109, 180, 24);
                    panelInfo.add(txtEstado);
                }
                {
                    JLabel lblFechaRegistro = new JLabel("Fecha de Registro");
                    lblFechaRegistro.setForeground(Color.WHITE);
                    lblFechaRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblFechaRegistro.setBounds(12, 150, 140, 16);
                    panelInfo.add(lblFechaRegistro);
                }
                {
                    txtFechaRegistro = new JTextField();
                    txtFechaRegistro.setEditable(false);
                    txtFechaRegistro.setBackground(new Color(0, 0, 51));
                    txtFechaRegistro.setForeground(Color.WHITE);
                    txtFechaRegistro.setCaretColor(Color.WHITE);
                    txtFechaRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtFechaRegistro.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtFechaRegistro.setBounds(12, 179, 180, 24);
                    panelInfo.add(txtFechaRegistro);
                }
                {
                    JLabel lblFechaAtencion = new JLabel("Fecha de Atención");
                    lblFechaAtencion.setForeground(Color.WHITE);
                    lblFechaAtencion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblFechaAtencion.setBounds(220, 150, 140, 16);
                    panelInfo.add(lblFechaAtencion);
                }
                {
                    txtFechaAtencion = new JTextField();
                    txtFechaAtencion.setEditable(false);
                    txtFechaAtencion.setBackground(new Color(0, 0, 51));
                    txtFechaAtencion.setForeground(Color.WHITE);
                    txtFechaAtencion.setCaretColor(Color.WHITE);
                    txtFechaAtencion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtFechaAtencion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtFechaAtencion.setBounds(220, 179, 180, 24);
                    panelInfo.add(txtFechaAtencion);
                }
            }

            {
                JPanel panelClienteInfo = new JPanel();
                panelClienteInfo.setLayout(null);
                panelClienteInfo.setBackground(new Color(102, 102, 204));
                panelClienteInfo.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
                panelClienteInfo.setBounds(12, 261, 600, 135);
                panel.add(panelClienteInfo);

                {
                    JLabel lblClienteNombre = new JLabel("Nombre del Cliente");
                    lblClienteNombre.setForeground(Color.WHITE);
                    lblClienteNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblClienteNombre.setBounds(12, 13, 140, 16);
                    panelClienteInfo.add(lblClienteNombre);
                }
                {
                    txtClienteNombre = new JTextField();
                    txtClienteNombre.setEditable(false);
                    txtClienteNombre.setBackground(new Color(0, 0, 51));
                    txtClienteNombre.setForeground(Color.WHITE);
                    txtClienteNombre.setCaretColor(Color.WHITE);
                    txtClienteNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtClienteNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtClienteNombre.setBounds(12, 42, 263, 24);
                    panelClienteInfo.add(txtClienteNombre);
                }
                {
                    JLabel lblClienteCedula = new JLabel("Cédula");
                    lblClienteCedula.setForeground(Color.WHITE);
                    lblClienteCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblClienteCedula.setBounds(287, 13, 100, 16);
                    panelClienteInfo.add(lblClienteCedula);
                }
                {
                    txtClienteCedula = new JTextField();
                    txtClienteCedula.setEditable(false);
                    txtClienteCedula.setBackground(new Color(0, 0, 51));
                    txtClienteCedula.setForeground(Color.WHITE);
                    txtClienteCedula.setCaretColor(Color.WHITE);
                    txtClienteCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtClienteCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtClienteCedula.setBounds(287, 42, 263, 24);
                    panelClienteInfo.add(txtClienteCedula);
                }
                
                JLabel lblTelefono = new JLabel("Telefono");
                lblTelefono.setForeground(Color.WHITE);
                lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblTelefono.setBounds(287, 69, 122, 16);
                panelClienteInfo.add(lblTelefono);
                
                txtTelefono = new JTextField();
                txtTelefono.setForeground(Color.WHITE);
                txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtTelefono.setEditable(false);
                txtTelefono.setCaretColor(Color.WHITE);
                txtTelefono.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtTelefono.setBackground(new Color(0, 0, 51));
                txtTelefono.setBounds(287, 98, 263, 24);
                panelClienteInfo.add(txtTelefono);
                
                JLabel lblDireccion = new JLabel("Direccion");
                lblDireccion.setForeground(Color.WHITE);
                lblDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblDireccion.setBounds(12, 69, 56, 16);
                panelClienteInfo.add(lblDireccion);
                
                txtDireccion = new JTextField();
                txtDireccion.setForeground(Color.WHITE);
                txtDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtDireccion.setEditable(false);
                txtDireccion.setCaretColor(Color.WHITE);
                txtDireccion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtDireccion.setBackground(new Color(0, 0, 51));
                txtDireccion.setBounds(12, 98, 263, 24);
                panelClienteInfo.add(txtDireccion);
            }

            {
                JPanel panelEmpleado = new JPanel();
                panelEmpleado.setLayout(null);
                panelEmpleado.setBackground(new Color(102, 102, 204));
                panelEmpleado.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
                panelEmpleado.setBounds(12, 409, 600, 80);
                panel.add(panelEmpleado);

                {
                    JLabel lblEmpleado = new JLabel("Empleado a cargo");
                    lblEmpleado.setForeground(Color.WHITE);
                    lblEmpleado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblEmpleado.setBounds(12, 13, 140, 16);
                    panelEmpleado.add(lblEmpleado);
                }
                {
                    txtEmpleadoAsignado = new JTextField();
                    txtEmpleadoAsignado.setEditable(false);
                    txtEmpleadoAsignado.setBackground(new Color(0, 0, 51));
                    txtEmpleadoAsignado.setForeground(Color.WHITE);
                    txtEmpleadoAsignado.setCaretColor(Color.WHITE);
                    txtEmpleadoAsignado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtEmpleadoAsignado.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtEmpleadoAsignado.setBounds(12, 42, 400, 24);
                    panelEmpleado.add(txtEmpleadoAsignado);
                }
            }

            {
                JPanel panelDescripcion = new JPanel();
                panelDescripcion.setLayout(null);
                panelDescripcion.setBackground(new Color(102, 102, 204));
                panelDescripcion.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
                panelDescripcion.setBounds(12, 502, 600, 149);
                panel.add(panelDescripcion);

                {
                    lblDescripcion = new JLabel("Descripción");
                    lblDescripcion.setForeground(Color.WHITE);
                    lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblDescripcion.setBounds(12, 13, 100, 16);
                    panelDescripcion.add(lblDescripcion);
                }
                {
                    txtDescripcion = new JTextPane();
                    txtDescripcion.setEditable(false);
                    txtDescripcion.setBackground(new Color(0, 0, 51));
                    txtDescripcion.setForeground(Color.WHITE);
                    txtDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    txtDescripcion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                    txtDescripcion.setBounds(12, 40, 576, 80);
                    panelDescripcion.add(txtDescripcion);
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

            JButton btnCerrar = new JButton("Salir");
            btnCerrar.setForeground(Color.WHITE);
            btnCerrar.setBackground(new Color(102, 0, 0));
            btnCerrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnCerrar.setFocusPainted(false);
            btnCerrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            buttonPane.add(btnCerrar);
        }

        if (miSolicitud != null) {
            loadSolicitud();
        }
    }

    private void loadSolicitud() {
        if (miSolicitud == null) return;

        txtCodigo.setText(miSolicitud.getCodigo() != null ? miSolicitud.getCodigo() : "");
        txtTipo.setText(miSolicitud.getTipo() != null ? miSolicitud.getTipo().name() : "SIN TIPO");
        txtDescripcion.setText(miSolicitud.getDescripcion() != null ? miSolicitud.getDescripcion() : "");
        txtEstado.setText(miSolicitud.getEstado() != null ? miSolicitud.getEstado().name() : "DESCONOCIDO");

        txtFechaRegistro.setText(miSolicitud.getFechaRegistro() != null ? 
                miSolicitud.getFechaRegistro().toString() : "");

        txtFechaAtencion.setText(miSolicitud.getFechaAtencion() != null ? 
                miSolicitud.getFechaAtencion().toString() : "");

        Persona cli = miSolicitud.getCliente();
        if (cli != null) {
            txtClienteNombre.setText(cli.getNombre() != null ? cli.getNombre() : "N/A");
            txtClienteCedula.setText(cli.getCedula() != null ? cli.getCedula() : "N/A");
            txtDireccion.setText(cli.getDireccion());
            txtTelefono.setText(cli.getTelefono());
        } else {
            txtClienteNombre.setText("N/A");
            txtClienteCedula.setText("N/A");
        }

        Empleado emp = miSolicitud.getEmpleado();
        if (emp != null) {
            txtEmpleadoAsignado.setText(emp.getNombre() != null ? emp.getCedula() + " - " + emp.getNombre(): "No asignado");
        } else {
            txtEmpleadoAsignado.setText("No asignado");
        }
    }
}