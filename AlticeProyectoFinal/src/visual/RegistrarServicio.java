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
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import logico.Altice;
import logico.Servicio;
import logico.TipoServicio;
import javax.swing.JTextField;

public class RegistrarServicio extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Servicio miServicio;
    private boolean cerrarAlRegistrar;

    private JComboBox<TipoServicio> comboTipo;
    private JTextPane txtDescripcion;
    private JCheckBox checkActivo;
    private JButton okButton;
    private JButton cancelButton;
    private JTextField txtTipo;

    public static void main(String[] args) {
        try {
            RegistrarServicio dialog = new RegistrarServicio(null, false);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegistrarServicio(Servicio servicio, boolean cerrarAlRegistrar) {
        this.miServicio = servicio;
        this.cerrarAlRegistrar = cerrarAlRegistrar;

        setTitle(miServicio == null ? "Registrar Servicio" : "Modificar Servicio");
        setResizable(false);
        setBounds(100, 100, 480, 380);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(0, 0, 51));
        getContentPane().setLayout(new BorderLayout());

        contentPanel.setBackground(new Color(0, 0, 51));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        {
            JPanel panel = new JPanel();
            panel.setBackground(new Color(102, 102, 204));
            panel.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            contentPanel.add(panel, BorderLayout.CENTER);
            panel.setLayout(null);

            {
                JLabel lblTipo = new JLabel("Tipo de Servicio");
                lblTipo.setForeground(Color.WHITE);
                lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblTipo.setBounds(182, 20, 100, 16);
                panel.add(lblTipo);
            }
            {
                comboTipo = new JComboBox<>();
                comboTipo.setBackground(new Color(0, 0, 51));
                comboTipo.setForeground(Color.WHITE);
                comboTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                comboTipo.setBounds(133, 49, 200, 28);
                panel.add(comboTipo);
            }
            {
                JLabel lblDescripcion = new JLabel("Descripción");
                lblDescripcion.setForeground(Color.WHITE);
                lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                lblDescripcion.setBounds(172, 90, 120, 16);
                panel.add(lblDescripcion);
            }
            {
                txtDescripcion = new JTextPane();
                txtDescripcion.setBackground(new Color(0, 0, 51));
                txtDescripcion.setForeground(Color.WHITE);
                txtDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                txtDescripcion.setBounds(41, 118, 385, 80);
                panel.add(txtDescripcion);
            }
            {
                checkActivo = new JCheckBox("Activo");
                checkActivo.setSelected(true);
                checkActivo.setForeground(Color.WHITE);
                checkActivo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                checkActivo.setBackground(new Color(102, 102, 204));
                checkActivo.setBounds(178, 215, 100, 25);
                panel.add(checkActivo);
            }
            {
            	txtTipo = new JTextField();
            	txtTipo.setForeground(Color.WHITE);
            	txtTipo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            	txtTipo.setEditable(false);
            	txtTipo.setColumns(10);
            	txtTipo.setCaretColor(Color.WHITE);
            	txtTipo.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            	txtTipo.setBackground(new Color(0, 0, 51));
            	txtTipo.setBounds(133, 49, 200, 26);
            	panel.add(txtTipo);
            }
        }

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            okButton = new JButton("Aceptar");
            okButton.setForeground(Color.WHITE);
            okButton.setBackground(new Color(0, 0, 51));
            okButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            okButton.setFocusPainted(false);
            okButton.addActionListener(e -> registrarServicio());
            buttonPane.add(okButton);

            cancelButton = new JButton("Cancelar");
            cancelButton.setForeground(Color.WHITE);
            cancelButton.setBackground(new Color(102, 0, 0));
            cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            cancelButton.setFocusPainted(false);
            cancelButton.addActionListener(e -> dispose());
            buttonPane.add(cancelButton);
        }
        checkActivo.setVisible(false);
        txtTipo.setVisible(false);
        
        cargarTiposDisponibles();

        if (miServicio != null) {
            loadServicio();
            checkActivo.setVisible(true);
            txtTipo.setVisible(true);
            comboTipo.setVisible(false);
        }
    }

    private void cargarTiposDisponibles() {
        comboTipo.removeAllItems();
        for (TipoServicio tipo : TipoServicio.values()) {
            if (!Altice.getInstance().existeServicio(tipo)) {
                comboTipo.addItem(tipo);
            }
        }
    }

    private void loadServicio() {
        if (miServicio == null) return;
        comboTipo.removeAllItems();
        comboTipo.addItem(miServicio.getTipo());
        comboTipo.setEnabled(false); 
        txtTipo.setText(miServicio.getTipo().name());
        txtDescripcion.setText(miServicio.getDescripcion());
        checkActivo.setSelected(miServicio.isActivo());
    }

    private void registrarServicio() {
        if (comboTipo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de servicio", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una descripción", "Error", JOptionPane.ERROR_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }

        // ==================== MODO MODIFICAR ====================
        if (miServicio != null) {
            miServicio.setDescripcion(txtDescripcion.getText().trim());
            miServicio.setActivo(checkActivo.isSelected());

            if (Altice.getInstance().modificarServicio(miServicio)) {
                JOptionPane.showMessageDialog(this, "Servicio modificado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar el servicio", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return;
        }

        // ==================== MODO REGISTRAR ====================
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea registrar este servicio?",
                "Confirmar Registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcion != JOptionPane.YES_OPTION) return;

        TipoServicio tipo = (TipoServicio) comboTipo.getSelectedItem();
        String descripcion = txtDescripcion.getText().trim();
        boolean activo = checkActivo.isSelected();

        String codigo = "SERV-" + String.format("%04d", Altice.getInstance().getGenServicioid() + 1);

        Servicio nuevo = new Servicio(tipo, descripcion);
        nuevo.setActivo(activo);

        if (Altice.getInstance().registrarServicio(nuevo)) {
            JOptionPane.showMessageDialog(this, "Servicio registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            if (cerrarAlRegistrar) {
                dispose();
            } else {
                txtDescripcion.setText("");
                cargarTiposDisponibles();
                checkActivo.setSelected(true);
                comboTipo.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el servicio.\nEs posible que ya exista este tipo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}