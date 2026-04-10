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
import logico.Empleado;
import logico.Persona;
import logico.Rol;
import logico.Solicitud;
import logico.TipoSolicitud;

public class RegistrarSolicitud extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Solicitud miSolicitud;
    private boolean cerrarAlRegistrar;

    private JTextField txtCedula;
    private JComboBox<TipoSolicitud> comboTipo;
    private JTextPane txtDescripcion;

    private JButton okButton;
    private JButton cancelButton;
    private JTextField txtCodigo;
    private JComboBox<String> comboClientes;
    private JButton btnBuscar;
    private JButton Limpiar;

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
        setBounds(100, 100, 629, 645);
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
                panelCliente.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
                panelCliente.setBounds(12, 46, 574, 222);
                panel.add(panelCliente);
                panelCliente.setLayout(null);

                {
                    JLabel lblCedula = new JLabel("Cédula / RNC");
                    lblCedula.setForeground(Color.WHITE);
                    lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 15));
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
                    btnBuscar = new JButton("Buscar");
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
                	JLabel lblCliente = new JLabel("Cliente");
                	lblCliente.setForeground(Color.WHITE);
                	lblCliente.setFont(new Font("Segoe UI", Font.PLAIN, 15));
                	lblCliente.setBounds(259, 93, 55, 16);
                	panelCliente.add(lblCliente);
                }
                {
                	comboClientes = new JComboBox<String>();
                	comboClientes.setForeground(Color.WHITE);
                	comboClientes.setFont(new Font("Segoe UI", Font.BOLD, 16));
                	comboClientes.setBackground(new Color(0, 0, 51));
                	comboClientes.setBounds(12, 122, 550, 40);
                	panelCliente.add(comboClientes);
                }
                {
                	Limpiar = new JButton("Limpiar");
                	Limpiar.addActionListener(new ActionListener() {
                		public void actionPerformed(ActionEvent e) {
                			txtCedula.setText("");
                			buscarCliente();
                			
                		}
                	});
                	Limpiar.setForeground(Color.WHITE);
                	Limpiar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                	Limpiar.setFocusPainted(false);
                	Limpiar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                	Limpiar.setBackground(new Color(0, 0, 51));
                	Limpiar.setBounds(465, 42, 97, 25);
                	panelCliente.add(Limpiar);
                }
            }

            // ====================== PANEL DATOS DE LA SOLICITUD ======================
            {
                JPanel panelSolicitud = new JPanel();
                panelSolicitud.setLayout(null);
                panelSolicitud.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
                panelSolicitud.setBackground(new Color(102, 102, 204));
                panelSolicitud.setBounds(12, 281, 574, 223);
                panel.add(panelSolicitud);

                {
                    JLabel lblTipo = new JLabel("Tipo de Solicitud");
                    lblTipo.setForeground(Color.WHITE);
                    lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
                    lblTipo.setBounds(229, 15, 120, 16);
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
                    lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
                    lblDescripcion.setBounds(240, 79, 93, 16);
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
            {
            	JLabel label = new JLabel("C\u00F3digo");
            	label.setForeground(Color.WHITE);
            	label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            	label.setBounds(12, 17, 56, 16);
            	panel.add(label);
            }
            {
            	txtCodigo = new JTextField();
            	txtCodigo.setText("SOL-00000");
            	txtCodigo.setForeground(Color.WHITE);
            	txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            	txtCodigo.setEditable(false);
            	txtCodigo.setColumns(10);
            	txtCodigo.setCaretColor(Color.WHITE);
            	txtCodigo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            	txtCodigo.setBackground(new Color(0, 0, 51));
            	txtCodigo.setBounds(67, 13, 112, 24);
            	panel.add(txtCodigo);
            }
        }

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            okButton = new JButton("Aceptar");
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
        txtCodigo.setText("SOL-" + String.format("%05d", Altice.getGenSolicitudid()+1));
        cargarTiposSolicitud();
        cargarClientesActivos();

        if (miSolicitud != null) {
            loadSolicitud();  
        }
    }

    private void cargarTiposSolicitud() {
        comboTipo.removeAllItems();
        for (TipoSolicitud tipo : TipoSolicitud.values()) {
            comboTipo.addItem(tipo);
        }
    }

    private void loadSolicitud() {
        if (miSolicitud == null) return;

        Persona cliente = miSolicitud.getCliente();

        txtCedula.setText(cliente != null ? cliente.getCedula() : "");

        txtCedula.setEditable(false);           
        comboTipo.setSelectedItem(miSolicitud.getTipo());
        comboTipo.setEnabled(false);            
        txtDescripcion.setText(miSolicitud.getDescripcion());
    }

    private void buscarCliente() {
        String cedula = txtCedula.getText().trim();

        comboClientes.removeAllItems();
        boolean encontrado = false;
        for (Cliente cli : Altice.getInstance().getMisClientes()) {
            if (cli.getUsuario() != null && cli.getUsuario().isActivo() &&
                cli.getCedula() != null && 
                cli.getCedula().toLowerCase().contains(cedula.toLowerCase())) {
                
                String item = cli.getCedula() + " - " + cli.getNombre();
                comboClientes.addItem(item);
                encontrado = true;
            }
        }

        if (!encontrado) {
            Empleado emp = Altice.getInstance().buscarEmpleadoByCedula(cedula);
            if (emp != null) {
                JOptionPane.showMessageDialog(this,
                    "Los empleados no pueden realizar solicitudes.",
                    "Acción no permitida", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                    "No se encontró ningún cliente activo con esa cédula.",
                    "No encontrado", JOptionPane.WARNING_MESSAGE);
            }
            
            cargarClientesActivos();
            return;
        }
        if (comboClientes.getItemCount() == 1) {
            comboClientes.setSelectedIndex(0);
        }
    }

    private void registrarSolicitud() {
        if (comboTipo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de solicitud", "Error", JOptionPane.ERROR_MESSAGE);
            comboTipo.requestFocus();
            return;
        }

        if (txtDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una descripción", "Error", JOptionPane.ERROR_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }
        if (comboClientes.getSelectedItem() == null || 
            comboClientes.getSelectedItem().toString().contains("No hay")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente válido", 
                "Error", JOptionPane.ERROR_MESSAGE);
            comboClientes.requestFocus();
            return;
        }

        TipoSolicitud tipo = (TipoSolicitud) comboTipo.getSelectedItem();
        String descripcion = txtDescripcion.getText().trim();
        if (miSolicitud != null) {
            miSolicitud.setDescripcion(descripcion);
            if (Altice.getInstance().modificarSolicitud(miSolicitud)) {
                JOptionPane.showMessageDialog(this, "Solicitud modificada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar la solicitud", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return;
        }

        String itemCliente = (String) comboClientes.getSelectedItem();
        String cedula = itemCliente.substring(0, itemCliente.indexOf(" - ")).trim();

        Persona persona = Altice.getInstance().buscarPersonaByCedula(cedula);

        if (!(persona instanceof Cliente)) {
            JOptionPane.showMessageDialog(this, "Solo los clientes pueden crear solicitudes.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = (Cliente) persona;

        int nuevoId = Altice.getGenSolicitudid() + 1;
        String codigo = "SOL-" + String.format("%05d", nuevoId);

        Solicitud nuevaSolicitud = new Solicitud(codigo, cliente, tipo, descripcion);

        if (Altice.getInstance().registrarSolicitud(nuevaSolicitud)) {
            JOptionPane.showMessageDialog(this, "Solicitud registrada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            if(Altice.getSesion().getRol() == Rol.TECNICO)
            {
            	Altice.getInstance().asignarTecnicoASolicitud(codigo, Altice.getSesion().getCodigo());
            	JOptionPane.showMessageDialog(this, "Se te ha asignado a esta solicitud correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            if (cerrarAlRegistrar) {
                dispose();
            } else {
                txtCedula.setText("");
                txtDescripcion.setText("");
                txtCodigo.setText("SOL-" + String.format("%05d", Altice.getGenSolicitudid()+1));
                comboTipo.setSelectedIndex(0);
                comboClientes.setSelectedIndex(0);
                txtCedula.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la solicitud", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void cargarClientesActivos() {
        comboClientes.removeAllItems();

        for (Cliente cli : Altice.getInstance().getMisClientes()) {
            if (cli.getUsuario() != null && cli.getUsuario().isActivo()) {
                String item = cli.getCedula() + " - " + cli.getNombre();
                comboClientes.addItem(item);
            }
        }

        if (comboClientes.getItemCount() == 0) {
            comboClientes.addItem("No hay clientes activos registrados");
        }
    }
}