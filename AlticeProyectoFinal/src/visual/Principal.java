package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogo;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setBackground(new Color(0, 0, 51));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/alticelogo.png")));
		setTitle("Altice");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 671);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(369, 13, 228, 249);
		panel.add(lblLogo);

		ImageIcon icon = new ImageIcon(Principal.class.getResource("/img/alticeblanco.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(scaledImage));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBounds(263, 291, 441, 298);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(192, 30, 56, 16);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(58, 58, 324, 31);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setBounds(176, 115, 88, 16);
		panel_1.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(58, 153, 324, 31);
		panel_1.add(textField_1);
		
		btnNewButton = new JButton("Iniciar sesi\u00F3n");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(158, 223, 125, 45);
		panel_1.add(btnNewButton);

	}
}
