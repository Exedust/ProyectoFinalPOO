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

public class GestionContratos extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;
    private JButton btnDetalles;
    private JButton btnPagar;
    private JButton btnAgregar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            GestionContratos dialog = new GestionContratos();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public GestionContratos() {
        setTitle("Gestionar Contratos");
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
            JLabel lblNewLabel_1 = new JLabel("ID");
            lblNewLabel_1.setForeground(Color.WHITE);
            lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblNewLabel_1.setBounds(256, 88, 56, 16);
            contentPanel.add(lblNewLabel_1);
        }
        {
            JLabel lblComercialesRegistrados = new JLabel("Contratos activos: 00");
            lblComercialesRegistrados.setForeground(Color.WHITE);
            lblComercialesRegistrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblComercialesRegistrados.setBounds(12, 59, 216, 16);
            contentPanel.add(lblComercialesRegistrados);
        }
        {
            JLabel lblContratosRegistrados = new JLabel("Contratos registrados: 00");
            lblContratosRegistrados.setForeground(Color.WHITE);
            lblContratosRegistrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblContratosRegistrados.setBounds(12, 32, 216, 16);
            contentPanel.add(lblContratosRegistrados);
        }

        // ====================== BOTONES LATERALES ======================
        {
            btnAgregar = new JButton("Agregar");
            btnAgregar.setForeground(Color.WHITE);
            btnAgregar.setBackground(new Color(0, 0, 51));
            btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnAgregar.setFocusPainted(false);
            btnAgregar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnAgregar.setBounds(1143, 145, 97, 25);
            contentPanel.add(btnAgregar);
        }
        {
            JButton Cerrar = new JButton("Desactivar");
            Cerrar.setForeground(Color.WHITE);
            Cerrar.setBackground(new Color(102, 0, 0));  // Rojo oscuro como en el ejemplo
            Cerrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            Cerrar.setFocusPainted(false);
            Cerrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            Cerrar.setBounds(1143, 183, 97, 25);
            contentPanel.add(Cerrar);
        }
        {
            btnPagar = new JButton("Realizar Pago");
            btnPagar.setForeground(Color.WHITE);
            btnPagar.setBackground(new Color(0, 0, 51));
            btnPagar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnPagar.setFocusPainted(false);
            btnPagar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnPagar.setBounds(1143, 302, 97, 25);
            contentPanel.add(btnPagar);
        }
        
        btnDetalles = new JButton("Detalles");
        btnDetalles.setForeground(Color.WHITE);
        btnDetalles.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btnDetalles.setFocusPainted(false);
        btnDetalles.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
        btnDetalles.setBackground(new Color(0, 0, 51));
        btnDetalles.setBounds(1143, 264, 97, 25);
        contentPanel.add(btnDetalles);
        
        JLabel lblContratosCerrados = new JLabel("Contratos cerrados: 00");
        lblContratosCerrados.setForeground(Color.WHITE);
        lblContratosCerrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblContratosCerrados.setBounds(240, 59, 216, 16);
        contentPanel.add(lblContratosCerrados);

        // ====================== BOTONES INFERIORES (OK / CANCEL) ======================
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

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