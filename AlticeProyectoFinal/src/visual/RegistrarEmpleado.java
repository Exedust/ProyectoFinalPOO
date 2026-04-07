package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.JCheckBox;

public class RegistrarEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblCedula;

	// Panel de tipo de empleado y campos variables
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnComercial;
	private JRadioButton rdbtnAdministrador;
	private ButtonGroup groupTipoEmpleado;

	// Campos de salario y comisión
	private JLabel lblSalario;
	private JSpinner spinnerSalario;
	private JLabel lblComision;
	private JSpinner spinnerComision;
	private JCheckBox checkBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarEmpleado dialog = new RegistrarEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarEmpleado() {
		setTitle("Registrar Empleado");
		setResizable(false);
		setBounds(100, 100, 614, 629);
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

			// ====================== PANEL DATOS PERSONALES ======================
			{
				JPanel panelDatos = new JPanel();
				panelDatos.setLayout(null);
				panelDatos.setBackground(new Color(102, 102, 204));
				panelDatos.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
				panelDatos.setBounds(8, 13, 567, 297);
				panel.add(panelDatos);

				{
					JLabel label = new JLabel("Nombre");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(12, 24, 56, 16);
					panelDatos.add(label);
				}
				{
					textField = new JTextField();
					textField.setBackground(new Color(0, 0, 51));
					textField.setForeground(Color.WHITE);
					textField.setCaretColor(Color.WHITE);
					textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					textField.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					textField.setColumns(10);
					textField.setBounds(12, 53, 263, 24);
					panelDatos.add(textField);
				}
				{
					lblCedula = new JLabel("Cedula");
					lblCedula.setForeground(Color.WHITE);
					lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					lblCedula.setBounds(12, 88, 56, 16);
					panelDatos.add(lblCedula);
				}
				{
					textField_1 = new JTextField();
					textField_1.setBackground(new Color(0, 0, 51));
					textField_1.setForeground(Color.WHITE);
					textField_1.setCaretColor(Color.WHITE);
					textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					textField_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					textField_1.setColumns(10);
					textField_1.setBounds(12, 117, 263, 24);
					panelDatos.add(textField_1);
				}
				{
					JLabel label = new JLabel("Telefono");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(12, 152, 56, 16);
					panelDatos.add(label);
				}
				{
					textField_2 = new JTextField();
					textField_2.setBackground(new Color(0, 0, 51));
					textField_2.setForeground(Color.WHITE);
					textField_2.setCaretColor(Color.WHITE);
					textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					textField_2.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					textField_2.setColumns(10);
					textField_2.setBounds(12, 181, 263, 24);
					panelDatos.add(textField_2);
				}
				{
					JLabel label = new JLabel("Direccion");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(12, 216, 122, 16);
					panelDatos.add(label);
				}
				{
					textField_3 = new JTextField();
					textField_3.setBackground(new Color(0, 0, 51));
					textField_3.setForeground(Color.WHITE);
					textField_3.setCaretColor(Color.WHITE);
					textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					textField_3.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					textField_3.setColumns(10);
					textField_3.setBounds(12, 245, 263, 24);
					panelDatos.add(textField_3);
				}
				{
					JLabel label = new JLabel("Correo electronico");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(287, 24, 122, 16);
					panelDatos.add(label);
				}
				{
					textField_4 = new JTextField();
					textField_4.setBackground(new Color(0, 0, 51));
					textField_4.setForeground(Color.WHITE);
					textField_4.setCaretColor(Color.WHITE);
					textField_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					textField_4.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					textField_4.setColumns(10);
					textField_4.setBounds(287, 53, 263, 24);
					panelDatos.add(textField_4);
				}
				{
					JLabel label = new JLabel("Contraseña");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(287, 88, 122, 16);
					panelDatos.add(label);
				}
				{
					passwordField = new JPasswordField();
					passwordField.setBackground(new Color(0, 0, 51));
					passwordField.setForeground(Color.WHITE);
					passwordField.setCaretColor(Color.WHITE);
					passwordField.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					passwordField.setBounds(287, 117, 263, 24);
					panelDatos.add(passwordField);
				}
				{
					JLabel label = new JLabel("Confirmar Contraseña");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(287, 152, 154, 16);
					panelDatos.add(label);
				}
				{
					passwordField_1 = new JPasswordField();
					passwordField_1.setBackground(new Color(0, 0, 51));
					passwordField_1.setForeground(Color.WHITE);
					passwordField_1.setCaretColor(Color.WHITE);
					passwordField_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					passwordField_1.setBounds(287, 181, 263, 24);
					panelDatos.add(passwordField_1);
				}
			}

			// ====================== PANEL TIPO DE EMPLEADO ======================
			{
				JPanel panelTipo = new JPanel();
				panelTipo.setForeground(Color.WHITE);
				panelTipo.setBackground(new Color(102, 102, 204));
				panelTipo.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
				panelTipo.setBounds(137, 323, 324, 143);
				panel.add(panelTipo);
				panelTipo.setLayout(null);

				// Radio Buttons
				rdbtnTecnico = new JRadioButton("Técnico");
				rdbtnTecnico.setForeground(Color.WHITE);
				rdbtnTecnico.setBackground(new Color(102, 102, 204));
				rdbtnTecnico.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				rdbtnTecnico.setSelected(true);
				rdbtnTecnico.setBounds(19, 9, 82, 25);
				panelTipo.add(rdbtnTecnico);

				rdbtnComercial = new JRadioButton("Comercial");
				rdbtnComercial.setForeground(Color.WHITE);
				rdbtnComercial.setBackground(new Color(102, 102, 204));
				rdbtnComercial.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				rdbtnComercial.setBounds(19, 55, 96, 25);
				panelTipo.add(rdbtnComercial);

				rdbtnAdministrador = new JRadioButton("Administrador");
				rdbtnAdministrador.setForeground(Color.WHITE);
				rdbtnAdministrador.setBackground(new Color(102, 102, 204));
				rdbtnAdministrador.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				rdbtnAdministrador.setBounds(19, 101, 131, 25);
				panelTipo.add(rdbtnAdministrador);

				// Salario (visible para todos)
				lblSalario = new JLabel("Salario");
				lblSalario.setForeground(Color.WHITE);
				lblSalario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				lblSalario.setBounds(185, 9, 47, 16);
				panelTipo.add(lblSalario);

				spinnerSalario = new JSpinner();
				spinnerSalario.setForeground(new Color(255, 255, 255));
				spinnerSalario.setBackground(new Color(51, 51, 102));
				spinnerSalario.setBounds(185, 38, 82, 22);
				panelTipo.add(spinnerSalario);

				// Comisión (solo para Comercial y Administrador)
				lblComision = new JLabel("Comisión");
				lblComision.setForeground(Color.WHITE);
				lblComision.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				lblComision.setBounds(185, 73, 59, 16);
				panelTipo.add(lblComision);

				spinnerComision = new JSpinner();
				spinnerComision.setBounds(185, 102, 82, 22);
				panelTipo.add(spinnerComision);

				// ButtonGroup
				groupTipoEmpleado = new ButtonGroup();
				groupTipoEmpleado.add(rdbtnTecnico);
				groupTipoEmpleado.add(rdbtnComercial);
				groupTipoEmpleado.add(rdbtnAdministrador);
				{
					checkBox = new JCheckBox("Activo");
					checkBox.setSelected(true);
					checkBox.setForeground(Color.WHITE);
					checkBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
					checkBox.setBackground(new Color(102, 102, 204));
					checkBox.setBounds(260, 483, 77, 25);
					panel.add(checkBox);
				}

				// ActionListeners para mostrar/ocultar comisión
				ActionListener tipoListener = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (rdbtnTecnico.isSelected()) {
							lblComision.setVisible(false);
							spinnerComision.setVisible(false);
						} else {
							lblComision.setVisible(true);
							spinnerComision.setVisible(true);
						}
					}
				};

				rdbtnTecnico.addActionListener(tipoListener);
				rdbtnComercial.addActionListener(tipoListener);
				rdbtnAdministrador.addActionListener(tipoListener);

				// Estado inicial (Técnico seleccionado)
				lblComision.setVisible(false);
				spinnerComision.setVisible(false);
			}
		}

		// ====================== BOTONES OK / CANCEL ======================
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