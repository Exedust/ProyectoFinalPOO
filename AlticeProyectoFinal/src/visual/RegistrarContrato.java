package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import logico.Altice;
import logico.Cliente;
import logico.Contrato;
import logico.Empleado;
import logico.Persona;
import logico.Plan;
import logico.Solicitud;
import logico.TipoSolicitud;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class RegistrarContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Persona selected;

	private JPanel buttonPane;
	private JButton btnAceptar;
	private JButton cancelButton;
	private JPanel panel;
	private JPanel panelExistente;
	private JLabel lblCedularnc;
	private JTextField txtCedula;
	private JButton btnBuscar;
	private JPanel panel_1;
	private JLabel lblPlan;
	private JTextField txtCodigo;
	private JLabel label_8;
	private JButton btnNuevo;
	private JComboBox<String> comboPlan;
	private JCheckBox checkInstalacion;
	private JComboBox<String> comboClientes;
	private JButton btnLimpiar;

	public static void main(String[] args) {
		try {
			RegistrarContrato dialog = new RegistrarContrato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RegistrarContrato() {
		setResizable(false);
		setTitle("Registrar Contrato");

		setBounds(100, 100, 697, 637);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			panel.setBackground(new Color(0, 0, 51));
			panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
					TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JLabel label = new JLabel("Cliente");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Segoe UI", Font.BOLD, 15));
			label.setBounds(12, 86, 53, 16);
			panel.add(label);
		}

		panelExistente = new JPanel();
		panelExistente.setLayout(null);
		panelExistente.setBackground(new Color(102, 102, 204));
		panelExistente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		panelExistente.setBounds(12, 117, 640, 200);
		panel.add(panelExistente);

		lblCedularnc = new JLabel("Cedula/RNC");
		lblCedularnc.setForeground(Color.WHITE);
		lblCedularnc.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCedularnc.setBounds(12, 13, 88, 16);
		panelExistente.add(lblCedularnc);

		txtCedula = new JTextField();
		txtCedula.setBackground(new Color(0, 0, 51));
		txtCedula.setForeground(Color.WHITE);
		txtCedula.setCaretColor(Color.WHITE);
		txtCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtCedula.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		txtCedula.setColumns(10);
		txtCedula.setBounds(12, 42, 263, 24);
		panelExistente.add(txtCedula);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(0, 0, 51));
		btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnBuscar.setFocusPainted(false);
		btnBuscar.setBounds(287, 41, 97, 25);
		panelExistente.add(btnBuscar);

		JLabel lblTelefono = new JLabel("Cliente");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTelefono.setBounds(292, 79, 56, 16);
		panelExistente.add(lblTelefono);

		comboClientes = new JComboBox<String>();
		comboClientes.setForeground(Color.WHITE);
		comboClientes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		comboClientes.setBackground(new Color(0, 0, 51));
		comboClientes.setBounds(45, 108, 550, 40);
		panelExistente.add(comboClientes);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCedula.setText("");
				buscar();
			}
		});
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnLimpiar.setFocusPainted(false);
		btnLimpiar.setBackground(new Color(0, 0, 51));
		btnLimpiar.setBounds(498, 42, 97, 25);
		panelExistente.add(btnLimpiar);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 204));
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_1.setBounds(12, 330, 640, 126);
		panel.add(panel_1);
		panel_1.setLayout(null);

		comboPlan = new JComboBox();
		comboPlan.setBackground(new Color(0, 0, 51));
		comboPlan.setForeground(Color.WHITE);
		comboPlan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comboPlan.setBounds(47, 49, 548, 33);
		panel_1.add(comboPlan);

		lblPlan = new JLabel("Plan");
		lblPlan.setForeground(Color.WHITE);
		lblPlan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPlan.setBounds(298, 13, 38, 16);
		panel_1.add(lblPlan);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setForeground(Color.WHITE);
		txtCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtCodigo.setColumns(10);
		txtCodigo.setCaretColor(Color.WHITE);
		txtCodigo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		txtCodigo.setBackground(new Color(0, 0, 51));
		txtCodigo.setBounds(12, 42, 112, 24);
		txtCodigo.setText(String.format("CO-%05d", Altice.getGenContratoid()));
		panel.add(txtCodigo);

		label_8 = new JLabel("C\u00F3digo");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		label_8.setBounds(12, 13, 56, 16);
		panel.add(label_8);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sizeAntes = Altice.getInstance().getMisClientes().size();
				RegistrarCliente registrar = new RegistrarCliente(null, true);
				registrar.setModal(true);
				registrar.setVisible(true);

				int sizeDespues = Altice.getInstance().getMisClientes().size();

				if (sizeDespues > sizeAntes) {
					selected = Altice.getInstance().getMisClientes().get(sizeDespues - 1);

					btnNuevo.setEnabled(false);
					cargarPersonasActivas();
					comboClientes.setSelectedItem(selected.getCedula() + " - " + selected.getNombre());

					cargarPlanes();

					JOptionPane.showMessageDialog(RegistrarContrato.this,
							"Cliente registrado correctamente.\nAhora puede continuar con el contrato.",
							"Cliente Agregado", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(RegistrarContrato.this, "No se registró ningún cliente nuevo.",
							"Operación Cancelada", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNuevo.setBounds(77, 84, 97, 25);
		panel.add(btnNuevo);
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnNuevo.setFocusPainted(false);
		btnNuevo.setBackground(new Color(0, 0, 51));
		{
			buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
					TitledBorder.TOP, null, Color.WHITE));
			buttonPane.setBackground(new Color(0, 0, 51));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						registrarContrato();
					}
				});
				btnAceptar.setForeground(Color.WHITE);
				btnAceptar.setBackground(new Color(0, 0, 51));
				btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				btnAceptar.setFocusPainted(false);
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBackground(new Color(102, 0, 0));
				cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				cancelButton.setFocusPainted(false);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		txtCodigo.setText(String.format("CO-%05d", Altice.getGenContratoid()));

		checkInstalacion = new JCheckBox("Requiere Instalacion");
		checkInstalacion.setSelected(true);
		checkInstalacion.setForeground(Color.WHITE);
		checkInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkInstalacion.setBackground(new Color(102, 102, 204));
		checkInstalacion.setBounds(248, 477, 174, 25);
		panel.add(checkInstalacion);

		cargarPersonasActivas();
		cargarPlanes();
	}

	private void buscar() {
		String cedula = txtCedula.getText().trim();
		comboClientes.removeAllItems();
		boolean encontrado = false;

		for (Cliente cli : Altice.getInstance().getMisClientes()) {
			if (cli.getUsuario() != null && cli.getUsuario().isActivo() && cli.getCedula() != null
					&& cli.getCedula().toLowerCase().contains(cedula.toLowerCase())) {

				String item = cli.getCedula() + " - " + cli.getNombre();
				if (!existeEnCombo(item)) {
					comboClientes.addItem(item);
					encontrado = true;
				}
			}
		}
		for (Empleado emp : Altice.getInstance().getMisEmpleados()) {
			if (emp.isActivo() && emp.getCedula() != null
					&& emp.getCedula().toLowerCase().contains(cedula.toLowerCase())) {

				String item = emp.getCedula() + " - " + emp.getNombre() + " (Empleado)";
				if (!existeEnCombo(item)) {
					comboClientes.addItem(item);
					encontrado = true;
				}
			}
		}

		if (!encontrado) {
			JOptionPane.showMessageDialog(this, "No se encontró ninguna persona activa con esa cédula.",
					"No encontrado", JOptionPane.WARNING_MESSAGE);

			cargarPersonasActivas();
		} else if (comboClientes.getItemCount() == 1) {
			comboClientes.setSelectedIndex(0);
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

	private void clean() {
		txtCedula.setText("");
		txtCedula.setEditable(true);
		btnBuscar.setVisible(true);
		btnNuevo.setEnabled(true);
		cargarPlanes();
		txtCodigo.setText(String.format("CO-%05d", Altice.getGenContratoid()));

		selected = null;

		txtCedula.requestFocus();
	}

	private void cargarPersonasActivas() {
		comboClientes.removeAllItems();

		for (Cliente cli : Altice.getInstance().getMisClientes()) {
			if (cli.getUsuario() != null && cli.getUsuario().isActivo()) {
				String item = cli.getCedula() + " - " + cli.getNombre();
				if (!existeEnCombo(item)) {
					comboClientes.addItem(item);
				}
			}
		}

		for (Empleado emp : Altice.getInstance().getMisEmpleados()) {
			if (emp.isActivo()) {
				String item = emp.getCedula() + " - " + emp.getNombre() + " (Empleado)";
				if (!existeEnCombo(item)) {
					comboClientes.addItem(item);
				}
			}
		}

		if (comboClientes.getItemCount() == 0) {
			comboClientes.addItem("No hay personas activas registradas");
		}
	}

	private void registrarContrato() {
		if (selected == null) {
			JOptionPane.showMessageDialog(this, "Debe buscar y seleccionar una persona primero.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (Altice.getInstance().tieneDeuda(selected.getCedula())) {
			JOptionPane.showMessageDialog(this,
					"El cliente tiene una deuda pendiente.\n"
							+ "No se puede registrar un nuevo contrato hasta regularizar la deuda.",
					"Deuda Pendiente", JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (comboPlan.getSelectedItem() == null || comboPlan.getSelectedItem().toString().contains("No hay planes")) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un plan válido.", "Error", JOptionPane.ERROR_MESSAGE);
			comboPlan.requestFocus();
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(this, "¿Desea registrar este contrato?", "Confirmar Registro",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (opcion != JOptionPane.YES_OPTION)
			return;

		if (registrar()) {
			JOptionPane.showMessageDialog(this, "Contrato registrado correctamente", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			if (checkInstalacion.isSelected() && selected instanceof Cliente) {
				String codigoSoli = "SOL-" + String.format("%05d", Altice.getGenSolicitudid() + 1);
				Cliente client = (Cliente) selected;
				Solicitud solicitud = new Solicitud(codigoSoli, client, TipoSolicitud.INSTALACION,
						"Instalación de equipo nuevo para el contrato " + txtCodigo.getText());

				if (Altice.getInstance().registrarSolicitud(solicitud)) {
					JOptionPane.showMessageDialog(this, "Solicitud de instalación creada correctamente", "Éxito",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this,
							"Contrato registrado, pero no se pudo crear la solicitud de instalación", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}
			}

			Altice.getInstance().producirPagos();

			clean();
			txtCedula.requestFocus();
		}
	}

	private boolean registrar() {
		if (!validar()) {
			return false;
		}

		String codigo = txtCodigo.getText();
		Plan planSeleccionado = obtenerPlanSeleccionado();

		if (planSeleccionado == null) {
			JOptionPane.showMessageDialog(this, "No se pudo obtener el plan seleccionado.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		Empleado emp = Altice.getInstance().buscarEmpleadoById(Altice.getSesion().getCodigo());

		Contrato nuevoContrato = new Contrato(codigo, emp, selected, planSeleccionado);

		return Altice.getInstance().registrarContrato(nuevoContrato);
	}

	private boolean validar() {
		if (selected == null) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar una persona.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (comboPlan.getSelectedItem() == null || comboPlan.getSelectedItem().toString().contains("No hay planes")) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un plan válido.", "Error", JOptionPane.ERROR_MESSAGE);
			comboPlan.requestFocus();
			return false;
		}

		return true;
	}

	private Plan obtenerPlanSeleccionado() {
		String itemSeleccionado = (String) comboPlan.getSelectedItem();
		if (itemSeleccionado == null)
			return null;

		String nombrePlan = itemSeleccionado.replace("EMP - ", "");

		for (Plan p : Altice.getInstance().getMisPlanes()) {
			if (p.getNombre().equalsIgnoreCase(nombrePlan) && p.isActivo()) {
				return p;
			}
		}
		return null;
	}

	private void cargarPlanes() {
		comboPlan.removeAllItems();

		boolean esEmpleado = (selected instanceof Empleado);

		for (Plan p : Altice.getInstance().getMisPlanes()) {
			if (!p.isActivo())
				continue;

			String nombrePlan = p.getNombre();

			if (esEmpleado) {
				comboPlan.addItem(nombrePlan);
			} else {
				if (!nombrePlan.startsWith("EMP")) {
					comboPlan.addItem(nombrePlan);
				}
			}
		}
		if (comboPlan.getItemCount() == 0) {
			if (esEmpleado) {
				comboPlan.addItem("No hay planes activos disponibles");
			} else {
				comboPlan.addItem("No hay planes disponibles para clientes");
			}
		}
	}
}