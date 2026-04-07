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

public class RegistrarServicio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton cancelButton;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarServicio dialog = new RegistrarServicio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarServicio() {
		setBackground(new Color(0, 0, 51));
		setTitle("Registrar Servicio");
		setResizable(false);
		setBounds(100, 100, 450, 319);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(102, 102, 204));
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(153, 153, 255)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Tipo");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setBounds(199, 13, 35, 16);
				panel.add(lblNewLabel);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setForeground(new Color(255, 255, 255));
				comboBox.setBackground(new Color(0, 0, 51));
				comboBox.setBounds(133, 44, 167, 22);
				panel.add(comboBox);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Descripcion");
				lblNewLabel_1.setForeground(new Color(255, 255, 255));
				lblNewLabel_1.setBounds(178, 79, 77, 16);
				panel.add(lblNewLabel_1);
			}
			
			JTextPane textPane = new JTextPane();
			textPane.setBackground(new Color(0, 0, 51));
			textPane.setForeground(new Color(255, 255, 255));
			textPane.setBounds(41, 108, 352, 49);
			panel.add(textPane);
			
			JCheckBox checkBox = new JCheckBox("Activo");
			checkBox.setSelected(true);
			checkBox.setForeground(Color.WHITE);
			checkBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
			checkBox.setBackground(new Color(102, 102, 204));
			checkBox.setBounds(178, 186, 77, 25);
			panel.add(checkBox);
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
