package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import logico.Altice;
import logico.Cliente;
import logico.Solicitud;
import logico.TipoSolicitud;
import logico.EstadoSolicitud;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.UIManager;

public class RegistrarSolicitudCliente extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JButton cancelButton;
    private JButton okButton;
    private JTextPane txtDescripcion;
    private JComboBox<TipoSolicitud> comboTipo;

    /**
     * Create the dialog.
     */
    public RegistrarSolicitudCliente() {
        setBackground(new Color(0, 0, 51));
        setTitle("Registrar Solicitud de Soporte");
        setResizable(false);
        setBounds(100, 100, 480, 340);
        getContentPane().setLayout(new BorderLayout());
        
        contentPanel.setBackground(new Color(0, 0, 51));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        {
            JPanel panel = new JPanel();
            panel.setBackground(new Color(102, 102, 204));
            panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
                    "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
            contentPanel.add(panel, BorderLayout.CENTER);
            panel.setLayout(null);

            {
                JLabel lblNewLabel = new JLabel("Tipo de Solicitud");
                lblNewLabel.setForeground(new Color(255, 255, 255));
                lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblNewLabel.setBounds(180, 20, 120, 16);
                panel.add(lblNewLabel);
            }

            {
                comboTipo = new JComboBox<>();
                comboTipo.setEnabled(false);           // No se puede cambiar
                comboTipo.setForeground(new Color(255, 255, 255));
                comboTipo.setBackground(new Color(0, 0, 51));
                comboTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                comboTipo.setBounds(133, 48, 200, 25);
                panel.add(comboTipo);
            }

            {
                JLabel lblNewLabel_1 = new JLabel("Descripción del problema");
                lblNewLabel_1.setForeground(new Color(255, 255, 255));
                lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblNewLabel_1.setBounds(150, 90, 180, 16);
                panel.add(lblNewLabel_1);
            }

            {
                txtDescripcion = new JTextPane();
                txtDescripcion.setBackground(new Color(0, 0, 51));
                txtDescripcion.setForeground(new Color(255, 255, 255));
                txtDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtDescripcion.setBounds(40, 118, 390, 100);
                panel.add(txtDescripcion);
            }
        }

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(153, 153, 255)));
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            {
                okButton = new JButton("Aceptar");
                okButton.setForeground(Color.WHITE);
                okButton.setBackground(new Color(0, 0, 51));
                okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                okButton.setFocusPainted(false);
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        registrarSolicitud();
                    }
                });
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }

            {
                cancelButton = new JButton("Cancelar");
                cancelButton.setForeground(Color.WHITE);
                cancelButton.setBackground(new Color(102, 0, 0));
                cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                cancelButton.setFocusPainted(false);
                cancelButton.addActionListener(e -> dispose());
                buttonPane.add(cancelButton);
            }
        }

        cargarTipoSolicitud();
    }

    private void cargarTipoSolicitud() {
        comboTipo.removeAllItems();
        comboTipo.addItem(TipoSolicitud.SOPORTE);
    }

    private void registrarSolicitud() {
        String descripcion = txtDescripcion.getText().trim();

        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Debe escribir una descripción del problema.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }

        String cedulaCliente = Altice.getInstance().buscarCedulaById(Altice.getSesion().getCodigo());
        Cliente cliente = (Cliente) Altice.getInstance().buscarPersonaByCedula(cedulaCliente);

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "No se pudo identificar al cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String codigo = "SOL-" + String.format("%05d", Altice.getGenSolicitudid() + 1);

        Solicitud nuevaSolicitud = new Solicitud(codigo, cliente, TipoSolicitud.SOPORTE, descripcion);

        if (Altice.getInstance().registrarSolicitud(nuevaSolicitud)) {
            JOptionPane.showMessageDialog(this, 
                "Solicitud de soporte registrada correctamente", 
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, 
                "Error al registrar la solicitud", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}