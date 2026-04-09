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
import logico.Contrato;
import logico.Empleado;
import logico.Persona;
import logico.Cliente;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DetallesContrato extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Contrato miContrato;

    // Campos del Contrato
    private JTextField txtCodigoContrato;
    private JTextField txtFechaInicio;
    private JTextField txtFechaCierre;

    // Campos del Empleado a cargo
    private JTextField txtNombreEmpleado;
    private JTextField txtCedulaEmpleado;
    private JTextField txtCorreoEmpleado;
    private JTextField txtTelefonoEmpleado;

    // Campos del Cliente
    private JTextField txtNombreCliente;
    private JTextField txtCedulaCliente;
    private JTextField txtCorreoCliente;
    private JTextField txtTelefonoCliente;

    // Botones de acción
    private JButton btnCerrarContrato;
    private JButton btnRealizarPago;
    private JLabel lblFechaCierre;

    public static void main(String[] args) {
        try {
            DetallesContrato dialog = new DetallesContrato(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DetallesContrato(Contrato contrato) {
        miContrato = contrato;

        setResizable(false);
        setTitle("Detalles del Contrato");
        setBounds(100, 100, 679, 945);
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

            // ====================== PANEL DATOS DEL CONTRATO ======================
            {
                JPanel panelContrato = new JPanel();
                panelContrato.setLayout(null);
                panelContrato.setBackground(new Color(102, 102, 204));
                panelContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                panelContrato.setBounds(12, 13, 616, 101);
                panel.add(panelContrato);

                JLabel lblCodigo = new JLabel("Código del Contrato");
                lblCodigo.setForeground(Color.WHITE);
                lblCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCodigo.setBounds(12, 13, 120, 16);
                panelContrato.add(lblCodigo);

                txtCodigoContrato = new JTextField();
                txtCodigoContrato.setEditable(false);
                txtCodigoContrato.setBackground(new Color(0, 0, 51));
                txtCodigoContrato.setForeground(Color.WHITE);
                txtCodigoContrato.setCaretColor(Color.WHITE);
                txtCodigoContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCodigoContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCodigoContrato.setBounds(12, 42, 150, 24);
                panelContrato.add(txtCodigoContrato);

                JLabel lblFechaInicio = new JLabel("Fecha de Inicio");
                lblFechaInicio.setForeground(Color.WHITE);
                lblFechaInicio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblFechaInicio.setBounds(180, 13, 100, 16);
                panelContrato.add(lblFechaInicio);

                txtFechaInicio = new JTextField();
                txtFechaInicio.setEditable(false);
                txtFechaInicio.setBackground(new Color(0, 0, 51));
                txtFechaInicio.setForeground(Color.WHITE);
                txtFechaInicio.setCaretColor(Color.WHITE);
                txtFechaInicio.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtFechaInicio.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtFechaInicio.setBounds(180, 42, 150, 24);
                panelContrato.add(txtFechaInicio);

                lblFechaCierre = new JLabel("Fecha de Cierre");
                lblFechaCierre.setForeground(Color.WHITE);
                lblFechaCierre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblFechaCierre.setBounds(348, 13, 100, 16);
                panelContrato.add(lblFechaCierre);

                txtFechaCierre = new JTextField();
                txtFechaCierre.setEditable(false);
                txtFechaCierre.setBackground(new Color(0, 0, 51));
                txtFechaCierre.setForeground(Color.WHITE);
                txtFechaCierre.setCaretColor(Color.WHITE);
                txtFechaCierre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtFechaCierre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtFechaCierre.setBounds(348, 42, 150, 24);
                panelContrato.add(txtFechaCierre);
            }

            // ====================== PANEL EMPLEADO A CARGO ======================
            {
                JPanel panelEmpleado = new JPanel();
                panelEmpleado.setLayout(null);
                panelEmpleado.setBackground(new Color(102, 102, 204));
                panelEmpleado.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Empleado a Cargo", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                panelEmpleado.setBounds(12, 127, 616, 180);
                panel.add(panelEmpleado);

                JLabel lblNombreEmp = new JLabel("Nombre");
                lblNombreEmp.setForeground(Color.WHITE);
                lblNombreEmp.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblNombreEmp.setBounds(12, 36, 56, 16);
                panelEmpleado.add(lblNombreEmp);

                txtNombreEmpleado = new JTextField();
                txtNombreEmpleado.setEditable(false);
                txtNombreEmpleado.setBackground(new Color(0, 0, 51));
                txtNombreEmpleado.setForeground(Color.WHITE);
                txtNombreEmpleado.setCaretColor(Color.WHITE);
                txtNombreEmpleado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtNombreEmpleado.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtNombreEmpleado.setBounds(12, 65, 280, 24);
                panelEmpleado.add(txtNombreEmpleado);

                JLabel lblCedulaEmp = new JLabel("Cédula");
                lblCedulaEmp.setForeground(Color.WHITE);
                lblCedulaEmp.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCedulaEmp.setBounds(12, 100, 56, 16);
                panelEmpleado.add(lblCedulaEmp);

                txtCedulaEmpleado = new JTextField();
                txtCedulaEmpleado.setEditable(false);
                txtCedulaEmpleado.setBackground(new Color(0, 0, 51));
                txtCedulaEmpleado.setForeground(Color.WHITE);
                txtCedulaEmpleado.setCaretColor(Color.WHITE);
                txtCedulaEmpleado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCedulaEmpleado.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCedulaEmpleado.setBounds(12, 129, 280, 24);
                panelEmpleado.add(txtCedulaEmpleado);

                JLabel lblCorreoEmp = new JLabel("Correo");
                lblCorreoEmp.setForeground(Color.WHITE);
                lblCorreoEmp.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCorreoEmp.setBounds(310, 36, 56, 16);
                panelEmpleado.add(lblCorreoEmp);

                txtCorreoEmpleado = new JTextField();
                txtCorreoEmpleado.setEditable(false);
                txtCorreoEmpleado.setBackground(new Color(0, 0, 51));
                txtCorreoEmpleado.setForeground(Color.WHITE);
                txtCorreoEmpleado.setCaretColor(Color.WHITE);
                txtCorreoEmpleado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCorreoEmpleado.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCorreoEmpleado.setBounds(310, 65, 280, 24);
                panelEmpleado.add(txtCorreoEmpleado);

                JLabel lblTelefonoEmp = new JLabel("Teléfono");
                lblTelefonoEmp.setForeground(Color.WHITE);
                lblTelefonoEmp.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblTelefonoEmp.setBounds(310, 100, 56, 16);
                panelEmpleado.add(lblTelefonoEmp);

                txtTelefonoEmpleado = new JTextField();
                txtTelefonoEmpleado.setEditable(false);
                txtTelefonoEmpleado.setBackground(new Color(0, 0, 51));
                txtTelefonoEmpleado.setForeground(Color.WHITE);
                txtTelefonoEmpleado.setCaretColor(Color.WHITE);
                txtTelefonoEmpleado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtTelefonoEmpleado.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtTelefonoEmpleado.setBounds(310, 129, 280, 24);
                panelEmpleado.add(txtTelefonoEmpleado);
            }

            // ====================== PANEL CLIENTE ======================
            {
                JPanel panelCliente = new JPanel();
                panelCliente.setLayout(null);
                panelCliente.setBackground(new Color(102, 102, 204));
                panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true),
                        "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
                panelCliente.setBounds(12, 327, 616, 180);
                panel.add(panelCliente);

                JLabel lblNombreCli = new JLabel("Nombre");
                lblNombreCli.setForeground(Color.WHITE);
                lblNombreCli.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblNombreCli.setBounds(12, 36, 56, 16);
                panelCliente.add(lblNombreCli);

                txtNombreCliente = new JTextField();
                txtNombreCliente.setEditable(false);
                txtNombreCliente.setBackground(new Color(0, 0, 51));
                txtNombreCliente.setForeground(Color.WHITE);
                txtNombreCliente.setCaretColor(Color.WHITE);
                txtNombreCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtNombreCliente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtNombreCliente.setBounds(12, 65, 280, 24);
                panelCliente.add(txtNombreCliente);

                JLabel lblCedulaCli = new JLabel("Cédula");
                lblCedulaCli.setForeground(Color.WHITE);
                lblCedulaCli.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCedulaCli.setBounds(12, 100, 56, 16);
                panelCliente.add(lblCedulaCli);

                txtCedulaCliente = new JTextField();
                txtCedulaCliente.setEditable(false);
                txtCedulaCliente.setBackground(new Color(0, 0, 51));
                txtCedulaCliente.setForeground(Color.WHITE);
                txtCedulaCliente.setCaretColor(Color.WHITE);
                txtCedulaCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCedulaCliente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCedulaCliente.setBounds(12, 129, 280, 24);
                panelCliente.add(txtCedulaCliente);

                JLabel lblCorreoCli = new JLabel("Correo");
                lblCorreoCli.setForeground(Color.WHITE);
                lblCorreoCli.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblCorreoCli.setBounds(310, 36, 56, 16);
                panelCliente.add(lblCorreoCli);

                txtCorreoCliente = new JTextField();
                txtCorreoCliente.setEditable(false);
                txtCorreoCliente.setBackground(new Color(0, 0, 51));
                txtCorreoCliente.setForeground(Color.WHITE);
                txtCorreoCliente.setCaretColor(Color.WHITE);
                txtCorreoCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtCorreoCliente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtCorreoCliente.setBounds(310, 65, 280, 24);
                panelCliente.add(txtCorreoCliente);

                JLabel lblTelefonoCli = new JLabel("Teléfono");
                lblTelefonoCli.setForeground(Color.WHITE);
                lblTelefonoCli.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblTelefonoCli.setBounds(310, 100, 56, 16);
                panelCliente.add(lblTelefonoCli);

                txtTelefonoCliente = new JTextField();
                txtTelefonoCliente.setEditable(false);
                txtTelefonoCliente.setBackground(new Color(0, 0, 51));
                txtTelefonoCliente.setForeground(Color.WHITE);
                txtTelefonoCliente.setCaretColor(Color.WHITE);
                txtTelefonoCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtTelefonoCliente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                txtTelefonoCliente.setBounds(310, 129, 280, 24);
                panelCliente.add(txtTelefonoCliente);
            }

            // ====================== BOTONES DE ACCIÓN ======================
            {
                btnRealizarPago = new JButton("Realizar Pago");
                btnRealizarPago.setForeground(Color.WHITE);
                btnRealizarPago.setBackground(new Color(0, 0, 51));
                btnRealizarPago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                btnRealizarPago.setFocusPainted(false);
                btnRealizarPago.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                btnRealizarPago.setBounds(511, 800, 117, 25);
                panel.add(btnRealizarPago);
            }
            {
                btnCerrarContrato = new JButton("Cerrar Contrato");
                btnCerrarContrato.setForeground(Color.WHITE);
                btnCerrarContrato.setBackground(new Color(102, 0, 0));
                btnCerrarContrato.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                btnCerrarContrato.setFocusPainted(false);
                btnCerrarContrato.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                btnCerrarContrato.setBounds(12, 800, 123, 25);
                panel.add(btnCerrarContrato);
            }
            
            JPanel panel_1 = new JPanel();
            panel_1.setLayout(null);
            panel_1.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "Historial de Pagos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
            panel_1.setBackground(new Color(102, 102, 204));
            panel_1.setBounds(12, 520, 616, 243);
            panel.add(panel_1);
        }

        // ====================== BOTONES INFERIORES ======================
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
            buttonPane.add(okButton);

            JButton cancelButton = new JButton("Cancelar");
            cancelButton.setForeground(Color.WHITE);
            cancelButton.setBackground(new Color(102, 0, 0));
            cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            cancelButton.setFocusPainted(false);
            cancelButton.addActionListener(e -> dispose());
            buttonPane.add(cancelButton);
        }

        if (miContrato != null) {
            loadContrato(miContrato);
        }

    }

    private void loadContrato(Contrato contrato) {
        if (contrato == null) return;

        txtCodigoContrato.setText(contrato.getCodigo());
        txtFechaInicio.setText(contrato.getFechaInicio() != null ? contrato.getFechaInicio().toString() : "");
        txtFechaCierre.setText(contrato.getFechaCierre() != null ? contrato.getFechaCierre().toString() : "");

        Empleado emp = contrato.getEmpleado();
        if (emp != null) {
            txtNombreEmpleado.setText(emp.getNombre());
            txtCedulaEmpleado.setText(emp.getCedula());
            txtCorreoEmpleado.setText(emp.getEmail());
            txtTelefonoEmpleado.setText(emp.getTelefono());
        }

        Persona cli = contrato.getCliente();
        if (cli != null) {
            txtNombreCliente.setText(cli.getNombre());
            txtCedulaCliente.setText(cli.getCedula());
            txtCorreoCliente.setText(cli.getEmail());
            txtTelefonoCliente.setText(cli.getTelefono());
        }
        
        if(contrato.isActivo())
        {
        	lblFechaCierre.setVisible(false);
        	txtFechaCierre.setVisible(false);
        }
    }
}