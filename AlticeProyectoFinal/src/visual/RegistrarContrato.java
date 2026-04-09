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
import logico.Empleado;
import logico.Persona;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class RegistrarContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private Persona selected;
	
	private ButtonGroup groupCliente;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JPanel panel;
	private JPanel panelExistente;
	private JLabel lblCedularnc;
	private JTextField txtCedula;
	private JButton btnBuscar;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	private JPanel panel_1;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblPlan;
	private JTextField txtCodigo;
	private JLabel label_8;
	private JButton btnNuevo;

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
		setBounds(100, 100, 697, 709);
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
			panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
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
		panelExistente.setBounds(12, 117, 640, 258);
		panel.add(panelExistente);
		
		lblCedularnc = new JLabel("Cedula/RNC");
		lblCedularnc.setForeground(Color.WHITE);
		lblCedularnc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
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
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNombre.setBounds(12, 98, 56, 16);
		panelExistente.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBackground(new Color(60, 60, 100));
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtNombre.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		txtNombre.setColumns(10);
		txtNombre.setBounds(12, 127, 263, 24);
		panelExistente.add(txtNombre);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblTelefono.setBounds(12, 162, 56, 16);
		panelExistente.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBackground(new Color(60, 60, 100));
		txtTelefono.setForeground(Color.WHITE);
		txtTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtTelefono.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(12, 191, 263, 24);
		panelExistente.add(txtTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblCorreo.setBounds(287, 100, 56, 16);
		panelExistente.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		txtCorreo.setBackground(new Color(60, 60, 100));
		txtCorreo.setForeground(Color.WHITE);
		txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtCorreo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(287, 129, 263, 24);
		panelExistente.add(txtCorreo);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDireccion.setBounds(287, 162, 56, 16);
		panelExistente.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBackground(new Color(60, 60, 100));
		txtDireccion.setForeground(Color.WHITE);
		txtDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtDireccion.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(287, 191, 263, 24);
		panelExistente.add(txtDireccion);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 204));
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_1.setBounds(12, 388, 640, 126);
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
		chckbxNewCheckBox.setBounds(292, 539, 77, 25);
		panel.add(chckbxNewCheckBox);
		
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
				RegistrarCliente nuevo = new RegistrarCliente(null, true);
				nuevo.setModal(true);
				nuevo.setVisible(true);
				btnNuevo.setEnabled(false);
				
		        int size = Altice.getInstance().getMisClientes().size();
		        if (size > 0) {
		            selected = Altice.getInstance().getMisClientes().get(size - 1);
		        }
		        
		        txtCedula.setText(selected.getCedula());
		        txtNombre.setText(selected.getNombre());
		        txtTelefono.setText(selected.getTelefono());
		        txtDireccion.setText(selected.getTelefono());
		        txtCorreo.setText(selected.getEmail());
		        txtCedula.setEditable(false);
		        btnBuscar.setVisible(false);
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
	private void buscar() {
        String cedula = txtCedula.getText().trim();
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una cédula/RNC", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Persona persona = Altice.getInstance().buscarPersonaByCedula(cedula);

        if (persona == null) {
            JOptionPane.showMessageDialog(this, "Cédula/RNC no registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        selected = persona;

        txtNombre.setText(persona.getNombre());
        txtTelefono.setText(persona.getTelefono());
        txtDireccion.setText(persona.getDireccion());
        txtCorreo.setText(persona.getEmail());

        if (persona instanceof Empleado) {
            JOptionPane.showMessageDialog(this, 
                "Empleado detectado.\nSe incluirá planes especiales.", 
                "Contrato Interno", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void registrarContrato() {
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Debe buscar y seleccionar una persona primero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}