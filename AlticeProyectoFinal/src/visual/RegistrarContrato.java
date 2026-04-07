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
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class RegistrarContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private ButtonGroup groupCliente;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JRadioButton rbNuevo;
	private JRadioButton rbExistente;
	private JPanel panelNuevo;
	private JPanel panelExistente;
	private JLabel label_9;
	private JTextField textField_12;
	private JButton btnBuscar;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JPanel panel_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblPlan;
	private JTextField textField_4;
	private JLabel label_8;

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
		setBounds(100, 100, 697, 762);
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			panel.setBackground(new Color(0, 0, 51));
			panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel label = new JLabel("Cliente");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Segoe UI", Font.BOLD, 15));
			label.setBounds(12, 86, 53, 16);
			panel.add(label);
			
			rbNuevo = new JRadioButton("Nuevo");
			rbNuevo.setForeground(Color.WHITE);
			rbNuevo.setBackground(new Color(0, 0, 51));
			rbNuevo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			rbNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanel("nuevo");
				}
			});
			rbNuevo.setSelected(true);
			rbNuevo.setBounds(73, 83, 85, 25);
			panel.add(rbNuevo);
			
			rbExistente = new JRadioButton("Existente");
			rbExistente.setForeground(Color.WHITE);
			rbExistente.setBackground(new Color(0, 0, 51));
			rbExistente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			rbExistente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanel("existente");
				}
			});
			rbExistente.setBounds(162, 83, 127, 25);
			panel.add(rbExistente);
			
			panelNuevo = new JPanel();
			panelNuevo.setLayout(null);
			panelNuevo.setBackground(new Color(102, 102, 204));
			panelNuevo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
			panelNuevo.setBounds(12, 115, 640, 290);
			panel.add(panelNuevo);
			
			JLabel label_1 = new JLabel("Nombre");
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			label_1.setBounds(12, 13, 56, 16);
			panelNuevo.add(label_1);
			
			textField = new JTextField();
			textField.setBackground(new Color(0, 0, 51));
			textField.setForeground(Color.WHITE);
			textField.setCaretColor(Color.WHITE);
			textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			textField.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
			textField.setColumns(10);
			textField.setBounds(12, 42, 263, 24);
			panelNuevo.add(textField);
			
			JLabel label_2 = new JLabel("Cedula");
			label_2.setForeground(Color.WHITE);
			label_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			label_2.setBounds(12, 77, 56, 16);
			panelNuevo.add(label_2);
			
			textField_1 = new JTextField();
			textField_1.setBackground(new Color(0, 0, 51));
			textField_1.setForeground(Color.WHITE);
			textField_1.setCaretColor(Color.WHITE);
			textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			textField_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
			textField_1.setColumns(10);
			textField_1.setBounds(12, 106, 263, 24);
			panelNuevo.add(textField_1);
			
			JLabel label_3 = new JLabel("Telefono");
			label_3.setForeground(Color.WHITE);
			label_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			label_3.setBounds(12, 141, 56, 16);
			panelNuevo.add(label_3);
			
			textField_2 = new JTextField();
			textField_2.setBackground(new Color(0, 0, 51));
			textField_2.setForeground(Color.WHITE);
			textField_2.setCaretColor(Color.WHITE);
			textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			textField_2.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
			textField_2.setColumns(10);
			textField_2.setBounds(12, 170, 263, 24);
			panelNuevo.add(textField_2);
			
			JLabel label_4 = new JLabel("Direccion");
			label_4.setForeground(Color.WHITE);
			label_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			label_4.setBounds(12, 205, 122, 16);
			panelNuevo.add(label_4);
			
			textField_3 = new JTextField();
			textField_3.setBackground(new Color(0, 0, 51));
			textField_3.setForeground(Color.WHITE);
			textField_3.setCaretColor(Color.WHITE);
			textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			textField_3.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
			textField_3.setColumns(10);
			textField_3.setBounds(12, 234, 263, 24);
			panelNuevo.add(textField_3);
			
			JLabel label_5 = new JLabel("Contrase\u00F1a");
			label_5.setForeground(Color.WHITE);
			label_5.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			label_5.setBounds(287, 77, 122, 16);
			panelNuevo.add(label_5);
			
			JLabel label_6 = new JLabel("Correo electronico");
			label_6.setForeground(Color.WHITE);
			label_6.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			label_6.setBounds(287, 13, 122, 16);
			panelNuevo.add(label_6);
			
			textField_5 = new JTextField();
			textField_5.setBackground(new Color(0, 0, 51));
			textField_5.setForeground(Color.WHITE);
			textField_5.setCaretColor(Color.WHITE);
			textField_5.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			textField_5.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
			textField_5.setColumns(10);
			textField_5.setBounds(287, 42, 263, 24);
			panelNuevo.add(textField_5);
			
			JLabel label_7 = new JLabel("Confirmar Contrase\u00F1a");
			label_7.setForeground(Color.WHITE);
			label_7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			label_7.setBounds(287, 141, 154, 16);
			panelNuevo.add(label_7);
			
			passwordField = new JPasswordField();
			passwordField.setBackground(new Color(0, 0, 51));
			passwordField.setForeground(Color.WHITE);
			passwordField.setCaretColor(Color.WHITE);
			passwordField.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
			passwordField.setBounds(287, 106, 263, 24);
			panelNuevo.add(passwordField);
			
			passwordField_1 = new JPasswordField();
			passwordField_1.setBackground(new Color(0, 0, 51));
			passwordField_1.setForeground(Color.WHITE);
			passwordField_1.setCaretColor(Color.WHITE);
			passwordField_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
			passwordField_1.setBounds(287, 170, 263, 24);
			panelNuevo.add(passwordField_1);
		}
		
		groupCliente = new ButtonGroup();
		groupCliente.add(rbNuevo);
		groupCliente.add(rbExistente);
		
		panelExistente = new JPanel();
		panelExistente.setLayout(null);
		panelExistente.setBackground(new Color(102, 102, 204));
		panelExistente.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		panelExistente.setBounds(12, 117, 640, 290);
		panel.add(panelExistente);
		
		label_9 = new JLabel("Cedula");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		label_9.setBounds(12, 13, 56, 16);
		panelExistente.add(label_9);
		
		textField_12 = new JTextField();
		textField_12.setBackground(new Color(0, 0, 51));
		textField_12.setForeground(Color.WHITE);
		textField_12.setCaretColor(Color.WHITE);
		textField_12.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textField_12.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		textField_12.setColumns(10);
		textField_12.setBounds(12, 42, 263, 24);
		panelExistente.add(textField_12);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(0, 0, 51));
		btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnBuscar.setFocusPainted(false);
		btnBuscar.setBounds(287, 41, 97, 25);
		panelExistente.add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNombre.setBounds(12, 118, 56, 16);
		panelExistente.add(lblNombre);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBackground(new Color(60, 60, 100));
		textField_7.setForeground(Color.WHITE);
		textField_7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textField_7.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		textField_7.setColumns(10);
		textField_7.setBounds(12, 147, 263, 24);
		panelExistente.add(textField_7);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblTelefono.setBounds(12, 182, 56, 16);
		panelExistente.add(lblTelefono);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBackground(new Color(60, 60, 100));
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textField_8.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		textField_8.setColumns(10);
		textField_8.setBounds(12, 211, 263, 24);
		panelExistente.add(textField_8);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblCorreo.setBounds(287, 120, 56, 16);
		panelExistente.add(lblCorreo);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setBackground(new Color(60, 60, 100));
		textField_9.setForeground(Color.WHITE);
		textField_9.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textField_9.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		textField_9.setColumns(10);
		textField_9.setBounds(287, 149, 263, 24);
		panelExistente.add(textField_9);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDireccion.setBounds(287, 182, 56, 16);
		panelExistente.add(lblDireccion);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setBackground(new Color(60, 60, 100));
		textField_10.setForeground(Color.WHITE);
		textField_10.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textField_10.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		textField_10.setColumns(10);
		textField_10.setBounds(287, 211, 263, 24);
		panelExistente.add(textField_10);
		
		mostrarPanel("nuevo");
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 204));
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_1.setBounds(12, 433, 640, 126);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(0, 0, 51));
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comboBox.setBounds(47, 49, 548, 33);
		panel_1.add(comboBox);
		
		lblPlan = new JLabel("Plan");
		lblPlan.setForeground(Color.WHITE);
		lblPlan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPlan.setBounds(298, 13, 38, 16);
		panel_1.add(lblPlan);
		
		chckbxNewCheckBox = new JCheckBox("Activo");
		chckbxNewCheckBox.setBackground(new Color(102, 102, 204));
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(302, 580, 77, 25);
		panel.add(chckbxNewCheckBox);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setCaretColor(Color.WHITE);
		textField_4.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		textField_4.setBackground(new Color(0, 0, 51));
		textField_4.setBounds(12, 42, 112, 24);
		panel.add(textField_4);
		
		label_8 = new JLabel("C\u00F3digo");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		label_8.setBounds(12, 13, 56, 16);
		panel.add(label_8);
		{
			buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
			buttonPane.setBackground(new Color(0, 0, 51));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setForeground(Color.WHITE);
				okButton.setBackground(new Color(0, 0, 51));
				okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				okButton.setFocusPainted(false);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBackground(new Color(102, 0, 0));
				cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				cancelButton.setFocusPainted(false);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void mostrarPanel(String tipo) {
		panelNuevo.setVisible(false);
		panelExistente.setVisible(false);
		if (tipo.equals("nuevo"))
			panelNuevo.setVisible(true);
		if (tipo.equals("existente"))
			panelExistente.setVisible(true);
	}
}