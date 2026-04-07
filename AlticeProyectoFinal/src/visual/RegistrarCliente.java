package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class RegistrarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JRadioButton rbPersona;
	private JRadioButton rbEmpresa;
	private JLabel lblCedula;
	
	private ButtonGroup groupTipoCliente;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarCliente dialog = new RegistrarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarCliente() {
		setTitle("Registrar Cliente");
		setResizable(false);
		setBounds(100, 100, 614, 568);
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 51));
			panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBackground(new Color(102, 102, 204));
				panel_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
				panel_1.setBounds(8, 112, 567, 297);
				panel.add(panel_1);
				{
					JLabel label = new JLabel("Nombre");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(12, 24, 56, 16);
					panel_1.add(label);
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
					panel_1.add(textField);
				}
				{
					lblCedula = new JLabel("Cedula");
					lblCedula.setForeground(Color.WHITE);
					lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					lblCedula.setBounds(12, 88, 56, 16);
					panel_1.add(lblCedula);
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
					panel_1.add(textField_1);
				}
				{
					JLabel label = new JLabel("Telefono");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(12, 152, 56, 16);
					panel_1.add(label);
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
					panel_1.add(textField_2);
				}
				{
					JLabel label = new JLabel("Direccion");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(12, 216, 122, 16);
					panel_1.add(label);
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
					panel_1.add(textField_3);
				}
				{
					JLabel label = new JLabel("Correo electronico");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(287, 24, 122, 16);
					panel_1.add(label);
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
					panel_1.add(textField_4);
				}
				{
					JLabel label = new JLabel("Contraseña");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(287, 88, 122, 16);
					panel_1.add(label);
				}
				{
					passwordField = new JPasswordField();
					passwordField.setBackground(new Color(0, 0, 51));
					passwordField.setForeground(Color.WHITE);
					passwordField.setCaretColor(Color.WHITE);
					passwordField.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					passwordField.setBounds(287, 117, 263, 24);
					panel_1.add(passwordField);
				}
				{
					JLabel label = new JLabel("Confirmar Contraseña");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(287, 152, 154, 16);
					panel_1.add(label);
				}
				{
					passwordField_1 = new JPasswordField();
					passwordField_1.setBackground(new Color(0, 0, 51));
					passwordField_1.setForeground(Color.WHITE);
					passwordField_1.setCaretColor(Color.WHITE);
					passwordField_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					passwordField_1.setBounds(287, 181, 263, 24);
					panel_1.add(passwordField_1);
				}
			}
			{
				rbPersona = new JRadioButton("Persona");
				rbPersona.setForeground(Color.WHITE);
				rbPersona.setBackground(new Color(0, 0, 51));
				rbPersona.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				rbPersona.setSelected(true);
				rbPersona.setBounds(8, 78, 82, 25);
				panel.add(rbPersona);
				
				rbPersona.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lblCedula.setText("Cedula");
					}
				});
			}
			{
				rbEmpresa = new JRadioButton("Empresa");
				rbEmpresa.setForeground(Color.WHITE);
				rbEmpresa.setBackground(new Color(0, 0, 51));
				rbEmpresa.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				rbEmpresa.setBounds(94, 78, 127, 25);
				panel.add(rbEmpresa);
				{
					JCheckBox checkBox = new JCheckBox("Activo");
					checkBox.setSelected(true);
					checkBox.setForeground(Color.WHITE);
					checkBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
					checkBox.setBackground(new Color(102, 102, 204));
					checkBox.setBounds(260, 427, 77, 25);
					panel.add(checkBox);
				}
				{
					JLabel lblCdigo = new JLabel("C\u00F3digo");
					lblCdigo.setForeground(Color.WHITE);
					lblCdigo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					lblCdigo.setBounds(12, 16, 56, 16);
					panel.add(lblCdigo);
				}
				{
					textField_5 = new JTextField();
					textField_5.setForeground(Color.WHITE);
					textField_5.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					textField_5.setColumns(10);
					textField_5.setCaretColor(Color.WHITE);
					textField_5.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					textField_5.setBackground(new Color(0, 0, 51));
					textField_5.setBounds(12, 45, 112, 24);
					panel.add(textField_5);
				}
				
				rbEmpresa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lblCedula.setText("RNC");
					}
				});
			}
		}
		
		// ButtonGroup
		groupTipoCliente = new ButtonGroup();
		groupTipoCliente.add(rbPersona);
		groupTipoCliente.add(rbEmpresa);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 0, 51));
			buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(Color.WHITE);
				okButton.setBackground(new Color(0, 0, 51));
				okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				okButton.setFocusPainted(false);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
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
}