package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.Altice;
import logico.Empleado;
import logico.Rol;
import logico.Solicitud;

import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class AsignarSolicitud extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtTipo;
	private JTextField txtNombreCliente;
	private JTextField txtDireccion;
	private JTextField txtCedulaCliente;
	private JTextField txtTelefono;
	private JComboBox<String> comboTecnicos;
	private JTextPane txtDescripcion;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private Solicitud solicitudActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AsignarSolicitud dialog = new AsignarSolicitud(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AsignarSolicitud(Solicitud solicitud) {
        this.solicitudActual = solicitud;

        setTitle("Asignar Solicitud");
        setResizable(false);
        setBounds(100, 100, 634, 714);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(0, 0, 51));
        getContentPane().setLayout(new BorderLayout());

        contentPanel.setBackground(new Color(0, 0, 51));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        // ====================== PANEL DATOS DE LA SOLICITUD ======================
        {
            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            panel.setBackground(new Color(102, 102, 204));
            panel.setBounds(12, 13, 600, 222);
            contentPanel.add(panel);

            JLabel label = new JLabel("Código");
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            label.setBounds(12, 13, 140, 16);
            panel.add(label);

            txtCodigo = new JTextField();
            txtCodigo.setEditable(false);
            txtCodigo.setForeground(Color.WHITE);
            txtCodigo.setCaretColor(Color.WHITE);
            txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtCodigo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtCodigo.setBackground(new Color(0, 0, 51));
            txtCodigo.setBounds(12, 42, 180, 24);
            panel.add(txtCodigo);

            JLabel label_1 = new JLabel("Tipo de Solicitud");
            label_1.setForeground(Color.WHITE);
            label_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            label_1.setBounds(287, 13, 140, 16);
            panel.add(label_1);

            txtTipo = new JTextField();
            txtTipo.setEditable(false);
            txtTipo.setForeground(Color.WHITE);
            txtTipo.setCaretColor(Color.WHITE);
            txtTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtTipo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtTipo.setBackground(new Color(0, 0, 51));
            txtTipo.setBounds(287, 42, 180, 24);
            panel.add(txtTipo);

            JLabel label_4 = new JLabel("Nombre del Cliente");
            label_4.setForeground(Color.WHITE);
            label_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            label_4.setBounds(12, 82, 140, 16);
            panel.add(label_4);

            txtNombreCliente = new JTextField();
            txtNombreCliente.setEditable(false);
            txtNombreCliente.setForeground(Color.WHITE);
            txtNombreCliente.setCaretColor(Color.WHITE);
            txtNombreCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtNombreCliente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtNombreCliente.setBackground(new Color(0, 0, 51));
            txtNombreCliente.setBounds(12, 111, 263, 24);
            panel.add(txtNombreCliente);

            JLabel label_5 = new JLabel("Dirección");
            label_5.setForeground(Color.WHITE);
            label_5.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            label_5.setBounds(12, 138, 56, 16);
            panel.add(label_5);

            txtDireccion = new JTextField();
            txtDireccion.setEditable(false);
            txtDireccion.setForeground(Color.WHITE);
            txtDireccion.setCaretColor(Color.WHITE);
            txtDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtDireccion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtDireccion.setBackground(new Color(0, 0, 51));
            txtDireccion.setBounds(12, 167, 263, 24);
            panel.add(txtDireccion);

            JLabel label_6 = new JLabel("Cédula");
            label_6.setForeground(Color.WHITE);
            label_6.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            label_6.setBounds(287, 82, 100, 16);
            panel.add(label_6);

            txtCedulaCliente = new JTextField();
            txtCedulaCliente.setEditable(false);
            txtCedulaCliente.setForeground(Color.WHITE);
            txtCedulaCliente.setCaretColor(Color.WHITE);
            txtCedulaCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtCedulaCliente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtCedulaCliente.setBackground(new Color(0, 0, 51));
            txtCedulaCliente.setBounds(287, 111, 263, 24);
            panel.add(txtCedulaCliente);

            JLabel label_7 = new JLabel("Teléfono");
            label_7.setForeground(Color.WHITE);
            label_7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            label_7.setBounds(287, 138, 122, 16);
            panel.add(label_7);

            txtTelefono = new JTextField();
            txtTelefono.setEditable(false);
            txtTelefono.setForeground(Color.WHITE);
            txtTelefono.setCaretColor(Color.WHITE);
            txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtTelefono.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtTelefono.setBackground(new Color(0, 0, 51));
            txtTelefono.setBounds(287, 167, 263, 24);
            panel.add(txtTelefono);
        }

        // ====================== PANEL DESCRIPCIÓN ======================
        {
            JPanel panel_2 = new JPanel();
            panel_2.setLayout(null);
            panel_2.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), 
                    "Descripción de la Solicitud", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            panel_2.setBackground(new Color(102, 102, 204));
            panel_2.setBounds(12, 248, 600, 149);
            contentPanel.add(panel_2);

            txtDescripcion = new JTextPane();
            txtDescripcion.setEditable(false);
            txtDescripcion.setForeground(Color.WHITE);
            txtDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtDescripcion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtDescripcion.setBackground(new Color(0, 0, 51));
            txtDescripcion.setBounds(12, 40, 576, 80);
            panel_2.add(txtDescripcion);
        }

        // ====================== PANEL ASIGNACIÓN TÉCNICO ======================
        {
            JPanel panel_1 = new JPanel();
            panel_1.setLayout(null);
            panel_1.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), 
                    "Asignar Técnico", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            panel_1.setBackground(new Color(102, 102, 204));
            panel_1.setBounds(12, 410, 600, 166);
            contentPanel.add(panel_1);

            JLabel lblTécnico = new JLabel("T\u00E9cnico");
            lblTécnico.setForeground(Color.WHITE);
            lblTécnico.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            lblTécnico.setBounds(259, 25, 140, 16);
            panel_1.add(lblTécnico);

            comboTecnicos = new JComboBox<>();
            comboTecnicos.setForeground(Color.WHITE);
            comboTecnicos.setFont(new Font("Segoe UI", Font.BOLD, 14));
            comboTecnicos.setBackground(new Color(0, 0, 51));
            comboTecnicos.setBounds(12, 54, 550, 40);
            panel_1.add(comboTecnicos);
        }

        // ====================== BOTONES INFERIORES ======================
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            btnAceptar = new JButton("Asignar Técnico");
            btnAceptar.setForeground(Color.WHITE);
            btnAceptar.setBackground(new Color(0, 0, 51));
            btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnAceptar.setFocusPainted(false);
            btnAceptar.addActionListener(e -> asignarTecnico());
            buttonPane.add(btnAceptar);
            getRootPane().setDefaultButton(btnAceptar);

            btnCancelar = new JButton("Cancelar");
            btnCancelar.setForeground(Color.WHITE);
            btnCancelar.setBackground(new Color(102, 0, 0));
            btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnCancelar.setFocusPainted(false);
            btnCancelar.addActionListener(e -> dispose());
            buttonPane.add(btnCancelar);
        }

        cargarDatosSolicitud();
        cargarTecnicosDisponibles();
    }

    private void cargarDatosSolicitud() {
        if (solicitudActual == null) return;

        txtCodigo.setText(solicitudActual.getCodigo());
        txtTipo.setText(solicitudActual.getTipo().name());
        txtDescripcion.setText(solicitudActual.getDescripcion());

        if (solicitudActual.getCliente() != null) {
            txtNombreCliente.setText(solicitudActual.getCliente().getNombre());
            txtCedulaCliente.setText(solicitudActual.getCliente().getCedula());
            txtTelefono.setText(solicitudActual.getCliente().getTelefono());
            txtDireccion.setText(solicitudActual.getCliente().getDireccion());
        }
    }

    private void cargarTecnicosDisponibles() {
        comboTecnicos.removeAllItems();

        for (Empleado emp : Altice.getInstance().getMisEmpleados()) {
            if (emp.getRol() == Rol.TECNICO && Altice.getInstance().estaDisponibleTecnico(emp.getCodigo())) {
                comboTecnicos.addItem(emp.getCodigo() + " - " + emp.getNombre());
            }
        }

        if (comboTecnicos.getItemCount() == 0) {
            comboTecnicos.addItem("No hay técnicos disponibles en este momento");
        }
    }

    private void asignarTecnico() {
        if (comboTecnicos.getSelectedItem() == null || 
            comboTecnicos.getSelectedItem().toString().contains("No hay técnicos")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un técnico disponible.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de asignar esta solicitud al técnico seleccionado?",
                "Confirmar Asignación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcion != JOptionPane.YES_OPTION) return;

        String item = comboTecnicos.getSelectedItem().toString();
        String codigoTecnico = item.split(" - ")[0];

        if (Altice.getInstance().asignarTecnicoASolicitud(solicitudActual.getCodigo(), codigoTecnico)) {
            JOptionPane.showMessageDialog(this, "Solicitud asignada correctamente", 
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo asignar la solicitud", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
