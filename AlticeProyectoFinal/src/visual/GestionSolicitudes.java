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

public class GestionSolicitudes extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            GestionSolicitudes dialog = new GestionSolicitudes();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public GestionSolicitudes() {
        setTitle("Gestionar Solicitudes");
        setResizable(false);
        setBounds(100, 100, 1280, 770);
        
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
            panel.setBounds(12, 145, 1102, 496);
            contentPanel.add(panel);
            // Aquí iría tu JTable más adelante
        }

        // ====================== CAMPOS DE BÚSQUEDA ======================
        {
            textField = new JTextField();
            textField.setBackground(new Color(0, 0, 51));
            textField.setForeground(Color.WHITE);
            textField.setCaretColor(Color.WHITE);
            textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            textField.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            textField.setBounds(12, 110, 232, 24);
            contentPanel.add(textField);
            textField.setColumns(10);
        }
        {
            textField_1 = new JTextField();
            textField_1.setBackground(new Color(0, 0, 51));
            textField_1.setForeground(Color.WHITE);
            textField_1.setCaretColor(Color.WHITE);
            textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            textField_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            textField_1.setBounds(256, 110, 232, 24);
            contentPanel.add(textField_1);
            textField_1.setColumns(10);
        }
        {
            JButton btnNewButton = new JButton("Buscar");
            btnNewButton.setForeground(Color.WHITE);
            btnNewButton.setBackground(new Color(0, 0, 51));
            btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnNewButton.setFocusPainted(false);
            btnNewButton.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnNewButton.setBounds(500, 109, 97, 25);
            contentPanel.add(btnNewButton);
        }
        {
            JComboBox comboBox = new JComboBox();
            comboBox.setBackground(new Color(0, 0, 51));
            comboBox.setForeground(Color.WHITE);
            comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            comboBox.setBounds(797, 110, 208, 24);
            contentPanel.add(comboBox);
        }
        {
            JButton btnNewButton_1 = new JButton("Filtrar");
            btnNewButton_1.setForeground(Color.WHITE);
            btnNewButton_1.setBackground(new Color(0, 0, 51));
            btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnNewButton_1.setFocusPainted(false);
            btnNewButton_1.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnNewButton_1.setBounds(1017, 110, 97, 25);
            contentPanel.add(btnNewButton_1);
        }

        // ====================== ETIQUETAS ======================
        {
            JLabel lblNewLabel = new JLabel("Cedula");
            lblNewLabel.setForeground(Color.WHITE);
            lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblNewLabel.setBounds(12, 88, 56, 16);
            contentPanel.add(lblNewLabel);
        }
        {
            JLabel lblNewLabel_1 = new JLabel("Nombre");
            lblNewLabel_1.setForeground(Color.WHITE);
            lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblNewLabel_1.setBounds(256, 88, 56, 16);
            contentPanel.add(lblNewLabel_1);
        }
        {
            JLabel lblNewLabel_2 = new JLabel("Solicitudes Registradas: 00");
            lblNewLabel_2.setForeground(Color.WHITE);
            lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblNewLabel_2.setBounds(12, 23, 216, 16);
            contentPanel.add(lblNewLabel_2);
        }
        {
            JLabel lblComercialesRegistrados = new JLabel("Solicitudes Pendientes: 00");
            lblComercialesRegistrados.setForeground(Color.WHITE);
            lblComercialesRegistrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblComercialesRegistrados.setBounds(12, 59, 216, 16);
            contentPanel.add(lblComercialesRegistrados);
        }
        {
            JLabel lblClientesPendientes = new JLabel("Solicitudes En Proceso: 00");
            lblClientesPendientes.setForeground(Color.WHITE);
            lblClientesPendientes.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblClientesPendientes.setBounds(240, 59, 216, 16);
            contentPanel.add(lblClientesPendientes);
        }

        // ====================== BOTONES LATERALES ======================
        {
            JButton btnNewButton_2 = new JButton("Agregar");
            btnNewButton_2.setForeground(Color.WHITE);
            btnNewButton_2.setBackground(new Color(0, 0, 51));
            btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnNewButton_2.setFocusPainted(false);
            btnNewButton_2.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnNewButton_2.setBounds(1143, 145, 97, 25);
            contentPanel.add(btnNewButton_2);
        }
        {
            JButton btnModificar = new JButton("Modificar");
            btnModificar.setForeground(Color.WHITE);
            btnModificar.setBackground(new Color(0, 0, 51));
            btnModificar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnModificar.setFocusPainted(false);
            btnModificar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnModificar.setBounds(1143, 183, 97, 25);
            contentPanel.add(btnModificar);
        }
        {
            JButton btnDesactivar = new JButton("Cancelar");
            btnDesactivar.setForeground(Color.WHITE);
            btnDesactivar.setBackground(new Color(102, 0, 0));  // Rojo oscuro como en el ejemplo
            btnDesactivar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnDesactivar.setFocusPainted(false);
            btnDesactivar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnDesactivar.setBounds(1143, 616, 97, 25);
            contentPanel.add(btnDesactivar);
        }
        {
            JButton btnNewButton_3 = new JButton("Asignar");
            btnNewButton_3.setForeground(Color.WHITE);
            btnNewButton_3.setBackground(new Color(0, 0, 51));
            btnNewButton_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnNewButton_3.setFocusPainted(false);
            btnNewButton_3.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnNewButton_3.setBounds(1143, 578, 97, 25);
            contentPanel.add(btnNewButton_3);
        }
        {
        	JLabel lblSolicitudesCompletadas = new JLabel("Solicitudes Completadas: 00");
        	lblSolicitudesCompletadas.setForeground(Color.WHITE);
        	lblSolicitudesCompletadas.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        	lblSolicitudesCompletadas.setBounds(468, 59, 216, 16);
        	contentPanel.add(lblSolicitudesCompletadas);
        }
        {
        	JLabel lblSolicitudesCanceladas = new JLabel("Solicitudes Canceladas: 00");
        	lblSolicitudesCanceladas.setForeground(Color.WHITE);
        	lblSolicitudesCanceladas.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        	lblSolicitudesCanceladas.setBounds(696, 59, 216, 16);
        	contentPanel.add(lblSolicitudesCanceladas);
        }
        {
        	JButton btnVerDetalles = new JButton("Ver Detalles");
        	btnVerDetalles.setForeground(Color.WHITE);
        	btnVerDetalles.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        	btnVerDetalles.setFocusPainted(false);
        	btnVerDetalles.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        	btnVerDetalles.setBackground(new Color(0, 0, 51));
        	btnVerDetalles.setBounds(1143, 221, 97, 25);
        	contentPanel.add(btnVerDetalles);
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