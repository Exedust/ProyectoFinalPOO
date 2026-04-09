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
import logico.Plan;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class GestionPlanes extends JDialog {

    private final static JPanel contentPanel = new JPanel();
   
    private static JTable table;
    private static DefaultTableModel model;
    private static Object[] row;
    private Plan selected = null;

    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnDesactivar;
    private JButton btnDetalles;
    private JButton btnSalir;

    private static JComboBox<String> comboFiltrar;

    public static void main(String[] args) {
        try {
            GestionPlanes dialog = new GestionPlanes();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GestionPlanes() {
        setTitle("Gestionar Planes");
        setResizable(false);
        setBounds(100, 100, 1280, 670);
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
            panel.setBounds(12, 94, 1102, 449);
            contentPanel.add(panel);
            panel.setLayout(new BorderLayout(0, 0));

            JScrollPane scrollPane = new JScrollPane();
            panel.add(scrollPane, BorderLayout.CENTER);

            table = new JTable();
            table.setFillsViewportHeight(true);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setFont(new Font("Segoe UI", Font.PLAIN, 13));

            model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            String[] headers = {"Código", "Nombre", "Descripción", "Estado"};
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
                        selected = Altice.getInstance().buscarPlanByCodigo(codigo);

                        btnModificar.setEnabled(true);
                        btnDesactivar.setEnabled(selected.isActivo());
                        btnDetalles.setEnabled(true);
                    }
                }
            });
        }

        // ====================== CAMPO DE BÚSQUEDA ======================
        {
            JTextField txtBuscar = new JTextField();
            txtBuscar.setBackground(new Color(0, 0, 51));
            txtBuscar.setForeground(Color.WHITE);
            txtBuscar.setCaretColor(Color.WHITE);
            txtBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            txtBuscar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            txtBuscar.setBounds(12, 57, 232, 24);
            contentPanel.add(txtBuscar);
        }
        {
            JButton btnBuscar = new JButton("Buscar");
            btnBuscar.setForeground(Color.WHITE);
            btnBuscar.setBackground(new Color(0, 0, 51));
            btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnBuscar.setFocusPainted(false);
            btnBuscar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnBuscar.setBounds(256, 57, 97, 25);
            contentPanel.add(btnBuscar);
        }

        // ====================== FILTRO ======================
        {
            comboFiltrar = new JComboBox<>();
            comboFiltrar.setBackground(new Color(0, 0, 51));
            comboFiltrar.setForeground(Color.WHITE);
            comboFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            comboFiltrar.setBounds(797, 57, 208, 24);
            comboFiltrar.addItem("Todos");
            comboFiltrar.addItem("Activos");
            comboFiltrar.addItem("Inactivos");
            contentPanel.add(comboFiltrar);
        }
        {
            JButton btnFiltrar = new JButton("Filtrar");
            btnFiltrar.addActionListener(e -> loadPlanes());
            btnFiltrar.setForeground(Color.WHITE);
            btnFiltrar.setBackground(new Color(0, 0, 51));
            btnFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnFiltrar.setFocusPainted(false);
            btnFiltrar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnFiltrar.setBounds(1017, 57, 97, 25);
            contentPanel.add(btnFiltrar);
        }

        // ====================== CONTADOR ======================
        {
            JLabel lblPlanesRegistrados = new JLabel("Planes registrados: 00");
            lblPlanesRegistrados.setForeground(Color.WHITE);
            lblPlanesRegistrados.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblPlanesRegistrados.setBounds(12, 32, 216, 16);
            contentPanel.add(lblPlanesRegistrados);
        }

        // ====================== BOTONES LATERALES ======================
        {
            btnAgregar = new JButton("Agregar");
            btnAgregar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
                    RegistrarPlan reg = new RegistrarPlan(null);
                    reg.setModal(true);
                    reg.setVisible(true);
                    loadPlanes();
            	}
            });
            btnAgregar.setForeground(Color.WHITE);
            btnAgregar.setBackground(new Color(0, 0, 51));
            btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnAgregar.setFocusPainted(false);
            btnAgregar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnAgregar.setBounds(1143, 94, 97, 25);
            contentPanel.add(btnAgregar);
        }
        {
            btnModificar = new JButton("Modificar");
            btnModificar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
                    if (selected != null) {
                        RegistrarPlan reg = new RegistrarPlan(selected);
                        reg.setModal(true);
                        reg.setVisible(true);
                        loadPlanes();
                        btnModificar.setEnabled(false);
                        btnDesactivar.setEnabled(false);
                        btnDetalles.setEnabled(false);
                    }
            	}
            });
            btnModificar.setForeground(Color.WHITE);
            btnModificar.setBackground(new Color(0, 0, 51));
            btnModificar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnModificar.setFocusPainted(false);
            btnModificar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnModificar.setBounds(1143, 132, 97, 25);
            btnModificar.setEnabled(false);
            contentPanel.add(btnModificar);
        }
        {
            btnDesactivar = new JButton("Desactivar");
            btnDesactivar.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
                    if (selected != null) {
                    	desactivarPlan();
                        loadPlanes();
                    }
            	}
            });
            btnDesactivar.setForeground(Color.WHITE);
            btnDesactivar.setBackground(new Color(102, 0, 0));
            btnDesactivar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnDesactivar.setFocusPainted(false);
            btnDesactivar.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnDesactivar.setBounds(1143, 170, 97, 25);
            btnDesactivar.setEnabled(false);
            contentPanel.add(btnDesactivar);
        }
        {
            btnDetalles = new JButton("Detalles");
            btnDetalles.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		if(selected != null)
            		{
            			DetallesPlan nuevo = new DetallesPlan(selected);
            			nuevo.setModal(true);
            			nuevo.setVisible(true);
                        btnModificar.setEnabled(false);
                        btnDesactivar.setEnabled(false);
                        btnDetalles.setEnabled(false);
            		}
            	}
            });
            btnDetalles.setForeground(Color.WHITE);
            btnDetalles.setBackground(new Color(0, 0, 51));
            btnDetalles.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            btnDetalles.setFocusPainted(false);
            btnDetalles.setBorder(new LineBorder(new Color(150, 150, 220), 1, true));
            btnDetalles.setBounds(1143, 251, 97, 25);
            btnDetalles.setEnabled(false);
            contentPanel.add(btnDetalles);
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
            btnSalir.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		dispose();
            	}
            });
            btnSalir.setForeground(Color.WHITE);
            btnSalir.setBackground(new Color(102, 0, 0));
            btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btnSalir.setFocusPainted(false);
            buttonPane.add(btnSalir);
        }

        loadPlanes();
    }

    public static void loadPlanes() {
        if (model == null) return;

        model.setRowCount(0);
        
        row = new Object[table.getColumnCount()];

        String filtro = comboFiltrar.getSelectedItem().toString();
        int count = 0;

        for (Plan p : Altice.getInstance().getMisPlanes()) {
            boolean incluir = false;

            switch (filtro) {
                case "Todos":
                    incluir = true;
                    break;
                case "Activos":
                    incluir = p.isActivo();
                    break;
                case "Inactivos":
                    incluir = !p.isActivo();
                    break;
            }

            if (incluir) {
                row[0] = p.getCodigo();
                row[1] = p.getNombre();
                row[2] = p.getDescripcion() != null ? p.getDescripcion() : "";
                row[3] = p.isActivo() ? "Activo" : "Inactivo";

                model.addRow(row);
                count++;
            }
        }

        // Actualizar contador
        for (Component c : contentPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                if (label.getText().startsWith("Planes registrados")) {
                    label.setText("Planes registrados: " + String.format("%02d", count));
                    break;
                }
            }
        }
    }

    private void desactivarPlan() {
        if (selected == null) return;

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea desactivar este plan?",
                "Confirmar Desactivación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (opcion != JOptionPane.YES_OPTION) return;

        if (Altice.getInstance().desactivarPlan(selected.getCodigo())) {
            JOptionPane.showMessageDialog(this, "Plan desactivado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            loadPlanes();
            btnModificar.setEnabled(false);
            btnDesactivar.setEnabled(false);
            btnDetalles.setEnabled(false);
            selected = null;
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo desactivar el plan", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}