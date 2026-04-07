package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarPagos extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ListarPagos dialog = new ListarPagos();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ListarPagos() {
        setTitle("Gestionar Pagos");
        setResizable(false);
        setBounds(100, 100, 1280, 633);
        
        getContentPane().setBackground(new Color(0, 0, 51));
        getContentPane().setLayout(new BorderLayout());
        
        contentPanel.setBackground(new Color(0, 0, 51));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        // ====================== PANEL PRINCIPAL DE TABLA ======================
        {
            JPanel panel = new JPanel();
            panel.setBackground(new Color(102, 102, 204));
            panel.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            panel.setBounds(12, 50, 1114, 483);
            contentPanel.add(panel);
            // Aquí iría tu JTable más adelante
        }
        {
            JComboBox comboBox = new JComboBox();
            comboBox.setBackground(new Color(0, 0, 51));
            comboBox.setForeground(Color.WHITE);
            comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            comboBox.setBounds(809, 13, 208, 24);
            contentPanel.add(comboBox);
        }
        {
            JButton btnNewButton_1 = new JButton("Filtrar");
            btnNewButton_1.setForeground(Color.WHITE);
            btnNewButton_1.setBackground(new Color(0, 0, 51));
            btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnNewButton_1.setFocusPainted(false);
            btnNewButton_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnNewButton_1.setBounds(1029, 13, 97, 25);
            contentPanel.add(btnNewButton_1);
        }
        {
            JLabel lblComercialesRegistrados = new JLabel("Pagos Pendientes: 00");
            lblComercialesRegistrados.setForeground(Color.WHITE);
            lblComercialesRegistrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblComercialesRegistrados.setBounds(12, 22, 216, 16);
            contentPanel.add(lblComercialesRegistrados);
        }

        // ====================== BOTONES LATERALES ======================
        {
            JButton btnNewButton_2 = new JButton("Realizar Pago");
            btnNewButton_2.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            	}
            });
            btnNewButton_2.setForeground(Color.WHITE);
            btnNewButton_2.setBackground(new Color(0, 0, 51));
            btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnNewButton_2.setFocusPainted(false);
            btnNewButton_2.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnNewButton_2.setBounds(1154, 412, 97, 25);
            contentPanel.add(btnNewButton_2);
        }
        {
            JButton btnModificar = new JButton("Ver Contrato");
            btnModificar.setForeground(Color.WHITE);
            btnModificar.setBackground(new Color(0, 0, 51));
            btnModificar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnModificar.setFocusPainted(false);
            btnModificar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnModificar.setBounds(1154, 508, 97, 25);
            contentPanel.add(btnModificar);
        }
        
        JLabel lblContratosCerrados = new JLabel("Pagos Realizados: 00");
        lblContratosCerrados.setForeground(Color.WHITE);
        lblContratosCerrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblContratosCerrados.setBounds(240, 22, 216, 16);
        contentPanel.add(lblContratosCerrados);
        {
        	JLabel lblMontoPendiente = new JLabel("Monto Pendiente: 00");
        	lblMontoPendiente.setForeground(Color.WHITE);
        	lblMontoPendiente.setFont(new Font("Segoe UI", Font.BOLD, 15));
        	lblMontoPendiente.setBounds(468, 21, 216, 16);
        	contentPanel.add(lblMontoPendiente);
        }

        // ====================== BOTONES INFERIORES (OK / CANCEL) ======================
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