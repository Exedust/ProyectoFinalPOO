package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.UIManager;

public class RegistrarPlan extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JCheckBox chkbxInternet;
    private JCheckBox chckbxCable;
    private JCheckBox chckbxTelefonia;
    
    private JPanel panelInternet;
    private JPanel panelCable;
    private JPanel panelMovil;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            RegistrarPlan dialog = new RegistrarPlan();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public RegistrarPlan() {
        setTitle("Registrar Plan");
        setResizable(false);
        setBounds(100, 100, 568, 657);
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

            // ====================== CAMPOS GENERALES ======================
            {
                JLabel lblNewLabel = new JLabel("Nombre");
                lblNewLabel.setForeground(Color.WHITE);
                lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblNewLabel.setBounds(242, 13, 56, 16);
                panel.add(lblNewLabel);
            }
            {
                textField = new JTextField();
                textField.setBackground(new Color(0, 0, 51));
                textField.setForeground(Color.WHITE);
                textField.setCaretColor(Color.WHITE);
                textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                textField.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                textField.setBounds(96, 42, 347, 24);
                panel.add(textField);
                textField.setColumns(10);
            }
            {
                JLabel lblDescripcion = new JLabel("Descripcion");
                lblDescripcion.setForeground(Color.WHITE);
                lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblDescripcion.setBounds(233, 77, 74, 16);
                panel.add(lblDescripcion);
            }
            {
                JTextPane textPane = new JTextPane();
                textPane.setBackground(new Color(0, 0, 51));
                textPane.setForeground(Color.WHITE);
                textPane.setCaretColor(Color.WHITE);
                textPane.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                textPane.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
                textPane.setBounds(87, 112, 365, 64);
                panel.add(textPane);
            }

            // ====================== PANEL SERVICIOS (CHECKBOX) ======================
            {
                JPanel panel_1 = new JPanel();
                panel_1.setForeground(new Color(255, 255, 255));
                panel_1.setLayout(null);
                panel_1.setBackground(new Color(102, 102, 204));
                panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Servicios", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
                panel_1.setBounds(87, 209, 365, 71);
                panel.add(panel_1);

                {
                    chkbxInternet = new JCheckBox("Internet");
                    chkbxInternet.setForeground(Color.WHITE);
                    chkbxInternet.setBackground(new Color(102, 102, 204));
                    chkbxInternet.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chkbxInternet.setBounds(8, 26, 86, 25);
                    panel_1.add(chkbxInternet);
                }
                {
                    chckbxCable = new JCheckBox("Cable");
                    chckbxCable.setForeground(Color.WHITE);
                    chckbxCable.setBackground(new Color(102, 102, 204));
                    chckbxCable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chckbxCable.setBounds(145, 26, 86, 25);
                    panel_1.add(chckbxCable);
                }
                {
                    chckbxTelefonia = new JCheckBox("Movil");
                    chckbxTelefonia.setForeground(Color.WHITE);
                    chckbxTelefonia.setBackground(new Color(102, 102, 204));
                    chckbxTelefonia.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chckbxTelefonia.setBounds(282, 26, 75, 25);
                    panel_1.add(chckbxTelefonia);
                }
            }

            // ====================== PANEL INTERNET ======================
            {
                panelInternet = new JPanel();
                panelInternet.setLayout(null);
                panelInternet.setBackground(new Color(102, 102, 204));
                panelInternet.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), 
                        "Internet", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
                panelInternet.setBounds(12, 303, 137, 232);
                panel.add(panelInternet);

                {
                    JLabel lblNewLabel_1 = new JLabel("Bajada (Mbps)");
                    lblNewLabel_1.setForeground(Color.WHITE);
                    lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblNewLabel_1.setBounds(23, 30, 91, 16);
                    panelInternet.add(lblNewLabel_1);
                }
                {
                    JSpinner spinner = new JSpinner();
                    spinner.setForeground(Color.WHITE);
                    spinner.setBackground(new Color(51, 51, 102));
                    spinner.setBounds(23, 59, 91, 22);
                    panelInternet.add(spinner);
                }
                {
                    JLabel lblSubidambps = new JLabel("Subida (Mbps)");
                    lblSubidambps.setForeground(Color.WHITE);
                    lblSubidambps.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblSubidambps.setBounds(23, 94, 91, 16);
                    panelInternet.add(lblSubidambps);
                }
                {
                    JSpinner spinner = new JSpinner();
                    spinner.setForeground(Color.WHITE);
                    spinner.setBackground(new Color(51, 51, 102));
                    spinner.setBounds(23, 123, 91, 22);
                    panelInternet.add(spinner);
                }
                {
                    JLabel lblNewLabel_2 = new JLabel("Precio");
                    lblNewLabel_2.setForeground(Color.WHITE);
                    lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblNewLabel_2.setBounds(45, 158, 46, 16);
                    panelInternet.add(lblNewLabel_2);
                }
                {
                    JSpinner spinner = new JSpinner();
                    spinner.setForeground(Color.WHITE);
                    spinner.setBackground(new Color(51, 51, 102));
                    spinner.setBounds(23, 186, 91, 22);
                    panelInternet.add(spinner);
                }
            }

            // ====================== PANEL MOVIL ======================
            {
                panelMovil = new JPanel();
                panelMovil.setLayout(null);
                panelMovil.setBackground(new Color(102, 102, 204));
                panelMovil.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), 
                        "Movil", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
                panelMovil.setBounds(385, 303, 137, 232);
                panel.add(panelMovil);

                {
                    JLabel lblMinutos = new JLabel("Minutos");
                    lblMinutos.setForeground(Color.WHITE);
                    lblMinutos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblMinutos.setBounds(40, 30, 56, 16);
                    panelMovil.add(lblMinutos);
                }
                {
                    JSpinner spinner = new JSpinner();
                    spinner.setForeground(Color.WHITE);
                    spinner.setBackground(new Color(51, 51, 102));
                    spinner.setBounds(23, 59, 91, 22);
                    panelMovil.add(spinner);
                }
                {
                    JLabel lblGigas = new JLabel("Gigas");
                    lblGigas.setForeground(Color.WHITE);
                    lblGigas.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    lblGigas.setBounds(49, 94, 39, 16);
                    panelMovil.add(lblGigas);
                }
                {
                    JSpinner spinner = new JSpinner();
                    spinner.setForeground(Color.WHITE);
                    spinner.setBackground(new Color(51, 51, 102));
                    spinner.setBounds(23, 123, 91, 22);
                    panelMovil.add(spinner);
                }
                {
                    JLabel label = new JLabel("Precio");
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label.setBounds(49, 158, 39, 16);
                    panelMovil.add(label);
                }
                {
                    JSpinner spinner = new JSpinner();
                    spinner.setForeground(Color.WHITE);
                    spinner.setBackground(new Color(51, 51, 102));
                    spinner.setBounds(23, 186, 91, 22);
                    panelMovil.add(spinner);
                }
            }

            // ====================== PANEL CABLE ======================
            {
                panelCable = new JPanel();
                panelCable.setLayout(null);
                panelCable.setBackground(new Color(102, 102, 204));
                panelCable.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), 
                        "Cable", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
                panelCable.setBounds(201, 303, 137, 232);
                panel.add(panelCable);

                {
                    JLabel label = new JLabel("Precio");
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    label.setBounds(46, 158, 45, 16);
                    panelCable.add(label);
                }
                {
                    JSpinner spinner = new JSpinner();
                    spinner.setForeground(Color.WHITE);
                    spinner.setBackground(new Color(51, 51, 102));
                    spinner.setBounds(23, 186, 91, 22);
                    panelCable.add(spinner);
                }
                {
                    JCheckBox chckbxNewCheckBox = new JCheckBox("Pack básico");
                    chckbxNewCheckBox.setForeground(Color.WHITE);
                    chckbxNewCheckBox.setBackground(new Color(102, 102, 204));
                    chckbxNewCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chckbxNewCheckBox.setBounds(16, 45, 105, 25);
                    panelCable.add(chckbxNewCheckBox);
                }
                {
                    JCheckBox chckbxPackPremium = new JCheckBox("Pack Premium");
                    chckbxPackPremium.setForeground(Color.WHITE);
                    chckbxPackPremium.setBackground(new Color(102, 102, 204));
                    chckbxPackPremium.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                    chckbxPackPremium.setBounds(12, 110, 113, 25);
                    panelCable.add(chckbxPackPremium);
                }
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

        // ====================== FUNCIONALIDAD CHECKBOX ======================
        // Mostrar/ocultar paneles según los checkboxes
        ActionListener servicioListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelInternet.setVisible(chkbxInternet.isSelected());
                panelCable.setVisible(chckbxCable.isSelected());
                panelMovil.setVisible(chckbxTelefonia.isSelected());
            }
        };

        chkbxInternet.addActionListener(servicioListener);
        chckbxCable.addActionListener(servicioListener);
        chckbxTelefonia.addActionListener(servicioListener);

        // Estado inicial: todos los paneles ocultos (puedes cambiarlo si quieres que empiecen visibles)
        panelInternet.setVisible(false);
        panelCable.setVisible(false);
        panelMovil.setVisible(false);
    }
}