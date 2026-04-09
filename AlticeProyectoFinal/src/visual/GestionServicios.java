package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import logico.Altice;
import logico.Servicio;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;   // ← Importante para corregir el error

public class GestionServicios extends JDialog {

    private final static JPanel contentPanel = new JPanel();
    
    private static JTable table;
    private static DefaultTableModel model;
    private static Object[] row;
    private Servicio selected = null;

    private static JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnDesactivar;
    private JButton btnSalir;
    private static JComboBox<String> comboFiltrar;

    public static void main(String[] args) {
        try {
            GestionServicios dialog = new GestionServicios();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GestionServicios() {
        setTitle("Gestionar Servicios");
        setResizable(false);
        setBounds(100, 100, 1280, 495);
        setLocationRelativeTo(null);
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
            panel.setBounds(10, 60, 1102, 325);
            contentPanel.add(panel);
            panel.setLayout(new BorderLayout(0, 0));
            
            JScrollPane scrollPane = new JScrollPane();
            panel.add(scrollPane, BorderLayout.CENTER);
            
            table = new JTable();
            table.setFillsViewportHeight(true);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setBackground(new Color(255, 255, 255));
            table.setForeground(new Color(0, 0, 0));
            table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            
            model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            
            String[] headers = {"Código", "Tipo", "Descripción", "Estado"};
            model.setColumnIdentifiers(headers);
            table.setModel(model);
            table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
            scrollPane.setViewportView(table);
            
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int ind = table.getSelectedRow();
                    if (ind != -1) {
                        String codigo = table.getValueAt(ind, 0).toString();
                        selected = Altice.getInstance().buscarServicioByCodigo(codigo);
                        
                        btnModificar.setEnabled(true);
                        if(selected.isActivo())
                        	btnDesactivar.setEnabled(true);
                    }
                }
            });
        }

        // Filtro
        {
            comboFiltrar = new JComboBox<>();
            comboFiltrar.setBackground(new Color(0, 0, 51));
            comboFiltrar.setForeground(Color.WHITE);
            comboFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            comboFiltrar.setBounds(795, 23, 208, 24);
            comboFiltrar.addItem("Todos");
            comboFiltrar.addItem("Activos");
            comboFiltrar.addItem("Inactivos");
            contentPanel.add(comboFiltrar);
        }
        {
            JButton btnFiltrar = new JButton("Filtrar");
            btnFiltrar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		loadServicios();
            	}
            });
            btnFiltrar.setForeground(Color.WHITE);
            btnFiltrar.setBackground(new Color(0, 0, 51));
            btnFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnFiltrar.setFocusPainted(false);
            btnFiltrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnFiltrar.setBounds(1015, 23, 97, 25);
            contentPanel.add(btnFiltrar);
        }

        {
            JLabel lblServiciosRegistrados = new JLabel("Servicios Registrados: 00");
            lblServiciosRegistrados.setForeground(Color.WHITE);
            lblServiciosRegistrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblServiciosRegistrados.setBounds(12, 32, 216, 16);
            contentPanel.add(lblServiciosRegistrados);
        }

        // ====================== BOTONES LATERALES ======================
        {
            btnAgregar = new JButton("Agregar");
            btnAgregar.setForeground(Color.WHITE);
            btnAgregar.setBackground(new Color(0, 0, 51));
            btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnAgregar.setFocusPainted(false);
            btnAgregar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnAgregar.setBounds(1150, 284, 97, 25);
            btnAgregar.addActionListener(e -> {
                RegistrarServicio reg = new RegistrarServicio(null, false);
                reg.setModal(true);
                reg.setVisible(true);
                loadServicios();
            });
            contentPanel.add(btnAgregar);
        }
        {
            btnModificar = new JButton("Modificar");
            btnModificar.setForeground(Color.WHITE);
            btnModificar.setBackground(new Color(0, 0, 51));
            btnModificar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnModificar.setFocusPainted(false);
            btnModificar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnModificar.setBounds(1150, 322, 97, 25);
            btnModificar.setEnabled(false);
            btnModificar.addActionListener(e -> {
                if (selected != null) {
                    RegistrarServicio reg = new RegistrarServicio(selected, false);
                    reg.setModal(true);
                    reg.setVisible(true);
                    loadServicios();
                    btnModificar.setEnabled(false);
                    btnDesactivar.setEnabled(false);
                }
            });
            contentPanel.add(btnModificar);
        }
        {
            btnDesactivar = new JButton("Desactivar");
            btnDesactivar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		desactivarServicio();
            	}
            });
            btnDesactivar.setForeground(Color.WHITE);
            btnDesactivar.setBackground(new Color(102, 0, 0));
            btnDesactivar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnDesactivar.setFocusPainted(false);
            btnDesactivar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnDesactivar.setBounds(1150, 360, 97, 25);
            btnDesactivar.setEnabled(false);
            contentPanel.add(btnDesactivar);
        }

        // ====================== BOTONES INFERIORES ======================
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(new Color(0, 0, 51));
            buttonPane.setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 220), 1, true), "",
                    TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            btnSalir = new JButton("Salir");
            btnSalir.setForeground(Color.WHITE);
            btnSalir.setBackground(new Color(102, 0, 0));
            btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnSalir.setFocusPainted(false);
            btnSalir.addActionListener(e -> dispose());
            buttonPane.add(btnSalir);
        }

        loadServicios();
    }

    public static void loadServicios() {
        model.setRowCount(0);
        row = new Object[table.getColumnCount()];

        String filtro = comboFiltrar.getSelectedItem().toString();
        int count = 0;

        for (Servicio s : Altice.getInstance().getMisServicios()) {
            boolean incluir = false;

            switch (filtro) {
                case "Todos":
                    incluir = true;
                    break;
                case "Activos":
                    incluir = s.isActivo();
                    break;
                case "Inactivos":
                    incluir = !s.isActivo();
                    break;
            }

            if (incluir) {
                row[0] = s.getCodigo();
                row[1] = s.getTipo().name();
                row[2] = s.getDescripcion();
                row[3] = s.isActivo() ? "Activo" : "Inactivo";

                model.addRow(row);
                count++;
            }
        }

        for (Component c : contentPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                if (label.getText().startsWith("Servicios Registrados")) {
                    label.setText("Servicios Registrados: " + String.format("%02d", count));
                    break;
                }
            }
        }
        if(count == 3)
        	btnAgregar.setEnabled(false);
        	
    }

    private void desactivarServicio() {
        if (selected == null) return;

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea desactivar este servicio?",
                "Confirmar Desactivación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (opcion != JOptionPane.YES_OPTION) return;

        if (Altice.getInstance().desactivarServicio(selected.getCodigo())) {
            JOptionPane.showMessageDialog(this, "Servicio desactivado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            loadServicios();
            btnModificar.setEnabled(false);
            btnDesactivar.setEnabled(false);
            selected = null;
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo desactivar el servicio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}