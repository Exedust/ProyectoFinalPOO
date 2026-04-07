package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class RegistrarSolicitud extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton cancelButton;
	private JButton okButton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarSolicitud dialog = new RegistrarSolicitud();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarSolicitud() {
		setBackground(new Color(0, 0, 51));
		setTitle("Registrar Solicitud");
		setResizable(false);
		setBounds(100, 100, 629, 597);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 51));
			panel.setBorder(new LineBorder(Color.WHITE));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(102, 102, 204));
				panel_1.setForeground(new Color(102, 102, 204));
				panel_1.setBounds(12, 13, 574, 222);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("Cedula");
					lblNewLabel.setForeground(new Color(255, 255, 255));
					lblNewLabel.setBounds(12, 13, 56, 16);
					panel_1.add(lblNewLabel);
				}
				{
					textField = new JTextField();
					textField.setForeground(Color.WHITE);
					textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					textField.setColumns(10);
					textField.setCaretColor(Color.WHITE);
					textField.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					textField.setBackground(new Color(0, 0, 51));
					textField.setBounds(12, 42, 263, 24);
					panel_1.add(textField);
				}
				{
					JButton button = new JButton("Buscar");
					button.setForeground(Color.WHITE);
					button.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					button.setFocusPainted(false);
					button.setBackground(new Color(0, 0, 51));
					button.setBounds(287, 42, 97, 25);
					panel_1.add(button);
				}
				{
					JLabel label = new JLabel("Nombre");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(12, 79, 56, 16);
					panel_1.add(label);
				}
				{
					textField_1 = new JTextField();
					textField_1.setForeground(Color.WHITE);
					textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					textField_1.setEditable(false);
					textField_1.setColumns(10);
					textField_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					textField_1.setBackground(new Color(60, 60, 100));
					textField_1.setBounds(12, 108, 263, 24);
					panel_1.add(textField_1);
				}
				{
					JLabel label = new JLabel("Telefono");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(12, 143, 56, 16);
					panel_1.add(label);
				}
				{
					textField_2 = new JTextField();
					textField_2.setForeground(Color.WHITE);
					textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					textField_2.setEditable(false);
					textField_2.setColumns(10);
					textField_2.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					textField_2.setBackground(new Color(60, 60, 100));
					textField_2.setBounds(12, 172, 263, 24);
					panel_1.add(textField_2);
				}
				{
					JLabel label = new JLabel("Correo");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(287, 81, 56, 16);
					panel_1.add(label);
				}
				{
					textField_3 = new JTextField();
					textField_3.setForeground(Color.WHITE);
					textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					textField_3.setEditable(false);
					textField_3.setColumns(10);
					textField_3.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					textField_3.setBackground(new Color(60, 60, 100));
					textField_3.setBounds(287, 110, 263, 24);
					panel_1.add(textField_3);
				}
				{
					JLabel label = new JLabel("Direccion");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					label.setBounds(287, 143, 56, 16);
					panel_1.add(label);
				}
				{
					textField_4 = new JTextField();
					textField_4.setForeground(Color.WHITE);
					textField_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
					textField_4.setEditable(false);
					textField_4.setColumns(10);
					textField_4.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
					textField_4.setBackground(new Color(60, 60, 100));
					textField_4.setBounds(287, 172, 263, 24);
					panel_1.add(textField_4);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(153, 153, 255)));
				panel_1.setBackground(new Color(102, 102, 204));
				panel_1.setBounds(12, 248, 574, 223);
				panel.add(panel_1);
				{
					JLabel label = new JLabel("Tipo");
					label.setForeground(Color.WHITE);
					label.setBounds(269, 13, 35, 16);
					panel_1.add(label);
				}
				{
					JComboBox comboBox = new JComboBox();
					comboBox.setForeground(Color.WHITE);
					comboBox.setBackground(new Color(0, 0, 51));
					comboBox.setBounds(203, 44, 167, 22);
					panel_1.add(comboBox);
				}
				{
					JLabel label = new JLabel("Descripcion");
					label.setForeground(Color.WHITE);
					label.setBounds(248, 79, 77, 16);
					panel_1.add(label);
				}
				{
					JTextPane textPane = new JTextPane();
					textPane.setForeground(Color.WHITE);
					textPane.setBackground(new Color(0, 0, 51));
					textPane.setBounds(82, 108, 410, 91);
					panel_1.add(textPane);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(153, 153, 255)));
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
}
